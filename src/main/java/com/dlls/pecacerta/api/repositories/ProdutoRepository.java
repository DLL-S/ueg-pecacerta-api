package com.dlls.pecacerta.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dlls.pecacerta.api.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	List<Produto> findByCodigoDeBarras(String codigoDeBarras);

	List<Produto> findByAtivo(Boolean ativo);
}
