ALTER TABLE funcionarios ADD COLUMN IF NOT EXISTS func_senha VARCHAR(120);
UPDATE funcionarios SET func_senha = '$2a$12$Wx0zpmBuQGO4wpI28yWKwueCNO7ENPY5/F8KHM5eArWLoS7.CqKJ.';

ALTER TABLE funcionarios ALTER COLUMN func_email SET NOT NULL;
ALTER TABLE funcionarios ALTER COLUMN func_senha SET NOT NULL;