package com.dlls.pecacerta.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dlls.pecacerta.api.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	List<Funcionario> findByCpf(String cpf);

	List<Funcionario> findByAtivo(Boolean ativo);
}
