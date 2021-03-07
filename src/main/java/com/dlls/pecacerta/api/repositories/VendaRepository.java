package com.dlls.pecacerta.api.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dlls.pecacerta.api.model.Orcamento;
import com.dlls.pecacerta.api.model.Venda;

public interface VendaRepository extends BaseRepository<Venda>, JpaRepository<Venda, Long>  {
	Optional<Venda> findById(Long id);
	List<Venda> findByAtivo(Boolean ativo);
}