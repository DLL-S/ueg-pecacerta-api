package com.dlls.pecacerta.api.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dlls.pecacerta.api.model.Marca;
import com.dlls.pecacerta.api.repositories.MarcaRepository;

@Service
@Component
public class MarcaService extends BaseService<Marca, MarcaRepository> {

}
