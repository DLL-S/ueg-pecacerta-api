package com.dlls.pecacerta.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

import com.dlls.pecacerta.api.model.Marca;
import com.dlls.pecacerta.api.repositories.MarcaRepository;
import com.dlls.pecacerta.api.services.MarcaService;

@RequestMapping("/api/v1/marcas")
public class MarcaController extends BaseController<Marca, MarcaRepository, MarcaService> {
}
