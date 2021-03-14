package com.dlls.pecacerta.api.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dlls.pecacerta.api.model.Cliente;

public interface ClienteRepository extends BaseRepository<Cliente>, JpaRepository<Cliente, Long>  {
	List<Cliente> findByCpfCnpj(String cpfCnpj);
	Optional<Cliente> findById(Long id);
	List<Cliente> findByAtivo(Boolean ativo);
	@SuppressWarnings("unchecked")
	Cliente save(Cliente model);
	@Query(
			  value = "SELECT * FROM clientes u "
			  		+ "WHERE u.cli_nome Like %?1% OR"
			  			+ " u.cli_cpf_cnpj Like %?1% OR"
			  			//+ " u.cli_data_nasc Like %?1% OR"
			  			+ " u.cli_email Like %?1% OR"
			  			+ " u.cli_telefone Like %?1%",
			  nativeQuery = true)
	List<Cliente> pesquise(String termo);
}