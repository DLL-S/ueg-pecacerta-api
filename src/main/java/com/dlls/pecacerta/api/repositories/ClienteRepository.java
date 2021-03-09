package com.dlls.pecacerta.api.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dlls.pecacerta.api.model.Cliente;

public interface ClienteRepository extends BaseRepository<Cliente>, JpaRepository<Cliente, Long>  {
	List<Cliente> findByCpfCnpj(String cpfCnpj);
	Optional<Cliente> findById(Long id);
	List<Cliente> findByAtivo(Boolean ativo);
	@SuppressWarnings("unchecked")
	Cliente save(Cliente model);
}