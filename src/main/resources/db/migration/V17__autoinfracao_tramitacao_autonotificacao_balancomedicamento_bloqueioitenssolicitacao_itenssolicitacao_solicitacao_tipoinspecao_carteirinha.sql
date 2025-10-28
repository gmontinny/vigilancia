-- V17: Criação das tabelas e sequências para Autoinfracao, Tramitacao, Autonotificacao,
-- Balancomedicamento, Bloqueioitenssolicitacao, Itenssolicitacao, Solicitacao, Tipoinspecao e Carteirinha
-- Alvo: PostgreSQL (schema padrão: app). Alinhado ao padrão de sequências com INCREMENT BY 50 (vide V14/V16).

CREATE SCHEMA IF NOT EXISTS app;

-- =========================
-- tipoinspecao
-- =========================
CREATE SEQUENCE IF NOT EXISTS app.tipoinspecao_idtipoinspecao_seq INCREMENT BY 50;

CREATE TABLE IF NOT EXISTS app.tipoinspecao (
    idtipoinspecao          INTEGER PRIMARY KEY DEFAULT nextval('app.tipoinspecao_idtipoinspecao_seq'),
    descricaotipoinspecao   TEXT NOT NULL,
    analiseprocesso         INTEGER,
    autoinfracao            INTEGER,
    notificacao             INTEGER,
    colheita                INTEGER,
    arquitetonico           INTEGER,
    administrativo          INTEGER
);
CREATE UNIQUE INDEX IF NOT EXISTS uk_tipoinspecao_descricao ON app.tipoinspecao (descricaotipoinspecao);

-- =========================
-- solicitacao
-- =========================
CREATE SEQUENCE IF NOT EXISTS app.solicitacao_idsolicitacao_seq INCREMENT BY 50;

CREATE TABLE IF NOT EXISTS app.solicitacao (
    idsolicitacao     INTEGER PRIMARY KEY DEFAULT nextval('app.solicitacao_idsolicitacao_seq'),
    nomesolicitacao   TEXT NOT NULL
);
CREATE UNIQUE INDEX IF NOT EXISTS uk_solicitacao_nome ON app.solicitacao (nomesolicitacao);

-- =========================
-- itenssolicitacao
-- =========================
CREATE SEQUENCE IF NOT EXISTS app.itenssolicitacao_iditenssolicitacao_seq INCREMENT BY 50;

CREATE TABLE IF NOT EXISTS app.itenssolicitacao (
    iditenssolicitacao       INTEGER PRIMARY KEY DEFAULT nextval('app.itenssolicitacao_iditenssolicitacao_seq'),
    nomeitenssolicitacao     TEXT NOT NULL,
    idsolicitacao            INTEGER NOT NULL,
    restritoitenssolicitacao INTEGER,
    CONSTRAINT fk_itenssolicitacao_solicitacao FOREIGN KEY (idsolicitacao)
        REFERENCES app.solicitacao (idsolicitacao)
);
CREATE INDEX IF NOT EXISTS idx_itenssolicitacao_idsolicitacao ON app.itenssolicitacao (idsolicitacao);
CREATE UNIQUE INDEX IF NOT EXISTS uk_itenssolicitacao_nome_solicitacao ON app.itenssolicitacao (nomeitenssolicitacao, idsolicitacao);

-- =========================
-- bloqueioitenssolicitacao
-- =========================
CREATE SEQUENCE IF NOT EXISTS app.bloqueioitenssolicitacao_idbloqueioitenssolicitacao_seq INCREMENT BY 50;

CREATE TABLE IF NOT EXISTS app.bloqueioitenssolicitacao (
    idbloqueioitenssolicitacao   INTEGER PRIMARY KEY DEFAULT nextval('app.bloqueioitenssolicitacao_idbloqueioitenssolicitacao_seq'),
    iditenssolicitacao           INTEGER,
    codigoreferencia             INTEGER,
    CONSTRAINT fk_bloqueio_itens FOREIGN KEY (iditenssolicitacao)
        REFERENCES app.itenssolicitacao (iditenssolicitacao)
);
CREATE INDEX IF NOT EXISTS idx_bloqueio_item_iditens ON app.bloqueioitenssolicitacao (iditenssolicitacao);

-- =========================
-- tramitacao
-- =========================
CREATE SEQUENCE IF NOT EXISTS app.tramitacao_idtramitacao_seq INCREMENT BY 50;

CREATE TABLE IF NOT EXISTS app.tramitacao (
    idtramitacao        INTEGER PRIMARY KEY DEFAULT nextval('app.tramitacao_idtramitacao_seq'),
    datafinal           DATE,
    datainicial         DATE,
    dataresposta        DATE,
    usuarioresposta     TEXT,
    horatramitacao      TIME,
    tipocolheita        INTEGER,
    tipoauto            INTEGER,
    tiponotificacao     INTEGER,
    tipoarquitetonico   INTEGER,
    tipoadministrativo  INTEGER,
    tipooperacao        INTEGER,
    prioridadetramite   INTEGER,
    numerotramitacao    INTEGER,
    statustramitacao    INTEGER,
    situacaotramitacao  INTEGER,
    leutramitacao       INTEGER,
    idordemservico      INTEGER,
    idtipoinspecao      INTEGER,
    textotramitacao     TEXT,
    textoresposta       TEXT,
    CONSTRAINT fk_tramitacao_ordemservico FOREIGN KEY (idordemservico)
        REFERENCES ordemservico (id),
    CONSTRAINT fk_tramitacao_tipoinspecao FOREIGN KEY (idtipoinspecao)
        REFERENCES app.tipoinspecao (idtipoinspecao)
);
CREATE INDEX IF NOT EXISTS idx_tramitacao_idordemservico ON app.tramitacao (idordemservico);
CREATE INDEX IF NOT EXISTS idx_tramitacao_idtipoinspecao ON app.tramitacao (idtipoinspecao);

-- =========================
-- autonotificacao
-- =========================
-- Entity usa GenerationType.AUTO sem @SequenceGenerator → criar sequência padrão esperada
CREATE SEQUENCE IF NOT EXISTS app.autonotificacao_seq INCREMENT BY 50;

CREATE TABLE IF NOT EXISTS app.autonotificacao (
    idautonotificacao   INTEGER PRIMARY KEY DEFAULT nextval('app.autonotificacao_seq'),
    descricaonotificacao TEXT,
    idtramitacao        INTEGER,
    prazo               INTEGER,
    CONSTRAINT fk_autonotificacao_tramitacao FOREIGN KEY (idtramitacao)
        REFERENCES app.tramitacao (idtramitacao)
);
CREATE INDEX IF NOT EXISTS idx_autonotificacao_idtramitacao ON app.autonotificacao (idtramitacao);

-- =========================
-- autoinfracao
-- =========================
CREATE SEQUENCE IF NOT EXISTS app.autoinfracao_idautoinfracao_seq INCREMENT BY 50;

CREATE TABLE IF NOT EXISTS app.autoinfracao (
    idautoinfracao              INTEGER PRIMARY KEY DEFAULT nextval('app.autoinfracao_idautoinfracao_seq'),
    dataautoinfracao            DATE,
    grauinfracaoautoinfracao    INTEGER,
    textoautoinfracao           TEXT,
    gerainterdicao              INTEGER,
    numeroauto                  INTEGER,
    geraadvertencia             INTEGER,
    geramulta                   INTEGER,
    valormulta                  TEXT,
    termoadvertencia            TEXT,
    termointerdicao             TEXT,
    textointerdicao             TEXT,
    tipoinfracao                TEXT,
    idtramitacao                INTEGER,
    CONSTRAINT fk_autoinfracao_tramitacao FOREIGN KEY (idtramitacao)
        REFERENCES app.tramitacao (idtramitacao)
);
CREATE INDEX IF NOT EXISTS idx_autoinfracao_idtramitacao ON app.autoinfracao (idtramitacao);

-- =========================
-- balancomedicamento
-- =========================
CREATE SEQUENCE IF NOT EXISTS app.balanco_idbalanco_seq INCREMENT BY 50;

CREATE TABLE IF NOT EXISTS app.balancomedicamento (
    idbalanco           INTEGER PRIMARY KEY DEFAULT nextval('app.balanco_idbalanco_seq'),
    bmpoanual           INTEGER,
    bmpotrimestral      INTEGER,
    bspoanual           INTEGER,
    bspotrimestral      INTEGER,
    dataentrega         DATE NOT NULL,
    idestabelecimento   INTEGER NOT NULL,
    livroreceituario    INTEGER,
    mesreferencia       INTEGER NOT NULL,
    qtdareceitaa        INTEGER,
    qtdareceitab        INTEGER,
    rmnramensal         INTEGER,
    rmnrb2mensal        INTEGER,
    rmvmensal           INTEGER,
    statusbalanco       INTEGER,
    textobalanco        TEXT,
    trimestrebmpo       INTEGER,
    trimestrebspo       INTEGER,
    idusuario           INTEGER,
    balancoanual        INTEGER,
    entregador          TEXT NOT NULL,
    CONSTRAINT fk_balancomedicamento_estabelecimento FOREIGN KEY (idestabelecimento)
        REFERENCES estabelecimento (id)
);
CREATE INDEX IF NOT EXISTS idx_balancomedicamento_idestabelecimento ON app.balancomedicamento (idestabelecimento);

-- =========================
-- carteirinha
-- =========================
CREATE SEQUENCE IF NOT EXISTS app.carteirinha_idcarteirinha_seq INCREMENT BY 50;

CREATE TABLE IF NOT EXISTS app.carteirinha (
    idcarteirinha   INTEGER PRIMARY KEY DEFAULT nextval('app.carteirinha_idcarteirinha_seq'),
    datacadastro    DATE,
    dataemissao     DATE,
    datavalidade    DATE,
    imagemcarteirinha TEXT NOT NULL,
    numprocesso     TEXT NOT NULL,
    statusimpresso  INTEGER
);
CREATE INDEX IF NOT EXISTS idx_carteirinha_numprocesso ON app.carteirinha (numprocesso);
