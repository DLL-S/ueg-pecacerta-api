package com.dlls.pecacerta.api.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dlls.pecacerta.api.model.MovimentacaoEstoque;

public interface MovimentacaoEstoqueRepository extends BaseRepository<MovimentacaoEstoque>, JpaRepository<MovimentacaoEstoque, Long> {
	Optional<MovimentacaoEstoque> findById(Long id);
	List<MovimentacaoEstoque> findByAtivo(Boolean ativo);
	@SuppressWarnings("unchecked")
	MovimentacaoEstoque save(MovimentacaoEstoque model);
}
