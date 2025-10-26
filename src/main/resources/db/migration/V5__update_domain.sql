-- V5__update_domain.sql
-- Atualiza o schema a partir do domínio atual: cria entidades recentes e relacionamentos
-- Target: PostgreSQL 15

-- =====================
-- Sequences (novas entidades)
-- =====================
CREATE SEQUENCE IF NOT EXISTS forum_idforum_seq INCREMENT BY 1 MINVALUE 1 START WITH 1;
CREATE SEQUENCE IF NOT EXISTS produtos_idprodutos_seq INCREMENT BY 1 MINVALUE 1 START WITH 1;
CREATE SEQUENCE IF NOT EXISTS saude_idsaude_seq INCREMENT BY 1 MINVALUE 1 START WITH 1;
CREATE SEQUENCE IF NOT EXISTS servicos_idservicos_seq INCREMENT BY 1 MINVALUE 1 START WITH 1;
CREATE SEQUENCE IF NOT EXISTS prodi_idprodi_seq INCREMENT BY 1 MINVALUE 1 START WITH 1;
CREATE SEQUENCE IF NOT EXISTS galeria_idgaleria_seq INCREMENT BY 1 MINVALUE 1 START WITH 1;
CREATE SEQUENCE IF NOT EXISTS roteiro_idroteiro_seq INCREMENT BY 1 MINVALUE 1 START WITH 1;
CREATE SEQUENCE IF NOT EXISTS motivo_idmotivo_seq INCREMENT BY 1 MINVALUE 1 START WITH 1;
CREATE SEQUENCE IF NOT EXISTS baixa_idbaixa_seq INCREMENT BY 1 MINVALUE 1 START WITH 1;
CREATE SEQUENCE IF NOT EXISTS sintomas_idsintomas_seq INCREMENT BY 1 MINVALUE 1 START WITH 1;

-- =====================
-- Tabelas (novas entidades)
-- =====================
CREATE TABLE IF NOT EXISTS forum (
    id             INTEGER PRIMARY KEY DEFAULT nextval('forum_idforum_seq'),
    data_hora      TIMESTAMP,
    idordemservico INTEGER NOT NULL,
    texto_forum    VARCHAR(1024),
    texto_usuario  VARCHAR(1024),
    status_forum   INTEGER,
    idusuario      INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS produtos (
    id                          INTEGER PRIMARY KEY DEFAULT nextval('produtos_idprodutos_seq'),
    aditivo_alimento            INTEGER,
    agrotoxico                  INTEGER,
    agua_mineral                INTEGER,
    agua_potavel                INTEGER,
    alimentos_autorizados       INTEGER,
    alimentos_prontos           INTEGER,
    armazenar                   INTEGER,
    comercializar               INTEGER,
    cosmeticos                  INTEGER,
    dispensador_registro        INTEGER,
    dispensar                   INTEGER,
    distribuir                  INTEGER,
    embalagem_alimento          INTEGER,
    embalar                     INTEGER,
    exportar                    INTEGER,
    fracionar                   INTEGER,
    grupo1                      INTEGER,
    grupo2                      INTEGER,
    grupo3                      INTEGER,
    grupo5                      INTEGER,
    higiene                     INTEGER,
    importar                    INTEGER,
    manipular                   INTEGER,
    medicamento_nao_especial    INTEGER,
    medicamentos_especial       INTEGER,
    oleo_vegetal                INTEGER,
    outros                      INTEGER,
    outro_mesmo_produto         VARCHAR(255),
    perfumaria                  INTEGER,
    produzir                    INTEGER,
    quimicos                    INTEGER,
    reembalar                   INTEGER,
    retinoicos                  INTEGER,
    saneantes                   INTEGER,
    saude                       INTEGER,
    suplementos                 INTEGER,
    transportar                 INTEGER,
    tratar                      INTEGER,
    veterinario                 INTEGER,
    deferido_fiscal             INTEGER,
    outros_casos                INTEGER,
    numprocesso                 VARCHAR(64)
);

CREATE TABLE IF NOT EXISTS servicos (
    id                 INTEGER PRIMARY KEY DEFAULT nextval('servicos_idservicos_seq'),
    albergue           INTEGER,
    atividades_somato  INTEGER,
    atividade_veterinaria INTEGER,
    dependencia_quimica INTEGER,
    esterilizacao      INTEGER,
    estetica           INTEGER,
    "grupoAservicos"  INTEGER,
    "grupoBservicos"  INTEGER,
    "grupoCservicos"  INTEGER,
    "grupoDservicos"  INTEGER,
    "grupoEservicos"  INTEGER,
    idoso              INTEGER,
    industrial         INTEGER,
    laboratorio        INTEGER,
    lavanderia_domestica INTEGER,
    lavanderia         INTEGER,
    limpa_fossa        INTEGER,
    limpeza_ar_condicionado INTEGER,
    limpeza_caixa_dagua INTEGER,
    limpeza            INTEGER,
    medicina_trabalho  INTEGER,
    pipa               INTEGER,
    pragas             INTEGER,
    saa                INTEGER,
    salao_beleza       INTEGER,
    tatuagem           INTEGER,
    numprocesso        VARCHAR(64)
);

CREATE TABLE IF NOT EXISTS saude (
    id                      INTEGER PRIMARY KEY DEFAULT nextval('saude_idsaude_seq'),
    acuputura               INTEGER,
    aids                    INTEGER,
    at                      INTEGER,
    banco_leite             INTEGER,
    banco_orgaos            INTEGER,
    banco                   INTEGER,
    buco                    INTEGER,
    cardioco                INTEGER,
    cardiologia             INTEGER,
    cirurgia_geral          INTEGER,
    citologia               INTEGER,
    clinica                 INTEGER,
    clinico_geral           INTEGER,
    coleta                  INTEGER,
    cronicos                INTEGER,
    dermatologista          INTEGER,
    dialise                 INTEGER,
    endocrinologia          INTEGER,
    endoscopia              INTEGER,
    enteral                 INTEGER,
    fisioterapia            INTEGER,
    fonoaudiologia          INTEGER,
    gastroenterologia       INTEGER,
    geriatria               INTEGER,
    ginecologia             INTEGER,
    hansenologia            INTEGER,
    hematologia             INTEGER,
    hemodialise             INTEGER,
    hemodinamica            INTEGER,
    hiperbarica             INTEGER,
    homecare                INTEGER,
    lactario                INTEGER,
    leito_dia               INTEGER,
    leito                   INTEGER,
    litotripsia             INTEGER,
    medico_radio            INTEGER,
    medico                  INTEGER,
    misoprostol             INTEGER,
    nefrologia              INTEGER,
    neonatologia            INTEGER,
    neurocirurgia           INTEGER,
    neurologia              INTEGER,
    nutricao                INTEGER,
    obstetrica              INTEGER,
    obstetricia_saude       INTEGER,
    odontologico_cirurgico  INTEGER,
    odontologico_radio      INTEGER,
    odontologico            INTEGER,
    oftalmologia            INTEGER,
    oncologia               INTEGER,
    oncologista             INTEGER,
    otorrinolaringologia    INTEGER,
    parenteral              INTEGER,
    patologia               INTEGER,
    pediatria               INTEGER,
    plastica                INTEGER,
    pneumologia             INTEGER,
    procedimento            INTEGER,
    psicologia              INTEGER,
    psiquiatria             INTEGER,
    reabilitacao            INTEGER,
    ressonancia             INTEGER,
    substitutiva            INTEGER,
    tisiologia              INTEGER,
    toraxica                INTEGER,
    transporte_a            INTEGER,
    transporte_b            INTEGER,
    transporte_c            INTEGER,
    transporte_d            INTEGER,
    traumatologia           INTEGER,
    uan                     INTEGER,
    uct                     INTEGER,
    ultrassonografia        INTEGER,
    unidade_isolamento      INTEGER,
    unidade_neo             INTEGER,
    unidade                 INTEGER,
    urologia                INTEGER,
    uti_adulto              INTEGER,
    uti_infantil            INTEGER,
    uti_neonatal            INTEGER,
    veterinario_radio       INTEGER,
    numprocesso             VARCHAR(64)
);

CREATE TABLE IF NOT EXISTS prodi (
    id               INTEGER PRIMARY KEY DEFAULT nextval('prodi_idprodi_seq'),
    cnpj_empresa     VARCHAR(32)  NOT NULL,
    cnpj_fabricante  VARCHAR(32)  NOT NULL,
    numero_processo  VARCHAR(64),
    numero_prodi     INTEGER
);

CREATE TABLE IF NOT EXISTS galeria (
    id            INTEGER PRIMARY KEY DEFAULT nextval('galeria_idgaleria_seq'),
    capa          VARCHAR(255) NOT NULL,
    data_galeria  DATE,
    hora_galeria  TIME,
    sequencia     INTEGER,
    titulo        VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS roteiro (
    id         INTEGER PRIMARY KEY DEFAULT nextval('roteiro_idroteiro_seq'),
    descricao  VARCHAR(255) NOT NULL,
    situacao   INTEGER
);

CREATE TABLE IF NOT EXISTS motivo (
    id         INTEGER PRIMARY KEY DEFAULT nextval('motivo_idmotivo_seq'),
    descricao  VARCHAR(255) NOT NULL,
    CONSTRAINT chk_motivo_descricao_min_len CHECK (char_length(descricao) >= 5)
);

CREATE TABLE IF NOT EXISTS baixa (
    id                 INTEGER PRIMARY KEY DEFAULT nextval('baixa_idbaixa_seq'),
    data_baixa         DATE,
    idestabelecimento  INTEGER,
    idresponsavel      INTEGER NOT NULL,
    numero_processo    VARCHAR(64)
);

CREATE TABLE IF NOT EXISTS sintomas (
    id          INTEGER PRIMARY KEY DEFAULT nextval('sintomas_idsintomas_seq'),
    descricao   VARCHAR(255) NOT NULL,
    CONSTRAINT chk_sintomas_descricao_min_len CHECK (char_length(descricao) >= 5)
);

-- =====================
-- Foreign Keys
-- =====================
ALTER TABLE forum
    ADD CONSTRAINT fk_forum_ordemservico
        FOREIGN KEY (idordemservico) REFERENCES ordemservico (id),
    ADD CONSTRAINT fk_forum_usuario
        FOREIGN KEY (idusuario) REFERENCES usuario (id);

ALTER TABLE produtos
    ADD CONSTRAINT fk_produtos_processo
        FOREIGN KEY (numprocesso) REFERENCES processo (numero_processo);

ALTER TABLE servicos
    ADD CONSTRAINT fk_servicos_processo
        FOREIGN KEY (numprocesso) REFERENCES processo (numero_processo);

ALTER TABLE saude
    ADD CONSTRAINT fk_saude_processo
        FOREIGN KEY (numprocesso) REFERENCES processo (numero_processo);

ALTER TABLE baixa
    ADD CONSTRAINT fk_baixa_estabelecimento
        FOREIGN KEY (idestabelecimento) REFERENCES estabelecimento (id),
    ADD CONSTRAINT fk_baixa_responsavel
        FOREIGN KEY (idresponsavel) REFERENCES responsavel_tecnico (id);

-- =====================
-- Indexes em colunas de FK
-- =====================
CREATE INDEX IF NOT EXISTS idx_forum_idordemservico ON forum (idordemservico);
CREATE INDEX IF NOT EXISTS idx_forum_idusuario ON forum (idusuario);
CREATE INDEX IF NOT EXISTS idx_produtos_numprocesso ON produtos (numprocesso);
CREATE INDEX IF NOT EXISTS idx_servicos_numprocesso ON servicos (numprocesso);
CREATE INDEX IF NOT EXISTS idx_saude_numprocesso ON saude (numprocesso);
CREATE INDEX IF NOT EXISTS idx_baixa_idestabelecimento ON baixa (idestabelecimento);
CREATE INDEX IF NOT EXISTS idx_baixa_idresponsavel ON baixa (idresponsavel);
