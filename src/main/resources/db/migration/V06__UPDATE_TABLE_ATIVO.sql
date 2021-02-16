ALTER TABLE produtos ADD prod_ativo boolean NOT NULL DEFAULT true;
ALTER TABLE marcas ADD marca_ativo boolean NOT NULL DEFAULT true;
ALTER TABLE funcionarios ADD func_ativo boolean NOT NULL DEFAULT true;
ALTER TABLE clientes ADD cli_ativo boolean NOT NULL DEFAULT true;
ALTER TABLE categorias ADD cat_ativo boolean NOT NULL DEFAULT true;