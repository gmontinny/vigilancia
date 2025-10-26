-- V7__licencias_mensagens_timelines_unidades_apreensoes.sql
-- Cria tabelas e sequências para Licencia, Mensagem, Timeline, Unidademedida e Apreensao
-- Target: PostgreSQL 15

-- =====================
-- Sequences
-- =====================
CREATE SEQUENCE IF NOT EXISTS licencia_idlicencia_seq INCREMENT BY 1 MINVALUE 1 START WITH 1;
CREATE SEQUENCE IF NOT EXISTS mensagem_idmensagem_seq INCREMENT BY 1 MINVALUE 1 START WITH 1;
CREATE SEQUENCE IF NOT EXISTS timeline_idtimeline_seq INCREMENT BY 1 MINVALUE 1 START WITH 1;
CREATE SEQUENCE IF NOT EXISTS unidademedida_idunidademedida_seq INCREMENT BY 1 MINVALUE 1 START WITH 1;
CREATE SEQUENCE IF NOT EXISTS apreensao_idapreensao_seq INCREMENT BY 1 MINVALUE 1 START WITH 1;

-- =====================
-- Tabela: licencia
-- =====================
CREATE TABLE IF NOT EXISTS licencia (
    id               INTEGER PRIMARY KEY DEFAULT nextval('licencia_idlicencia_seq'),
    data_licencia    DATE,
    data_vencimento  DATE,
    qt_impresso      INTEGER,
    observacao       VARCHAR(1024),
    status           INTEGER,
    idveiculo        INTEGER      NOT NULL
);

-- FK e índice
ALTER TABLE licencia
    ADD CONSTRAINT fk_licencia_veiculo
        FOREIGN KEY (idveiculo) REFERENCES veiculo (id);

CREATE INDEX IF NOT EXISTS idx_licencia_idveiculo ON licencia (idveiculo);

-- =====================
-- Tabela: mensagem
-- =====================
CREATE TABLE IF NOT EXISTS mensagem (
    id               INTEGER PRIMARY KEY DEFAULT nextval('mensagem_idmensagem_seq'),
    data_mensagem    DATE,
    de               VARCHAR(255)  NOT NULL,
    para             VARCHAR(255)  NOT NULL,
    status           INTEGER,
    texto            VARCHAR(2048) NOT NULL,
    idusuario        INTEGER,
    idordemservico   INTEGER       NOT NULL
);

-- FKs e índices
ALTER TABLE mensagem
    ADD CONSTRAINT fk_mensagem_ordemservico
        FOREIGN KEY (idordemservico) REFERENCES ordemservico (id);

-- (idusuario) é um campo livre na entidade, sem relacionamento; manter apenas índice opcional
CREATE INDEX IF NOT EXISTS idx_mensagem_idordemservico ON mensagem (idordemservico);
CREATE INDEX IF NOT EXISTS idx_mensagem_idusuario ON mensagem (idusuario);

-- =====================
-- Tabela: timeline
-- =====================
CREATE TABLE IF NOT EXISTS timeline (
    id               INTEGER PRIMARY KEY DEFAULT nextval('timeline_idtimeline_seq'),
    data_timeline    DATE,
    idusuario        INTEGER,
    situacao         INTEGER,
    texto            VARCHAR(2048),
    numero_processo  VARCHAR(64),
    tipo_situacao    VARCHAR(255),
    hora_timeline    TIME
);

-- FK e índice
ALTER TABLE timeline
    ADD CONSTRAINT fk_timeline_usuario
        FOREIGN KEY (idusuario) REFERENCES usuario (id);

CREATE INDEX IF NOT EXISTS idx_timeline_idusuario ON timeline (idusuario);

-- =====================
-- Tabela: unidademedida
-- =====================
CREATE TABLE IF NOT EXISTS unidademedida (
    id        INTEGER PRIMARY KEY DEFAULT nextval('unidademedida_idunidademedida_seq'),
    descricao VARCHAR(255) NOT NULL,
    sigla     VARCHAR(64)  NOT NULL,
    CONSTRAINT uk_unidademedida_sigla UNIQUE (sigla)
);

-- =====================
-- Tabela: apreensao
-- =====================
CREATE TABLE IF NOT EXISTS apreensao (
    id               INTEGER PRIMARY KEY DEFAULT nextval('apreensao_idapreensao_seq'),
    descarte         INTEGER,
    marca            VARCHAR(255) NOT NULL,
    numero_auto      INTEGER,
    quantidade       INTEGER,
    produto          VARCHAR(255) NOT NULL,
    local_descarte   VARCHAR(255),
    validade         DATE,
    lote             VARCHAR(255),
    volume           VARCHAR(255),
    data_fabricante  DATE,
    idunidademedida  INTEGER
);

-- FK e índice
ALTER TABLE apreensao
    ADD CONSTRAINT fk_apreensao_unidademedida
        FOREIGN KEY (idunidademedida) REFERENCES unidademedida (id);

CREATE INDEX IF NOT EXISTS idx_apreensao_idunidademedida ON apreensao (idunidademedida);
