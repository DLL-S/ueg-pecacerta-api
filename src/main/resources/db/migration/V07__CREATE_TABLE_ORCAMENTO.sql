CREATE TABLE orcamentos (
	orca_codigo serial NOT null primary key,
	orca_cliente integer NOT null,
	orca_data date NOT NULL,
	orca_valor_total double precision NOT NULL,
	orca_observacoes varchar NULL,
	orca_produtos_orcamento varchar not null,
	orca_ativo bool NOT NULL DEFAULT true,
	CONSTRAINT fk_clientes FOREIGN KEY (orca_cliente)
        REFERENCES clientes(codigo)
);

create table produtos_orcamento(
	orca_codigo serial NOT null primary key,
	orca_codigo_produto integer not null,
	orca_codigo_orcamento integer not null,
	orca_quantidade_produto integer not null,
	CONSTRAINT fk_produtos FOREIGN KEY (orca_codigo_produto)
        REFERENCES produtos(prod_codigo),
	CONSTRAINT fk_orcamentos FOREIGN KEY (orca_codigo_orcamento)
        REFERENCES orcamentos(orca_codigo)
);
