package com.dlls.pecacerta.api.services;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.dlls.pecacerta.api.exceptions.ClienteAlreadyExistsException;
import com.dlls.pecacerta.api.model.Cliente;
import com.dlls.pecacerta.api.repositories.ClienteRepository;

@Component
public class ClienteService extends BaseService<Cliente, ClienteRepository> {

	@Override
	public Cliente save(Cliente cliente) {
		if (!repository.findByCpfCnpj(cliente.getCpfCnpj()).isEmpty())
			throw new ClienteAlreadyExistsException();

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
