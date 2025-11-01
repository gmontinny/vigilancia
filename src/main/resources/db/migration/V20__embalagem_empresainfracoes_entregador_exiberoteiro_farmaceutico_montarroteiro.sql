-- V20: Migração das entidades Embalagem, Empresainfracoes, Entregador, Exiberoteiro, Farmaceutico e Montarroteiro
-- Alvo: PostgreSQL. Padrão de schema "app" e sequences com INCREMENT BY 50 (conforme V19).

CREATE SCHEMA IF NOT EXISTS app;

-- =========================
-- Sequences
-- =========================
CREATE SEQUENCE IF NOT EXISTS app.embalagem_idembalagem_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS app.empresainfracoes_idempresainfracoes_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS app.entregador_identregador_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS app.exiberoteiro_idexiberoteiro_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS app.farmaceuticos_idfarmaceuticos_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS app.montarroteiro_idmontarroteiro_seq INCREMENT BY 50;

-- =========================
-- Tabela: embalagem
-- =========================
CREATE TABLE IF NOT EXISTS app.embalagem (
    idembalagem          INTEGER PRIMARY KEY DEFAULT nextval('app.embalagem_idembalagem_seq'),
    descricaoembalagem   VARCHAR(255) NOT NULL
);

-- =========================
-- Tabela: empresainfracoes
-- =========================
CREATE TABLE IF NOT EXISTS app.empresainfracoes (
    idempresainfracoes   INTEGER PRIMARY KEY DEFAULT nextval('app.empresainfracoes_idempresainfracoes_seq'),
    tipoempresa          INTEGER NOT NULL,
    tipoinfracoes        INTEGER NOT NULL,
    valor                DOUBLE PRECISION NOT NULL
);

-- =========================
-- Tabela: entregador
-- =========================
CREATE TABLE IF NOT EXISTS app.entregador (
    identregador       INTEGER PRIMARY KEY DEFAULT nextval('app.entregador_identregador_seq'),
    celentregador      VARCHAR(64),
    cpfentregador      VARCHAR(32)  NOT NULL,
    emailentregador    VARCHAR(255),
    nomeentregador     VARCHAR(255) NOT NULL,
    numprocesso        VARCHAR(64)  NOT NULL,
    imagementregador   TEXT,
    telentregador      VARCHAR(64)
);

CREATE INDEX IF NOT EXISTS idx_entregador_numprocesso ON app.entregador (numprocesso);

DO $$
BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM pg_constraint WHERE conname = 'fk_entregador_processo'
    ) THEN
        ALTER TABLE app.entregador
            ADD CONSTRAINT fk_entregador_processo
            FOREIGN KEY (numprocesso)
            REFERENCES app.processo (numero_processo);
    END IF;
END $$;

-- =========================
-- Tabela: farmaceuticos
-- =========================
CREATE TABLE IF NOT EXISTS app.farmaceuticos (
    idfarmaceuticos            INTEGER PRIMARY KEY DEFAULT nextval('app.farmaceuticos_idfarmaceuticos_seq'),
    administracaofarmaceuticos INTEGER,
    afericaofarmaceuticos      INTEGER,
    atencaofarmaceuticos       INTEGER,
    entregafarmaceuticos       INTEGER,
    inalacaofarmaceuticos      INTEGER,
    perfuracaofarmaceuticos    INTEGER,
    quaisfarmaceuticos         VARCHAR(1024),
    numprocesso                VARCHAR(64)
);

CREATE INDEX IF NOT EXISTS idx_farmaceuticos_numprocesso ON app.farmaceuticos (numprocesso);

DO $$
BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM pg_constraint WHERE conname = 'fk_farmaceuticos_processo'
    ) THEN
        ALTER TABLE app.farmaceuticos
            ADD CONSTRAINT fk_farmaceuticos_processo
            FOREIGN KEY (numprocesso)
            REFERENCES app.processo (numero_processo);
    END IF;
END $$;

-- =========================
-- Tabela: montarroteiro
-- =========================
CREATE TABLE IF NOT EXISTS app.montarroteiro (
    idmontarroteiro   INTEGER PRIMARY KEY DEFAULT nextval('app.montarroteiro_idmontarroteiro_seq'),
    numeroroteiro     INTEGER,
    idroteiro         INTEGER
);

CREATE INDEX IF NOT EXISTS idx_montarroteiro_idroteiro ON app.montarroteiro (idroteiro);

DO $$
BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM pg_constraint WHERE conname = 'fk_montarroteiro_roteiro'
    ) THEN
        ALTER TABLE app.montarroteiro
            ADD CONSTRAINT fk_montarroteiro_roteiro
            FOREIGN KEY (idroteiro)
            REFERENCES app.roteiro (id);
    END IF;
END $$;

-- =========================
-- Tabela: exiberoteiro
-- =========================
CREATE TABLE IF NOT EXISTS app.exiberoteiro (
    idexiberoteiro     INTEGER PRIMARY KEY DEFAULT nextval('app.exiberoteiro_idexiberoteiro_seq'),
    idmontarroteiro    INTEGER,
    numprocesso        VARCHAR(64)
);

CREATE INDEX IF NOT EXISTS idx_exiberoteiro_idmontarroteiro ON app.exiberoteiro (idmontarroteiro);
CREATE INDEX IF NOT EXISTS idx_exiberoteiro_numprocesso ON app.exiberoteiro (numprocesso);

DO $$
BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM pg_constraint WHERE conname = 'fk_exiberoteiro_montarroteiro'
    ) THEN
        ALTER TABLE app.exiberoteiro
            ADD CONSTRAINT fk_exiberoteiro_montarroteiro
            FOREIGN KEY (idmontarroteiro)
            REFERENCES app.montarroteiro (idmontarroteiro);
    END IF;
END $$;

DO $$
BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM pg_constraint WHERE conname = 'fk_exiberoteiro_processo'
    ) THEN
        ALTER TABLE app.exiberoteiro
            ADD CONSTRAINT fk_exiberoteiro_processo
            FOREIGN KEY (numprocesso)
            REFERENCES app.processo (numero_processo);
    END IF;
END $$;

-- =========================
-- Ajuste de setval das sequences conforme dados existentes
-- =========================
DO $$
DECLARE v_max INTEGER;
BEGIN
    -- embalagem
    SELECT COALESCE(MAX(idembalagem), 0) + 1 INTO v_max FROM app.embalagem;
    PERFORM setval('app.embalagem_idembalagem_seq', GREATEST(v_max, 1), false);

    -- empresainfracoes
    SELECT COALESCE(MAX(idempresainfracoes), 0) + 1 INTO v_max FROM app.empresainfracoes;
    PERFORM setval('app.empresainfracoes_idempresainfracoes_seq', GREATEST(v_max, 1), false);

    -- entregador
    SELECT COALESCE(MAX(identregador), 0) + 1 INTO v_max FROM app.entregador;
    PERFORM setval('app.entregador_identregador_seq', GREATEST(v_max, 1), false);

    -- farmaceuticos
    SELECT COALESCE(MAX(idfarmaceuticos), 0) + 1 INTO v_max FROM app.farmaceuticos;
    PERFORM setval('app.farmaceuticos_idfarmaceuticos_seq', GREATEST(v_max, 1), false);

    -- montarroteiro
    SELECT COALESCE(MAX(idmontarroteiro), 0) + 1 INTO v_max FROM app.montarroteiro;
    PERFORM setval('app.montarroteiro_idmontarroteiro_seq', GREATEST(v_max, 1), false);

    -- exiberoteiro
    SELECT COALESCE(MAX(idexiberoteiro), 0) + 1 INTO v_max FROM app.exiberoteiro;
    PERFORM setval('app.exiberoteiro_idexiberoteiro_seq', GREATEST(v_max, 1), false);
END $$;
