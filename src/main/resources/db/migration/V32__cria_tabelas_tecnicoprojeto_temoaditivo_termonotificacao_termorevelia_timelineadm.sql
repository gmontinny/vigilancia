-- V32: Criação das tabelas Tecnicoprojeto, Temoaditivo, Termonotificacao,
-- Termorevelia e Timelineadm
-- Banco: PostgreSQL. Segue o padrão do projeto (V28/V30): sequences INCREMENT BY 50,
-- nomes de colunas conforme entidades, FKs para tabelas existentes.

-- =====================
-- Sequences
-- =====================
CREATE SEQUENCE IF NOT EXISTS tecnicoprojeto_idtecnicoprojeto_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS temoaditivo_idtermoaditivo_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS termonotificacao_idtermonotificacao_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS termorevelia_idtermorevelia_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS timelineadm_idtimelineadm_seq INCREMENT BY 50;

-- =====================
-- Tabela: tecnicoprojeto
-- =====================
CREATE TABLE IF NOT EXISTS tecnicoprojeto (
    idtecnicoprojeto      INTEGER PRIMARY KEY DEFAULT nextval('tecnicoprojeto_idtecnicoprojeto_seq'),
    celulartecnicoprojeto VARCHAR(255),
    emailtecnicoprojeto   VARCHAR(255) NOT NULL,
    idconselho            INTEGER NOT NULL,
    nometecnicoprojeto    VARCHAR(255) NOT NULL,
    numprocesso           VARCHAR(255),
    cpftecnicoprojeto     VARCHAR(255) NOT NULL,
    numeroconselho        VARCHAR(255)
);

DO $$
BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM information_schema.table_constraints tc
        WHERE tc.constraint_name = 'fk_tecnicoprojeto_idconselho'
          AND tc.table_name = 'tecnicoprojeto'
    ) THEN
        ALTER TABLE tecnicoprojeto
            ADD CONSTRAINT fk_tecnicoprojeto_idconselho
            FOREIGN KEY (idconselho) REFERENCES conselho(id);
    END IF;
END $$;

CREATE INDEX IF NOT EXISTS idx_tecnicoprojeto_idconselho ON tecnicoprojeto (idconselho);
CREATE INDEX IF NOT EXISTS idx_tecnicoprojeto_numprocesso ON tecnicoprojeto (numprocesso);

-- =====================
-- Tabela: temoaditivo
-- =====================
CREATE TABLE IF NOT EXISTS temoaditivo (
    idtermoaditivo         INTEGER PRIMARY KEY DEFAULT nextval('temoaditivo_idtermoaditivo_seq'),
    coordenadorresponsavel VARCHAR(255) NOT NULL,
    imagemassinatura       VARCHAR(1024) NOT NULL,
    textoaditivo           VARCHAR(2048) NOT NULL
);

-- =====================
-- Tabela: termonotificacao
-- =====================
CREATE TABLE IF NOT EXISTS termonotificacao (
    idtermonotificacao INTEGER PRIMARY KEY DEFAULT nextval('termonotificacao_idtermonotificacao_seq'),
    datanotificacao    DATE,
    horanotificacao    TIME,
    idestabelecimento  INTEGER,
    numerotramitacao   INTEGER,
    textonotificacao   VARCHAR(2048),
    diasnotificacao    INTEGER
);

DO $$
BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM information_schema.table_constraints tc
        WHERE tc.constraint_name = 'fk_termonotificacao_idestabelecimento'
          AND tc.table_name = 'termonotificacao'
    ) THEN
        ALTER TABLE termonotificacao
            ADD CONSTRAINT fk_termonotificacao_idestabelecimento
            FOREIGN KEY (idestabelecimento) REFERENCES estabelecimento(id);
    END IF;
END $$;

CREATE INDEX IF NOT EXISTS idx_termonotificacao_idestabelecimento ON termonotificacao (idestabelecimento);

-- =====================
-- Tabela: termorevelia
-- =====================
CREATE TABLE IF NOT EXISTS termorevelia (
    idtermorevelia         INTEGER PRIMARY KEY DEFAULT nextval('termorevelia_idtermorevelia_seq'),
    coordenadorresponsavel VARCHAR(255) NOT NULL,
    imagemassinatura       VARCHAR(1024) NOT NULL,
    textorevelia           VARCHAR(2048) NOT NULL
);

-- =====================
-- Tabela: timelineadm
-- =====================
CREATE TABLE IF NOT EXISTS timelineadm (
    idtimelineadm  INTEGER PRIMARY KEY DEFAULT nextval('timelineadm_idtimelineadm_seq'),
    data           DATE,
    hora           TIME,
    numprocesso    VARCHAR(255),
    processogerado VARCHAR(255),
    situacao       VARCHAR(255)
);

CREATE INDEX IF NOT EXISTS idx_timelineadm_numprocesso ON timelineadm (numprocesso);

-- =====================
-- Ajuste de setval das sequences (sincroniza com dados existentes)
-- =====================
DO $$
DECLARE v_max INTEGER;
BEGIN
    -- tecnicoprojeto
    SELECT COALESCE(MAX(idtecnicoprojeto), 0) + 1 INTO v_max FROM tecnicoprojeto;
    PERFORM setval('tecnicoprojeto_idtecnicoprojeto_seq', GREATEST(v_max, 1), false);

    -- temoaditivo
    SELECT COALESCE(MAX(idtermoaditivo), 0) + 1 INTO v_max FROM temoaditivo;
    PERFORM setval('temoaditivo_idtermoaditivo_seq', GREATEST(v_max, 1), false);

    -- termonotificacao
    SELECT COALESCE(MAX(idtermonotificacao), 0) + 1 INTO v_max FROM termonotificacao;
    PERFORM setval('termonotificacao_idtermonotificacao_seq', GREATEST(v_max, 1), false);

    -- termorevelia
    SELECT COALESCE(MAX(idtermorevelia), 0) + 1 INTO v_max FROM termorevelia;
    PERFORM setval('termorevelia_idtermorevelia_seq', GREATEST(v_max, 1), false);

    -- timelineadm
    SELECT COALESCE(MAX(idtimelineadm), 0) + 1 INTO v_max FROM timelineadm;
    PERFORM setval('timelineadm_idtimelineadm_seq', GREATEST(v_max, 1), false);
END $$;
