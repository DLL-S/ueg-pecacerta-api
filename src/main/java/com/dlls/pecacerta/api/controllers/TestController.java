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
		return ResponseEntity.ok("[{\"_id\": null,\"area\": {\"_id\": null,\"nome\": \"Filial Curitiba\"},\"cargo\": {\"_id\": null,\"areaId\": null,\r\n"
				+ "            \"nome\": \"Motorista autônomo\"},\"cartaoSUS\": {\"numero\": null},\"celular\": \"(26)9198-98894\",\r\n"
				+ "        \"centroDeCusto\": {\r\n"
				+ "            \"_id\": null,\r\n"
				+ "            \"areas\": null,\r\n"
				+ "            \"nome\": \"Construtora\"\r\n"
				+ "        },\r\n"
				+ "        \"clienteId\": \"faa83f3c-cd79-4fbb-99d8-5de4e9d09290\",\r\n"
				+ "        \"cnh\": {\r\n"
				+ "            \"categoria\": null,\r\n"
				+ "            \"dataExpedicao\": null,\r\n"
				+ "            \"dataPrimeiraHabilitacao\": null,\r\n"
				+ "            \"dataVencimento\": null,\r\n"
				+ "            \"numero\": null\r\n"
				+ "        },\r\n"
				+ "        \"codigoRequisicao\": \"2ABA8362-EA69-4956-A534-FFAE48CC1156\",\r\n"
				+ "        \"conta\": {\r\n"
				+ "            \"agencia\": \"1111111111\",\r\n"
				+ "            \"banco\": \"341 - Itaú Unibanco S.A.\",\r\n"
				+ "            \"numero\": \"1111111111111111\",\r\n"
				+ "            \"tipo\": {\r\n"
				+ "                \"codigo\": \"10\",\r\n"
				+ "                \"nome\": \"Conta Corrente\"\r\n"
				+ "            }\r\n"
				+ "        },\r\n"
				+ "        \"cpf\": \"914.000.925-40\",\r\n"
				+ "        \"ctps\": {\r\n"
				+ "            \"dataEmissao\": \"2021-04-02\",\r\n"
				+ "            \"estado\": {\r\n"
				+ "                \"codigo\": null,\r\n"
				+ "                \"nome\": null\r\n"
				+ "            },\r\n"
				+ "            \"numero\": \"9140009\",\r\n"
				+ "            \"seguroDesemprego\": false,\r\n"
				+ "            \"serie\": \"2540\"\r\n"
				+ "        },\r\n"
				+ "        \"data\": \"0001-01-01\",\r\n"
				+ "        \"dataAdmissaoPrevista\": \"0001-01-01\",\r\n"
				+ "        \"dataInicioReal\": null,\r\n"
				+ "        \"dataNascimento\": \"1992-10-15\",\r\n"
				+ "        \"dependentes\": [],\r\n"
				+ "        \"email\": \"oliver@teste.com\",\r\n"
				+ "        \"empresa\": {\r\n"
				+ "            \"_id\": null,\r\n"
				+ "            \"clienteId\": null,\r\n"
				+ "            \"cnpj\": \"44040707000105\",\r\n"
				+ "            \"filiais\": null,\r\n"
				+ "            \"nome\": \"Empresa Implantação\"\r\n"
				+ "        },\r\n"
				+ "        \"endereco\": {\r\n"
				+ "            \"bairro\": \"Setor Brasil\",\r\n"
				+ "            \"cep\": \"77824300\",\r\n"
				+ "            \"cidade\": {\r\n"
				+ "                \"codigo\": \"1702109\",\r\n"
				+ "                \"nome\": \"Araguaína\"\r\n"
				+ "            },\r\n"
				+ "            \"complemento\": null,\r\n"
				+ "            \"estado\": {\r\n"
				+ "                \"codigo\": \"17\",\r\n"
				+ "                \"nome\": \"Tocantins\"\r\n"
				+ "            },\r\n"
				+ "            \"logradouro\": \"Florianópolis\",\r\n"
				+ "            \"numero\": \"7787\",\r\n"
				+ "            \"tipoDeLogradouro\": \"39\"\r\n"
				+ "        },\r\n"
				+ "        \"estadoCivil\": {\r\n"
				+ "            \"codigo\": \"1\",\r\n"
				+ "            \"nome\": \" Solteiro\"\r\n"
				+ "        },\r\n"
				+ "        \"expediente\": null,\r\n"
				+ "        \"filial\": {\r\n"
				+ "            \"_id\": null,\r\n"
				+ "            \"centrosDeCustos\": null,\r\n"
				+ "            \"cnpj\": null,\r\n"
				+ "            \"nome\": \"Filial Curitiba\"\r\n"
				+ "        },\r\n"
				+ "        \"gestor\": {\r\n"
				+ "            \"_id\": null,\r\n"
				+ "            \"areaId\": null,\r\n"
				+ "            \"clienteId\": null,\r\n"
				+ "            \"nome\": \"MAFAST ACIDENTE TRABALHO MENOS QUINZE DIAS\",\r\n"
				+ "            \"perfil\": null\r\n"
				+ "        },\r\n"
				+ "        \"grauDeInstrucao\": {\r\n"
				+ "            \"codigo\": \"10\",\r\n"
				+ "            \"nome\": \" Pós-Graduação\"\r\n"
				+ "        },\r\n"
				+ "        \"idadmissao\": \"faa83f3c-cd79-4fbb-99d8-5de4e9d09290\",\r\n"
				+ "        \"idcandidato\": \"f8bf4ff3-8e2c-41a6-a538-ae3de8de3854\",\r\n"
				+ "        \"mae\": \"MAE\",\r\n"
				+ "        \"matricula\": \"\",\r\n"
				+ "        \"meConsideroTransgenero\": false,\r\n"
				+ "        \"nacionalidade\": {\r\n"
				+ "            \"codigo\": \"010\",\r\n"
				+ "            \"nome\": \"Brasil\"\r\n"
				+ "        },\r\n"
				+ "        \"naturalidade\": {\r\n"
				+ "            \"cidade\": {\r\n"
				+ "                \"codigo\": \"1501402\",\r\n"
				+ "                \"nome\": \"Belém\"\r\n"
				+ "            },\r\n"
				+ "            \"estado\": {\r\n"
				+ "                \"codigo\": \"15\",\r\n"
				+ "                \"nome\": \"Pará\"\r\n"
				+ "            }\r\n"
				+ "        },\r\n"
				+ "        \"nome\": \"JULIO OLIVER FERNANDES\",\r\n"
				+ "        \"nomeCorporativo\": \"\",\r\n"
				+ "        \"nomeSocial\": \"\",\r\n"
				+ "        \"opcoesBancarias\": [\r\n"
				+ "            {\r\n"
				+ "                \"cartaDeAberturaDeConta\": \"\",\r\n"
				+ "                \"nome\": \"\"\r\n"
				+ "            }\r\n"
				+ "        ],\r\n"
				+ "        \"orientacaoSexual\": {\r\n"
				+ "            \"codigo\": \"\",\r\n"
				+ "            \"nome\": \"\"\r\n"
				+ "        },\r\n"
				+ "        \"pai\": \"PAI\",\r\n"
				+ "        \"pis\": {\r\n"
				+ "            \"dataEmissao\": null,\r\n"
				+ "            \"numero\": null\r\n"
				+ "        },\r\n"
				+ "        \"raca\": {\r\n"
				+ "            \"codigo\": \"3\",\r\n"
				+ "            \"nome\": \"Amarelo(a)\"\r\n"
				+ "        },\r\n"
				+ "        \"reservista\": {\r\n"
				+ "            \"numero\": null,\r\n"
				+ "            \"ra\": \"\",\r\n"
				+ "            \"serie\": \"\"\r\n"
				+ "        },\r\n"
				+ "        \"rg\": {\r\n"
				+ "            \"dataExpedicao\": null,\r\n"
				+ "            \"estado\": {\r\n"
				+ "                \"codigo\": null,\r\n"
				+ "                \"nome\": null\r\n"
				+ "            },\r\n"
				+ "            \"numero\": \"6546654846846546546546545646545446\",\r\n"
				+ "            \"orgaoEmissor\": \"IE\"\r\n"
				+ "        },\r\n"
				+ "        \"salario\": \"0.00\",\r\n"
				+ "        \"sexo\": {\r\n"
				+ "            \"codigo\": \"0\",\r\n"
				+ "            \"nome\": \"Feminino\"\r\n"
				+ "        },\r\n"
				+ "        \"telefoneRecado\": null,\r\n"
				+ "        \"tituloEleitor\": {\r\n"
				+ "            \"cidade\": {\r\n"
				+ "                \"codigo\": \"\",\r\n"
				+ "                \"nome\": \"\"\r\n"
				+ "            },\r\n"
				+ "            \"dataEmissao\": \"\",\r\n"
				+ "            \"estado\": {\r\n"
				+ "                \"codigo\": null,\r\n"
				+ "                \"nome\": null\r\n"
				+ "            },\r\n"
				+ "            \"numero\": \"78747454455446546\",\r\n"
				+ "            \"secao\": \"5465\",\r\n"
				+ "            \"zona\": \"768\"\r\n"
				+ "        },\r\n"
				+ "        \"vinculoEmpregaticio\": {\r\n"
				+ "            \"codigo\": 0,\r\n"
				+ "            \"descricao\": null\r\n"
				+ "        },\r\n"
				+ "        \"informacoesAdicionais\":[\r\n"
				+ "            {\r\n"
				+ "                \"codigo\": 121,\r\n"
				+ "                 \"valor\":\"42\"\r\n"
				+ "            },\r\n"
				+ "            {\r\n"
				+ "                \"codigo\": 122, \r\n"
				+ "                \"valor\":\"GG\"\r\n"
				+ "            },\r\n"
				+ "            {\r\n"
				+ "                \"codigo\": 123, \r\n"
				+ "                \"valor\":\"GG\"\r\n"
				+ "            },\r\n"
				+ "            {\r\n"
				+ "                \"codigo\": 124, \r\n"
				+ "                \"valor\":\"GG\"\r\n"
				+ "            }\r\n"
				+ "        ]\r\n"
				+ "    }\r\n"
				+ "]");
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> Login()
	{
		return ResponseEntity.ok("{\"token\": \"1C39DE5E-F358-45FC-A928-9BD4FA80FADB\"}");
	}
}
