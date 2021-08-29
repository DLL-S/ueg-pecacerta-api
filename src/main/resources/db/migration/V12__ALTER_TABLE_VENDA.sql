ALTER TABLE vendas ADD vnd_forma_de_pagamento VARCHAR(40);
ALTER TABLE vendas alter column vnd_nota_fiscal drop not null;
ALTER TABLE notas_fiscais ADD nf_codigo_venda integer;
ALTER TABLE notas_fiscais alter column nf_numero type varchar(100);