-- V21: Corrige a sequência da tabela embalagem
-- Problema: A entidade Embalagem espera a sequência embalagem_idembalagem_seq, 
-- mas a tabela foi criada com IDENTITY na V11

-- Remove a propriedade IDENTITY da coluna primeiro
ALTER TABLE app.embalagem ALTER COLUMN idembalagem DROP IDENTITY IF EXISTS;

-- Cria a sequência esperada pelo Hibernate
CREATE SEQUENCE IF NOT EXISTS app.embalagem_idembalagem_seq INCREMENT BY 1;

-- Ajusta o valor inicial da sequência para o próximo valor após os registros existentes
DO $$
BEGIN
    PERFORM setval('app.embalagem_idembalagem_seq', COALESCE((SELECT MAX(idembalagem) FROM app.embalagem), 0) + 1, false);
END $$;

-- Define o default para usar a sequência
ALTER TABLE app.embalagem ALTER COLUMN idembalagem SET DEFAULT nextval('app.embalagem_idembalagem_seq');