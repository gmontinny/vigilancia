-- V15: Cria sequências faltantes esperadas pelo Hibernate para entidades com GenerationType.AUTO sem @SequenceGenerator
-- Contexto: Erro no startup "Schema-validation: missing sequence [analiseprocesso_seq]"
-- Alvo: PostgreSQL (schema padrão: app)

CREATE SCHEMA IF NOT EXISTS app;

-- Analiseprocesso usa @GeneratedValue(AUTO) sem @SequenceGenerator
-- O Hibernate espera a sequência app.analiseprocesso_seq
CREATE SEQUENCE IF NOT EXISTS app.analiseprocesso_seq INCREMENT BY 50;

-- Areainspecao também usa @GeneratedValue(AUTO) sem @SequenceGenerator
-- O Hibernate espera a sequência app.areainspecao_seq
CREATE SEQUENCE IF NOT EXISTS app.areainspecao_seq INCREMENT BY 50;

-- Observação: Demais entidades (Administrativo, Agrupamento, Arquitetonico, Licenciamento)
-- já usam @SequenceGenerator com sequências específicas e foram ajustadas na V14 para INCREMENT BY 50.
