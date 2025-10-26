-- V4__domain_full.sql
-- Completa o schema conforme o domínio atual (entidades e relacionamentos adicionais)
-- Target: PostgreSQL 15

-- =====================
-- Sequences
-- =====================
CREATE SEQUENCE IF NOT EXISTS acao_idacao_seq INCREMENT BY 1 MINVALUE 1 START WITH 1;
CREATE SEQUENCE IF NOT EXISTS ordemservico_idordemservico_seq INCREMENT BY 1 MINVALUE 1 START WITH 1;
CREATE SEQUENCE IF NOT EXISTS reclamacao_idreclamacao_seq INCREMENT BY 1 MINVALUE 1 START WITH 1;
CREATE SEQUENCE IF NOT EXISTS bpa_idbpa_seq INCREMENT BY 1 MINVALUE 1 START WITH 1;
CREATE SEQUENCE IF NOT EXISTS tabela_idtabelas_seq INCREMENT BY 1 MINVALUE 1 START WITH 1;
CREATE SEQUENCE IF NOT EXISTS produtocategoria_idprodutocategoria_seq INCREMENT BY 1 MINVALUE 1 START WITH 1;
CREATE SEQUENCE IF NOT EXISTS fiscal_idfiscal_seq INCREMENT BY 1 MINVALUE 1 START WITH 1;
CREATE SEQUENCE IF NOT EXISTS alvara_idalvara_seq INCREMENT BY 1 MINVALUE 1 START WITH 1;
CREATE SEQUENCE IF NOT EXISTS endereco_idendereco_seq INCREMENT BY 1 MINVALUE 1 START WITH 1;
CREATE SEQUENCE IF NOT EXISTS tipoempresa_idtipoempresa_seq INCREMENT BY 1 MINVALUE 1 START WITH 1;
CREATE SEQUENCE IF NOT EXISTS logs_idlogs_seq INCREMENT BY 1 MINVALUE 1 START WITH 1;
CREATE SEQUENCE IF NOT EXISTS permissao_idpermissao_seq INCREMENT BY 1 MINVALUE 1 START WITH 1;
CREATE SEQUENCE IF NOT EXISTS fabril_idfabril_seq INCREMENT BY 1 MINVALUE 1 START WITH 1;

-- =====================
-- Tables
-- =====================
CREATE TABLE IF NOT EXISTS acao (
    id   INTEGER PRIMARY KEY DEFAULT nextval('acao_idacao_seq'),
    nome VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS endereco (
    id          INTEGER PRIMARY KEY DEFAULT nextval('endereco_idendereco_seq'),
    bairro      VARCHAR(255) NOT NULL,
    cep         VARCHAR(32)  NOT NULL,
    complemento VARCHAR(255),
    logradouro  VARCHAR(255),
    numero      INTEGER,
    longitude   VARCHAR(64),
    latitude    VARCHAR(64),
    idusuario   INTEGER
);

CREATE TABLE IF NOT EXISTS tipoempresa (
    id        INTEGER PRIMARY KEY DEFAULT nextval('tipoempresa_idtipoempresa_seq'),
    descricao VARCHAR(255),
    sigla     VARCHAR(64)
);

CREATE TABLE IF NOT EXISTS ordemservico (
    id                  INTEGER PRIMARY KEY DEFAULT nextval('ordemservico_idordemservico_seq'),
    data_final          DATE,
    data_inicial        DATE,
    data_ordem_servico  DATE,
    data_conclusao      DATE,
    usuario_conclusao   VARCHAR(255),
    situacao            INTEGER,
    texto_conclusao     VARCHAR(1024),
    texto_problema      VARCHAR(1024),
    prioridade          INTEGER,
    tls                 INTEGER,
    tipo                INTEGER,
    hora_ordem_servico  TIME,
    tipo_documento      VARCHAR(255),
    descricao_documento VARCHAR(255),
    idacao              INTEGER,
    numprocesso         VARCHAR(64)
);

CREATE TABLE IF NOT EXISTS produtocategoria (
    id   INTEGER PRIMARY KEY DEFAULT nextval('produtocategoria_idprodutocategoria_seq'),
    nome VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS reclamacao (
    id                  INTEGER PRIMARY KEY DEFAULT nextval('reclamacao_idreclamacao_seq'),
    bairro_reclamado    VARCHAR(255),
    data_reclamado      DATE,
    descricao_reclamado VARCHAR(1024),
    endereco_reclamado  VARCHAR(255),
    nome_reclamado      VARCHAR(255),
    nome_reclamante     VARCHAR(255),
    telefone_reclamacao VARCHAR(64),
    tipo_atendimento    VARCHAR(255),
    tipo_reclamado      VARCHAR(255),
    ponto_referencia    VARCHAR(255),
    anonima_reclamacao  INTEGER,
    tipo_imovel         INTEGER,
    hora_reclamacao     TIME,
    idordemservico      INTEGER,
    idprodutocategoria  INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS bpa (
    id        INTEGER PRIMARY KEY DEFAULT nextval('bpa_idbpa_seq'),
    descricao VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS tabela (
    id        INTEGER PRIMARY KEY DEFAULT nextval('tabela_idtabelas_seq'),
    nome      VARCHAR(255) NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    ordem     INTEGER      NOT NULL
);

CREATE TABLE IF NOT EXISTS fiscal (
    id                   INTEGER PRIMARY KEY DEFAULT nextval('fiscal_idfiscal_seq'),
    status               INTEGER NOT NULL,
    numero_tramitacao    INTEGER,
    responsavel_fiscal   INTEGER,
    total_notificacao    INTEGER,
    idusuario            INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS alvara (
    id               INTEGER PRIMARY KEY DEFAULT nextval('alvara_idalvara_seq'),
    data_alvara      DATE,
    data_vencimento  DATE,
    qt_impresso      INTEGER,
    numero_processo  VARCHAR(64),
    idestabelecimento INTEGER NOT NULL,
    tipo_alvara      INTEGER NOT NULL,
    status_alvara    INTEGER
);

CREATE TABLE IF NOT EXISTS logs (
    id        INTEGER PRIMARY KEY DEFAULT nextval('logs_idlogs_seq'),
    data_log  DATE,
    hora_log  TIME,
    idusuario INTEGER
);

CREATE TABLE IF NOT EXISTS permissao (
    id                INTEGER PRIMARY KEY DEFAULT nextval('permissao_idpermissao_seq'),
    delete_permissao  INTEGER,
    insert_permissao  INTEGER,
    select_permissao  INTEGER,
    update_permissao  INTEGER,
    idtabelas         INTEGER,
    idusuario         INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS fabril (
    id           INTEGER PRIMARY KEY DEFAULT nextval('fabril_idfabril_seq'),
    bairro       VARCHAR(255) NOT NULL,
    cep          VARCHAR(32)  NOT NULL,
    cnpj         VARCHAR(32)  NOT NULL,
    email        VARCHAR(255) NOT NULL,
    fone         VARCHAR(64),
    municipio    VARCHAR(255) NOT NULL,
    numero       INTEGER,
    razao_social VARCHAR(255) NOT NULL,
    rua          VARCHAR(255) NOT NULL,
    tipo_fabril  INTEGER      NOT NULL,
    uf           VARCHAR(8)   NOT NULL
);

-- =====================
-- Ajustes em tabelas existentes
-- =====================
-- Renomeia a coluna de tipo de empresa no estabelecimento, se existir no padrão antigo
DO $$
BEGIN
    IF EXISTS (
        SELECT 1
        FROM information_schema.columns
        WHERE table_name = 'estabelecimento' AND column_name = 'id_tipo_empresa'
    ) AND NOT EXISTS (
        SELECT 1
        FROM information_schema.columns
        WHERE table_name = 'estabelecimento' AND column_name = 'idtipoempresa'
    ) THEN
        EXECUTE 'ALTER TABLE estabelecimento RENAME COLUMN id_tipo_empresa TO idtipoempresa';
    END IF;
    -- Garante presença da coluna caso nenhuma das duas exista
    IF NOT EXISTS (
        SELECT 1 FROM information_schema.columns
        WHERE table_name = 'estabelecimento' AND column_name = 'idtipoempresa'
    ) THEN
        EXECUTE 'ALTER TABLE estabelecimento ADD COLUMN idtipoempresa INTEGER';
    END IF;
END$$;

-- =====================
-- Foreign Keys
-- =====================
ALTER TABLE endereco
    ADD CONSTRAINT fk_endereco_usuario
        FOREIGN KEY (idusuario) REFERENCES usuario (id);

ALTER TABLE ordemservico
    ADD CONSTRAINT fk_ordemservico_acao
        FOREIGN KEY (idacao) REFERENCES acao (id),
    ADD CONSTRAINT fk_ordemservico_processo
        FOREIGN KEY (numprocesso) REFERENCES processo (numero_processo);

ALTER TABLE reclamacao
    ADD CONSTRAINT fk_reclamacao_ordemservico
        FOREIGN KEY (idordemservico) REFERENCES ordemservico (id),
    ADD CONSTRAINT fk_reclamacao_produtocategoria
        FOREIGN KEY (idprodutocategoria) REFERENCES produtocategoria (id);

ALTER TABLE fiscal
    ADD CONSTRAINT fk_fiscal_usuario
        FOREIGN KEY (idusuario) REFERENCES usuario (id);

ALTER TABLE alvara
    ADD CONSTRAINT fk_alvara_estabelecimento
        FOREIGN KEY (idestabelecimento) REFERENCES estabelecimento (id);

ALTER TABLE logs
    ADD CONSTRAINT fk_logs_usuario
        FOREIGN KEY (idusuario) REFERENCES usuario (id);

ALTER TABLE permissao
    ADD CONSTRAINT fk_permissao_tabela
        FOREIGN KEY (idtabelas) REFERENCES tabela (id),
    ADD CONSTRAINT fk_permissao_usuario
        FOREIGN KEY (idusuario) REFERENCES usuario (id);

ALTER TABLE estabelecimento
    ADD CONSTRAINT fk_estabelecimento_tipoempresa
        FOREIGN KEY (idtipoempresa) REFERENCES tipoempresa (id);

-- =====================
-- Indexes em colunas de FK
-- =====================
CREATE INDEX IF NOT EXISTS idx_endereco_idusuario ON endereco (idusuario);
CREATE INDEX IF NOT EXISTS idx_ordemservico_idacao ON ordemservico (idacao);
CREATE INDEX IF NOT EXISTS idx_ordemservico_numprocesso ON ordemservico (numprocesso);
CREATE INDEX IF NOT EXISTS idx_reclamacao_idordemservico ON reclamacao (idordemservico);
CREATE INDEX IF NOT EXISTS idx_reclamacao_idprodutocategoria ON reclamacao (idprodutocategoria);
CREATE INDEX IF NOT EXISTS idx_fiscal_idusuario ON fiscal (idusuario);
CREATE INDEX IF NOT EXISTS idx_alvara_idestabelecimento ON alvara (idestabelecimento);
CREATE INDEX IF NOT EXISTS idx_logs_idusuario ON logs (idusuario);
CREATE INDEX IF NOT EXISTS idx_permissao_idtabelas ON permissao (idtabelas);
CREATE INDEX IF NOT EXISTS idx_permissao_idusuario ON permissao (idusuario);
CREATE INDEX IF NOT EXISTS idx_estabelecimento_idtipoempresa ON estabelecimento (idtipoempresa);
