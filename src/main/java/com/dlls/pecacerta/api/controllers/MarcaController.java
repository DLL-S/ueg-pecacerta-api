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
import com.dlls.pecacerta.api.model.Marca;
import com.dlls.pecacerta.api.repositories.MarcaRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/marca")
public class MarcaController {
	
	@Autowired
	private MarcaRepository marcaRepository;

	@Autowired
	private ApplicationEventPublisher publisher;
	
	@PostMapping("")
	public ResponseEntity<?> incluirMarca(@Validated @RequestBody Marca marca, HttpServletResponse response) {
		var savedMarca = this.marcaRepository.save(marca);
		
		publisher.publishEvent(new ResourceCreatedEvent(this, response, savedMarca.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(savedMarca);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> alterarMarca(@PathVariable(value = "id") Long marcaId,
			@Validated @RequestBody Marca marcaParam) throws ResourceNotFoundException {
		
		var marca = marcaRepository.findById(marcaId)
				.orElseThrow(() -> new ResourceNotFoundException("Nenhuma marca encontrada pelo código fornecido" + marcaId));
		
		marca.setNome(marcaParam.getNome());
		marca.setAtivo(marcaParam.getAtivo());
		
		return ResponseEntity.ok(this.marcaRepository.save(marca));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> consultarMarca(@PathVariable(value = "id") Long marcaId) throws ResourceNotFoundException {
	
		var marca = marcaRepository.findById(marcaId)
				.orElseThrow(() -> new ResourceNotFoundException("Esta marca não foi encontrad pelo codigo " + marcaId));
	
		return ResponseEntity.ok().body(marca);
	}
	
	@GetMapping("")
	public ResponseEntity<?> listarMarcas() {
		var marcas = this.marcaRepository.findAll();
		return marcas.isEmpty() ? 
				ResponseEntity.noContent().build() : ResponseEntity.ok(marcas);
	}
	
	//List of all products
	@GetMapping("/ativos")
	public ResponseEntity<?> listarMarcasAtivas() {
		var marcas = this.marcaRepository.findByAtivo(true);
		return marcas.isEmpty() ? 
				ResponseEntity.noContent().build() : ResponseEntity.ok(marcas);
	}
	
	//Alter Product
	@PutMapping("/{id}/ativar/{ativar}")
	public ResponseEntity<?> ativarMarca(@PathVariable(value = "id") Long marcaId,
			@PathVariable(value = "ativar") Boolean booleano) throws ResourceNotFoundException {
		
		var marca = marcaRepository.findById(marcaId)
				.orElseThrow(() -> new ResourceNotFoundException("Nenhuma marca encontrado pelo código: " + marcaId));
		
		marca.setAtivo(booleano);
		
		return ResponseEntity.ok(this.marcaRepository.save(marca));
	}
}
