create table notas_fiscais(
	nf_codigo serial NOT null primary key,
	nf_numero integer not null
);

CREATE TABLE vendas (
	vnd_codigo serial NOT null primary key,
	vnd_cliente integer NOT null,
	vnd_nota_fiscal integer unique NOT null,
	vnd_data date NOT NULL,
	vnd_valor_total double precision NOT NULL,
	vnd_observacoes varchar NULL,
	vnd_ativo bool NOT NULL DEFAULT true,
	CONSTRAINT fk_clientes FOREIGN KEY (vnd_cliente)
        REFERENCES clientes(codigo),
	CONSTRAINT fk_nf FOREIGN KEY (vnd_nota_fiscal)
        REFERENCES notas_fiscais(nf_codigo)
);

create table produtos_vendas(
	vnd_codigo serial NOT null primary key,
	vnd_codigo_produto integer not null,
	vnd_codigo_venda integer not null,
	vnd_quantidade_produto integer not null,
	CONSTRAINT fk_produtos FOREIGN KEY (vnd_codigo_produto)
        REFERENCES produtos(prod_codigo),
	CONSTRAINT fk_vendas FOREIGN KEY (vnd_codigo_venda)
        REFERENCES vendas(vnd_codigo)
);