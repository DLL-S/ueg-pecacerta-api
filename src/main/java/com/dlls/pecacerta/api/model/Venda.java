package com.dlls.pecacerta.api.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.dlls.pecacerta.api.utils.FormaDePagamento;

@Entity
@Table(name = "vendas")
public class Venda extends BaseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vnd_codigo")
	private Long codigo;

	@ManyToOne
	@JoinColumn(name = "vnd_cliente")
	private Cliente cliente;

	@Column(name = "vnd_data")
	private Date data;
	
	@Column(name = "vnd_valor_total")
	private Double valorTotal;
	
	@Column(name = "vnd_forma_de_pagamento")
	@Enumerated(EnumType.STRING)
	private FormaDePagamento formaDePagamento;

	@OneToOne
	@JoinColumn(name = "vnd_nota_fiscal")
	private NotaFiscal notaFiscal;
	
	@Column(name = "vnd_observacoes")
	private String observacoes;

	@OneToMany
	@JoinColumn(name = "vnd_produtos_venda")
	private List<ProdutosVenda> produtosVenda;

	@Column(name = "vnd_ativo")
	private Boolean ativo = true;

	@Override
	public Long getCodigo() {
		return codigo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public FormaDePagamento getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(FormaDePagamento formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(NotaFiscal notaFiscal) {
		this.notaFiscal = notaFiscal;
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

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	@Override
	public void setAtivo(Boolean ativo) {
	}

	public Boolean getAtivo() {
		return ativo;
	}
}
