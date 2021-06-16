package com.dlls.pecacerta.api.controllers;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dlls.pecacerta.api.model.Venda;
import com.dlls.pecacerta.api.repositories.VendaRepository;
import com.dlls.pecacerta.api.services.VendaService;

@RestController
@RequestMapping("/api/v1/vendas")
public class VendaController extends BaseController<Venda, VendaRepository, VendaService> {
	@PutMapping("/{id}/autorizado")
	public Boolean AprovadoPeloGestor(String tokenGestor)
	{
		return servico.AutorizacaoDoGestor(tokenGestor);
	}

	@PutMapping("/finalizar")
	public Venda RealizarVenda(Venda venda)
	{
		return servico.RealizarVenda(venda, (long)0);
	}
}
