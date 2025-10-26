-- V6__categorias_veiculos.sql
-- Cria tabelas e sequências para as entidades Categoria e Veiculo conforme o domínio atual
-- Target: PostgreSQL 15

-- =====================
-- Sequences
-- =====================
CREATE SEQUENCE IF NOT EXISTS categoria_idcategoria_seq INCREMENT BY 1 MINVALUE 1 START WITH 1;
CREATE SEQUENCE IF NOT EXISTS veiculo_idveiculo_seq INCREMENT BY 1 MINVALUE 1 START WITH 1;

-- =====================
-- Tabela: categoria
-- =====================
CREATE TABLE IF NOT EXISTS categoria (
    id     INTEGER PRIMARY KEY DEFAULT nextval('categoria_idcategoria_seq'),
    codigo INTEGER,
    tipo   VARCHAR(255)
);

-- =====================
-- Tabela: veiculo
-- =====================
CREATE TABLE IF NOT EXISTS veiculo (
    id                 INTEGER PRIMARY KEY DEFAULT nextval('veiculo_idveiculo_seq'),
    chassi             VARCHAR(64)  NOT NULL,
    placa              VARCHAR(32)  NOT NULL,
    numero_processo    VARCHAR(64),
    placa_caminhao     VARCHAR(32),
    chassi_caminhao    VARCHAR(64),
    idcategoria        INTEGER      NOT NULL,
    idestabelecimento  INTEGER      NOT NULL,
    CONSTRAINT chk_veiculo_chassi_min_len CHECK (char_length(chassi) >= 17)
);

-- =====================
-- FKs
-- =====================
ALTER TABLE veiculo
    ADD CONSTRAINT fk_veiculo_categoria
        FOREIGN KEY (idcategoria) REFERENCES categoria (id);

ALTER TABLE veiculo
    ADD CONSTRAINT fk_veiculo_estabelecimento
        FOREIGN KEY (idestabelecimento) REFERENCES estabelecimento (id);

-- =====================
-- Indexes
-- =====================
CREATE INDEX IF NOT EXISTS idx_veiculo_idcategoria ON veiculo (idcategoria);
CREATE INDEX IF NOT EXISTS idx_veiculo_idestabelecimento ON veiculo (idestabelecimento);
