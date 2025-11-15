-- V29: Criação das tabelas Notrecursoadmprimeirainstancia, Outroresponsavel,
-- Processoadministrativo, Processolicenciamento e Processosolicitacao
-- Banco: PostgreSQL. Segue o padrão do projeto (V23/V28): sequences INCREMENT BY 50,
-- nomes de colunas conforme entidades, FKs para tabelas existentes (inclui app.processo(numero_processo)).

-- =====================
-- Sequences
-- =====================
CREATE SEQUENCE IF NOT EXISTS notrecursoadmprimeirainstanci_idnotrecursoadmprimeirainstan_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS outroresponsavel_idoutrosresponsaveis_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS processoadministrativo_idprocessoadministrativo_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS processolicenciamento_idprocessolicenciamento_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS processosolicitacao_idprocessosolicitacao_seq INCREMENT BY 50;

-- =====================
-- Tabela: notrecursoadmprimeirainstancia
-- =====================
CREATE TABLE IF NOT EXISTS notrecursoadmprimeirainstancia (
    idnotrecursoadmprimeirainstancia     INTEGER PRIMARY KEY DEFAULT nextval('notrecursoadmprimeirainstanci_idnotrecursoadmprimeirainstan_seq'),
    assinatura                           VARCHAR(255) NOT NULL,
    coordenador                          VARCHAR(255) NOT NULL,
    datarecursoadministrativo            DATE,
    horarecursoadministrativo            TIME,
    textorecursoadministrativo           VARCHAR(255) NOT NULL
);

-- =====================
-- Tabela: outroresponsavel
-- =====================
CREATE TABLE IF NOT EXISTS outroresponsavel (
    idoutrosresponsaveis    INTEGER PRIMARY KEY DEFAULT nextval('outroresponsavel_idoutrosresponsaveis_seq'),
    idconselho              INTEGER NOT NULL,
    nomeresponsavel         VARCHAR(255) NOT NULL,
    numeroestabelecimento   INTEGER,
    setorresponsavel        VARCHAR(255) NOT NULL,
    numeroconselho          VARCHAR(255) NOT NULL,
    cpfresponsavel          VARCHAR(255) NOT NULL,
    statusbaixa             INTEGER
);

DO $$
BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM information_schema.table_constraints tc
        WHERE tc.constraint_name = 'fk_outroresponsavel_idconselho'
          AND tc.table_name = 'outroresponsavel'
    ) THEN
        ALTER TABLE outroresponsavel
            ADD CONSTRAINT fk_outroresponsavel_idconselho
            FOREIGN KEY (idconselho) REFERENCES conselho(id);
    END IF;
END $$;

CREATE INDEX IF NOT EXISTS idx_outroresponsavel_idconselho ON outroresponsavel (idconselho);

-- =====================
-- Tabela: processoadministrativo
-- =====================
CREATE TABLE IF NOT EXISTS processoadministrativo (
    idprocessoadministrativo  INTEGER PRIMARY KEY DEFAULT nextval('processoadministrativo_idprocessoadministrativo_seq'),
    dataprocesso              DATE,
    dataciencia               DATE,
    indicadorcontrarazao      INTEGER,
    numeroauto                INTEGER,
    numprocesso               VARCHAR(255) NOT NULL,
    textorazao                VARCHAR(255),
    textoresposta             VARCHAR(255),
    processogerado            VARCHAR(255),
    tiporesultado             INTEGER,
    fiscalresponsavel         INTEGER,
    fiscalcontraresposta      INTEGER,
    tiposituacao              INTEGER
);

-- FK para Processo (schema app), chave natural coluna numero_processo
DO $$
BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM information_schema.table_constraints tc
        WHERE tc.constraint_name = 'fk_processoadm_numprocesso'
          AND tc.table_name = 'processoadministrativo'
    ) THEN
        ALTER TABLE processoadministrativo
            ADD CONSTRAINT fk_processoadm_numprocesso
            FOREIGN KEY (numprocesso) REFERENCES app.processo(numero_processo);
    END IF;
END $$;

CREATE INDEX IF NOT EXISTS idx_processoadm_numprocesso ON processoadministrativo (numprocesso);

-- =====================
-- Tabela: processolicenciamento
-- =====================
CREATE TABLE IF NOT EXISTS processolicenciamento (
    idprocessolicenciamento  INTEGER PRIMARY KEY DEFAULT nextval('processolicenciamento_idprocessolicenciamento_seq'),
    numprocesso              VARCHAR(255) NOT NULL,
    idlicenciamento          INTEGER NOT NULL,
    liberacao                INTEGER
);

DO $$
BEGIN
    -- FK para licenciamento
    IF NOT EXISTS (
        SELECT 1 FROM information_schema.table_constraints tc
        WHERE tc.constraint_name = 'fk_proclicen_idlicenciamento'
          AND tc.table_name = 'processolicenciamento'
    ) THEN
        ALTER TABLE processolicenciamento
            ADD CONSTRAINT fk_proclicen_idlicenciamento
            FOREIGN KEY (idlicenciamento) REFERENCES licenciamento(idlicenciamento);
    END IF;

    -- FK para Processo (schema app) usando numero_processo
    IF NOT EXISTS (
        SELECT 1 FROM information_schema.table_constraints tc
        WHERE tc.constraint_name = 'fk_proclicen_numprocesso'
          AND tc.table_name = 'processolicenciamento'
    ) THEN
        ALTER TABLE processolicenciamento
            ADD CONSTRAINT fk_proclicen_numprocesso
            FOREIGN KEY (numprocesso) REFERENCES app.processo(numero_processo);
    END IF;
END $$;

CREATE INDEX IF NOT EXISTS idx_proclicen_idlicenciamento ON processolicenciamento (idlicenciamento);
CREATE INDEX IF NOT EXISTS idx_proclicen_numprocesso ON processolicenciamento (numprocesso);

-- =====================
-- Tabela: processosolicitacao
-- =====================
CREATE TABLE IF NOT EXISTS processosolicitacao (
    idprocessosolicitacao   INTEGER PRIMARY KEY DEFAULT nextval('processosolicitacao_idprocessosolicitacao_seq'),
    numprocesso             VARCHAR(255) NOT NULL,
    iditenssolicitacao      INTEGER NOT NULL
);

DO $$
BEGIN
    -- FK para Itenssolicitacao
    IF NOT EXISTS (
        SELECT 1 FROM information_schema.table_constraints tc
        WHERE tc.constraint_name = 'fk_procsol_iditenssolicitacao'
          AND tc.table_name = 'processosolicitacao'
    ) THEN
        ALTER TABLE processosolicitacao
            ADD CONSTRAINT fk_procsol_iditenssolicitacao
            FOREIGN KEY (iditenssolicitacao) REFERENCES itenssolicitacao(iditenssolicitacao);
    END IF;

    -- FK para Processo (schema app) usando numero_processo
    IF NOT EXISTS (
        SELECT 1 FROM information_schema.table_constraints tc
        WHERE tc.constraint_name = 'fk_procsol_numprocesso'
          AND tc.table_name = 'processosolicitacao'
    ) THEN
        ALTER TABLE processosolicitacao
            ADD CONSTRAINT fk_procsol_numprocesso
            FOREIGN KEY (numprocesso) REFERENCES app.processo(numero_processo);
    END IF;
END $$;

CREATE INDEX IF NOT EXISTS idx_procsol_iditenssolicitacao ON processosolicitacao (iditenssolicitacao);
CREATE INDEX IF NOT EXISTS idx_procsol_numprocesso ON processosolicitacao (numprocesso);

-- =====================
-- Ajuste de setval das sequences (sincroniza com dados existentes)
-- =====================
DO $$
DECLARE v_max INTEGER;
BEGIN
    -- notrecursoadmprimeirainstancia
    SELECT COALESCE(MAX(idnotrecursoadmprimeirainstancia), 0) + 1 INTO v_max FROM notrecursoadmprimeirainstancia;
    PERFORM setval('notrecursoadmprimeirainstanci_idnotrecursoadmprimeirainstan_seq', GREATEST(v_max, 1), false);

    -- outroresponsavel
    SELECT COALESCE(MAX(idoutrosresponsaveis), 0) + 1 INTO v_max FROM outroresponsavel;
    PERFORM setval('outroresponsavel_idoutrosresponsaveis_seq', GREATEST(v_max, 1), false);

    -- processoadministrativo
    SELECT COALESCE(MAX(idprocessoadministrativo), 0) + 1 INTO v_max FROM processoadministrativo;
    PERFORM setval('processoadministrativo_idprocessoadministrativo_seq', GREATEST(v_max, 1), false);

    -- processolicenciamento
    SELECT COALESCE(MAX(idprocessolicenciamento), 0) + 1 INTO v_max FROM processolicenciamento;
    PERFORM setval('processolicenciamento_idprocessolicenciamento_seq', GREATEST(v_max, 1), false);

    -- processosolicitacao
    SELECT COALESCE(MAX(idprocessosolicitacao), 0) + 1 INTO v_max FROM processosolicitacao;
    PERFORM setval('processosolicitacao_idprocessosolicitacao_seq', GREATEST(v_max, 1), false);
END $$;
