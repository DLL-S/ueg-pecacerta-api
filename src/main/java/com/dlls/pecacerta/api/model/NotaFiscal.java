package com.dlls.pecacerta.api.model;

import java.util.Date;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "notas_fiscais")
public class NotaFiscal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nf_codigo")
	private Long codigo;

	@Column(name = "nf_numero")
	private String numero;

	@Column(name = "nf_codigo_venda")
	private Long codigoVenda;

	public NotaFiscal(Long codigoVenda) {
		var data = new Date();
		numero = "52-"+ data.getYear() + data.getMonth()+"-17921427000125-65-001-"+new Random().nextInt()+"-9-" + new Random().nextInt()+"-0";
	
		this.codigoVenda = codigoVenda;
	}

	public NotaFiscal(){
		var data = new Date();
		numero = "52-"+ data.getYear() + data.getMonth()+"-17921427000125-65-001-"+new Random().nextInt()+"-9-" + new Random().nextInt()+"-0";
	}
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Long getCodigoVenda() {
		return codigoVenda;
	}

	public void setCodigoVenda(Long codigoVenda) {
		this.codigoVenda = codigoVenda;
	}
}
