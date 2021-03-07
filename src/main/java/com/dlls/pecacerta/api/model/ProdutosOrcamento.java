package com.dlls.pecacerta.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "produtos_orcamento")
public class ProdutosOrcamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotNull
	@Column(name = "orca_codigo_produto")
	private Long codigoProduto;
	
	@NotNull
	@Column(name = "orca_codigo_orcamento")
	private Long codigoOrcamento;
	
	@NotNull
	@Column(name = "orca_quantidade_produto")
	private Integer quantidade;
	
	public Long getCodigoProduto() {
		return codigoProduto;
	}
	
	public void setCodigoProduto(Long codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	
	public Long getCodigoOrcamento() {
		return codigoOrcamento;
	}
	
	public void setCodigoOrcamento(Long codigoOrcamento) {
		this.codigoOrcamento = codigoOrcamento;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
}
