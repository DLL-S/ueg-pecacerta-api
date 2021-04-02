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
		return ResponseEntity.ok("[{\r\n"
				+ "        \"_id\": null,\r\n"
				+ "        \"area\": {\r\n"
				+ "            \"_id\": null,\r\n"
				+ "            \"nome\": \"Matriz Goiania\"\r\n"
				+ "        },\r\n"
				+ "        \"cargo\": {\r\n"
				+ "            \"_id\": null,\r\n"
				+ "            \"areaId\": null,\r\n"
				+ "            \"nome\": \"Analista De Negócios\"\r\n"
				+ "        },\r\n"
				+ "        \"cartaoSUS\": {\r\n"
				+ "            \"numero\": null\r\n"
				+ "        },\r\n"
				+ "        \"celular\": \"(62)1258-67592\",\r\n"
				+ "        \"centroDeCusto\": {\r\n"
				+ "            \"_id\": null,\r\n"
				+ "            \"areas\": null,\r\n"
				+ "            \"nome\": \"Administrativo\"\r\n"
				+ "        },\r\n"
				+ "        \"clienteId\": \"0619f11f-5c6c-4167-99fc-84aad0feb545\",\r\n"
				+ "        \"cnh\": {\r\n"
				+ "            \"categoria\": null,\r\n"
				+ "            \"dataExpedicao\": null,\r\n"
				+ "            \"dataPrimeiraHabilitacao\": null,\r\n"
				+ "            \"dataVencimento\": null,\r\n"
				+ "            \"numero\": null\r\n"
				+ "        },\r\n"
				+ "        \"codigoRequisicao\": \"2B6E72D5-77F9-42E6-847B-00F153B9898E\",\r\n"
				+ "        \"conta\": {\r\n"
				+ "            \"agencia\": \"0001\",\r\n"
				+ "            \"banco\": \"341 - Itaú Unibanco S.A.\",\r\n"
				+ "            \"numero\": \"518592845\",\r\n"
				+ "            \"tipo\": {\r\n"
				+ "                \"codigo\": \"10\",\r\n"
				+ "                \"nome\": \"Conta Corrente\"\r\n"
				+ "            }\r\n"
				+ "        },\r\n"
				+ "        \"cpf\": \"290.450.680-28\",\r\n"
				+ "        \"ctps\": {\r\n"
				+ "            \"dataEmissao\": \"2021-04-02\",\r\n"
				+ "            \"estado\": {\r\n"
				+ "                \"codigo\": null,\r\n"
				+ "                \"nome\": null\r\n"
				+ "            },\r\n"
				+ "            \"numero\": \"2904506\",\r\n"
				+ "            \"seguroDesemprego\": false,\r\n"
				+ "            \"serie\": \"8028\"\r\n"
				+ "        },\r\n"
				+ "        \"data\": \"0001-01-01\",\r\n"
				+ "        \"dataAdmissaoPrevista\": \"0001-01-01\",\r\n"
				+ "        \"dataInicioReal\": null,\r\n"
				+ "        \"dataNascimento\": \"2000-04-20\",\r\n"
				+ "        \"dependentes\": [],\r\n"
				+ "        \"email\": \"ailll@email.com\",\r\n"
				+ "        \"empresa\": {\r\n"
				+ "            \"_id\": null,\r\n"
				+ "            \"clienteId\": null,\r\n"
				+ "            \"cnpj\": \"44040707000105\",\r\n"
				+ "            \"filiais\": null,\r\n"
				+ "            \"nome\": \"Empresa Implantação\"\r\n"
				+ "        },\r\n"
				+ "        \"endereco\": {\r\n"
				+ "            \"bairro\": \"Jardim Europa\",\r\n"
				+ "            \"cep\": \"74325140\",\r\n"
				+ "            \"cidade\": {\r\n"
				+ "                \"codigo\": \"5208707\",\r\n"
				+ "                \"nome\": \"Goiânia\"\r\n"
				+ "            },\r\n"
				+ "            \"complemento\": null,\r\n"
				+ "            \"estado\": {\r\n"
				+ "                \"codigo\": \"52\",\r\n"
				+ "                \"nome\": \"Goiás\"\r\n"
				+ "            },\r\n"
				+ "            \"logradouro\": \"Piza\",\r\n"
				+ "            \"numero\": \"852\",\r\n"
				+ "            \"tipoDeLogradouro\": \"39\"\r\n"
				+ "        },\r\n"
				+ "        \"estadoCivil\": {\r\n"
				+ "            \"codigo\": \"2\",\r\n"
				+ "            \"nome\": \" Casado\"\r\n"
				+ "        },\r\n"
				+ "        \"expediente\": null,\r\n"
				+ "        \"filial\": {\r\n"
				+ "            \"_id\": null,\r\n"
				+ "            \"centrosDeCustos\": null,\r\n"
				+ "            \"cnpj\": null,\r\n"
				+ "            \"nome\": \"Matriz Goiania\"\r\n"
				+ "        },\r\n"
				+ "        \"gestor\": {\r\n"
				+ "            \"_id\": null,\r\n"
				+ "            \"areaId\": null,\r\n"
				+ "            \"clienteId\": null,\r\n"
				+ "            \"nome\": \"mirela mura\",\r\n"
				+ "            \"perfil\": null\r\n"
				+ "        },\r\n"
				+ "        \"grauDeInstrucao\": {\r\n"
				+ "            \"codigo\": \"18\",\r\n"
				+ "            \"nome\": \" MBA Incompleto\"\r\n"
				+ "        },\r\n"
				+ "        \"idadmissao\": \"0619f11f-5c6c-4167-99fc-84aad0feb545\",\r\n"
				+ "        \"idcandidato\": \"574d3363-f36e-4b27-b573-97171ed52590\",\r\n"
				+ "        \"mae\": \"MAE\",\r\n"
				+ "        \"matricula\": \"\",\r\n"
				+ "        \"meConsideroTransgenero\": false,\r\n"
				+ "        \"nacionalidade\": {\r\n"
				+ "            \"codigo\": \"010\",\r\n"
				+ "            \"nome\": \"Brasil\"\r\n"
				+ "        },\r\n"
				+ "        \"naturalidade\": {\r\n"
				+ "            \"cidade\": {\r\n"
				+ "                \"codigo\": \"4101309\",\r\n"
				+ "                \"nome\": \"Antônio Olinto\"\r\n"
				+ "            },\r\n"
				+ "            \"estado\": {\r\n"
				+ "                \"codigo\": \"41\",\r\n"
				+ "                \"nome\": \"Paraná\"\r\n"
				+ "            }\r\n"
				+ "        },\r\n"
				+ "        \"nome\": \"CADASTRO API\",\r\n"
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
				+ "        \"pai\": \"PAE\",\r\n"
				+ "        \"pis\": {\r\n"
				+ "            \"dataEmissao\": null,\r\n"
				+ "            \"numero\": null\r\n"
				+ "        },\r\n"
				+ "        \"raca\": {\r\n"
				+ "            \"codigo\": \"2\",\r\n"
				+ "            \"nome\": \"Negro(a)\"\r\n"
				+ "        },\r\n"
				+ "        \"reservista\": {\r\n"
				+ "            \"numero\": null,\r\n"
				+ "            \"ra\": \"\",\r\n"
				+ "            \"serie\": \"\"\r\n"
				+ "        },\r\n"
				+ "        \"rg\": {\r\n"
				+ "            \"dataExpedicao\": null,\r\n"
				+ "            \"estado\": {\r\n"
				+ "                \"codigo\": \"25\",\r\n"
				+ "                \"nome\": \"Paraiba\"\r\n"
				+ "            },\r\n"
				+ "            \"numero\": \"1515158882\",\r\n"
				+ "            \"orgaoEmissor\": \"EX\"\r\n"
				+ "        },\r\n"
				+ "        \"salario\": \"2500.00\",\r\n"
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
				+ "                \"codigo\": null,\"nome\": null},\"numero\": \"151515105\",\"secao\": \"6021\",\"zona\": \"100\"},\"vinculoEmpregaticio\": {\"codigo\": 0,\"descricao\": null}, \"informacoesAdicionais\":[{\"codigo\": 1,\"valor\":\"063802f1-5744-4efc-90d2-01ae5491bd88\"}]}]");
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> Login()
	{
		return ResponseEntity.ok("{\"token\": \"1C39DE5E-F358-45FC-A928-9BD4FA80FADB\"}");
	}
}
