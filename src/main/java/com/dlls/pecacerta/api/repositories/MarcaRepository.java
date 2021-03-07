package com.dlls.pecacerta.api.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dlls.pecacerta.api.model.Marca;

public interface MarcaRepository extends BaseRepository<Marca>, JpaRepository<Marca, Long>  {
	List<Marca> findByNomeIgnoreCase(String name);
	Optional<Marca> findById(Long id);
	List<Marca> findByAtivo(Boolean ativo);
}
