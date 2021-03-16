package com.dlls.pecacerta.api.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dlls.pecacerta.api.model.Orcamento;
import com.dlls.pecacerta.api.model.ProdutosOrcamento;
import com.dlls.pecacerta.api.repositories.OrcamentoRepository;
import com.dlls.pecacerta.api.repositories.ProdutosOrcamentoRepository;

@Component
public class OrcamentoService extends BaseService<Orcamento, OrcamentoRepository> {
	@Autowired
	ProdutoService prodService;
	
	@Autowired
	ProdutosOrcamentoRepository prodOrcaRepo;

	@Autowired
	ClienteService cliService;
	
	public Orcamento addProdutosOrcamento(Long id, Long idprod, Integer quantidade) {
		var param = prodService.find(idprod);
		var orcamento = find(id);
		var prodOrcamento = orcamento.getProdutosOrcamento();
		ProdutosOrcamento orcamentoProduto;
		if( prodOrcamento.stream().anyMatch(x -> x.getCodigoProduto() == param.getCodigo()))
		{
			orcamentoProduto = prodOrcamento.stream().filter(x -> x.getCodigoProduto() == param.getCodigo()).findFirst().get();
			prodOrcamento.remove(orcamentoProduto);
			var qtdOld = orcamentoProduto.getQuantidade();
			var newQtd = qtdOld + quantidade > 0 ? qtdOld + quantidade : 0;
			orcamentoProduto.setQuantidade(newQtd);
		}
		else
		{
			orcamentoProduto = new ProdutosOrcamento(param.getCodigo(), id, quantidade);
		}
		
		prodOrcamento.add(orcamentoProduto);
		orcamento.setProdutosOrcamento(prodOrcamento);
		
		return this.save(atualizaValorTotal(orcamento));
	}

	@Override
	public Orcamento save(Orcamento model) {
		var cliente = cliService.find(model.getCliente().getCodigo());

		model.setCliente(cliente);
		
		var produtos = model.getProdutosOrcamento();
		model.setProdutosOrcamento(null);
		var savedOrca = super.save(model);
		var produtosDoOrcamento = prodOrcaRepo.findAll().stream().filter(y->y.getCodigoOrcamento() == savedOrca.getCodigo());
		produtos.forEach((x)-> {
			x.setCodigoOrcamento(savedOrca.getCodigo());
			var prodOrca = produtosDoOrcamento.filter(y-> y.getCodigoProduto() == x.getCodigoProduto()).findFirst();
			if(prodOrca.isPresent())
				x.setCodigo(prodOrca.get().getCodigo());
		});
		produtos = prodOrcaRepo.saveAll(produtos);
		savedOrca.setProdutosOrcamento(produtos);
		return super.save(atualizaValorTotal(savedOrca));
	}
	
	private Orcamento atualizaValorTotal(Orcamento model)
	{
		Double valores = 0.0;
		for (var iterable_element : model.getProdutosOrcamento()) {
			valores += iterable_element.getQuantidade()*prodService.consulteValor(iterable_element.getCodigoProduto());
		}
		
		model.setValorTotal(valores);
		return model;
	}
}
