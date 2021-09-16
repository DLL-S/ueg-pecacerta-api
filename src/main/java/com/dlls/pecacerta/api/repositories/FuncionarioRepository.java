package com.dlls.pecacerta.api.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dlls.pecacerta.api.model.Funcionario;

public interface FuncionarioRepository extends BaseRepository<Funcionario>, JpaRepository<Funcionario, Long>  {
	
	List<Funcionario> findByCpf(String cpf);
	
	Optional<Funcionario> findById(Long id);
	
	Optional<Funcionario> findByEmail(String email);
	
	Boolean existsByEmail(String email);
	
	List<Funcionario> findByAtivo(Boolean ativo);
	
	@SuppressWarnings("unchecked")
	Funcionario save(Funcionario model);
}
