package com.dlls.pecacerta.api.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dlls.pecacerta.api.model.NotaFiscal;
import com.dlls.pecacerta.api.repositories.NotaFiscalRepository;

@Service
@Component
public class NotaFiscalService extends BaseService<NotaFiscal, NotaFiscalRepository>{
	public NotaFiscal GerarNotaFiscal(Long codigoVenda)
	{
		return repository.save(new NotaFiscal(codigoVenda));
	}
}
