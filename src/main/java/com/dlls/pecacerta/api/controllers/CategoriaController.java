package com.dlls.pecacerta.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

import com.dlls.pecacerta.api.model.Categoria;
import com.dlls.pecacerta.api.repositories.CategoriaRepository;
import com.dlls.pecacerta.api.services.CategoriaService;

@RequestMapping("/api/v1/categorias")
public class CategoriaController extends BaseController<Categoria, CategoriaRepository, CategoriaService> {
}
