-- V29: Criação das tabelas de notificações (primeira instância, recurso, recurso administrativo, segunda instância e relação usuário)
-- Observação: Nomes de tabelas, colunas e sequences seguem exatamente a nomenclatura das entidades.
-- Banco: PostgreSQL

-- ===============
-- Sequences
-- ===============
CREATE SEQUENCE IF NOT EXISTS notificacaoprimeirainstancia_idprimeirainstancia_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS notificacaorecurso_idnotificacaorecurso_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS notificacaorecursoadministrativo_idrecursoadministrativo_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS notificacaosegundainstancia_idsegundainstancia_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS notificacaousuario_idnotificacaousuario_seq INCREMENT BY 50;

-- ===============
-- Tabela: notificacaoprimeirainstancia
-- ===============
CREATE TABLE IF NOT EXISTS notificacaoprimeirainstancia (
    idprimeirainstancia INTEGER PRIMARY KEY DEFAULT nextval('notificacaoprimeirainstancia_idprimeirainstancia_seq'),
    assinatura          VARCHAR(255) NOT NULL,
    coordenador         VARCHAR(255) NOT NULL,
    texto               VARCHAR(255) NOT NULL
);

-- ===============
-- Tabela: notificacaorecurso
-- ===============
CREATE TABLE IF NOT EXISTS notificacaorecurso (
    idnotificacaorecurso      INTEGER PRIMARY KEY DEFAULT nextval('notificacaorecurso_idnotificacaorecurso_seq'),
    assinaturacoordenador     VARCHAR(255),
    coordenadorarecursonotificacao VARCHAR(255) NOT NULL,
    textonotificacaorecurso   VARCHAR(255) NOT NULL
);

-- ===============
-- Tabela: notificacaorecursoadministrativo
-- ===============
CREATE TABLE IF NOT EXISTS notificacaorecursoadministrativo (
    idrecursoadministrativo     INTEGER PRIMARY KEY DEFAULT nextval('notificacaorecursoadministrativo_idrecursoadministrativo_seq'),
    datarecursoadministrativo   DATE,
    horarecursoadministrativo   TIME,
    textorecursoadministrativo  VARCHAR(255),
    coordenador                 VARCHAR(255),
    assinatura                  VARCHAR(255)
);

-- ===============
-- Tabela: notificacaosegundainstancia
-- ===============
CREATE TABLE IF NOT EXISTS notificacaosegundainstancia (
    idsegundainstancia INTEGER PRIMARY KEY DEFAULT nextval('notificacaosegundainstancia_idsegundainstancia_seq'),
    assinatura         VARCHAR(255) NOT NULL,
    coordenador        VARCHAR(255) NOT NULL,
    texto              VARCHAR(255) NOT NULL,
    tipo               VARCHAR(255)
);

-- ===============
-- Tabela: notificacaousuario
-- ===============
CREATE TABLE IF NOT EXISTS notificacaousuario (
    idnotificacaousuario INTEGER PRIMARY KEY DEFAULT nextval('notificacaousuario_idnotificacaousuario_seq'),
    idusuario            INTEGER,
    numerodocumento      INTEGER
);

-- ===============
-- Índices auxiliares (se úteis em consultas)
-- ===============
CREATE INDEX IF NOT EXISTS idx_notificacaorecurso_coordenadora ON notificacaorecurso (coordenadorarecursonotificacao);
CREATE INDEX IF NOT EXISTS idx_notificacaoprimeira_coordenador ON notificacaoprimeirainstancia (coordenador);
CREATE INDEX IF NOT EXISTS idx_notificacaosegunda_coordenador ON notificacaosegundainstancia (coordenador);
CREATE INDEX IF NOT EXISTS idx_notificacaousuario_idusuario ON notificacaousuario (idusuario);
