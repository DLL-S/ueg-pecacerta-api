package com.dlls.pecacerta.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "produtos_orcamento")
public class ProdutosOrcamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orca_codigo")
	private Long codigo;

	@NotNull
	@Column(name = "orca_codigo_produto")
	private Long codigoProduto;
	
	@Column(name="orca_codigo_orcamento", nullable=false)
	private Long codigoOrcamento;
	
	@NotNull
	@Column(name = "orca_quantidade_produto")
	private Integer quantidade;

	public ProdutosOrcamento() {
	}
	
	public ProdutosOrcamento(Long codigoProduto, Long codigoOrcamento, int quantidade) {
		this.codigoProduto = codigoProduto;
		this.codigoOrcamento = codigoOrcamento;
		this.quantidade = quantidade;
	}

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
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
}
