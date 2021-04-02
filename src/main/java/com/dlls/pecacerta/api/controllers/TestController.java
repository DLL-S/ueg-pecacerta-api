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
		return ResponseEntity.ok("[{\"_id\": null,\"area\": {\"_id\": null,\"nome\": \"Filial Curitiba\"},\"cargo\": {\"_id\": null,\"areaId\": null, \"nome\": \"Motorista autônomo\"},\"cartaoSUS\": {\"numero\": null},\"celular\": \"(26)9198-98894\", \"centroDeCusto\": { \"_id\": null, \"areas\": null, \"nome\": \"Construtora\" }, \"clienteId\": \"faa83f3c-cd79-4fbb-99d8-5de4e9d09290\", \"cnh\": { \"categoria\": null, \"dataExpedicao\": null, \"dataPrimeiraHabilitacao\": null, \"dataVencimento\": null, \"numero\": null }, \"codigoRequisicao\": \"2ABA8362-EA69-4956-A534-FFAE48CC1156\", \"conta\": { \"agencia\": \"1111111111\", \"banco\": \"341 - Itaú Unibanco S.A.\", \"numero\": \"1111111111111111\", \"tipo\": { \"codigo\": \"10\", \"nome\": \"Conta Corrente\" } }, \"cpf\": \"914.000.925-40\", \"ctps\": { \"dataEmissao\": \"2021-04-02\", \"estado\": { \"codigo\": null, \"nome\": null }, \"numero\": \"9140009\", \"seguroDesemprego\": false, \"serie\": \"2540\" }, \"data\": \"0001-01-01\", \"dataAdmissaoPrevista\": \"0001-01-01\", \"dataInicioReal\": null, \"dataNascimento\": \"1992-10-15\", \"dependentes\": [], \"email\": \"oliver@teste.com\", \"empresa\": { \"_id\": null, \"clienteId\": null, \"cnpj\": \"44040707000105\", \"filiais\": null, \"nome\": \"Empresa Implantação\" }, \"endereco\": { \"bairro\": \"Setor Brasil\", \"cep\": \"77824300\", \"cidade\": { \"codigo\": \"1702109\", \"nome\": \"Araguaína\" }, \"complemento\": null, \"estado\": { \"codigo\": \"17\", \"nome\": \"Tocantins\" }, \"logradouro\": \"Florianópolis\", \"numero\": \"7787\", \"tipoDeLogradouro\": \"39\" }, \"estadoCivil\": { \"codigo\": \"1\", \"nome\": \" Solteiro\" }, \"expediente\": null, \"filial\": { \"_id\": null, \"centrosDeCustos\": null, \"cnpj\": null, \"nome\": \"Filial Curitiba\" }, \"gestor\": { \"_id\": null, \"areaId\": null, \"clienteId\": null, \"nome\": \"MAFAST ACIDENTE TRABALHO MENOS QUINZE DIAS\", \"perfil\": null }, \"grauDeInstrucao\": { \"codigo\": \"10\", \"nome\": \" Pós-Graduação\" }, \"idadmissao\": \"faa83f3c-cd79-4fbb-99d8-5de4e9d09290\", \"idcandidato\": \"f8bf4ff3-8e2c-41a6-a538-ae3de8de3854\", \"mae\": \"MAE\", \"matricula\": \"\", \"meConsideroTransgenero\": false, \"nacionalidade\": { \"codigo\": \"010\", \"nome\": \"Brasil\" }, \"naturalidade\": { \"cidade\": { \"codigo\": \"1501402\", \"nome\": \"Belém\" }, \"estado\": { \"codigo\": \"15\", \"nome\": \"Pará\" } }, \"nome\": \"JULIO OLIVER FERNANDES\", \"nomeCorporativo\": \"\", \"nomeSocial\": \"\", \"opcoesBancarias\": [ { \"cartaDeAberturaDeConta\": \"\", \"nome\": \"\" } ], \"orientacaoSexual\": { \"codigo\": \"\", \"nome\": \"\" }, \"pai\": \"PAI\", \"pis\": { \"dataEmissao\": null, \"numero\": null }, \"raca\": { \"codigo\": \"3\", \"nome\": \"Amarelo(a)\" }, \"reservista\": { \"numero\": null, \"ra\": \"\", \"serie\": \"\" }, \"rg\": { \"dataExpedicao\": null, \"estado\": { \"codigo\": null, \"nome\": null }, \"numero\": \"6546654846846546546546545646545446\", \"orgaoEmissor\": \"IE\" }, \"salario\": \"0.00\", \"sexo\": { \"codigo\": \"0\", \"nome\": \"Feminino\" }, \"telefoneRecado\": null, \"tituloEleitor\": { \"cidade\": { \"codigo\": \"\", \"nome\": \"\" }, \"dataEmissao\": \"\", \"estado\": { \"codigo\": null, \"nome\": null }, \"numero\": \"78747454455446546\", \"secao\": \"5465\", \"zona\": \"768\" }, \"vinculoEmpregaticio\": { \"codigo\": 0, \"descricao\": null }, \"informacoesAdicionais\":[ { \"codigo\": 121, \"valor\":\"42\" }, { \"codigo\": 122, \"valor\":\"GG\" }, {\"codigo\": 123,\"valor\":\"GG\"},{\"codigo\": 124,\"valor\":\"GG\"}]}]");
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> Login()
	{
		return ResponseEntity.ok("{\"token\": \"1C39DE5E-F358-45FC-A928-9BD4FA80FADB\"}");
	}
}
