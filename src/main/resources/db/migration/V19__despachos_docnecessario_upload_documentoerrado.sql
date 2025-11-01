-- V19: Migração das entidades Despachoimprocedencia, Despachoinstancia,
-- Despachorevelia, Docnecessario, Documentoerrado e Uploadnecessario
-- Alvo: PostgreSQL. Mantendo padrão de schema "app" e sequences com INCREMENT BY 50 (conforme V17/V18).

CREATE SCHEMA IF NOT EXISTS app;

-- =========================
-- Sequences
-- =========================
CREATE SEQUENCE IF NOT EXISTS app.docnecessario_iddocnecessario_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS app.uploadnecessario_iduploadnecessario_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS app.documentoerrado_iddocumentoerrado_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS app.despachoimprocedencia_iddespachoimprocedencia_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS app.despachoinstancia_iddespachoinstancia_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS app.despachorevelia_iddespachorevelia_seq INCREMENT BY 50;

-- =========================
-- Tabela: docnecessario
-- =========================
CREATE TABLE IF NOT EXISTS app.docnecessario (
    iddocnecessario      INTEGER PRIMARY KEY DEFAULT nextval('app.docnecessario_iddocnecessario_seq'),
    idagrupamento        INTEGER NOT NULL,
    iditenssolicitacao   INTEGER NOT NULL,
    iddocumento          INTEGER NULL
);

-- Índices FKs docnecessario
CREATE INDEX IF NOT EXISTS idx_docnecessario_idagrupamento ON app.docnecessario (idagrupamento);
CREATE INDEX IF NOT EXISTS idx_docnecessario_iditenssolicitacao ON app.docnecessario (iditenssolicitacao);
CREATE INDEX IF NOT EXISTS idx_docnecessario_iddocumento ON app.docnecessario (iddocumento);

-- FKs docnecessario
DO $$
BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM pg_constraint WHERE conname = 'fk_docnecessario_agrupamento'
    ) THEN
        ALTER TABLE app.docnecessario
            ADD CONSTRAINT fk_docnecessario_agrupamento
            FOREIGN KEY (idagrupamento)
            REFERENCES app.agrupamento (idagrupamento);
    END IF;
END $$;

DO $$
BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM pg_constraint WHERE conname = 'fk_docnecessario_itenssolicitacao'
    ) THEN
        ALTER TABLE app.docnecessario
            ADD CONSTRAINT fk_docnecessario_itenssolicitacao
            FOREIGN KEY (iditenssolicitacao)
            REFERENCES app.itenssolicitacao (iditenssolicitacao);
    END IF;
END $$;

DO $$
BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM pg_constraint WHERE conname = 'fk_docnecessario_documento'
    ) THEN
        ALTER TABLE app.docnecessario
            ADD CONSTRAINT fk_docnecessario_documento
            FOREIGN KEY (iddocumento)
            REFERENCES app.documento (id);
    END IF;
END $$;

-- =========================
-- Tabela: uploadnecessario
-- =========================
CREATE TABLE IF NOT EXISTS app.uploadnecessario (
    iduploadnecessario   INTEGER PRIMARY KEY DEFAULT nextval('app.uploadnecessario_iduploadnecessario_seq'),
    dataupload           DATE,
    documentoupload      TEXT,
    horaupload           TIME,
    iddocnecessario      INTEGER NULL,
    numprocesso          TEXT,
    validacaoupload      INTEGER,
    situacaoupload       INTEGER,
    textoupload          TEXT
);

CREATE INDEX IF NOT EXISTS idx_uploadnecessario_iddocnecessario ON app.uploadnecessario (iddocnecessario);

DO $$
BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM pg_constraint WHERE conname = 'fk_uploadnecessario_docnecessario'
    ) THEN
        ALTER TABLE app.uploadnecessario
            ADD CONSTRAINT fk_uploadnecessario_docnecessario
            FOREIGN KEY (iddocnecessario)
            REFERENCES app.docnecessario (iddocnecessario);
    END IF;
END $$;

-- =========================
-- Tabela: documentoerrado
-- =========================
CREATE TABLE IF NOT EXISTS app.documentoerrado (
    iddocumentoerrado        INTEGER PRIMARY KEY DEFAULT nextval('app.documentoerrado_iddocumentoerrado_seq'),
    datadocumentoerrado      DATE,
    horadocumentoerrado      TIME,
    arquivodocumentoerrado   TEXT,
    iduploadnecessario       INTEGER NULL
);

CREATE INDEX IF NOT EXISTS idx_documentoerrado_iduploadnecessario ON app.documentoerrado (iduploadnecessario);

DO $$
BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM pg_constraint WHERE conname = 'fk_documentoerrado_uploadnecessario'
    ) THEN
        ALTER TABLE app.documentoerrado
            ADD CONSTRAINT fk_documentoerrado_uploadnecessario
            FOREIGN KEY (iduploadnecessario)
            REFERENCES app.uploadnecessario (iduploadnecessario);
    END IF;
END $$;

-- =========================
-- Tabela: despachoimprocedencia
-- =========================
CREATE TABLE IF NOT EXISTS app.despachoimprocedencia (
    iddespachoimprocedencia          INTEGER PRIMARY KEY DEFAULT nextval('app.despachoimprocedencia_iddespachoimprocedencia_seq'),
    secreatriodespachoimprocedencia  VARCHAR(255) NOT NULL,
    textodespachoimprocedencia       TEXT NOT NULL
);

-- =========================
-- Tabela: despachoinstancia
-- =========================
CREATE TABLE IF NOT EXISTS app.despachoinstancia (
    iddespachoinstancia   INTEGER PRIMARY KEY DEFAULT nextval('app.despachoinstancia_iddespachoinstancia_seq'),
    gerenteresponsavel    VARCHAR(255) NOT NULL,
    imagemassinatura      TEXT,
    textoinstancia        TEXT NOT NULL
);

-- =========================
-- Tabela: despachorevelia
-- =========================
CREATE TABLE IF NOT EXISTS app.despachorevelia (
    iddespachorevelia         INTEGER PRIMARY KEY DEFAULT nextval('app.despachorevelia_iddespachorevelia_seq'),
    secretariodespachorevelia VARCHAR(255) NOT NULL,
    textodespachorevelia      TEXT NOT NULL
);

-- =========================
-- Ajuste de setval das sequences conforme dados existentes
-- =========================
DO $$
DECLARE v_max INTEGER;
BEGIN
    -- docnecessario
    SELECT COALESCE(MAX(iddocnecessario), 0) + 1 INTO v_max FROM app.docnecessario;
    PERFORM setval('app.docnecessario_iddocnecessario_seq', GREATEST(v_max, 1), false);

    -- uploadnecessario
    SELECT COALESCE(MAX(iduploadnecessario), 0) + 1 INTO v_max FROM app.uploadnecessario;
    PERFORM setval('app.uploadnecessario_iduploadnecessario_seq', GREATEST(v_max, 1), false);

    -- documentoerrado
    SELECT COALESCE(MAX(iddocumentoerrado), 0) + 1 INTO v_max FROM app.documentoerrado;
    PERFORM setval('app.documentoerrado_iddocumentoerrado_seq', GREATEST(v_max, 1), false);

    -- despachoimprocedencia
    SELECT COALESCE(MAX(iddespachoimprocedencia), 0) + 1 INTO v_max FROM app.despachoimprocedencia;
    PERFORM setval('app.despachoimprocedencia_iddespachoimprocedencia_seq', GREATEST(v_max, 1), false);

    -- despachoinstancia
    SELECT COALESCE(MAX(iddespachoinstancia), 0) + 1 INTO v_max FROM app.despachoinstancia;
    PERFORM setval('app.despachoinstancia_iddespachoinstancia_seq', GREATEST(v_max, 1), false);

    -- despachorevelia
    SELECT COALESCE(MAX(iddespachorevelia), 0) + 1 INTO v_max FROM app.despachorevelia;
    PERFORM setval('app.despachorevelia_iddespachorevelia_seq', GREATEST(v_max, 1), false);
END $$;