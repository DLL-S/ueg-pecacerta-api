package com.dlls.pecacerta.api.services;

import org.springframework.stereotype.Component;

import com.dlls.pecacerta.api.model.Marca;
import com.dlls.pecacerta.api.model.Produto;
import com.dlls.pecacerta.api.model.ProdutosVenda;
import com.dlls.pecacerta.api.model.Venda;
import com.dlls.pecacerta.api.repositories.MarcaRepository;
import com.dlls.pecacerta.api.repositories.VendaRepository;

@Component
public class VendaService extends BaseService<Venda, VendaRepository> {
}
