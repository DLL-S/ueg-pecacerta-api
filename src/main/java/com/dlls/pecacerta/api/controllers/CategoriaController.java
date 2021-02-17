package com.dlls.pecacerta.api.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dlls.pecacerta.api.events.ResourceCreatedEvent;
import com.dlls.pecacerta.api.exceptions.CategoriaNoneExistentException;
import com.dlls.pecacerta.api.model.Categoria;
import com.dlls.pecacerta.api.repositories.CategoriaRepository;

@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriaController {
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ApplicationEventPublisher publisher;

	@PostMapping("")
	public ResponseEntity<?> incluirCategoria(@Validated @RequestBody Categoria categoria,
			HttpServletResponse response) {
		var savedCategoria = this.categoriaRepository.save(categoria);

		publisher.publishEvent(new ResourceCreatedEvent(this, response, savedCategoria.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(savedCategoria);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> alterarCategoria(@PathVariable(value = "id") Long categoriaId,
			@Validated @RequestBody Categoria categoriaParam) {

		var categoria = categoriaRepository.findById(categoriaId).orElseThrow(
				() -> new CategoriaNoneExistentException());

		categoria.setNome(categoriaParam.getNome());
		categoria.setAtivo(categoriaParam.getAtivo());

		return ResponseEntity.ok(this.categoriaRepository.save(categoria));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> consultarCategoria(@PathVariable(value = "id") Long categoriaId){
		var categorias = categoriaRepository.findById(categoriaId);
		return categorias.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(categorias);
	}

	@GetMapping("")
	public ResponseEntity<?> listarCategorias() {
		var categorias = this.categoriaRepository.findAll();
		return categorias.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(categorias);
	}

	@GetMapping("/ativos")
	public ResponseEntity<?> listarCategoriasAtivas() {
		var categorias = this.categoriaRepository.findByAtivo(true);
		return categorias.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(categorias);
	}

	@PutMapping("/{id}/ativo")
	public ResponseEntity<?> ativarCategoria(@PathVariable(value = "id") Long categoriaId,
			@Validated @RequestBody Boolean booleano) {

		var categoria = categoriaRepository.findById(categoriaId).orElseThrow(
				() -> new CategoriaNoneExistentException());

		categoria.setAtivo(booleano);

		return ResponseEntity.ok(this.categoriaRepository.save(categoria));
	}
}
