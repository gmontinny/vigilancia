-- V31: Criação das tabelas Tramiteadm, Uploadrestricao, Uploadvalidate e Valorauto
-- Banco: PostgreSQL. Segue o padrão do projeto (V30/V32): sequences INCREMENT BY 50,
-- nomes de colunas conforme entidades e índices para possíveis FKs.

-- =====================
-- Sequences
-- =====================
CREATE SEQUENCE IF NOT EXISTS tramiteadm_idtramiteadm_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS uploadrestricao_iduploadrestricao_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS uploadvalidate_iduploadvalidate_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS valorauto_idvalorauto_seq INCREMENT BY 50;

-- =====================
-- Tabela: tramiteadm
-- =====================
CREATE TABLE IF NOT EXISTS tramiteadm (
    idtramiteadm       INTEGER PRIMARY KEY DEFAULT nextval('tramiteadm_idtramiteadm_seq'),
    datafinal          DATE NOT NULL,
    datainicial        DATE NOT NULL,
    idusuario          INTEGER,
    numerotramiteadm   INTEGER,
    numprocesso        VARCHAR(255),
    situacao           VARCHAR(255),
    status             INTEGER,
    numeroauto         INTEGER
);

CREATE INDEX IF NOT EXISTS idx_tramiteadm_numprocesso ON tramiteadm (numprocesso);

-- =====================
-- Tabela: uploadrestricao
-- =====================
CREATE TABLE IF NOT EXISTS uploadrestricao (
    iduploadrestricao   INTEGER PRIMARY KEY DEFAULT nextval('uploadrestricao_iduploadrestricao_seq'),
    iditenssolicitacao  INTEGER NOT NULL,
    totaldocumentos     INTEGER NOT NULL,
    descricao           VARCHAR(255)
);

-- FK para Itenssolicitacao, quando existir
DO $$
BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM information_schema.table_constraints tc
        WHERE tc.constraint_name = 'fk_uploadrestricao_iditenssolicitacao'
          AND tc.table_name = 'uploadrestricao'
    ) THEN
        BEGIN
            ALTER TABLE uploadrestricao
                ADD CONSTRAINT fk_uploadrestricao_iditenssolicitacao
                FOREIGN KEY (iditenssolicitacao) REFERENCES itenssolicitacao(iditenssolicitacao);
        EXCEPTION WHEN undefined_table THEN
            -- Tabela itenssolicitacao não existe neste momento da migração; ignorar FK.
            NULL;
        END;
    END IF;
END $$;

CREATE INDEX IF NOT EXISTS idx_uploadrestricao_iditenssolicitacao ON uploadrestricao (iditenssolicitacao);

-- =====================
-- Tabela: uploadvalidate
-- =====================
CREATE TABLE IF NOT EXISTS uploadvalidate (
    iduploadvalidate  INTEGER PRIMARY KEY DEFAULT nextval('uploadvalidate_iduploadvalidate_seq'),
    dataupload        DATE,
    documentoupload   VARCHAR(255),
    horaupload        TIME,
    iddocnecessario   INTEGER,
    numprocesso       VARCHAR(255),
    situacaoupload    INTEGER,
    textoupload       VARCHAR(2048),
    validacaoupload   INTEGER
);

CREATE INDEX IF NOT EXISTS idx_uploadvalidate_numprocesso ON uploadvalidate (numprocesso);

-- =====================
-- Tabela: valorauto
-- =====================
CREATE TABLE IF NOT EXISTS valorauto (
    idvalorauto   INTEGER PRIMARY KEY DEFAULT nextval('valorauto_idvalorauto_seq'),
    grauinfracao  INTEGER NOT NULL,
    valor         VARCHAR(255) NOT NULL,
    valorminimo   VARCHAR(255) NOT NULL
);

-- =====================
-- Ajuste de setval das sequences (sincroniza com dados existentes)
-- =====================
DO $$
DECLARE v_max INTEGER;
BEGIN
    -- tramiteadm
    SELECT COALESCE(MAX(idtramiteadm), 0) + 1 INTO v_max FROM tramiteadm;
    PERFORM setval('tramiteadm_idtramiteadm_seq', GREATEST(v_max, 1), false);

    -- uploadrestricao
    SELECT COALESCE(MAX(iduploadrestricao), 0) + 1 INTO v_max FROM uploadrestricao;
    PERFORM setval('uploadrestricao_iduploadrestricao_seq', GREATEST(v_max, 1), false);

    -- uploadvalidate
    SELECT COALESCE(MAX(iduploadvalidate), 0) + 1 INTO v_max FROM uploadvalidate;
    PERFORM setval('uploadvalidate_iduploadvalidate_seq', GREATEST(v_max, 1), false);

    -- valorauto
    SELECT COALESCE(MAX(idvalorauto), 0) + 1 INTO v_max FROM valorauto;
    PERFORM setval('valorauto_idvalorauto_seq', GREATEST(v_max, 1), false);
END $$;
