package com.dlls.pecacerta.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dlls.pecacerta.api.model.Produto;
import com.dlls.pecacerta.api.repositories.ProdutoRepository;
import com.dlls.pecacerta.api.services.ProdutoService;

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController extends BaseController<Produto, ProdutoRepository, ProdutoService> {
}
