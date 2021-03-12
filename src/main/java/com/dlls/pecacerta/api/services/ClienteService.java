package com.dlls.pecacerta.api.services;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.dlls.pecacerta.api.exceptions.CNPJInvalidoException;
import com.dlls.pecacerta.api.exceptions.CPFInvalidoException;
import com.dlls.pecacerta.api.exceptions.ClienteAlreadyExistsException;
import com.dlls.pecacerta.api.model.Cliente;
import com.dlls.pecacerta.api.repositories.ClienteRepository;
import com.dlls.pecacerta.api.utils.EnumTipoCliente;

import br.com.safeguard.check.SafeguardCheck;
import br.com.safeguard.interfaces.Check;
import br.com.safeguard.types.ParametroTipo;

@Component
public class ClienteService extends BaseService<Cliente, ClienteRepository> {
	Check check = new SafeguardCheck();
	@Override
	public Cliente save(Cliente cliente) {
		if (!repository.findByCpfCnpj(cliente.getCpfCnpj()).isEmpty())
			throw new ClienteAlreadyExistsException();

		if (check
				.elementOf(cliente.getCpfCnpj(),ParametroTipo.NUMERO)
				.elementOf(cliente.getCpfCnpj(), cliente.getTipoCliente() == EnumTipoCliente.PESSOA_FISICA ? ParametroTipo.CPF : ParametroTipo.CNPJ)
				.validate()
				.hasError())
			throw cliente.getTipoCliente() == EnumTipoCliente.PESSOA_FISICA ? new CPFInvalidoException(): new CNPJInvalidoException();
		
		return repository.save(cliente);
	}
	
	@Override
	public Cliente update(Long codigo, Cliente updatedCliente) {
		var savedCliente = find(codigo);

		var clienteComMesmoCpf = repository.findByCpfCnpj(updatedCliente.getCpfCnpj());
		if (!clienteComMesmoCpf.isEmpty())
			for (var cliente : clienteComMesmoCpf)
				if (cliente.getCodigo() != savedCliente.getCodigo())
					throw new ClienteAlreadyExistsException();

		BeanUtils.copyProperties(updatedCliente, savedCliente, "codigo");
		return repository.save(savedCliente);
	}
}
