-- V2__domain_schema.sql
-- DDL generated from JPA domain to enable versioned migrations with Flyway
-- Target: PostgreSQL

-- Sequences
CREATE SEQUENCE IF NOT EXISTS conselho_idconselho_seq INCREMENT BY 1 MINVALUE 1 START WITH 1;
CREATE SEQUENCE IF NOT EXISTS responsavel_tecnico_id_seq INCREMENT BY 1 MINVALUE 1 START WITH 1;
CREATE SEQUENCE IF NOT EXISTS usuario_idusuario_seq INCREMENT BY 1 MINVALUE 1 START WITH 1;
CREATE SEQUENCE IF NOT EXISTS estabelecimento_idestabelecimento_seq INCREMENT BY 1 MINVALUE 1 START WITH 1;

-- Tables
CREATE TABLE IF NOT EXISTS conselho (
    id   INTEGER PRIMARY KEY DEFAULT nextval('conselho_idconselho_seq'),
    nome VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS responsavel_tecnico (
    id               INTEGER PRIMARY KEY DEFAULT nextval('responsavel_tecnico_id_seq'),
    nome             VARCHAR(255) NOT NULL,
    cpf              VARCHAR(32)  NOT NULL,
    numero_conselho  VARCHAR(64)  NOT NULL,
    numero_processo  VARCHAR(64),
    id_conselho      INTEGER      NOT NULL
);

CREATE TABLE IF NOT EXISTS usuario (
    id               INTEGER PRIMARY KEY DEFAULT nextval('usuario_idusuario_seq'),
    nome             VARCHAR(255) NOT NULL,
    cpf              VARCHAR(32)  NOT NULL,
    email            VARCHAR(255) NOT NULL,
    senha            VARCHAR(255) NOT NULL,
    celular          VARCHAR(64),
    imagem           VARCHAR(512),
    sexo             INTEGER,
    advogado         INTEGER,
    status           INTEGER      NOT NULL,
    tipo             INTEGER      NOT NULL,
    auditor          INTEGER,
    administrativo   INTEGER,
    status_envio     INTEGER,
    coordenador      INTEGER,
    recurso_humano   INTEGER
);

CREATE TABLE IF NOT EXISTS estabelecimento (
    id                   INTEGER PRIMARY KEY DEFAULT nextval('estabelecimento_idestabelecimento_seq'),
    razao_social         VARCHAR(255) NOT NULL,
    nome_fantasia        VARCHAR(255),
    cnpj                 VARCHAR(32),
    ie                   VARCHAR(64),
    email                VARCHAR(255) NOT NULL,
    telefone             VARCHAR(64),
    celular              VARCHAR(64),
    cep                  VARCHAR(16)  NOT NULL,
    endereco             VARCHAR(255) NOT NULL,
    numero               INTEGER,
    bairro               VARCHAR(255) NOT NULL,
    area                 VARCHAR(255) NOT NULL,
    latitude             VARCHAR(64),
    longitude            VARCHAR(64),
    cm                   BIGINT,
    cnes                 BIGINT,
    cpf_responsavel      VARCHAR(32),
    data_cadastro        DATE,
    situacao             INTEGER,
    albergado            INTEGER,
    "check"             INTEGER,
    ambulante            INTEGER,
    endereco_fiscal      INTEGER,
    id_tipo_empresa      INTEGER,
    numero_atividade     INTEGER,
    idusuario            INTEGER,
    idresponsavel        INTEGER      NOT NULL
);

CREATE TABLE IF NOT EXISTS processo (
    numero_processo        VARCHAR(64) PRIMARY KEY,
    data_entrada           DATE,
    status                 INTEGER,
    resultado              INTEGER,
    observacao             VARCHAR(1024),
    endereco_arquitetonico VARCHAR(1024),
    idusuario              INTEGER,
    idestabelecimento      INTEGER NOT NULL
);

-- Foreign keys
ALTER TABLE responsavel_tecnico
    ADD CONSTRAINT fk_responsavel_tecnico_conselho
        FOREIGN KEY (id_conselho) REFERENCES conselho (id);

ALTER TABLE estabelecimento
    ADD CONSTRAINT fk_estabelecimento_usuario
        FOREIGN KEY (idusuario) REFERENCES usuario (id),
    ADD CONSTRAINT fk_estabelecimento_responsavel
        FOREIGN KEY (idresponsavel) REFERENCES responsavel_tecnico (id);

ALTER TABLE processo
    ADD CONSTRAINT fk_processo_usuario
        FOREIGN KEY (idusuario) REFERENCES usuario (id),
    ADD CONSTRAINT fk_processo_estabelecimento
        FOREIGN KEY (idestabelecimento) REFERENCES estabelecimento (id);

-- Indexes on FK columns
CREATE INDEX IF NOT EXISTS idx_responsavel_tecnico_id_conselho ON responsavel_tecnico (id_conselho);
CREATE INDEX IF NOT EXISTS idx_estabelecimento_idusuario ON estabelecimento (idusuario);
CREATE INDEX IF NOT EXISTS idx_estabelecimento_idresponsavel ON estabelecimento (idresponsavel);
CREATE INDEX IF NOT EXISTS idx_processo_idusuario ON processo (idusuario);
CREATE INDEX IF NOT EXISTS idx_processo_idestabelecimento ON processo (idestabelecimento);
