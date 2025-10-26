-- V14: Ajusta incremento das sequências para alinhar com allocationSize padrão do Hibernate (50)
-- Contexto: Entidades que usam @SequenceGenerator sem especificar allocationSize usam o padrão 50.
-- As sequências criadas na V13 estavam com INCREMENT BY 1, causando erro de validação do Hibernate.

CREATE SCHEMA IF NOT EXISTS app;

-- Use ALTER SEQUENCE IF EXISTS para evitar erros quando uma sequência não existir no ambiente.

-- ADMINISTRATIVO
ALTER SEQUENCE IF EXISTS app.administrativo_idadministrativo_seq INCREMENT BY 50;

-- AGRUPAMENTO
ALTER SEQUENCE IF EXISTS app.agrupamento_idagrupamento_seq INCREMENT BY 50;

-- ANALISEPROCESSO
ALTER SEQUENCE IF EXISTS app.analiseprocesso_idanaliseprocesso_seq INCREMENT BY 50;

-- AREAINSPECAO
ALTER SEQUENCE IF EXISTS app.areainspecao_idareainspecao_seq INCREMENT BY 50;

-- ARQUITETONICOS
ALTER SEQUENCE IF EXISTS app.arquitetonicos_idarquitetonicos_seq INCREMENT BY 50;

-- LICENCIAMENTO
ALTER SEQUENCE IF EXISTS app.licenciamento_idlicenciamento_seq INCREMENT BY 50;

-- Observação importante:
-- Sequências de entidades do legado criadas na V11 com allocationSize = 1 (e.g., forum_idforum_seq, usuario_idusuario_seq, etc.)
-- NÃO são alteradas aqui para preservar o comportamento esperado pelos respectivos @SequenceGenerator(allocationSize = 1).
