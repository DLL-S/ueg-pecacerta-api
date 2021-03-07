package com.dlls.pecacerta.api.services;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.dlls.pecacerta.api.exceptions.ProdutoAlreadyExistsException;
import com.dlls.pecacerta.api.model.Produto;
import com.dlls.pecacerta.api.repositories.ProdutoRepository;

@Component
public class ProdutoService extends BaseService<Produto, ProdutoRepository>{
	@Override
	public Produto save(Produto produto) {
		if (!repository.findByCodigoDeBarras(produto.getCodigoDeBarras()).isEmpty())
			throw new ProdutoAlreadyExistsException();
		
		return this.repository.save(produto);
	}

	@Override
	public Produto update(Long codigo, Produto produto) {
		var savedProduto = find(codigo);
		
		var produtoComMesmoCodBarras = repository.findByCodigoDeBarras(produto.getCodigoDeBarras());
		if (!produtoComMesmoCodBarras.isEmpty())
			for(var produtoBr : produtoComMesmoCodBarras)
				if (produtoBr.getCodigo() != savedProduto.getCodigo())
					throw new ProdutoAlreadyExistsException();

		BeanUtils.copyProperties(produto, savedProduto, "codigo");
		return repository.save(savedProduto);
	}
}
