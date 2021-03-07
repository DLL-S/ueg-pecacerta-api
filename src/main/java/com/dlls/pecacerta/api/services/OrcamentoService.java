package com.dlls.pecacerta.api.services;

import org.springframework.stereotype.Component;

import com.dlls.pecacerta.api.model.Orcamento;
import com.dlls.pecacerta.api.model.Produto;
import com.dlls.pecacerta.api.model.ProdutosOrcamento;
import com.dlls.pecacerta.api.model.ProdutosVenda;
import com.dlls.pecacerta.api.model.Venda;
import com.dlls.pecacerta.api.repositories.OrcamentoRepository;

@Component
public class OrcamentoService extends BaseService<Orcamento, OrcamentoRepository> {
	public Orcamento addProdutosOrcamento(Long id, Produto param, Integer quantidade) {
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
