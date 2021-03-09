package com.dlls.pecacerta.api.services;

import org.springframework.stereotype.Component;

import com.dlls.pecacerta.api.model.NotaFiscal;
import com.dlls.pecacerta.api.repositories.NotaFiscalRepository;

@Component
public class NotaFiscalService extends BaseService<NotaFiscal, NotaFiscalRepository>{
	public NotaFiscal GerarNotaFiscal(Long codigoVenda)
	{
		return repository.save(new NotaFiscal(codigoVenda));
	}
}
