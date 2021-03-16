package com.dlls.pecacerta.api.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dlls.pecacerta.api.model.Produto;

public interface ProdutoRepository extends BaseRepository<Produto>, JpaRepository<Produto, Long>  {
	List<Produto> findByCodigoDeBarras(String codigoDeBarras);
	Optional<Produto> findById(Long id);
	List<Produto> findByAtivo(Boolean ativo);
	@SuppressWarnings("unchecked")
	Produto save(Produto model);
}
