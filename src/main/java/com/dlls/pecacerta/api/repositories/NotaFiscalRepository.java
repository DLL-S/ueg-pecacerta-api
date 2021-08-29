package com.dlls.pecacerta.api.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dlls.pecacerta.api.model.NotaFiscal;

public interface NotaFiscalRepository extends JpaRepository<NotaFiscal, Long> {
	Optional<NotaFiscal> findById(Long id);
	@SuppressWarnings("unchecked")
	NotaFiscal save(NotaFiscal model);
}
