package com.dlls.pecacerta.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dlls.pecacerta.api.model.ProdutosOrcamento;

public interface ProdutosOrcamentoRepository extends JpaRepository<ProdutosOrcamento, Long> {
	List<ProdutosOrcamento> findByCodigoOrcamento(Long codigoOrcamento);
}
