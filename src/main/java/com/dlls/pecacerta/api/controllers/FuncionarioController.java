package com.dlls.pecacerta.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

import com.dlls.pecacerta.api.model.Funcionario;
import com.dlls.pecacerta.api.repositories.FuncionarioRepository;
import com.dlls.pecacerta.api.services.FuncionarioService;

@RequestMapping("/api/v1/funcionarios")
public class FuncionarioController extends BaseController<Funcionario, FuncionarioRepository, FuncionarioService> {
}
