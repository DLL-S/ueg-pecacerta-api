package com.dlls.pecacerta.api.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dlls.pecacerta.api.exceptions.ProdutoAlreadyExistsException;
import com.dlls.pecacerta.api.model.Produto;
import com.dlls.pecacerta.api.repositories.ProdutoRepository;

@Component
public class ProdutoService extends BaseService<Produto, ProdutoRepository>{
	@Autowired
	EstoqueService estoqueservice;
	
	@Override
	public Produto save(Produto produto) {
		if (!repository.findByCodigoDeBarras(produto.getCodigoDeBarras()).isEmpty())
			throw new ProdutoAlreadyExistsException();
		
		var callback = this.repository.save(produto);
		estoqueservice.registrarOperacaoManterProduto(callback.getCodigo(), callback.getQtdeEstoque(), (long)1);
		return callback;
	}

	@Override
	public Produto update(Long codigo, Produto produto) {
		var savedProduto = find(codigo);
		
		var produtoComMesmoCodBarras = repository.findByCodigoDeBarras(produto.getCodigoDeBarras());
		if (!produtoComMesmoCodBarras.isEmpty())
			for(var produtoBr : produtoComMesmoCodBarras)
				if (produtoBr.getCodigo() != savedProduto.getCodigo())
					throw new ProdutoAlreadyExistsException();

		produto.setCodigo(codigo);
		
		var callback = this.repository.save(produto);
		
		return callback;
	}
	public double consulteValor(Long id)
	{
		return find(id).getPreco();
	}
}
