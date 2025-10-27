-- V16: Criação das tabelas e sequências para Arquivodocumento, Assuntosolicitacao, Atividadefiscal, Atividades e Atividadevigilancia
-- Alvo: PostgreSQL (schema padrão: app). Alinhado ao padrão de sequências com INCREMENT BY 50 (vide V14).

CREATE SCHEMA IF NOT EXISTS app;

-- =========================
-- arquivodocumentos
-- =========================
CREATE SEQUENCE IF NOT EXISTS app.arquivodocumentos_idarquivo_seq INCREMENT BY 50;

CREATE TABLE IF NOT EXISTS app.arquivodocumentos (
    idarquivo       INTEGER PRIMARY KEY DEFAULT nextval('app.arquivodocumentos_idarquivo_seq'),
    dataarquivo     DATE,
    horaarquivo     TIME,
    nomearquivo     TEXT,
    tamanhoarquivo  TEXT,
    usuarioarquivo  TEXT,
    tipoarquivo     TEXT,
    nomeoriginal    TEXT,
    statusarquivo   INTEGER,
    textoarquivo    TEXT,
    nomeeditado     TEXT,
    numprocesso     TEXT NOT NULL
);
CREATE INDEX IF NOT EXISTS idx_arquivodocumentos_numprocesso ON app.arquivodocumentos (numprocesso);

-- =========================
-- assuntosolicitacao
-- =========================
-- Entity usa GenerationType.AUTO sem @SequenceGenerator → criar sequência padrão esperada
CREATE SEQUENCE IF NOT EXISTS app.assuntosolicitacao_seq INCREMENT BY 50;

CREATE TABLE IF NOT EXISTS app.assuntosolicitacao (
    idassunto            INTEGER PRIMARY KEY DEFAULT nextval('app.assuntosolicitacao_seq'),
    iditenssolicitacao   INTEGER,
    numprocesso          TEXT
);
CREATE INDEX IF NOT EXISTS idx_assuntosolicitacao_iditens ON app.assuntosolicitacao (iditenssolicitacao);
CREATE INDEX IF NOT EXISTS idx_assuntosolicitacao_numprocesso ON app.assuntosolicitacao (numprocesso);

-- =========================
-- atividadefiscal
-- =========================
-- Entity usa GenerationType.AUTO sem @SequenceGenerator → criar sequência padrão esperada
CREATE SEQUENCE IF NOT EXISTS app.atividadefiscal_seq INCREMENT BY 50;

CREATE TABLE IF NOT EXISTS app.atividadefiscal (
    idatividadefiscal  INTEGER PRIMARY KEY DEFAULT nextval('app.atividadefiscal_seq'),
    idlicenciamento    INTEGER,
    numprocesso        TEXT,
    CONSTRAINT fk_atividadefiscal_licenciamento FOREIGN KEY (idlicenciamento)
        REFERENCES app.licenciamento (idlicenciamento)
);
CREATE INDEX IF NOT EXISTS idx_atividadefiscal_idlicenciamento ON app.atividadefiscal (idlicenciamento);

-- =========================
-- atividades
-- =========================
-- A entidade Atividades não define @Table; com a PhysicalNamingStrategy padrão, a tabela será "atividades".
-- O identificador utiliza um @SequenceGenerator com sequenceName = 'atividadebpa_idatividadebpa_seq'.
CREATE SEQUENCE IF NOT EXISTS app.atividadebpa_idatividadebpa_seq INCREMENT BY 50;

CREATE TABLE IF NOT EXISTS app.atividades (
    idatividades          INTEGER PRIMARY KEY DEFAULT nextval('app.atividadebpa_idatividadebpa_seq'),
    descricaoatividades   TEXT NOT NULL
);
CREATE UNIQUE INDEX IF NOT EXISTS uk_atividades_descricao ON app.atividades (descricaoatividades);

-- =========================
-- atividadevigilancia
-- =========================
CREATE SEQUENCE IF NOT EXISTS app.atividadevigilancia_idatividade_seq INCREMENT BY 50;

CREATE TABLE IF NOT EXISTS app.atividadevigilancia (
    idatividade      INTEGER PRIMARY KEY DEFAULT nextval('app.atividadevigilancia_idatividade_seq'),
    idlicenciamento  INTEGER,
    liberacao        INTEGER,
    numeroatividade  INTEGER,
    CONSTRAINT fk_atividadevigilancia_licenciamento FOREIGN KEY (idlicenciamento)
        REFERENCES app.licenciamento (idlicenciamento)
);
CREATE INDEX IF NOT EXISTS idx_atividadevigilancia_idlicenciamento ON app.atividadevigilancia (idlicenciamento);
