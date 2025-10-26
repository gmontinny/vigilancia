-- V8__ajustes_nomes_colunas_servicos.sql
-- Padroniza nomes de colunas da tabela servicos para snake_case sem aspas
-- Alvo: PostgreSQL 15

-- Observação:
-- A V5 criou colunas com identificadores citados e camelCase: "grupoAservicos".."grupoEservicos".
-- Aqui renomeamos para nomes válidos em snake_case, alinhados ao naming padrão do Hibernate.

DO $$
BEGIN
    -- Renomeia apenas se a coluna existir com o nome antigo e a nova ainda não existir
    IF EXISTS (
        SELECT 1 FROM information_schema.columns
        WHERE table_schema = current_schema()
          AND table_name = 'servicos'
          AND column_name = 'grupoAservicos'
    ) AND NOT EXISTS (
        SELECT 1 FROM information_schema.columns
        WHERE table_schema = current_schema()
          AND table_name = 'servicos'
          AND column_name = 'grupo_a'
    ) THEN
        EXECUTE 'ALTER TABLE servicos RENAME COLUMN "grupoAservicos" TO grupo_a';
    END IF;

    IF EXISTS (
        SELECT 1 FROM information_schema.columns
        WHERE table_schema = current_schema()
          AND table_name = 'servicos'
          AND column_name = 'grupoBservicos'
    ) AND NOT EXISTS (
        SELECT 1 FROM information_schema.columns
        WHERE table_schema = current_schema()
          AND table_name = 'servicos'
          AND column_name = 'grupo_b'
    ) THEN
        EXECUTE 'ALTER TABLE servicos RENAME COLUMN "grupoBservicos" TO grupo_b';
    END IF;

    IF EXISTS (
        SELECT 1 FROM information_schema.columns
        WHERE table_schema = current_schema()
          AND table_name = 'servicos'
          AND column_name = 'grupoCservicos'
    ) AND NOT EXISTS (
        SELECT 1 FROM information_schema.columns
        WHERE table_schema = current_schema()
          AND table_name = 'servicos'
          AND column_name = 'grupo_c'
    ) THEN
        EXECUTE 'ALTER TABLE servicos RENAME COLUMN "grupoCservicos" TO grupo_c';
    END IF;

    IF EXISTS (
        SELECT 1 FROM information_schema.columns
        WHERE table_schema = current_schema()
          AND table_name = 'servicos'
          AND column_name = 'grupoDservicos'
    ) AND NOT EXISTS (
        SELECT 1 FROM information_schema.columns
        WHERE table_schema = current_schema()
          AND table_name = 'servicos'
          AND column_name = 'grupo_d'
    ) THEN
        EXECUTE 'ALTER TABLE servicos RENAME COLUMN "grupoDservicos" TO grupo_d';
    END IF;

    IF EXISTS (
        SELECT 1 FROM information_schema.columns
        WHERE table_schema = current_schema()
          AND table_name = 'servicos'
          AND column_name = 'grupoEservicos'
    ) AND NOT EXISTS (
        SELECT 1 FROM information_schema.columns
        WHERE table_schema = current_schema()
          AND table_name = 'servicos'
          AND column_name = 'grupo_e'
    ) THEN
        EXECUTE 'ALTER TABLE servicos RENAME COLUMN "grupoEservicos" TO grupo_e';
    END IF;
END $$;