package com.dlls.pecacerta.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@PostMapping("/trocar")
	public ResponseEntity<?> registrarTroca(Long codigoProduto, int quantidade)//, Long operadorLogado)
	{
		return ResponseEntity.ok(servico.registrarTroca(codigoProduto, quantidade, (long)0));
	}

	@PostMapping("/incluir")
	public ResponseEntity<?> registrarInclusao(Long codigoProduto, int quantidade)//, Long operadorLogado)
	{
		return ResponseEntity.ok(servico.registrarInclusao(codigoProduto, quantidade, (long)0));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> consultar(@PathVariable(value = "id") Long id){
		return ResponseEntity.ok(servico.find(id));
	}

	@GetMapping
	public ResponseEntity<?> listar() {
		var models = servico.findAll();
		return models.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(models);
	}
}
