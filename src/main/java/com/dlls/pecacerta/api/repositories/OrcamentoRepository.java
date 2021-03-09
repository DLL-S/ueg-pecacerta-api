package com.dlls.pecacerta.api.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dlls.pecacerta.api.model.Orcamento;

public interface OrcamentoRepository extends BaseRepository<Orcamento>, JpaRepository<Orcamento, Long> {
	Optional<Orcamento> findById(Long id);
	List<Orcamento> findByAtivo(Boolean ativo);
	@SuppressWarnings("unchecked")
	Orcamento save(Orcamento model);
}
