CREATE TABLE Funcionarios (
	codigo SERIAL PRIMARY KEY,
	func_nome VARCHAR(60) NOT NULL,
	func_tipo_funcionario VARCHAR(20) NOT NULL,
	func_cpf VARCHAR(11) NOT NULL UNIQUE,
	func_data_nasc DATE NOT NULL,
	func_logradouro VARCHAR(40),
    func_numero VARCHAR(10),
    func_complemento VARCHAR(30),
    func_bairro VARCHAR(30),
    func_cep VARCHAR(10),
    func_cidade VARCHAR(30),
    func_estado varchar(30),
    func_email VARCHAR(40) NOT NULL,
    func_telefone VARCHAR(12) NOT NULL
);

INSERT INTO Funcionarios (func_nome,func_tipo_funcionario,func_cpf,func_data_nasc,func_logradouro,func_numero,func_complemento,func_bairro,func_cep,func_cidade,func_estado,func_email,func_telefone) 
VALUES ('Lucas De Moraes Corrêa','Gerente',54691578064,'2000-06-02','Rua 230, Qd 49',230,'Próximo ao ipasgo','Universitário','74.605-110','Goiânia','Goiás','lucas.moraes@pecacerta.com','62994168746');
INSERT INTO Funcionarios (func_nome,func_tipo_funcionario,func_cpf,func_data_nasc,func_logradouro,func_numero,func_complemento,func_bairro,func_cep,func_cidade,func_estado,func_email,func_telefone) 
VALUES ('Leonardo Pereira Cabral','Gerente',99219038021,'1999-01-02','Avenida cine, lote 01',438,'Ed. Nova Morada','Alfaville','11.400-102','Goiânia','Goiás','leonardo.pereira@pecacerta.com','62994412301');
INSERT INTO Funcionarios (func_nome,func_tipo_funcionario,func_cpf,func_data_nasc,func_logradouro,func_numero,func_complemento,func_bairro,func_cep,func_cidade,func_estado,func_email,func_telefone) 
VALUES ('Danyellias Vaz De Lima Manso','Gerente',71480034070,'1998-02-08','Alamenda Bota Fogo, Lote 48',856,'Ed. Prime','Nova canaã','54.212-152','Goiânia','Goiás','danyellias.manso@pecacerta.com','6295478604');
INSERT INTO Funcionarios (func_nome,func_tipo_funcionario,func_cpf,func_data_nasc,func_logradouro,func_numero,func_complemento,func_bairro,func_cep,func_cidade,func_estado,func_email,func_telefone) 
VALUES ('Fernando Pereira Da Cunha','Atendente',35262670067,'1996-05-04','Rua 44',668,'Edifício Passa Tempo','Setor Oeste','38.400-128','Goiânia','Goiás','fernando.cunha@pecacerta.com','62995412301');