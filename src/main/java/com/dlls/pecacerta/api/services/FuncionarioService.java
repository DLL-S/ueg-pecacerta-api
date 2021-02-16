package com.dlls.pecacerta.api.services;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlls.pecacerta.api.exceptions.FuncionarioAlreadyExistsException;
import com.dlls.pecacerta.api.exceptions.FuncionarioNoneExistentException;
import com.dlls.pecacerta.api.model.Funcionario;
import com.dlls.pecacerta.api.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public Funcionario findFuncionario(Long codigo) {
		var savedPerson = funcionarioRepository.findById(codigo)
				.orElseThrow(() -> new FuncionarioNoneExistentException());
		return savedPerson;
	}

	public Funcionario save(@Valid Funcionario funcionario) {
		if (!funcionarioRepository.findByCpf(funcionario.getCpf()).isEmpty())
			throw new FuncionarioAlreadyExistsException();

		return funcionarioRepository.save(funcionario);
	}

	public Funcionario update(Long codigo, @Valid Funcionario updatedFuncionario) {
		var savedFuncionario = findFuncionario(codigo);

		var funcionarioComMesmoCpf = funcionarioRepository.findByCpf(updatedFuncionario.getCpf());
		if (!funcionarioComMesmoCpf.isEmpty())
			for (var funcionario : funcionarioComMesmoCpf)
				if (funcionario.getCodigo() != savedFuncionario.getCodigo())
					throw new FuncionarioAlreadyExistsException();

		BeanUtils.copyProperties(updatedFuncionario, savedFuncionario, "codigo");
		return funcionarioRepository.save(savedFuncionario);
	}
}
