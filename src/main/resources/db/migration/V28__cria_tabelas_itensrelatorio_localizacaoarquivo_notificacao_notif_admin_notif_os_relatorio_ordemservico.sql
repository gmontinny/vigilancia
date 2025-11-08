-- V28: Criação das tabelas para Itensrelatorio, Localizacaoarquivo, Notificacao,
-- Notificacaoadministrativa, Notificacaoordemservico, Relatorio e Ordemservico
-- Observação: Nomes de tabelas, colunas e sequences seguem exatamente a nomenclatura das entidades.
-- Banco: PostgreSQL

-- ===============
-- Sequences
-- ===============
CREATE SEQUENCE IF NOT EXISTS ordemservico_idordemservico_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS localizacaoarquivo_idlocalizacaoarquivo_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS notificacao_idnotificacao_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS notificacaoadministrativa_idnotivicacaoadministrativa_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS notificacaoordemservico_idnotificacaoordemservico_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS relatorio_idrelatorio_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS itensrelatorio_iditensrelatorio_seq INCREMENT BY 50;

-- ===============
-- Tabela: ordemservico
-- ===============
CREATE TABLE IF NOT EXISTS ordemservico (
    idordemservico            INTEGER PRIMARY KEY DEFAULT nextval('ordemservico_idordemservico_seq'),
    datafinal                 DATE,
    datainicial               DATE,
    dataordemservico          DATE,
    dataconclusao             DATE,
    usuarioconclusao          VARCHAR(255),
    situacaoordemservico      INTEGER,
    textoconclusao            VARCHAR(255),
    textoproblema             VARCHAR(255),
    prioridadeordemservico    INTEGER,
    tlsordemservico           INTEGER,
    tipoordemservico          INTEGER,
    horaordemservico          TIME,
    tipodocumento             VARCHAR(255),
    descricaodocumento        VARCHAR(255),
    idacao                    INTEGER,
    numprocesso               VARCHAR(255)
);

-- FKs da ordemservico
DO $$
BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM information_schema.table_constraints tc
        WHERE tc.constraint_name = 'fk_ordemservico_idacao'
          AND tc.table_name = 'ordemservico'
    ) THEN
        ALTER TABLE ordemservico
            ADD CONSTRAINT fk_ordemservico_idacao
            FOREIGN KEY (idacao) REFERENCES acao;
    END IF;

    IF NOT EXISTS (
        SELECT 1 FROM information_schema.table_constraints tc
        WHERE tc.constraint_name = 'fk_ordemservico_numprocesso'
          AND tc.table_name = 'ordemservico'
    ) THEN
        -- Processo está mapeado como schema = app, coluna PK = numeroProcesso
        ALTER TABLE ordemservico
            ADD CONSTRAINT fk_ordemservico_numprocesso
            FOREIGN KEY (numprocesso) REFERENCES app.processo(numero_processo);
    END IF;
END $$;

CREATE INDEX IF NOT EXISTS idx_ordemservico_idacao ON ordemservico (idacao);
CREATE INDEX IF NOT EXISTS idx_ordemservico_numprocesso ON ordemservico (numprocesso);

-- ===============
-- Tabela: localizacaoarquivo
-- ===============
CREATE TABLE IF NOT EXISTS localizacaoarquivo (
    idlocalizacaoarquivo  INTEGER PRIMARY KEY DEFAULT nextval('localizacaoarquivo_idlocalizacaoarquivo_seq'),
    numprocesso           VARCHAR(255) NOT NULL,
    tipolocalizacao       INTEGER NOT NULL,
    prateleira            INTEGER NOT NULL
);

-- FK para Processo (schema app)
DO $$
BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM information_schema.table_constraints tc
        WHERE tc.constraint_name = 'fk_localizacaoarquivo_numprocesso'
          AND tc.table_name = 'localizacaoarquivo'
    ) THEN
        ALTER TABLE localizacaoarquivo
            ADD CONSTRAINT fk_localizacaoarquivo_numprocesso
            FOREIGN KEY (numprocesso) REFERENCES app.processo(numero_processo);
    END IF;
END $$;

CREATE INDEX IF NOT EXISTS idx_localizacaoarquivo_numprocesso ON localizacaoarquivo (numprocesso);

-- ===============
-- Tabela: notificacao
-- ===============
CREATE TABLE IF NOT EXISTS notificacao (
    idnotificacao      INTEGER PRIMARY KEY DEFAULT nextval('notificacao_idnotificacao_seq'),
    datanotificacao    DATE,
    statusnotificacao  INTEGER,
    denotificacao      VARCHAR(255),
    paranotificacao    VARCHAR(255),
    mensagemnotificacao VARCHAR(255),
    totalnotificacao   INTEGER,
    horanotificacao    TIME,
    idusuario          INTEGER NOT NULL
);

DO $$
BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM information_schema.table_constraints tc
        WHERE tc.constraint_name = 'fk_notificacao_idusuario'
          AND tc.table_name = 'notificacao'
    ) THEN
        ALTER TABLE notificacao
            ADD CONSTRAINT fk_notificacao_idusuario
            FOREIGN KEY (idusuario) REFERENCES usuario;
    END IF;
END $$;

CREATE INDEX IF NOT EXISTS idx_notificacao_idusuario ON notificacao (idusuario);

-- ===============
-- Tabela: notificacaoadministrativa
-- ===============
CREATE TABLE IF NOT EXISTS notificacaoadministrativa (
    idnotificacaoadministrativa     INTEGER PRIMARY KEY DEFAULT nextval('notificacaoadministrativa_idnotivicacaoadministrativa_seq'),
    datanotificacaoadministrativa   DATE,
    horanotificacaoadministrativa   TIME,
    liberarnotificacaoadministrativa INTEGER,
    numeroauto                      INTEGER NOT NULL,
    textonotificacaoadministrativa  VARCHAR(255) NOT NULL
);

-- ===============
-- Tabela: notificacaoordemservico
-- ===============
CREATE TABLE IF NOT EXISTS notificacaoordemservico (
    idnotificacaoordemservico        INTEGER PRIMARY KEY DEFAULT nextval('notificacaoordemservico_idnotificacaoordemservico_seq'),
    datanotificacaoordemservico      DATE,
    horanotificacaooredemservico     TIME,
    idordemservico                   INTEGER NOT NULL,
    idusuario                        INTEGER NOT NULL,
    statusordemservico               INTEGER
);

DO $$
BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM information_schema.table_constraints tc
        WHERE tc.constraint_name = 'fk_notificacaoos_idordemservico'
          AND tc.table_name = 'notificacaoordemservico'
    ) THEN
        ALTER TABLE notificacaoordemservico
            ADD CONSTRAINT fk_notificacaoos_idordemservico
            FOREIGN KEY (idordemservico) REFERENCES ordemservico;
    END IF;

    IF NOT EXISTS (
        SELECT 1 FROM information_schema.table_constraints tc
        WHERE tc.constraint_name = 'fk_notificacaoos_idusuario'
          AND tc.table_name = 'notificacaoordemservico'
    ) THEN
        ALTER TABLE notificacaoordemservico
            ADD CONSTRAINT fk_notificacaoos_idusuario
            FOREIGN KEY (idusuario) REFERENCES usuario;
    END IF;
END $$;

CREATE INDEX IF NOT EXISTS idx_notificacaoos_idordemservico ON notificacaoordemservico (idordemservico);
CREATE INDEX IF NOT EXISTS idx_notificacaoos_idusuario ON notificacaoordemservico (idusuario);

-- ===============
-- Tabela: relatorio
-- ===============
CREATE TABLE IF NOT EXISTS relatorio (
    idrelatorio          INTEGER PRIMARY KEY DEFAULT nextval('relatorio_idrelatorio_seq'),
    descricaorelatorio   VARCHAR(255) NOT NULL,
    nomerelatorio        VARCHAR(255) NOT NULL
);

-- ===============
-- Tabela: itensrelatorio
-- ===============
CREATE TABLE IF NOT EXISTS itensrelatorio (
    iditensrelatorio  INTEGER PRIMARY KEY DEFAULT nextval('itensrelatorio_iditensrelatorio_seq'),
    idrelatorio       INTEGER,
    idusuario         INTEGER
);

DO $$
BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM information_schema.table_constraints tc
        WHERE tc.constraint_name = 'fk_itensrelatorio_idrelatorio'
          AND tc.table_name = 'itensrelatorio'
    ) THEN
        ALTER TABLE itensrelatorio
            ADD CONSTRAINT fk_itensrelatorio_idrelatorio
            FOREIGN KEY (idrelatorio) REFERENCES relatorio;
    END IF;

    IF NOT EXISTS (
        SELECT 1 FROM information_schema.table_constraints tc
        WHERE tc.constraint_name = 'fk_itensrelatorio_idusuario'
          AND tc.table_name = 'itensrelatorio'
    ) THEN
        ALTER TABLE itensrelatorio
            ADD CONSTRAINT fk_itensrelatorio_idusuario
            FOREIGN KEY (idusuario) REFERENCES usuario;
    END IF;
END $$;

CREATE INDEX IF NOT EXISTS idx_itensrelatorio_idrelatorio ON itensrelatorio (idrelatorio);
CREATE INDEX IF NOT EXISTS idx_itensrelatorio_idusuario ON itensrelatorio (idusuario);

-- ===============
-- Ajuste de setval das sequences (sincroniza com dados existentes)
-- ===============
DO $$
DECLARE
    v_max INTEGER;
    v_pkcol TEXT;
BEGIN
    -- ordemservico (compatível com ambientes onde a PK é 'id' ou 'idordemservico')
    SELECT kcu.column_name INTO v_pkcol
    FROM information_schema.table_constraints tc
    JOIN information_schema.key_column_usage kcu
      ON kcu.constraint_name = tc.constraint_name
     AND kcu.table_schema = tc.table_schema
    WHERE tc.constraint_type = 'PRIMARY KEY'
      AND tc.table_name = 'ordemservico'
      AND (tc.table_schema = 'public' OR tc.table_schema = current_schema())
    LIMIT 1;

    IF v_pkcol IS NULL THEN
        -- fallback: tenta detectar coluna por nome esperado
        IF EXISTS (
            SELECT 1 FROM information_schema.columns
            WHERE table_schema = current_schema()
              AND table_name = 'ordemservico'
              AND column_name = 'idordemservico'
        ) THEN
            v_pkcol := 'idordemservico';
        ELSIF EXISTS (
            SELECT 1 FROM information_schema.columns
            WHERE table_schema = current_schema()
              AND table_name = 'ordemservico'
              AND column_name = 'id'
        ) THEN
            v_pkcol := 'id';
        END IF;
    END IF;

    IF v_pkcol IS NOT NULL THEN
        EXECUTE format('SELECT COALESCE(MAX(%I), 0) + 1 FROM ordemservico', v_pkcol) INTO v_max;
        PERFORM setval('ordemservico_idordemservico_seq', GREATEST(v_max, 1), false);
    END IF;

    -- localizacaoarquivo
    SELECT COALESCE(MAX(idlocalizacaoarquivo), 0) + 1 INTO v_max FROM localizacaoarquivo;
    PERFORM setval('localizacaoarquivo_idlocalizacaoarquivo_seq', GREATEST(v_max, 1), false);

    -- notificacao
    SELECT COALESCE(MAX(idnotificacao), 0) + 1 INTO v_max FROM notificacao;
    PERFORM setval('notificacao_idnotificacao_seq', GREATEST(v_max, 1), false);

    -- notificacaoadministrativa
    SELECT COALESCE(MAX(idnotificacaoadministrativa), 0) + 1 INTO v_max FROM notificacaoadministrativa;
    PERFORM setval('notificacaoadministrativa_idnotivicacaoadministrativa_seq', GREATEST(v_max, 1), false);

    -- notificacaoordemservico
    SELECT COALESCE(MAX(idnotificacaoordemservico), 0) + 1 INTO v_max FROM notificacaoordemservico;
    PERFORM setval('notificacaoordemservico_idnotificacaoordemservico_seq', GREATEST(v_max, 1), false);

    -- relatorio
    SELECT COALESCE(MAX(idrelatorio), 0) + 1 INTO v_max FROM relatorio;
    PERFORM setval('relatorio_idrelatorio_seq', GREATEST(v_max, 1), false);

    -- itensrelatorio
    SELECT COALESCE(MAX(iditensrelatorio), 0) + 1 INTO v_max FROM itensrelatorio;
    PERFORM setval('itensrelatorio_iditensrelatorio_seq', GREATEST(v_max, 1), false);
END $$;
