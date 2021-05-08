package com.dlls.pecacerta.api.model;

import java.util.Date;

import com.dlls.pecacerta.api.utils.OperacaoEstoque;

public class MovimentacaoEstoque extends BaseModel {
	Long codigo;
	OperacaoEstoque operacao;
	Produto produto;
	Double precoDeVenda;
	Integer quantidade;
	Date data;
	Boolean ativo;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public OperacaoEstoque getOperacao() {
		return operacao;
	}
	public void setOperacao(OperacaoEstoque operacao) {
		this.operacao = operacao;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public double getPrecoDeVenda() {
		return precoDeVenda;
	}
	public void setPrecoDeVenda(double precoDeVenda) {
		this.precoDeVenda = precoDeVenda;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	

}
