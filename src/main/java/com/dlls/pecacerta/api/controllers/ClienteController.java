package com.dlls.pecacerta.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dlls.pecacerta.api.model.Cliente;
import com.dlls.pecacerta.api.repositories.ClienteRepository;
import com.dlls.pecacerta.api.services.ClienteService;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController extends BaseController<Cliente, ClienteRepository, ClienteService> {
}
