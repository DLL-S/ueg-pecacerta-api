package com.dlls.pecacerta.api.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.dlls.pecacerta.api.utils.FormaDePagamento;

@Entity
@Table(name = "vendas")
public class Venda {
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
	private FormaDePagamento formaDePagamento;

	@OneToOne
	@JoinColumn(name = "vnd_nota_fiscal")
	private NotaFiscal notaFiscal;
	
	@Column(name = "vnd_observacoes")
	private String observacoes;

	@OneToMany
	@JoinColumn(name = "vnd_produtos_venda")
	private List<ProdutosVenda> produtosVenda;
}
