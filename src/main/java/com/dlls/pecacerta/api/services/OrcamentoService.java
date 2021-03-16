package com.dlls.pecacerta.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dlls.pecacerta.api.model.Orcamento;
import com.dlls.pecacerta.api.model.ProdutosOrcamento;
import com.dlls.pecacerta.api.repositories.OrcamentoRepository;
import com.dlls.pecacerta.api.repositories.ProdutosOrcamentoRepository;

@Service
@Component
public class OrcamentoService extends BaseService<Orcamento, OrcamentoRepository> {
	@Autowired
	ProdutoService prodService;
	
	@Autowired
	ProdutosOrcamentoRepository prodOrcaRepo;

	@Autowired
	ClienteService cliService;
	
	public OrcamentoService()
	{
		
	}
	
	///Construtor para testes.
	public OrcamentoService(ProdutoService prodService, ProdutosOrcamentoRepository prodOrcaRepo, ClienteService cliService, OrcamentoRepository repository)
	{
		this.prodService = prodService;
		this.prodOrcaRepo = prodOrcaRepo;
		this.cliService = cliService;
		super.repository = repository;
	}

	@Override
	public Orcamento save(Orcamento model) {
		var cliente = cliService.find(model.getCliente().getCodigo());
		model.setCliente(cliente);
		
		var produtos = model.getProdutosOrcamento();
		model.setProdutosOrcamento(null);
		var savedOrca = super.save(model);
		produtos.forEach((x)-> x.setCodigoOrcamento(savedOrca.getCodigo()));
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
