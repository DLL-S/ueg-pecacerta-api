package com.dlls.pecacerta.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "notas_fiscais")
public class NotaFiscal  extends BaseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nf_codigo")
	private Long codigo;

	@NotNull
	@Column(name = "nf_numero")
	private String numero;

	@NotNull
	@Column(name = "nf_codigo_venda")
	private Long codigoVenda;

	@Column(name = "nf_ativo")
	private Boolean ativo;

	public NotaFiscal(Long codigoVenda) {
		this.codigoVenda = codigoVenda;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getCodigoDeBarras() {
		return numero;
	}

	public void setCodigoDeBarras(String numero) {
		this.numero = numero;
	}

	public Long getCodigoVenda() {
		return codigoVenda;
	}

	public void setCodigoVenda(Long codigoVenda) {
		this.codigoVenda = codigoVenda;
	}

	@Override
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
}
