package com.dlls.pecacerta.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "produtos_vendas")
public class ProdutosVenda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vnd_codigo")
	private Long codigo;
	
	@NotNull
	@Column(name = "vnd_codigo_produto")
	private Long codigoProduto;
	
	@NotNull
	@Column(name = "vnd_codigo_venda")
	private Long codigoVenda;
	
	@NotNull
	@Column(name = "vnd_quantidade_produto")
	private Integer quantidade;
	
	public ProdutosVenda(Long codigoProduto, Long codigoVenda, int quantidade) {
		this.codigoProduto = codigoProduto;
		this.codigoVenda = codigoVenda;
		this.quantidade = quantidade;
	}

	public Long getCodigoProduto() {
		return codigoProduto;
	}
	
	public void setCodigoProduto(Long codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	
	public Long getCodigoVenda() {
		return codigoVenda;
	}
	
	public void setCodigoVenda(Long codigoOrcamento) {
		this.codigoVenda = codigoOrcamento;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
}
