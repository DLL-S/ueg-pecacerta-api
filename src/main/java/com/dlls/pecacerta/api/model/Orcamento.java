package com.dlls.pecacerta.api.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orcamentos")
public class Orcamento extends BaseModel{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orca_codigo")
	private Long codigo;

	@OneToOne
	@JoinColumn(name = "orca_cliente")
	private Cliente cliente;

	@Column(name = "orca_data")
	private Date data;
	
	@Column(name = "orca_valor_total")
	private Double valorTotal;
	
	@Column(name = "orca_observacoes")
	private String observacoes;

	@OneToMany(cascade=CascadeType.ALL, mappedBy="codigoOrcamento")
	private List<ProdutosOrcamento> produtosOrcamento;
	
	@Column(name = "orca_ativo")
	private Boolean ativo = true;

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

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

	public Boolean getAtivo() {
		return ativo;
	}

	@Override
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
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

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public List<ProdutosOrcamento> getProdutosOrcamento() {
		return produtosOrcamento;
	}

	public void setProdutosOrcamento(List<ProdutosOrcamento> produtosOrcamento) {
		this.produtosOrcamento = produtosOrcamento;
	}
}
