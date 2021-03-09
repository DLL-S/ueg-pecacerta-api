package com.dlls.pecacerta.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dlls.pecacerta.api.model.Orcamento;
import com.dlls.pecacerta.api.model.Produto;
import com.dlls.pecacerta.api.repositories.OrcamentoRepository;
import com.dlls.pecacerta.api.services.OrcamentoService;
import com.dlls.pecacerta.api.utils.CodigoQuantidade;

@RestController
@RequestMapping("/api/v1/orcamentos")
public class OrcamentoController extends BaseController<Orcamento, OrcamentoRepository, OrcamentoService> {
	@PutMapping("/{id}/adicionarProduto")
	public  ResponseEntity<?> incluirProduto(@PathVariable(value = "id") Long id,
			@Validated @RequestBody CodigoQuantidade codigoQuantidade)
	{
		return ResponseEntity.ok(servico.addProdutosOrcamento(id, codigoQuantidade.codigo, codigoQuantidade.quantidade));
	}
}
