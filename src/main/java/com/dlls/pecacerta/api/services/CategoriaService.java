package com.dlls.pecacerta.api.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dlls.pecacerta.api.model.Categoria;
import com.dlls.pecacerta.api.repositories.CategoriaRepository;

@Service
@Component
public class CategoriaService extends BaseService<Categoria, CategoriaRepository> {
}
