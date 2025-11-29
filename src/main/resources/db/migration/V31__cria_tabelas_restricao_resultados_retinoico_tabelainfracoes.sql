-- V31: Criação das tabelas Restricao, Resultadoprimeirainstancia,
-- Resultadosegundainstancia, Retinoico e Tabelainfracoes
-- Banco: PostgreSQL. Segue o padrão do V30 (sequences INCREMENT BY 50,
-- CREATE TABLE IF NOT EXISTS, FKs com verificação, índices para FKs e setval).

-- =====================
-- Sequences
-- =====================
CREATE SEQUENCE IF NOT EXISTS restricao_idrestricao_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS resultadoprimeirainstancia_idresultadoprimeira_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS resultadosegundainstancia_idresultadosegunda_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS retinoico_idretinoico_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS tabelainfracoes_idtabelainfracoes_seq INCREMENT BY 50;

-- =====================
-- Tabela: restricao
-- =====================
CREATE TABLE IF NOT EXISTS restricao (
    idrestricao          INTEGER PRIMARY KEY DEFAULT nextval('restricao_idrestricao_seq'),
    datarestricao        DATE,
    idestabelecimento    INTEGER,
    idusuario            INTEGER,
    statusrestricao      INTEGER,
    textorestricao       VARCHAR(255)
);

DO $$
BEGIN
    -- FK: restricao.idestabelecimento -> estabelecimento(id)
    IF NOT EXISTS (
        SELECT 1 FROM information_schema.table_constraints tc
        WHERE tc.constraint_name = 'fk_restricao_idestabelecimento'
          AND tc.table_name = 'restricao'
    ) THEN
        ALTER TABLE restricao
            ADD CONSTRAINT fk_restricao_idestabelecimento
            FOREIGN KEY (idestabelecimento) REFERENCES estabelecimento(id);
    END IF;

    -- FK: restricao.idusuario -> usuario(id)
    IF NOT EXISTS (
        SELECT 1 FROM information_schema.table_constraints tc
        WHERE tc.constraint_name = 'fk_restricao_idusuario'
          AND tc.table_name = 'restricao'
    ) THEN
        ALTER TABLE restricao
            ADD CONSTRAINT fk_restricao_idusuario
            FOREIGN KEY (idusuario) REFERENCES usuario(id);
    END IF;
END $$;

CREATE INDEX IF NOT EXISTS idx_restricao_idestabelecimento ON restricao (idestabelecimento);
CREATE INDEX IF NOT EXISTS idx_restricao_idusuario ON restricao (idusuario);

-- =====================
-- Tabela: resultadoprimeirainstancia
-- =====================
CREATE TABLE IF NOT EXISTS resultadoprimeirainstancia (
    idresultadoprimeira  INTEGER PRIMARY KEY DEFAULT nextval('resultadoprimeirainstancia_idresultadoprimeira_seq'),
    datalancada          DATE,
    idusuario            INTEGER,
    numprocesso          VARCHAR(255),
    tipoprocedencia      VARCHAR(255)
);

DO $$
BEGIN
    -- FK: resultadoprimeirainstancia.idusuario -> usuario(id)
    IF NOT EXISTS (
        SELECT 1 FROM information_schema.table_constraints tc
        WHERE tc.constraint_name = 'fk_res1inst_idusuario'
          AND tc.table_name = 'resultadoprimeirainstancia'
    ) THEN
        ALTER TABLE resultadoprimeirainstancia
            ADD CONSTRAINT fk_res1inst_idusuario
            FOREIGN KEY (idusuario) REFERENCES usuario(id);
    END IF;

    -- FK: resultadoprimeirainstancia.numprocesso -> app.processo(numero_processo)
    IF NOT EXISTS (
        SELECT 1 FROM information_schema.table_constraints tc
        WHERE tc.constraint_name = 'fk_res1inst_numprocesso'
          AND tc.table_name = 'resultadoprimeirainstancia'
    ) THEN
        ALTER TABLE resultadoprimeirainstancia
            ADD CONSTRAINT fk_res1inst_numprocesso
            FOREIGN KEY (numprocesso) REFERENCES app.processo(numero_processo);
    END IF;
END $$;

CREATE INDEX IF NOT EXISTS idx_res1inst_idusuario ON resultadoprimeirainstancia (idusuario);
CREATE INDEX IF NOT EXISTS idx_res1inst_numprocesso ON resultadoprimeirainstancia (numprocesso);

-- =====================
-- Tabela: resultadosegundainstancia
-- =====================
CREATE TABLE IF NOT EXISTS resultadosegundainstancia (
    idresultadosegunda   INTEGER PRIMARY KEY DEFAULT nextval('resultadosegundainstancia_idresultadosegunda_seq'),
    datalancada          DATE,
    idusuario            INTEGER,
    numprocesso          VARCHAR(255),
    tipoprocedencia      VARCHAR(255)
);

DO $$
BEGIN
    -- FK: resultadosegundainstancia.idusuario -> usuario(id)
    IF NOT EXISTS (
        SELECT 1 FROM information_schema.table_constraints tc
        WHERE tc.constraint_name = 'fk_res2inst_idusuario'
          AND tc.table_name = 'resultadosegundainstancia'
    ) THEN
        ALTER TABLE resultadosegundainstancia
            ADD CONSTRAINT fk_res2inst_idusuario
            FOREIGN KEY (idusuario) REFERENCES usuario(id);
    END IF;

    -- FK: resultadosegundainstancia.numprocesso -> app.processo(numero_processo)
    IF NOT EXISTS (
        SELECT 1 FROM information_schema.table_constraints tc
        WHERE tc.constraint_name = 'fk_res2inst_numprocesso'
          AND tc.table_name = 'resultadosegundainstancia'
    ) THEN
        ALTER TABLE resultadosegundainstancia
            ADD CONSTRAINT fk_res2inst_numprocesso
            FOREIGN KEY (numprocesso) REFERENCES app.processo(numero_processo);
    END IF;
END $$;

CREATE INDEX IF NOT EXISTS idx_res2inst_idusuario ON resultadosegundainstancia (idusuario);
CREATE INDEX IF NOT EXISTS idx_res2inst_numprocesso ON resultadosegundainstancia (numprocesso);

-- =====================
-- Tabela: retinoico
-- =====================
CREATE TABLE IF NOT EXISTS retinoico (
    idretinoico      INTEGER PRIMARY KEY DEFAULT nextval('retinoico_idretinoico_seq'),
    statusretinoico  INTEGER,
    dataretinoico    DATE,
    numprocesso      VARCHAR(255) NOT NULL,
    tiporetinoico    INTEGER NOT NULL
);

DO $$
BEGIN
    -- FK: retinoico.numprocesso -> app.processo(numero_processo)
    IF NOT EXISTS (
        SELECT 1 FROM information_schema.table_constraints tc
        WHERE tc.constraint_name = 'fk_retinoico_numprocesso'
          AND tc.table_name = 'retinoico'
    ) THEN
        ALTER TABLE retinoico
            ADD CONSTRAINT fk_retinoico_numprocesso
            FOREIGN KEY (numprocesso) REFERENCES app.processo(numero_processo);
    END IF;
END $$;

CREATE INDEX IF NOT EXISTS idx_retinoico_numprocesso ON retinoico (numprocesso);

-- =====================
-- Tabela: tabelainfracoes
-- =====================
CREATE TABLE IF NOT EXISTS tabelainfracoes (
    idtabelainfracoes  INTEGER PRIMARY KEY DEFAULT nextval('tabelainfracoes_idtabelainfracoes_seq'),
    conformidade       VARCHAR(255) NOT NULL,
    tiporisco          INTEGER NOT NULL,
    tipograuinfracao   INTEGER,
    valorconformidade  DOUBLE PRECISION NOT NULL,
    ordeminfracoes     INTEGER
);

-- =====================
-- Ajuste de setval das sequences (sincroniza com dados existentes)
-- =====================
DO $$
DECLARE v_max INTEGER;
BEGIN
    -- restricao
    SELECT COALESCE(MAX(idrestricao), 0) + 1 INTO v_max FROM restricao;
    PERFORM setval('restricao_idrestricao_seq', GREATEST(v_max, 1), false);

    -- resultadoprimeirainstancia
    SELECT COALESCE(MAX(idresultadoprimeira), 0) + 1 INTO v_max FROM resultadoprimeirainstancia;
    PERFORM setval('resultadoprimeirainstancia_idresultadoprimeira_seq', GREATEST(v_max, 1), false);

    -- resultadosegundainstancia
    SELECT COALESCE(MAX(idresultadosegunda), 0) + 1 INTO v_max FROM resultadosegundainstancia;
    PERFORM setval('resultadosegundainstancia_idresultadosegunda_seq', GREATEST(v_max, 1), false);

    -- retinoico
    SELECT COALESCE(MAX(idretinoico), 0) + 1 INTO v_max FROM retinoico;
    PERFORM setval('retinoico_idretinoico_seq', GREATEST(v_max, 1), false);

    -- tabelainfracoes
    SELECT COALESCE(MAX(idtabelainfracoes), 0) + 1 INTO v_max FROM tabelainfracoes;
    PERFORM setval('tabelainfracoes_idtabelainfracoes_seq', GREATEST(v_max, 1), false);
END $$;
