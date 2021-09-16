package com.dlls.pecacerta.api.services;

import java.util.List;
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
	
	@Override
	public Orcamento save(Orcamento model) {
		var cliente = cliService.find(model.getCliente().getCodigo());

		model.setCliente(cliente);
		
		var produtos = model.getProdutosOrcamento();
		model.setProdutosOrcamento(null);
		var savedOrca = super.save(model);
		var produtosDoOrcamento = prodOrcaRepo.findByCodigoOrcamento(savedOrca.getCodigo());
		produtos.forEach((x)-> {
			x.setCodigoOrcamento(savedOrca.getCodigo());
			var prodOrca = produtosDoOrcamento.stream().filter(y-> y.getCodigoProduto() == x.getCodigoProduto()).findFirst();
			if(prodOrca.isPresent())
				x.setCodigo(prodOrca.get().getCodigo());
		});
		trataExclusaoProduto(produtosDoOrcamento, produtos);
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
	
	private void trataExclusaoProduto(List<ProdutosOrcamento> produtosOld, List<ProdutosOrcamento> produtosNew)
	{
		for (var produtosOrcamento : produtosOld) {
			if(! produtosNew.stream().anyMatch(x-> x.getCodigo() == produtosOrcamento.getCodigo()))
				prodOrcaRepo.deleteById(produtosOrcamento.getCodigo());
		}
	}
}
