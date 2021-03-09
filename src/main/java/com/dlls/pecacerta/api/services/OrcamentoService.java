package com.dlls.pecacerta.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dlls.pecacerta.api.model.Orcamento;
import com.dlls.pecacerta.api.model.Produto;
import com.dlls.pecacerta.api.model.ProdutosOrcamento;
import com.dlls.pecacerta.api.repositories.OrcamentoRepository;

@Component
public class OrcamentoService extends BaseService<Orcamento, OrcamentoRepository> {
	@Autowired
	ProdutoService prodService;
	
	public Orcamento addProdutosOrcamento(Long id, Long idprod, Integer quantidade) {
		var param = prodService.find(idprod);
		var orcamento = find(id);
		var prodOrcamento = orcamento.getProdutosOrcamento();
		ProdutosOrcamento orcamentoProduto;
		if( prodOrcamento.stream().anyMatch(x -> x.getCodigoProduto() == param.getCodigo()))
		{
			orcamentoProduto = prodOrcamento.stream().filter(x -> x.getCodigoProduto() == param.getCodigo()).findFirst().get();
			var qtdOld = orcamentoProduto.getQuantidade();
			var newQtd = qtdOld + quantidade;
			orcamentoProduto.setQuantidade(newQtd);
		}
		else
		{
			orcamentoProduto = new ProdutosOrcamento(param.getCodigo(), id, quantidade);
		}
		
		prodOrcamento.add(orcamentoProduto);
		orcamento.setProdutosOrcamento(prodOrcamento);
		return this.save(orcamento);
	}
}
