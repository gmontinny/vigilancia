-- V22: Migração das entidades Geraatividade, Geracategoriaservico, Geracodigocertificacao, Geradocumento e Geragaleria
-- Alvo: PostgreSQL. Padrão de schema "app" e sequences com INCREMENT BY 50 (conforme V19/V20).

CREATE SCHEMA IF NOT EXISTS app;

-- =========================
-- Sequences
-- =========================
CREATE SEQUENCE IF NOT EXISTS app.geraatividade_idgeraatividade_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS app.geracategoriaservico_idgeracategoriaservico_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS app.geracodigocertificacao_idcodigocertificacao_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS app.geradocumento_idgeradocumento_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS app.geragaleria_idgeragaleria_seq INCREMENT BY 50;

-- =========================
-- Tabela: geraatividade
-- =========================
CREATE TABLE IF NOT EXISTS app.geraatividade (
    idgeraatividade      INTEGER PRIMARY KEY DEFAULT nextval('app.geraatividade_idgeraatividade_seq'),
    dataatividade        DATE,
    horaatividade        TIME,
    idusuario            INTEGER,
    statusgeraatividade  INTEGER
);

CREATE INDEX IF NOT EXISTS idx_geraatividade_idusuario ON app.geraatividade (idusuario);

-- =========================
-- Tabela: geracategoriaservico
-- =========================
CREATE TABLE IF NOT EXISTS app.geracategoriaservico (
    idgeracategoriaservico  INTEGER PRIMARY KEY DEFAULT nextval('app.geracategoriaservico_idgeracategoriaservico_seq'),
    datacategoriaservico    DATE,
    idusuario               INTEGER,
    status                  INTEGER
);

CREATE INDEX IF NOT EXISTS idx_geracategoriaservico_idusuario ON app.geracategoriaservico (idusuario);

-- =========================
-- Tabela: geracodigocertificacao
-- =========================
CREATE TABLE IF NOT EXISTS app.geracodigocertificacao (
    idcodigocertificacao  INTEGER PRIMARY KEY DEFAULT nextval('app.geracodigocertificacao_idcodigocertificacao_seq'),
    datacertificacao      DATE,
    horacertificacao      TIME,
    chavecertificacao     VARCHAR(255)
);

-- =========================
-- Tabela: geradocumento
-- =========================
CREATE TABLE IF NOT EXISTS app.geradocumento (
    idgeradocumento  INTEGER PRIMARY KEY DEFAULT nextval('app.geradocumento_idgeradocumento_seq'),
    idusuario        INTEGER,
    status           INTEGER
);

CREATE INDEX IF NOT EXISTS idx_geradocumento_idusuario ON app.geradocumento (idusuario);

-- =========================
-- Tabela: geragaleria
-- =========================
CREATE TABLE IF NOT EXISTS app.geragaleria (
    idgeragaleria      INTEGER PRIMARY KEY DEFAULT nextval('app.geragaleria_idgeragaleria_seq'),
    datageragaleria    DATE,
    horageragaleria    TIME,
    idusuario          INTEGER,
    statusgeragaleria  INTEGER
);

CREATE INDEX IF NOT EXISTS idx_geragaleria_idusuario ON app.geragaleria (idusuario);

-- =========================
-- Ajuste de setval das sequences conforme dados existentes
-- =========================
DO $$
DECLARE v_max INTEGER;
BEGIN
    -- geraatividade
    SELECT COALESCE(MAX(idgeraatividade), 0) + 1 INTO v_max FROM app.geraatividade;
    PERFORM setval('app.geraatividade_idgeraatividade_seq', GREATEST(v_max, 1), false);

    -- geracategoriaservico
    SELECT COALESCE(MAX(idgeracategoriaservico), 0) + 1 INTO v_max FROM app.geracategoriaservico;
    PERFORM setval('app.geracategoriaservico_idgeracategoriaservico_seq', GREATEST(v_max, 1), false);

    -- geracodigocertificacao
    SELECT COALESCE(MAX(idcodigocertificacao), 0) + 1 INTO v_max FROM app.geracodigocertificacao;
    PERFORM setval('app.geracodigocertificacao_idcodigocertificacao_seq', GREATEST(v_max, 1), false);

    -- geradocumento
    SELECT COALESCE(MAX(idgeradocumento), 0) + 1 INTO v_max FROM app.geradocumento;
    PERFORM setval('app.geradocumento_idgeradocumento_seq', GREATEST(v_max, 1), false);

    -- geragaleria
    SELECT COALESCE(MAX(idgeragaleria), 0) + 1 INTO v_max FROM app.geragaleria;
    PERFORM setval('app.geragaleria_idgeragaleria_seq', GREATEST(v_max, 1), false);
END $$;
