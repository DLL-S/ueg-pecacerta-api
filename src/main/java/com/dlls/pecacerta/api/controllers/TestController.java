package com.dlls.pecacerta.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="*", methods= {RequestMethod.PUT, RequestMethod.POST, RequestMethod.GET})
@RestController
@RequestMapping("test")
public class TestController{
	@GetMapping("/integracoes/admissoes")
	public ResponseEntity<?> AprovadoPeloGestor()
	{
		return ResponseEntity.ok("[{\"_id\":null,\"area\":{\"_id\":null,\"nome\":\"Matriz Goiania\"},\"cargo\":{\"_id\":null,\"areaId\":null,\"nome\":\"Analista De Negócios\"},\"cartaoSUS\":{\"numero\":null},\"celular\":\"(62)9123-45678\",\"centroDeCusto\":{\"_id\":null,\"areas\":null,\"nome\":\"Administrativo\"},\"clienteId\":\"ae45eea0-e4fd-486f-a232-308b3be8e858\",\"cnh\":{\"categoria\":null,\"dataExpedicao\":null,\"dataPrimeiraHabilitacao\":null,\"dataVencimento\":null,\"numero\":null},\"codigoRequisicao\":\"7FDA169A-B345-4F9D-A742-D4C3523CB9C2\",\"conta\":{\"agencia\":\"0001\",\"banco\":\"341 - Itaú Unibanco S.A.\",\"numero\":\"41555157\",\"tipo\":{\"codigo\":\"10\",\"nome\":\"Conta Corrente\"}},\"cpf\":\"970.814.970-55\",\"ctps\":{\"dataEmissao\":\"2021-04-01\",\"estado\":{\"codigo\":null,\"nome\":null},\"numero\":\"9708149\",\"seguroDesemprego\":false,\"serie\":\"7055\"},\"data\":\"0001-01-01\",\"dataAdmissaoPrevista\":\"0001-01-01\",\"dataInicioReal\":null,\"dataNascimento\":\"2000-06-17\",\"dependentes\":[],\"email\":\"leonardopereira10@gmail.com\",\"empresa\":{\"_id\":null,\"clienteId\":null,\"cnpj\":\"44040707000105\",\"filiais\":null,\"nome\":\"Empresa Implantação\"},\"endereco\":{\"bairro\":\"Jardim Europa\",\"cep\":\"74325130\",\"cidade\":{\"codigo\":\"5208707\",\"nome\":\"Goiânia\"},\"complemento\":null,\"estado\":{\"codigo\":\"52\",\"nome\":\"Goiás\"},\"logradouro\":\"Capri\",\"numero\":\"52\",\"tipoDeLogradouro\":\"39\"},\"estadoCivil\":{\"codigo\":\"1\",\"nome\":\" Solteiro\"},\"expediente\":null,\"filial\":{\"_id\":null,\"centrosDeCustos\":null,\"cnpj\":null,\"nome\":\"Matriz Goiania\"},\"gestor\":{\"_id\":null,\"areaId\":null,\"clienteId\":null,\"nome\":\"MAT NORMAL\",\"perfil\":null},\"grauDeInstrucao\":{\"codigo\":\"5\",\"nome\":\" Ensino Fundamental Completo\"},\"idadmissao\":\"ae45eea0-e4fd-486f-a232-308b3be8e858\",\"idcandidato\":\"a0dce294-4899-415c-aec4-f12ded266ee1\",\"mae\":null,\"matricula\":\"\",\"meConsideroTransgenero\":false,\"nacionalidade\":{\"codigo\":\"010\",\"nome\":\"Brasil\"},\"naturalidade\":{\"cidade\":{\"codigo\":\"5002407\",\"nome\":\"Caarapó\"},\"estado\":{\"codigo\":\"50\",\"nome\":\"Mato Grosso do Sul \"}},\"nome\":\"ALEATORIOO\",\"nomeCorporativo\":\"\",\"nomeSocial\":\"\",\"opcoesBancarias\":[{\"cartaDeAberturaDeConta\":\"\",\"nome\":\"\"}],\"orientacaoSexual\":{\"codigo\":\"\",\"nome\":\"\"},\"pai\":null,\"pis\":{\"dataEmissao\":null,\"numero\":null},\"raca\":{\"codigo\":\"4\",\"nome\":\"Indigena\"},\"reservista\":{\"numero\":null,\"ra\":\"\",\"serie\":\"\"},\"rg\":{\"dataExpedicao\":null,\"estado\":{\"codigo\":null,\"nome\":null},\"numero\":\"385590568\",\"orgaoEmissor\":\"IE\"},\"salario\":\"1000.00\",\"sexo\":{\"codigo\":\"0\",\"nome\":\"Feminino\"},\"telefoneRecado\":null,\"tituloEleitor\":{\"cidade\":{\"codigo\":\"\",\"nome\":\"\"},\"dataEmissao\":\"\",\"estado\":{\"codigo\":null,\"nome\":null},\"numero\":\"0515502151503\",\"secao\":\"0015\",\"zona\":\"500\"},\"vinculoEmpregaticio\":{\"codigo\":0,\"descricao\":null},\"informacoesAdicionais\": [{\"codigo\": 121, \"valor\":\"info adic\"},{\"codigo\": 122, \"valor\":\"dois\"},{\"codigo\": 123, \"valor\":\"tres\"},{\"codigo\": 124, \"valor\":\"quatro\"}]}]");
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> Login()
	{
		return ResponseEntity.ok("{\"token\": \"1C39DE5E-F358-45FC-A928-9BD4FA80FADB\"}");
	}
}
