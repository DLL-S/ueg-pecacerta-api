package com.dlls.pecacerta.api.controllers;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dlls.pecacerta.api.events.ResourceCreatedEvent;
import com.dlls.pecacerta.api.exceptions.ProdutoNoneExistentException;
import com.dlls.pecacerta.api.model.Produto;
import com.dlls.pecacerta.api.repositories.ProdutoRepository;
import com.dlls.pecacerta.api.services.ProdutoService;

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {
	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ApplicationEventPublisher publisher;

	@PostMapping("")
	public ResponseEntity<?> incluirProduto(@Valid @RequestBody Produto produto, HttpServletResponse response) {
		var savedProduto = produtoService.save(produto);

		publisher.publishEvent(new ResourceCreatedEvent(this, response, savedProduto.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(savedProduto);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> alterarProduto(@PathVariable(value = "id") Long produtoId,
			@Valid @RequestBody Produto produtoParam) {

		var savedProduto = produtoService.update(produtoId, produtoParam);
		return ResponseEntity.ok(savedProduto);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> consultarProduto(@PathVariable(value = "id") Long produtoId){
		var produtos = this.produtoRepository.findById(produtoId);
		return produtos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(produtos);
	}

	@GetMapping("")
	public ResponseEntity<?> listarProdutos() {
		var produtos = this.produtoRepository.findAll();
		return produtos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(produtos);
	}

	@GetMapping("/ativos")
	public ResponseEntity<?> listarProdutosAtivos() {
		var produtos = this.produtoRepository.findByAtivo(true);
		return produtos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(produtos);
	}

	@PutMapping("/{id}/ativo")
	public ResponseEntity<?> ativarProduto(@PathVariable(value = "id") Long produtoId,
			@Valid @RequestBody Boolean booleano) {

		var produto = produtoRepository.findById(produtoId).orElseThrow(
				() -> new ProdutoNoneExistentException());

		produto.setAtivo(booleano);

		return ResponseEntity.ok(this.produtoRepository.save(produto));
	}
}
