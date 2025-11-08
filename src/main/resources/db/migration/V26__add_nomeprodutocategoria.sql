-- V26: Ajuste da tabela app.produtocategoria para compatibilizar com o mapeamento JPA
-- Objetivo: garantir a existência da coluna nomeprodutocategoria

CREATE SCHEMA IF NOT EXISTS app;

-- Adiciona a coluna se não existir (mantida como NULLABLE para compatibilidade)
ALTER TABLE IF EXISTS app.produtocategoria
    ADD COLUMN IF NOT EXISTS nomeprodutocategoria TEXT;

-- Tentativa de preenchimento a partir de colunas legadas, se existirem
DO $$
BEGIN
    -- Copiar de "nome" se a coluna existir
    IF EXISTS (
        SELECT 1 FROM information_schema.columns
        WHERE table_schema = 'app' AND table_name = 'produtocategoria' AND column_name = 'nome'
    ) THEN
        EXECUTE 'UPDATE app.produtocategoria SET nomeprodutocategoria = COALESCE(nomeprodutocategoria, nome)';
    END IF;

    -- Copiar de "descricao" se a coluna existir
    IF EXISTS (
        SELECT 1 FROM information_schema.columns
        WHERE table_schema = 'app' AND table_name = 'produtocategoria' AND column_name = 'descricao'
    ) THEN
        EXECUTE 'UPDATE app.produtocategoria SET nomeprodutocategoria = COALESCE(nomeprodutocategoria, descricao)';
    END IF;

    -- Copiar de "categoria" se a coluna existir
    IF EXISTS (
        SELECT 1 FROM information_schema.columns
        WHERE table_schema = 'app' AND table_name = 'produtocategoria' AND column_name = 'categoria'
    ) THEN
        EXECUTE 'UPDATE app.produtocategoria SET nomeprodutocategoria = COALESCE(nomeprodutocategoria, categoria)';
    END IF;
END $$;

-- Observação: Não aplicamos NOT NULL aqui para evitar falhas em bancos já populados.
-- O @NotNull do JPA garante validação na aplicação ao salvar/atualizar registros.
