package com.dlls.pecacerta.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dlls.pecacerta.api.model.Venda;
import com.dlls.pecacerta.api.repositories.VendaRepository;

@Component
public class VendaService extends BaseService<Venda, VendaRepository> {
	@Autowired
	NotaFiscalService servicoDeNotas;
	
	public Boolean AutorizacaoDoGestor(String tokenUsrGestor) {
		return true;
	}
	
	public Venda GerarNotaFiscal(Venda venda)
	{
		venda.setNotaFiscal(servicoDeNotas.GerarNotaFiscal(venda.getCodigo()));
		return venda;
	}
}
