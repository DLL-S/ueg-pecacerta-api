package com.dlls.pecacerta.api.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dlls.pecacerta.api.model.Categoria;

public interface CategoriaRepository extends BaseRepository<Categoria>, JpaRepository<Categoria, Long> {
	List<Categoria> findByNomeIgnoreCase(String name);
	Optional<Categoria> findById(Long id);
	List<Categoria> findByAtivo(Boolean ativo);
	@SuppressWarnings("unchecked")
	Categoria save(Categoria model);
}
