CREATE TABLE controle_estoque (
	estq_codigo serial NOT null primary key,
	estq_operacao integer NOT null,
	estq_produto integer unique NOT null,
	estq_preco_de_venda double precision NOT NULL,
	estq_quantidade integer not NULL,
	estq_data date NOT NULL,
	estq_ativo bool NOT NULL DEFAULT true,
	estq_funcionario integer NOT null,
	CONSTRAINT fk_funciona FOREIGN KEY (estq_funcionario)
        REFERENCES funcionarios(codigo),
	CONSTRAINT fk_produto FOREIGN KEY (estq_produto)
        REFERENCES produtos(prod_codigo)
);