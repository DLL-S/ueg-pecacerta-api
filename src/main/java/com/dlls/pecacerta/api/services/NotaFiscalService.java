package com.dlls.pecacerta.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dlls.pecacerta.api.model.NotaFiscal;
import com.dlls.pecacerta.api.repositories.NotaFiscalRepository;

@Component
public class NotaFiscalService{@Autowired
	protected NotaFiscalRepository repository;
	public NotaFiscal GerarNotaFiscal(Long codigoVenda)
	{
		return repository.save(new NotaFiscal(codigoVenda));
	}
}
