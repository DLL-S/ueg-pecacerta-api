package com.dlls.pecacerta.api.controllers;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dlls.pecacerta.api.events.ResourceCreatedEvent;
import com.dlls.pecacerta.api.exceptions.ClienteNoneExistentException;
import com.dlls.pecacerta.api.model.Cliente;
import com.dlls.pecacerta.api.repositories.ClienteRepository;
import com.dlls.pecacerta.api.services.ClienteService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {
	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public ResponseEntity<?> getAll() {
		var clientes = clienteRepository.findAll();
		return clientes.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(clientes);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<?> getById(@PathVariable Long codigo) {
		var clientes = clienteRepository.findById(codigo);
		return clientes.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(clientes);
	}

	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody Cliente cliente, HttpServletResponse response) {
		var savedCliente = clienteService.save(cliente);

		publisher.publishEvent(new ResourceCreatedEvent(this, response, savedCliente.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(savedCliente);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
		var savedCliente = clienteService.update(id, cliente);
		return ResponseEntity.ok(savedCliente);
	}

	@GetMapping("/ativos")
	public ResponseEntity<?> listarClientesAtivas() {
		var clientes = this.clienteRepository.findByAtivo(true);
		return clientes.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(clientes);
	}

	@PutMapping("/{id}/ativo")
	public ResponseEntity<?> ativarCliente(@PathVariable(value = "id") Long clienteId,
			@Validated @RequestBody Boolean booleano) {

		var cliente = clienteRepository.findById(clienteId).orElseThrow(
				() -> new ClienteNoneExistentException());

		cliente.setAtivo(booleano);

		return ResponseEntity.ok(this.clienteRepository.save(cliente));
	}
}
