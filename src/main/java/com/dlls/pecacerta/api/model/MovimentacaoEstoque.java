package com.dlls.pecacerta.api.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.dlls.pecacerta.api.enumerators.EnumOperacaoEstoque;

@Entity
@Table(name = "controle_estoque")
public class MovimentacaoEstoque extends BaseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "estq_codigo")
	Long codigo;
	
	@Column(name = "estq_operacao")
	EnumOperacaoEstoque operacao;
	
	@ManyToOne
	@JoinColumn(name = "estq_produto")
	Produto produto;
	
	@Column(name = "estq_preco_de_venda")
	Double precoDeVenda;
	
	@Column(name = "estq_quantidade")
	Integer quantidade;
	
	@Column(name = "estq_data")
	Date data;
	
	@Column(name = "estq_ativo")
	Boolean ativo;
	
	@ManyToOne
	@JoinColumn(name = "estq_funcionario")
	Funcionario atendente;
	
	public MovimentacaoEstoque() {}
	
	public MovimentacaoEstoque(Produto produto, int quantidade, EnumOperacaoEstoque operacao, Funcionario atendente) {
		this.produto = produto;
		this.quantidade = quantidade;
		this.operacao = operacao;
		this.atendente = atendente;
		this.data = new Date(System.currentTimeMillis());
		this.precoDeVenda = produto.getPreco();
		this.ativo = true;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public EnumOperacaoEstoque getOperacao() {
		return operacao;
	}

	public void setOperacao(EnumOperacaoEstoque operacao) {
		this.operacao = operacao;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Double getPrecoDeVenda() {
		return precoDeVenda;
	}

	public void setPrecoDeVenda(Double precoDeVenda) {
		this.precoDeVenda = precoDeVenda;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
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

	public Funcionario getAtendente() {
		return atendente;
	}

	public void setAtendente(Funcionario atendente) {
		this.atendente = atendente;
	}
}
