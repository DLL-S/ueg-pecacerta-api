package com.dlls.pecacerta.api.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.dlls.pecacerta.api.model.Orcamento;
import com.dlls.pecacerta.api.repositories.OrcamentoRepository;
import com.dlls.pecacerta.api.services.OrcamentoService;

@RestController
public class OrcamentoController extends BaseController<Orcamento, OrcamentoRepository, OrcamentoService> {

}
