package com.dlls.pecacerta.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dlls.pecacerta.api.model.MovimentacaoEstoque;
import com.dlls.pecacerta.api.repositories.MovimentacaoEstoqueRepository;
import com.dlls.pecacerta.api.enumerators.EnumOperacaoEstoque;

@Component
public class EstoqueService extends BaseService<MovimentacaoEstoque, MovimentacaoEstoqueRepository> {

	@Autowired
	ProdutoService servicoProduto;
	@Autowired
	FuncionarioService servicoFuncionario;

	public MovimentacaoEstoque registrarTroca(Long codigoProduto, int quantidade, Long codigoAtendente) 
	{
		var produto = servicoProduto.find(codigoProduto);
		var atendente = servicoFuncionario.find(codigoAtendente);
		var movimentacao = new MovimentacaoEstoque(produto, quantidade, EnumOperacaoEstoque.Troca, atendente);
		produto.setQtdeEstoque(produto.getQtdeEstoque()-quantidade);
		servicoProduto.update(codigoProduto, produto);
		return this.save(movimentacao);
	}
	
	public MovimentacaoEstoque registrarVenda(Long codigoProduto, int quantidade, Long codigoAtendente)
	{
		var produto = servicoProduto.find(codigoProduto);
		var atendente = servicoFuncionario.find(codigoAtendente);
		var movimentacao = new MovimentacaoEstoque(produto, quantidade, EnumOperacaoEstoque.Saida, atendente);
		produto.setQtdeEstoque(produto.getQtdeEstoque()-quantidade);
		servicoProduto.update(codigoProduto, produto);
		return this.save(movimentacao);
	}
	
	public MovimentacaoEstoque registrarInclusao(Long codigoProduto, int quantidade, Long codigoAtendente)
	{
		var produto = servicoProduto.find(codigoProduto);
		var atendente = servicoFuncionario.find(codigoAtendente);
		var movimentacao = new MovimentacaoEstoque(produto, quantidade, EnumOperacaoEstoque.Saida, atendente);
		produto.setQtdeEstoque(produto.getQtdeEstoque()+quantidade);
		servicoProduto.update(codigoProduto, produto);
		return this.save(movimentacao);
	}
	
	public MovimentacaoEstoque registrarOperacaoManterProduto(Long codigoProduto, int diferenca, Long codigoAtendente)
	{
		if(diferenca != 0)
		{
			var produto = servicoProduto.find(codigoProduto);
			var atendente = servicoFuncionario.find(codigoAtendente);
			var movimentacao = new MovimentacaoEstoque(produto, diferenca > 0 ? diferenca : diferenca*(-1), diferenca > 0 ? EnumOperacaoEstoque.Entrada : EnumOperacaoEstoque.Perda, atendente);
			return this.save(movimentacao);
		}
		
		return null;
	}

}
