CREATE TABLE clientes (
	codigo SERIAL PRIMARY KEY,
	cli_nome VARCHAR(60) NOT NULL,
	cli_tipo_cliente VARCHAR(20) NOT NULL,
	cli_cpf_cnpj VARCHAR(14) NOT NULL UNIQUE,
	cli_data_nasc DATE NOT NULL,
	cli_logradouro VARCHAR(40),
    cli_numero VARCHAR(10),
    cli_complemento VARCHAR(30),
    cli_bairro VARCHAR(30),
    cli_cep VARCHAR(10),
    cli_cidade VARCHAR(30),
    cli_estado varchar(30),
    cli_email VARCHAR(40) NOT NULL,
    cli_telefone VARCHAR(12) NOT NULL
);

INSERT INTO clientes (cli_nome,cli_tipo_cliente,cli_cpf_cnpj,cli_data_nasc,cli_logradouro,cli_numero,cli_complemento,cli_bairro,cli_cep,cli_cidade,cli_estado,cli_email,cli_telefone)
VALUES ('Têm De Tudo Auto Peças S/A','PESSOA_JURIDICA',73904387000184,'2018-06-02','Rua 3, Qd 43',80,'Ao lado da drgoaria','Bom Jesus','74.605-110','Trindade','Goiás','temdetudopecas@gmail.com','3003654893');
INSERT INTO clientes (cli_nome,cli_tipo_cliente,cli_cpf_cnpj,cli_data_nasc,cli_logradouro,cli_numero,cli_complemento,cli_bairro,cli_cep,cli_cidade,cli_estado,cli_email,cli_telefone)
VALUES ('Damião Dos Santos e Silva','PESSOA_FISICA',23919716051,'1985-09-02','Rua 9, Lote 12',201,'Apto 206','Marista','74.485-110','Goiânia','Goiás','damiao.silva@gmail.com','62458746250');