package com.dlls.pecacerta.api.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dlls.pecacerta.api.events.ResourceCreatedEvent;
import com.dlls.pecacerta.api.model.Funcionario;
import com.dlls.pecacerta.api.repositories.FuncionarioRepository;
import com.dlls.pecacerta.api.services.FuncionarioService;

@RestController
@RequestMapping("/api/v1/funcionarios")
public class FuncionarioController extends BaseController<Funcionario, FuncionarioRepository, FuncionarioService> {
	@PostMapping("/cadastre")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> incluir(@Validated @RequestBody Funcionario model,
			@RequestBody String senha,
			HttpServletResponse response) {
		model.setSenha(new BCryptPasswordEncoder().encode(senha)); 
		var savedModel = servico.save(model);
		publisher.publishEvent(new ResourceCreatedEvent(this, response, savedModel.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(savedModel);
	}
}
