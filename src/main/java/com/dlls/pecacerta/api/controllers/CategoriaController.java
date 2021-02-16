package com.dlls.pecacerta.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dlls.pecacerta.api.events.ResourceCreatedEvent;
import com.dlls.pecacerta.api.exceptions.ResourceNotFoundException;
import com.dlls.pecacerta.api.model.Categoria;
import com.dlls.pecacerta.api.model.Cliente;
import com.dlls.pecacerta.api.repositories.CategoriaRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ApplicationEventPublisher publisher;
	
	@PostMapping("categoria")
	public ResponseEntity<?> incluirCategoria(@Validated @RequestBody Categoria categoria, HttpServletResponse response) {
		var savedCategoria = this.categoriaRepository.save(categoria);

		publisher.publishEvent(new ResourceCreatedEvent(this, response, savedCategoria.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(savedCategoria);
	}
	
	@PutMapping("categoria/{id}")
	public ResponseEntity<?> alterarCategoria(@PathVariable(value = "id") Long categoriaId,
			@Validated @RequestBody Categoria categoriaParam) throws ResourceNotFoundException {
		
		var categoria = categoriaRepository.findById(categoriaId)
				.orElseThrow(() -> new ResourceNotFoundException("Nenhuma categoria encontrada pelo código " + categoriaId));
		
		categoria.setNome(categoriaParam.getNome());
		categoria.setAtivo(categoriaParam.getAtivo());
		
		return ResponseEntity.ok(this.categoriaRepository.save(categoria));
	}
	
	@GetMapping("categoria/{id}")
	public ResponseEntity<?> consultarCategoria(@PathVariable(value = "id") Long categoriaId) throws ResourceNotFoundException {
	
		var categoria = categoriaRepository.findById(categoriaId)
				.orElseThrow(() -> new ResourceNotFoundException("Esta categoria não foi encontrada pelo codigo " + categoriaId));
	
		return ResponseEntity.ok().body(categoria);
	}
	
	@GetMapping("categoria")
	public ResponseEntity<?> listarCategorias() {
		var categorias = this.categoriaRepository.findAll();
		return categorias.isEmpty() ? 
				ResponseEntity.noContent().build() : ResponseEntity.ok(categorias);
	}
	
	//List of all products
	@GetMapping("/ativos")
	public ResponseEntity<?> listarCategoriasAtivas() {
		var categorias = this.categoriaRepository.findByAtivo(true);
		return categorias.isEmpty() ? 
				ResponseEntity.noContent().build() : ResponseEntity.ok(categorias);
	}
	
	//Alter Product
	@PutMapping("/{id}/ativar/{ativar}")
	public ResponseEntity<?> ativarCategoria(@PathVariable(value = "id") Long categoriaId,
			@PathVariable(value = "ativar") Boolean booleano) throws ResourceNotFoundException {
		
		var categoria = categoriaRepository.findById(categoriaId)
				.orElseThrow(() -> new ResourceNotFoundException("Nenhuma categoria encontrado pelo código: " + categoriaId));
		
		categoria.setAtivo(booleano);
		
		return ResponseEntity.ok(this.categoriaRepository.save(categoria));
	}
}
