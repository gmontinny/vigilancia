-- V3__grupo_subgrupo.sql
-- Cria tabelas e sequências para entidades Grupo e Subgrupo conforme JPA
-- Target: PostgreSQL 15

-- Sequences
CREATE SEQUENCE IF NOT EXISTS grupo_idgrupo_seq INCREMENT BY 1 MINVALUE 1 START WITH 1;
CREATE SEQUENCE IF NOT EXISTS subgrupo_idsubgrupo_seq INCREMENT BY 1 MINVALUE 1 START WITH 1;

-- Tables
CREATE TABLE IF NOT EXISTS grupo (
    id   INTEGER PRIMARY KEY DEFAULT nextval('grupo_idgrupo_seq'),
    nome VARCHAR(255) NOT NULL,
    CONSTRAINT chk_grupo_nome_min_len CHECK (char_length(nome) >= 5)
);

CREATE TABLE IF NOT EXISTS subgrupo (
    id       INTEGER PRIMARY KEY DEFAULT nextval('subgrupo_idsubgrupo_seq'),
    nome     VARCHAR(255) NOT NULL,
    idgrupo  INTEGER      NOT NULL,
    CONSTRAINT chk_subgrupo_nome_min_len CHECK (char_length(nome) >= 5)
);

-- FKs
ALTER TABLE subgrupo
    ADD CONSTRAINT fk_subgrupo_grupo
        FOREIGN KEY (idgrupo) REFERENCES grupo (id);

-- Indexes
CREATE INDEX IF NOT EXISTS idx_subgrupo_idgrupo ON subgrupo (idgrupo);
