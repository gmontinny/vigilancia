-- V25: Migração das entidades Itenscolheita, Itensdocumento, Itensembalagem, Itensexiberoteiro, Itensgaleria, Termocolheita e Produtocategoria
-- Alvo: PostgreSQL. Padrão de schema "app" e sequences com INCREMENT BY 50 (conforme V23/V24).

CREATE SCHEMA IF NOT EXISTS app;

-- =========================
-- Sequences
-- =========================
CREATE SEQUENCE IF NOT EXISTS app.produtocategoria_idprodutocategoria_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS app.termocolheita_idtermocolheita_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS app.itensembalagem_iditensembalagem_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS app.itenscolheita_iditenscolheita_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS app.itensdocumento_iditensdocumento_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS app.itensexiberoteiro_iditensexiberoteiro_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS app.itensgaleria_iditensgaleria_seq INCREMENT BY 50;

-- =========================
-- Tabela: produtocategoria
-- =========================
CREATE TABLE IF NOT EXISTS app.produtocategoria (
    idprodutocategoria     INTEGER PRIMARY KEY DEFAULT nextval('app.produtocategoria_idprodutocategoria_seq'),
    nomeprodutocategoria   TEXT NOT NULL
);

-- =========================
-- Tabela: termocolheita
-- =========================
CREATE TABLE IF NOT EXISTS app.termocolheita (
    idtermocolheita        INTEGER PRIMARY KEY DEFAULT nextval('app.termocolheita_idtermocolheita_seq'),
    apresentacaotermocolheita TEXT,
    bairrotermocolheita    TEXT,
    ceptermocolheita       TEXT,
    cidadetermocolheita    TEXT,
    cnpjtermocolheita      TEXT,
    contraprova01          INTEGER,
    contraprova02          INTEGER,
    contraprova03          INTEGER,
    embaladortermocolheita TEXT,
    enderecotermocolheita  TEXT,
    fabricantetermocolheita TEXT,
    finsanalisetermocolheita INTEGER,
    numerotramitacao       INTEGER,
    nomeproduto            TEXT,
    datacolheita           DATE,
    idprodutocategoria     INTEGER,
    inscricaotermocolheita TEXT,
    laboratorio01          INTEGER,
    laboratorio02          INTEGER,
    laboratorio03          INTEGER,
    lacre01termocolheita   INTEGER,
    lacre02termocolheita   INTEGER,
    lacre03termocolheita   INTEGER,
    localconsumo           TEXT,
    lotetermocolheita      TEXT,
    marcatermocolheita     TEXT,
    numeroconsumidor       INTEGER,
    observacao             TEXT,
    periodoincubacao       TEXT,
    pesovolumento          TEXT,
    quantidadeamostra      INTEGER,
    quantidadedoente       INTEGER,
    registrotermocolheita  TEXT,
    tecnicoresponsavel     TEXT,
    termometrotermocolheita TEXT,
    tipoanalise            TEXT,
    uftermocolheita        TEXT,
    validadetermocolheita  TEXT,
    fabricacaotermocolheita TEXT,
    idmotivo               INTEGER,
    numeroendereco         INTEGER,
    sintomastermocolheita  TEXT,
    telefonetermocolheita  TEXT,
    arquivolaudo           TEXT,
    tipoformatacao         INTEGER,
    CONSTRAINT fk_termocolheita_produtocategoria
        FOREIGN KEY (idprodutocategoria) REFERENCES app.produtocategoria,
    CONSTRAINT fk_termocolheita_motivo
        FOREIGN KEY (idmotivo) REFERENCES app.motivo (id)
);

CREATE INDEX IF NOT EXISTS idx_termocolheita_idprodutocategoria ON app.termocolheita (idprodutocategoria);
CREATE INDEX IF NOT EXISTS idx_termocolheita_idmotivo ON app.termocolheita (idmotivo);

-- =========================
-- Tabela: itensembalagem
-- =========================
CREATE TABLE IF NOT EXISTS app.itensembalagem (
    iditensembalagem   INTEGER PRIMARY KEY DEFAULT nextval('app.itensembalagem_iditensembalagem_seq'),
    idembalagem        INTEGER,
    idestabelecimento  INTEGER,
    numeroprodi        INTEGER,
    numeroitensprodi   INTEGER,
    CONSTRAINT fk_itensembalagem_embalagem
        FOREIGN KEY (idembalagem) REFERENCES app.embalagem (idembalagem),
    CONSTRAINT fk_itensembalagem_estabelecimento
        FOREIGN KEY (idestabelecimento) REFERENCES app.estabelecimento (id)
);

CREATE INDEX IF NOT EXISTS idx_itensembalagem_idembalagem ON app.itensembalagem (idembalagem);
CREATE INDEX IF NOT EXISTS idx_itensembalagem_idestabelecimento ON app.itensembalagem (idestabelecimento);

-- =========================
-- Tabela: itenscolheita
-- =========================
CREATE TABLE IF NOT EXISTS app.itenscolheita (
    iditenscolheita    INTEGER PRIMARY KEY DEFAULT nextval('app.itenscolheita_iditenscolheita_seq'),
    numerotramitacao   INTEGER,
    idtermocolheita    INTEGER NOT NULL,
    CONSTRAINT fk_itenscolheita_termocolheita
        FOREIGN KEY (idtermocolheita) REFERENCES app.termocolheita (idtermocolheita)
);

CREATE INDEX IF NOT EXISTS idx_itenscolheita_idtermocolheita ON app.itenscolheita (idtermocolheita);

-- =========================
-- Tabela: itensdocumento
-- =========================
CREATE TABLE IF NOT EXISTS app.itensdocumento (
    iditensdocumento   INTEGER PRIMARY KEY DEFAULT nextval('app.itensdocumento_iditensdocumento_seq'),
    nomearquivo        TEXT NOT NULL,
    numerodocumento    INTEGER,
    oldarquivo         TEXT NOT NULL,
    tipoarquivo        TEXT NOT NULL,
    status             INTEGER
);

-- =========================
-- Tabela: itensexiberoteiro
-- =========================
CREATE TABLE IF NOT EXISTS app.itensexiberoteiro (
    iditensexiberoteiro INTEGER PRIMARY KEY DEFAULT nextval('app.itensexiberoteiro_iditensexiberoteiro_seq'),
    atende               INTEGER,
    atendeparcialmente   INTEGER,
    idexiberoteiro       INTEGER NOT NULL,
    iditensroteiro       INTEGER NOT NULL,
    naoatende            INTEGER,
    naoseaplica          INTEGER,
    numeroauto           INTEGER,
    CONSTRAINT fk_itensexiberoteiro_exiberoteiro
        FOREIGN KEY (idexiberoteiro) REFERENCES app.exiberoteiro (idexiberoteiro),
    CONSTRAINT fk_itensexiberoteiro_itensroteiro
        FOREIGN KEY (iditensroteiro) REFERENCES app.itensroteiro (iditensroteiro)
);

CREATE INDEX IF NOT EXISTS idx_itensexiberoteiro_idexiberoteiro ON app.itensexiberoteiro (idexiberoteiro);
CREATE INDEX IF NOT EXISTS idx_itensexiberoteiro_iditensroteiro ON app.itensexiberoteiro (iditensroteiro);

-- =========================
-- Tabela: itensgaleria
-- =========================
CREATE TABLE IF NOT EXISTS app.itensgaleria (
    iditensgaleria       INTEGER PRIMARY KEY DEFAULT nextval('app.itensgaleria_iditensgaleria_seq'),
    imagemitensgaleria   TEXT,
    seguenciagaleria     INTEGER,
    tituloitensgaleria   TEXT
);

-- =========================
-- Ajuste de setval das sequences conforme dados existentes
-- =========================
DO $$
DECLARE v_max INTEGER;
BEGIN

    -- termocolheita
    SELECT COALESCE(MAX(idtermocolheita), 0) + 1 INTO v_max FROM app.termocolheita;
    PERFORM setval('app.termocolheita_idtermocolheita_seq', GREATEST(v_max, 1), false);

    -- itensembalagem
    SELECT COALESCE(MAX(iditensembalagem), 0) + 1 INTO v_max FROM app.itensembalagem;
    PERFORM setval('app.itensembalagem_iditensembalagem_seq', GREATEST(v_max, 1), false);

    -- itenscolheita
    SELECT COALESCE(MAX(iditenscolheita), 0) + 1 INTO v_max FROM app.itenscolheita;
    PERFORM setval('app.itenscolheita_iditenscolheita_seq', GREATEST(v_max, 1), false);

    -- itensdocumento
    SELECT COALESCE(MAX(iditensdocumento), 0) + 1 INTO v_max FROM app.itensdocumento;
    PERFORM setval('app.itensdocumento_iditensdocumento_seq', GREATEST(v_max, 1), false);

    -- itensexiberoteiro
    SELECT COALESCE(MAX(iditensexiberoteiro), 0) + 1 INTO v_max FROM app.itensexiberoteiro;
    PERFORM setval('app.itensexiberoteiro_iditensexiberoteiro_seq', GREATEST(v_max, 1), false);

    -- itensgaleria
    SELECT COALESCE(MAX(iditensgaleria), 0) + 1 INTO v_max FROM app.itensgaleria;
    PERFORM setval('app.itensgaleria_iditensgaleria_seq', GREATEST(v_max, 1), false);
END $$;