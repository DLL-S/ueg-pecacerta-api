package com.dlls.pecacerta.api.utils;

import java.util.ArrayList;
import java.util.List;

import com.dlls.pecacerta.api.enumerators.EnumFormaDePagamento;
import com.dlls.pecacerta.api.model.Orcamento;
import com.dlls.pecacerta.api.model.ProdutosOrcamento;
import com.dlls.pecacerta.api.model.ProdutosVenda;
import com.dlls.pecacerta.api.model.Venda;

public class VendaOrcamentoConverter {	
	public static Venda ObtenhaVenda(Orcamento orcamento, EnumFormaDePagamento formaPagamento)
	{
		var venda = new Venda();
		venda.setAtivo(orcamento.getAtivo());
		venda.setCliente(orcamento.getCliente());
		venda.setProdutosVenda(null);
		venda.setFormaDePagamento(formaPagamento);
		venda.setValorTotal(orcamento.getValorTotal());
		return venda;
	}
	
	public static List<ProdutosVenda> ObtenhaProdutosVenda(List<ProdutosOrcamento> produtosOrcamento)
	{
		var produtosVenda = new ArrayList<ProdutosVenda>();
		for (ProdutosOrcamento orcamento : produtosOrcamento) {
			var venda = new ProdutosVenda(orcamento.getCodigoProduto(), null, orcamento.getQuantidade());
			produtosVenda.add(venda);
		}
		
		return produtosVenda;
	}
}
