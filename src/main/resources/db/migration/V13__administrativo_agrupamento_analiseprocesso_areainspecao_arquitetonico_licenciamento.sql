-- V13: Criação das tabelas Administrativo, Agrupamento, Analiseprocesso, Areainspecao, Arquitetonico e Licenciamento
-- Alinhado com estratégia física (snake_case) e schema padrão `app`

-- Schema base
CREATE SCHEMA IF NOT EXISTS app;

-- (Opcional/segurança) Sequence padrão do Hibernate quando usa AUTO sem @SequenceGenerator
CREATE SEQUENCE IF NOT EXISTS app.hibernate_sequence INCREMENT BY 1;

-- =========================
-- ADMINISTRATIVO
-- =========================
CREATE SEQUENCE IF NOT EXISTS app.administrativo_idadministrativo_seq INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS app.administrativo (
    idadministrativo        INTEGER PRIMARY KEY DEFAULT nextval('app.administrativo_idadministrativo_seq'),
    assinaturacoordenadoria TEXT    NOT NULL,
    assinaturadiretoria     TEXT    NOT NULL,
    coordenadoria          TEXT    NOT NULL,
    diretoria              TEXT    NOT NULL,
    urlqrcode              TEXT,
    dataadministrativo     TIMESTAMP
);

-- =========================
-- AGRUPAMENTO
-- =========================
CREATE SEQUENCE IF NOT EXISTS app.agrupamento_idagrupamento_seq INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS app.agrupamento (
    idagrupamento   INTEGER PRIMARY KEY DEFAULT nextval('app.agrupamento_idagrupamento_seq'),
    nomeagrupamento TEXT    NOT NULL,
    idsubgrupo      INTEGER
);

-- Regras/índices
ALTER TABLE IF EXISTS app.agrupamento
    ADD CONSTRAINT chk_agrupamento_nome_min_len CHECK (char_length(nomeagrupamento) >= 5) NOT VALID;

ALTER TABLE IF EXISTS app.agrupamento
    ADD CONSTRAINT fk_agrupamento_subgrupo
        FOREIGN KEY (idsubgrupo) REFERENCES app.subgrupo (id);

CREATE INDEX IF NOT EXISTS idx_agrupamento_idsubgrupo ON app.agrupamento (idsubgrupo);

-- =========================
-- ANALISEPROCESSO
-- =========================
CREATE SEQUENCE IF NOT EXISTS app.analiseprocesso_idanaliseprocesso_seq INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS app.analiseprocesso (
    idanaliseprocesso          INTEGER PRIMARY KEY DEFAULT nextval('app.analiseprocesso_idanaliseprocesso_seq'),
    autorizacaoanaliseprocesso TEXT,
    statusanaliseprocesso      INTEGER,
    textoanaliseprocesso       TEXT,
    numprocesso                VARCHAR(255)
);

ALTER TABLE IF EXISTS app.analiseprocesso
    ADD CONSTRAINT fk_analiseprocesso_processo
        FOREIGN KEY (numprocesso) REFERENCES app.processo (numero_processo);

CREATE INDEX IF NOT EXISTS idx_analiseprocesso_numprocesso ON app.analiseprocesso (numprocesso);

-- =========================
-- AREAINSPECAO
-- =========================
CREATE SEQUENCE IF NOT EXISTS app.areainspecao_idareainspecao_seq INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS app.areainspecao (
    idareainspecao   INTEGER PRIMARY KEY DEFAULT nextval('app.areainspecao_idareainspecao_seq'),
    nomeareainspecao TEXT
);

-- =========================
-- ARQUITETONICOS
-- =========================
CREATE SEQUENCE IF NOT EXISTS app.arquitetonicos_idarquitetonicos_seq INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS app.arquitetonicos (
    idarquitetonicos           INTEGER PRIMARY KEY DEFAULT nextval('app.arquitetonicos_idarquitetonicos_seq'),
    dataanalisearquitetonicos  DATE,
    situacaoarquitetonicos     INTEGER NOT NULL,
    numerotramitacao           INTEGER NOT NULL,
    analisearquitetonico       INTEGER,
    textoarquitetonico         TEXT    NOT NULL
);

-- =========================
-- LICENCIAMENTO
-- =========================
CREATE SEQUENCE IF NOT EXISTS app.licenciamento_idlicenciamento_seq INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS app.licenciamento (
    idlicenciamento    INTEGER PRIMARY KEY DEFAULT nextval('app.licenciamento_idlicenciamento_seq'),
    datalicenciamento  DATE,
    datavencimento     DATE,
    qtimpresso         INTEGER,
    obslicenciamento   TEXT,
    idveiculo          INTEGER NOT NULL,
    statuslicenciamento INTEGER,
    idagrupamento      INTEGER
);

ALTER TABLE IF EXISTS app.licenciamento
    ADD CONSTRAINT fk_licenciamento_veiculo
        FOREIGN KEY (idveiculo) REFERENCES app.veiculo (id);

ALTER TABLE IF EXISTS app.licenciamento
    ADD CONSTRAINT fk_licenciamento_agrupamento
        FOREIGN KEY (idagrupamento) REFERENCES app.agrupamento (idagrupamento);

CREATE INDEX IF NOT EXISTS idx_licenciamento_idveiculo ON app.licenciamento (idveiculo);
CREATE INDEX IF NOT EXISTS idx_licenciamento_idagrupamento ON app.licenciamento (idagrupamento);
