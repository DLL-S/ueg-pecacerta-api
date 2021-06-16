package com.dlls.pecacerta.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dlls.pecacerta.api.services.EstoqueService;


@RestController
@RequestMapping("/api/v1/controleestoque")
@CrossOrigin(origins="*", methods= {RequestMethod.PUT, RequestMethod.POST, RequestMethod.GET})
public class EstoqueController {
	@Autowired
	EstoqueService servico;

	@PostMapping("troca")
	public ResponseEntity<?> registrarTroca(Long codigoProduto, int quantidade)//, Long operadorLogado)
	{
		return ResponseEntity.ok(servico.registrarTroca(codigoProduto, quantidade, (long)0));
	}
}
