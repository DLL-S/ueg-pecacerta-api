package com.dlls.pecacerta.api.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlls.pecacerta.api.exceptions.ProdutoAlreadyExistsException;
import com.dlls.pecacerta.api.exceptions.ProdutoNoneExistentException;
import com.dlls.pecacerta.api.model.Produto;
import com.dlls.pecacerta.api.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	ProdutoRepository produtoRepository;
	
	public Produto findProduto(Long idProduto) {
		var produto = produtoRepository.findById(idProduto).orElseThrow(
				() -> new ProdutoNoneExistentException());
		return produto;
	}
	
	public Produto save(Produto produto) {
		if (!produtoRepository.findByCodigoDeBarras(produto.getCodigoDeBarras()).isEmpty())
			throw new ProdutoAlreadyExistsException();
		
		return this.produtoRepository.save(produto);
	}
	
	public Produto update(Long codigo, Produto produto) {
		var savedProduto = findProduto(codigo);
		
		var produtoComMesmoCodBarras = produtoRepository.findByCodigoDeBarras(produto.getCodigoDeBarras());
		if (!produtoComMesmoCodBarras.isEmpty())
			for(var produtoBr : produtoComMesmoCodBarras)
				if (produtoBr.getCodigo() != savedProduto.getCodigo())
					throw new ProdutoAlreadyExistsException();

		BeanUtils.copyProperties(produto, savedProduto, "codigo");
		return produtoRepository.save(savedProduto);
	}
}
