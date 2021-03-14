package com.dlls.pecacerta.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dlls.pecacerta.api.model.Cliente;
import com.dlls.pecacerta.api.repositories.ClienteRepository;
import com.dlls.pecacerta.api.services.ClienteService;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController extends BaseController<Cliente, ClienteRepository, ClienteService> {
	@GetMapping("/pesquisa")
	public ResponseEntity<?> consultar(@RequestParam String termo){
		return ResponseEntity.ok(servico.pesquise(termo));
	}
}
