-- V18: Criação das tabelas e sequências para Categoriaanalise, Categoriaproduto,
-- Categoriaroteiro, Categoriaservico, Despachocontrarazao, Itensroteiro, Servicosaude e Legislacao
-- Alvo: PostgreSQL (schema padrão: app). Alinhado ao padrão de sequências com INCREMENT BY 50 (vide V17).

CREATE SCHEMA IF NOT EXISTS app;

-- =========================
-- categoriaanalise
-- =========================
CREATE SEQUENCE IF NOT EXISTS app.categoriaanalise_idcategoriaanalise_seq INCREMENT BY 50;

CREATE TABLE IF NOT EXISTS app.categoriaanalise (
    idcategoriaanalise     INTEGER PRIMARY KEY DEFAULT nextval('app.categoriaanalise_idcategoriaanalise_seq'),
    nomecategoriaanalise   TEXT NOT NULL
);
CREATE UNIQUE INDEX IF NOT EXISTS uk_categoriaanalise_nome ON app.categoriaanalise (nomecategoriaanalise);

-- =========================
-- categoriaproduto
-- =========================
CREATE SEQUENCE IF NOT EXISTS app.categoriaproduto_idcategoriaproduto_seq INCREMENT BY 50;

CREATE TABLE IF NOT EXISTS app.categoriaproduto (
    idcategoriaproduto         INTEGER PRIMARY KEY DEFAULT nextval('app.categoriaproduto_idcategoriaproduto_seq'),
    descricaocategoriaproduto  TEXT    NOT NULL,
    codigoprodi                INTEGER NOT NULL
);
CREATE INDEX IF NOT EXISTS idx_categoriaproduto_codigoprodi ON app.categoriaproduto (codigoprodi);

-- =========================
-- categoriaroteiro
-- =========================
CREATE SEQUENCE IF NOT EXISTS app.categoriaroteiro_idcategoriaroteiro_seq INCREMENT BY 50;

CREATE TABLE IF NOT EXISTS app.categoriaroteiro (
    idcategoriaroteiro    INTEGER PRIMARY KEY DEFAULT nextval('app.categoriaroteiro_idcategoriaroteiro_seq'),
    descricaocategoria    TEXT NOT NULL
);
CREATE UNIQUE INDEX IF NOT EXISTS uk_categoriaroteiro_descricao ON app.categoriaroteiro (descricaocategoria);

-- =========================
-- categoriaservico
-- =========================
CREATE SEQUENCE IF NOT EXISTS app.categoriaservico_idcategoriaservico_seq INCREMENT BY 50;

CREATE TABLE IF NOT EXISTS app.categoriaservico (
    idcategoriaservico    INTEGER PRIMARY KEY DEFAULT nextval('app.categoriaservico_idcategoriaservico_seq'),
    desccategoriaservico  TEXT NOT NULL
);
CREATE UNIQUE INDEX IF NOT EXISTS uk_categoriaservico_descricao ON app.categoriaservico (desccategoriaservico);

-- =========================
-- despachocontrarazao
-- =========================
CREATE SEQUENCE IF NOT EXISTS app.despachocontrarazao_iddespachocontrarazao_seq INCREMENT BY 50;

CREATE TABLE IF NOT EXISTS app.despachocontrarazao (
    iddespachocontrarazao    INTEGER PRIMARY KEY DEFAULT nextval('app.despachocontrarazao_iddespachocontrarazao_seq'),
    gerenteresponsavel       TEXT    NOT NULL,
    imagemassinatura         TEXT,
    textodespacho            TEXT    NOT NULL
);

-- =========================
-- legislacao
-- =========================
CREATE SEQUENCE IF NOT EXISTS app.legislacao_idlegislacao_seq INCREMENT BY 50;

CREATE TABLE IF NOT EXISTS app.legislacao (
    idlegislacao           INTEGER PRIMARY KEY DEFAULT nextval('app.legislacao_idlegislacao_seq'),
    artigolegislacao       TEXT    NOT NULL,
    descricaolegislacao    TEXT    NOT NULL,
    incisolegislacao       TEXT,
    decretolegislacao      INTEGER,
    leilegislacao          TEXT    NOT NULL,
    paragrafolegislacao    TEXT,
    valorlegislacao        TEXT,
    riscolegislacao        TEXT
);
CREATE INDEX IF NOT EXISTS idx_legislacao_lei ON app.legislacao (leilegislacao);

-- =========================
-- itensroteiro
-- =========================
CREATE SEQUENCE IF NOT EXISTS app.itensroteiro_iditensroteiro_seq INCREMENT BY 50;

CREATE TABLE IF NOT EXISTS app.itensroteiro (
    iditensroteiro          INTEGER PRIMARY KEY DEFAULT nextval('app.itensroteiro_iditensroteiro_seq'),
    numeroroteiro           INTEGER,
    idlegislacao755         INTEGER,
    gerainfracao            INTEGER NOT NULL,
    criticidade             INTEGER NOT NULL,
    descricaoitensroteiro   TEXT    NOT NULL,
    idcategoriaroteiro      INTEGER NOT NULL,
    idlegislacao            INTEGER NOT NULL,
    CONSTRAINT fk_itensroteiro_categoriaroteiro FOREIGN KEY (idcategoriaroteiro)
        REFERENCES app.categoriaroteiro (idcategoriaroteiro),
    CONSTRAINT fk_itensroteiro_legislacao FOREIGN KEY (idlegislacao)
        REFERENCES app.legislacao (idlegislacao)
);
CREATE INDEX IF NOT EXISTS idx_itensroteiro_idcategoria ON app.itensroteiro (idcategoriaroteiro);
CREATE INDEX IF NOT EXISTS idx_itensroteiro_idlegislacao ON app.itensroteiro (idlegislacao);

-- =========================
-- servicosaude
-- =========================
CREATE SEQUENCE IF NOT EXISTS app.servicosaude_idservicosaude_seq INCREMENT BY 50;

CREATE TABLE IF NOT EXISTS app.servicosaude (
    idservicosaude      INTEGER PRIMARY KEY DEFAULT nextval('app.servicosaude_idservicosaude_seq'),
    idagrupamento       INTEGER,
    numeroservico       INTEGER NOT NULL,
    idcategoriaservico  INTEGER,
    idcategoriaanalise  INTEGER,
    CONSTRAINT fk_servicosaude_agrupamento FOREIGN KEY (idagrupamento)
        REFERENCES app.agrupamento (idagrupamento),
    CONSTRAINT fk_servicosaude_categoriaservico FOREIGN KEY (idcategoriaservico)
        REFERENCES app.categoriaservico (idcategoriaservico)
    -- Nota: idcategoriaanalise é inteiro simples na entidade; não cria FK aqui
);
CREATE INDEX IF NOT EXISTS idx_servicosaude_idagrupamento ON app.servicosaude (idagrupamento);
CREATE INDEX IF NOT EXISTS idx_servicosaude_idcategoriaservico ON app.servicosaude (idcategoriaservico);
