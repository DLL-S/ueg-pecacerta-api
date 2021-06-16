package com.dlls.pecacerta.api.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dlls.pecacerta.api.enumerators.EnumFormaDePagamento;
import com.dlls.pecacerta.api.enumerators.EnumOperacaoEstoque;
import com.dlls.pecacerta.api.model.Orcamento;
import com.dlls.pecacerta.api.model.ProdutosVenda;
import com.dlls.pecacerta.api.model.Venda;
import com.dlls.pecacerta.api.repositories.ProdutosOrcamentoRepository;
import com.dlls.pecacerta.api.repositories.ProdutosVendaRepository;
import com.dlls.pecacerta.api.repositories.VendaRepository;
import com.dlls.pecacerta.api.utils.VendaOrcamentoConverter;

@Component
public class VendaService extends BaseService<Venda, VendaRepository> {
	@Autowired
	NotaFiscalService servicoDeNotas;
	
	@Autowired
	EstoqueService servicoDeEstoque;

	@Autowired
	ProdutosVendaRepository prodVendRepo;
	
	public Boolean AutorizacaoDoGestor(String tokenUsrGestor) {
		return true;
	}
	
	public Venda RealizarVenda(Orcamento orcamento, EnumFormaDePagamento formaPagamento, Long codigoAtendente) {
		var venda = VendaOrcamentoConverter.ObtenhaVenda(orcamento, formaPagamento);
		if((formaPagamento == EnumFormaDePagamento.APrazoBoletoBancario || 
			formaPagamento == EnumFormaDePagamento.APrazoCheque))
			// && !EhGerente(codigoAtendente))
		{
			// Pedir autorização;
		}
		else {
			var produtos = VendaOrcamentoConverter.ObtenhaProdutosVenda(orcamento.getProdutosOrcamento());
			venda = FinalizeVenda(venda, produtos, codigoAtendente);
		}
		
		return venda;
	}
	
	public Venda RealizarVenda(Venda venda, Long codigoAtendente) {
		if((venda.getFormaDePagamento() == EnumFormaDePagamento.APrazoBoletoBancario || 
				venda.getFormaDePagamento() == EnumFormaDePagamento.APrazoCheque))
			// && !EhGerente(codigoAtendente))
		{
			// Pedir autorização;
		}
		else {
			venda = FinalizeVenda(venda, venda.getProdutosVenda(), codigoAtendente);
		}
		
		return venda;
	}
	
	private Venda FinalizeVenda(Venda venda, List<ProdutosVenda> produtosVenda, Long codigoAtendente)
	{
		venda.setData(new Date(System.currentTimeMillis()));
		var savedVenda = this.save(venda);
		
		produtosVenda.forEach((x)-> {
			x.setCodigoVenda(savedVenda.getCodigo());
		});
		
		savedVenda.setProdutosVenda(produtosVenda);
		
		for (ProdutosVenda produtoVenda : savedVenda.getProdutosVenda()) {
			servicoDeEstoque.registrarMovimentacao(
					produtoVenda.getCodigoProduto(),
					produtoVenda.getQuantidade(),
					EnumOperacaoEstoque.Saida,
					codigoAtendente
				);
		}
		
		prodVendRepo.saveAll(produtosVenda);
		return this.save(GerarNotaFiscal(savedVenda));
	}
	
	private Venda GerarNotaFiscal(Venda venda)
	{
		venda.setNotaFiscal(servicoDeNotas.GerarNotaFiscal(venda.getCodigo()));
		return venda;
	}
}
