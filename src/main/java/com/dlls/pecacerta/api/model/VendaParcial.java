package com.dlls.pecacerta.api.model;

import java.util.List;

import com.dlls.pecacerta.api.enumerators.EnumFormaDePagamento;

public class VendaParcial {
	private Long cliente;

	private EnumFormaDePagamento formaDePagamento;

	private String observacoes;

	private List<ProdutosVenda> produtosVenda;

	public Long getCliente() {
		return cliente;
	}

	public void setCliente(Long cliente) {
		this.cliente = cliente;
	}

	public EnumFormaDePagamento getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(EnumFormaDePagamento formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public List<ProdutosVenda> getProdutosVenda() {
		return produtosVenda;
	}

	public void setProdutosVenda(List<ProdutosVenda> produtosVenda) {
		this.produtosVenda = produtosVenda;
	}
}
