package com.dlls.pecacerta.api.controllers;

import javax.servlet.http.HttpServletResponse;

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
import com.dlls.pecacerta.api.exceptions.ResourceNotFoundException;
import com.dlls.pecacerta.api.model.Produto;
import com.dlls.pecacerta.api.repositories.ProdutoRepository;

@RestController
@RequestMapping("/api/v1/produto")
public class ProdutoController {
	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ApplicationEventPublisher publisher;

	// ***Métodos do Crud***//

	// Insert Product
	@PostMapping("")
	public ResponseEntity<?> incluirProduto(@Validated @RequestBody Produto produto, HttpServletResponse response) {
		var savedProduto = this.produtoRepository.save(produto);

		publisher.publishEvent(new ResourceCreatedEvent(this, response, savedProduto.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(savedProduto);
	}

	// Alter Product
	@PutMapping("/{id}")
	public ResponseEntity<?> alterarProduto(@PathVariable(value = "id") Long produtoId,
			@Validated @RequestBody Produto produtoParam) throws ResourceNotFoundException {

		var produto = produtoRepository.findById(produtoId).orElseThrow(
				() -> new ResourceNotFoundException("Nenhum produto encontrado pelo código: " + produtoId));

		produto.setNome(produtoParam.getNome());
		produto.setDescricao(produtoParam.getDescricao());
		produto.setCategoria(produtoParam.getCategoria());
		produto.setMarca(produtoParam.getMarca());
		produto.setPreco(produtoParam.getPreco());
		produto.setQtdeEstoque(produtoParam.getQtdeEstoque());
		produto.setAtivo(produtoParam.getAtivo());

		return ResponseEntity.ok(this.produtoRepository.save(produto));
	}

	// Search Product by ID
	@GetMapping("/{id}")
	public ResponseEntity<?> consultarProduto(@PathVariable(value = "id") Long produtoId)
			throws ResourceNotFoundException {

		var produto = produtoRepository.findById(produtoId).orElseThrow(
				() -> new ResourceNotFoundException("Nenhum produto encontrado pelo código: " + produtoId));

		return ResponseEntity.ok().body(produto);
	}

	// List of all products
	@GetMapping("")
	public ResponseEntity<?> listarProdutos() {
		var produtos = this.produtoRepository.findAll();
		return produtos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(produtos);
	}

	// List of all products
	@GetMapping("/ativos")
	public ResponseEntity<?> listarProdutosAtivos() {
		var produtos = this.produtoRepository.findByAtivo(true);
		return produtos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(produtos);
	}

	// Alter Product
	@PutMapping("/{id}/ativo")
	public ResponseEntity<?> ativarProduto(@PathVariable(value = "id") Long produtoId,
			@Validated @RequestBody Boolean booleano) throws ResourceNotFoundException {

		var produto = produtoRepository.findById(produtoId).orElseThrow(
				() -> new ResourceNotFoundException("Nenhum produto encontrado pelo código: " + produtoId));

		produto.setAtivo(booleano);

		return ResponseEntity.ok(this.produtoRepository.save(produto));
	}
}
