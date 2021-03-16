package com.dlls.pecacerta.api.tests;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import com.dlls.pecacerta.api.model.Cliente;
import com.dlls.pecacerta.api.model.Orcamento;
import com.dlls.pecacerta.api.model.Produto;
import com.dlls.pecacerta.api.model.ProdutosOrcamento;
import com.dlls.pecacerta.api.repositories.ClienteRepository;
import com.dlls.pecacerta.api.repositories.OrcamentoRepository;
import com.dlls.pecacerta.api.repositories.ProdutoRepository;
import com.dlls.pecacerta.api.repositories.ProdutosOrcamentoRepository;
import com.dlls.pecacerta.api.services.BaseService;
import com.dlls.pecacerta.api.services.ClienteService;
import com.dlls.pecacerta.api.services.OrcamentoService;
import com.dlls.pecacerta.api.services.ProdutoService;
import com.dlls.pecacerta.api.utils.EnumTipoCliente;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.google.common.base.Optional;

import javassist.expr.NewArray;
import junit.framework.TestCase;

@SpringBootTest
@AutoConfigureMockMvc
public class OrcamentoTest{

	@SpyBean
	@MockBean
	@Spy
	@Mock
	ProdutosOrcamentoRepository prodOrcaRepo;

	@Spy
	@Mock
	@SpyBean
	@MockBean
	OrcamentoRepository orcaRepo;

	@Spy
	@Mock
	@SpyBean
	@MockBean
	ProdutoService prodService = new ProdutoService();

	@Spy
	@Mock
	@SpyBean
	@MockBean
	ClienteService cliService = new ClienteService();
	
	@Autowired
	@InjectMocks
	OrcamentoService servOrca;
	
	Produto produto;
	Cliente cliente;

	@Before
	public void setUp() throws Exception {
		cliente = new Cliente();
		cliente.setCodigo((long) 1);
		cliente.setAtivo(true);
		cliente.setCpfCnpj("43691942881");
		cliente.setDataNascFund(LocalDate.of(2000,04,13));
		cliente.setTipoCliente(EnumTipoCliente.PESSOA_FISICA);
		
		produto = new Produto();
		produto.setAtivo(true);
		produto.setPreco(12.5);
		
		orcaRepo = Mockito.mock(OrcamentoRepository.class);
		when(orcaRepo
		        .save(Mockito.any()))
		        .thenReturn(getOrcamentoSaved());
		
		cliService = Mockito.mock(ClienteService.class);
		when(cliService
		        .find((long) 1))
		        .thenReturn(cliente);
		
		prodService = Mockito.mock(ProdutoService.class);
		when(prodService
		        .find((long)1))
		        .thenReturn(produto);
		when(prodService
		        .consulteValor((long)1))
		        .thenReturn(produto.getPreco()*5);
		
		prodOrcaRepo = Mockito.mock(ProdutosOrcamentoRepository.class);
		when(prodOrcaRepo
		        .saveAll(Mockito.any()))
		        .thenReturn(new ArrayList<ProdutosOrcamento>());
		
		servOrca = new OrcamentoService(prodService, prodOrcaRepo, cliService, orcaRepo);
	}

	@Test
	public void testNovoOrcamento() {
		var savedOrca = servOrca.save(getOrcamentoNotSaved());
		assertNotNull(savedOrca);
		assertTrue(savedOrca.getCodigo() != 0);
		assertTrue(savedOrca.getValorTotal() != null);
	}
	
	private Orcamento getOrcamentoNotSaved()
	{
		var orcamento = new Orcamento();
		var cli = new Cliente();
		cli.setCodigo((long) 1);
		orcamento.setCliente(cli);
		orcamento.setProdutosOrcamento(new ArrayList<ProdutosOrcamento>());
		orcamento.setData(new java.sql.Date(2021,03,13));
		return orcamento;
	}
	
	private Orcamento getOrcamentoSaved()
	{
		var orcamento = getOrcamentoNotSaved();
		orcamento.setCliente(cliente);
		orcamento.setCodigo((long) 1);
		return orcamento;
	}
}
