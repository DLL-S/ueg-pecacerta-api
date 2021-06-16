package com.dlls.pecacerta.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dlls.pecacerta.api.model.ProdutosVenda;

public interface ProdutosVendaRepository extends JpaRepository<ProdutosVenda, Long> {
	List<ProdutosVenda> findByCodigoVenda(Long codigoVenda);
}
