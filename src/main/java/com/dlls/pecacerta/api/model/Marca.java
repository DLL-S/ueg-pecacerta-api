package com.dlls.pecacerta.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Marcas")
public class Marca extends BaseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "marca_codigo")
	private Long codigo;

	@Column(name = "marca_nome")
	private String nome;

	@Column(name = "marca_ativo")
	private Boolean ativo = true;

	public Marca() {
	}

	public Marca(Long codigo, String nome, Boolean ativo) {
		this.codigo = codigo;
		this.nome = nome;
		this.ativo = ativo;
	}

	@Override
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	@Override
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
}
