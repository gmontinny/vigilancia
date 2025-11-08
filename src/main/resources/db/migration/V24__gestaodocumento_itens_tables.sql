-- V24: Migração das entidades Gestaodocumento, Itensatividade, Itensautoinfracao, Itensavaliacao e Itenscategoriaservico
-- Alvo: PostgreSQL. Padrão de schema "app" e sequences com INCREMENT BY 50 (conforme V23).

CREATE SCHEMA IF NOT EXISTS app;

-- =========================
-- Sequences
-- =========================
CREATE SEQUENCE IF NOT EXISTS app.gestaodocumento_idgestaodocumento_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS app.itensatividade_iditensatividade_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS app.itensautoinfracao_iditensautoinfracao_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS app.itensavaliacao_iditensavaliacao_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS app.itenscategoria_iditenscategoriaservico_seq INCREMENT BY 50;

-- =========================
-- Tabela: gestaodocumento
-- =========================
CREATE TABLE IF NOT EXISTS app.gestaodocumento (
    idgestaodocumento        INTEGER PRIMARY KEY DEFAULT nextval('app.gestaodocumento_idgestaodocumento_seq'),
    assuntogestaodocumento   TEXT NOT NULL,
    cpfentregador            TEXT NOT NULL,
    numerodocumento          INTEGER,
    nomeentregador           TEXT NOT NULL,
    solicitantegestaodocumento TEXT NOT NULL,
    tiposolicitacao          INTEGER NOT NULL,
    datagestaodocumento      DATE,
    idusuario                INTEGER,
    numprocesso              TEXT,
    status                   INTEGER,
    textodocumento           TEXT,
    idusuariodestino         INTEGER,
    statusenvio              INTEGER,
    horagestaodocumento      TIME,
    notificacao              INTEGER,
    usuariosnotificacao      TEXT
);

-- =========================
-- Tabela: itensatividade
-- =========================
CREATE TABLE IF NOT EXISTS app.itensatividade (
    iditensatividade INTEGER PRIMARY KEY DEFAULT nextval('app.itensatividade_iditensatividade_seq'),
    idatividades     INTEGER NOT NULL,
    idestabelecimento INTEGER NOT NULL,
    CONSTRAINT fk_itensatividade_atividades
        FOREIGN KEY (idatividades) REFERENCES app.atividades (idatividades),
    CONSTRAINT fk_itensatividade_estabelecimento
        FOREIGN KEY (idestabelecimento) REFERENCES app.estabelecimento (id)
);

CREATE INDEX IF NOT EXISTS idx_itensatividade_idatividades ON app.itensatividade (idatividades);
CREATE INDEX IF NOT EXISTS idx_itensatividade_idestabelecimento ON app.itensatividade (idestabelecimento);

-- =========================
-- Tabela: itensautoinfracao
-- =========================
CREATE TABLE IF NOT EXISTS app.itensautoinfracao (
    iditensautoinfracao INTEGER PRIMARY KEY DEFAULT nextval('app.itensautoinfracao_iditensautoinfracao_seq'),
    numeroauto          INTEGER,
    valoritens          TEXT,
    textoitens          TEXT,
    tiporisco           TEXT,
    idlegislacao        INTEGER
);

-- =========================
-- Tabela: itensavaliacao
-- =========================
CREATE TABLE IF NOT EXISTS app.itensavaliacao (
    iditensavaliacao  INTEGER PRIMARY KEY DEFAULT nextval('app.itensavaliacao_iditensavaliacao_seq'),
    datafinal         DATE,
    datarecebimento   DATE NOT NULL,
    prazo             INTEGER NOT NULL,
    responsavel       INTEGER NOT NULL,
    status            INTEGER,
    texto             TEXT NOT NULL,
    idgestaodocumento INTEGER,
    CONSTRAINT fk_itensavaliacao_gestaodocumento
        FOREIGN KEY (idgestaodocumento) REFERENCES app.gestaodocumento (idgestaodocumento)
);

CREATE INDEX IF NOT EXISTS idx_itensavaliacao_idgestaodocumento ON app.itensavaliacao (idgestaodocumento);

-- =========================
-- Tabela: itenscategoriaservico
-- =========================
CREATE TABLE IF NOT EXISTS app.itenscategoriaservico (
    iditenscategoriaservico   INTEGER PRIMARY KEY DEFAULT nextval('app.itenscategoria_iditenscategoriaservico_seq'),
    descitenscategoriaservico TEXT NOT NULL,
    numeroservico             INTEGER NOT NULL
);

-- =========================
-- Ajuste de setval das sequences conforme dados existentes
-- =========================
DO $$
DECLARE v_max INTEGER;
BEGIN
    -- gestaodocumento
    SELECT COALESCE(MAX(idgestaodocumento), 0) + 1 INTO v_max FROM app.gestaodocumento;
    PERFORM setval('app.gestaodocumento_idgestaodocumento_seq', GREATEST(v_max, 1), false);

    -- itensatividade
    SELECT COALESCE(MAX(iditensatividade), 0) + 1 INTO v_max FROM app.itensatividade;
    PERFORM setval('app.itensatividade_iditensatividade_seq', GREATEST(v_max, 1), false);

    -- itensautoinfracao
    SELECT COALESCE(MAX(iditensautoinfracao), 0) + 1 INTO v_max FROM app.itensautoinfracao;
    PERFORM setval('app.itensautoinfracao_iditensautoinfracao_seq', GREATEST(v_max, 1), false);

    -- itensavaliacao
    SELECT COALESCE(MAX(iditensavaliacao), 0) + 1 INTO v_max FROM app.itensavaliacao;
    PERFORM setval('app.itensavaliacao_iditensavaliacao_seq', GREATEST(v_max, 1), false);

    -- itenscategoriaservico
    SELECT COALESCE(MAX(iditenscategoriaservico), 0) + 1 INTO v_max FROM app.itenscategoriaservico;
    PERFORM setval('app.itenscategoria_iditenscategoriaservico_seq', GREATEST(v_max, 1), false);
END $$;