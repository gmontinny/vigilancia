-- V23: Migração das entidades Geraitensprodi, Geraprocesso, Geraroteiro, Geratermorevelia e Geratramite
-- Alvo: PostgreSQL. Padrão de schema "app" e sequences com INCREMENT BY 50 (conforme V22).

CREATE SCHEMA IF NOT EXISTS app;

-- =========================
-- Sequences
-- =========================
CREATE SEQUENCE IF NOT EXISTS app.geraitensprodi_idgeraitensprodi_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS app.geraprocesso_idprocesso_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS app.geraroteiro_idgeraroteiro_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS app.geratermorevelia_idtermorevelia_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS app.geratramite_idgeratramite_seq INCREMENT BY 50;

-- =========================
-- Tabela: geraitensprodi
-- =========================
CREATE TABLE IF NOT EXISTS app.geraitensprodi (
    idgeraitensprodi   INTEGER PRIMARY KEY DEFAULT nextval('app.geraitensprodi_idgeraitensprodi_seq'),
    dataitensprodi     DATE,
    horaitensprodi     TIME,
    idusuario          INTEGER,
    statusitensprodi   INTEGER
);

CREATE INDEX IF NOT EXISTS idx_geraitensprodi_idusuario ON app.geraitensprodi (idusuario);

-- =========================
-- Tabela: geraprocesso
-- =========================
CREATE TABLE IF NOT EXISTS app.geraprocesso (
    idprocesso      INTEGER PRIMARY KEY DEFAULT nextval('app.geraprocesso_idprocesso_seq'),
    dataprocesso    DATE,
    horaprocesso    TIME,
    idusuario       INTEGER,
    statusprocesso  INTEGER
);

CREATE INDEX IF NOT EXISTS idx_geraprocesso_idusuario ON app.geraprocesso (idusuario);

-- =========================
-- Tabela: geraroteiro
-- =========================
CREATE TABLE IF NOT EXISTS app.geraroteiro (
    idgeraroteiro    INTEGER PRIMARY KEY DEFAULT nextval('app.geraroteiro_idgeraroteiro_seq'),
    datageraroteiro  DATE,
    horageraroteiro  TIME,
    statusroteiro    INTEGER,
    idusuario        INTEGER
);

CREATE INDEX IF NOT EXISTS idx_geraroteiro_idusuario ON app.geraroteiro (idusuario);

-- =========================
-- Tabela: geratermorevelia
-- =========================
CREATE TABLE IF NOT EXISTS app.geratermorevelia (
    idtermorevelia  INTEGER PRIMARY KEY DEFAULT nextval('app.geratermorevelia_idtermorevelia_seq'),
    datarevelia     DATE,
    horarevelia     TIME,
    numeroauto      INTEGER
);

-- =========================
-- Tabela: geratramite
-- =========================
CREATE TABLE IF NOT EXISTS app.geratramite (
    idgeratramite   INTEGER PRIMARY KEY DEFAULT nextval('app.geratramite_idgeratramite_seq'),
    dtgeratramite   DATE,
    hrgeratramite   TIME
);

-- =========================
-- Ajuste de setval das sequences conforme dados existentes
-- =========================
DO $$
DECLARE v_max INTEGER;
BEGIN
    -- geraitensprodi
    SELECT COALESCE(MAX(idgeraitensprodi), 0) + 1 INTO v_max FROM app.geraitensprodi;
    PERFORM setval('app.geraitensprodi_idgeraitensprodi_seq', GREATEST(v_max, 1), false);

    -- geraprocesso
    SELECT COALESCE(MAX(idprocesso), 0) + 1 INTO v_max FROM app.geraprocesso;
    PERFORM setval('app.geraprocesso_idprocesso_seq', GREATEST(v_max, 1), false);

    -- geraroteiro
    SELECT COALESCE(MAX(idgeraroteiro), 0) + 1 INTO v_max FROM app.geraroteiro;
    PERFORM setval('app.geraroteiro_idgeraroteiro_seq', GREATEST(v_max, 1), false);

    -- geratermorevelia
    SELECT COALESCE(MAX(idtermorevelia), 0) + 1 INTO v_max FROM app.geratermorevelia;
    PERFORM setval('app.geratermorevelia_idtermorevelia_seq', GREATEST(v_max, 1), false);

    -- geratramite
    SELECT COALESCE(MAX(idgeratramite), 0) + 1 INTO v_max FROM app.geratramite;
    PERFORM setval('app.geratramite_idgeratramite_seq', GREATEST(v_max, 1), false);
END $$;