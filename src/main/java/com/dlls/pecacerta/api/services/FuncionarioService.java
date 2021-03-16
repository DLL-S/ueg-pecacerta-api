package com.dlls.pecacerta.api.services;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.dlls.pecacerta.api.exceptions.FuncionarioAlreadyExistsException;
import com.dlls.pecacerta.api.model.Funcionario;
import com.dlls.pecacerta.api.repositories.FuncionarioRepository;

@Component
public class FuncionarioService extends BaseService<Funcionario, FuncionarioRepository> {

	@Override
	public Funcionario save(Funcionario funcionario) {
		if (!repository.findByCpf(funcionario.getCpf()).isEmpty())
			throw new FuncionarioAlreadyExistsException();

		return repository.save(funcionario);
	}

	@Override
	public Funcionario update(Long codigo, Funcionario updatedFuncionario) {
		var savedFuncionario = find(codigo);

		var funcionarioComMesmoCpf = repository.findByCpf(updatedFuncionario.getCpf());
		if (!funcionarioComMesmoCpf.isEmpty())
			for (var funcionario : funcionarioComMesmoCpf)
				if (funcionario.getCodigo() != savedFuncionario.getCodigo())
					throw new FuncionarioAlreadyExistsException();

		BeanUtils.copyProperties(updatedFuncionario, savedFuncionario, "codigo");
		return repository.save(savedFuncionario);
	}
}
