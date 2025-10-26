-- V12: Alinha nomes de colunas com a estratégia física (snake_case)
-- Corrige colunas criadas em V11 com nomes camelCase (que viraram minúsculas) para snake_case

-- cupomauto
ALTER TABLE IF EXISTS app.cupomauto RENAME COLUMN descconformidade TO desc_conformidade;
ALTER TABLE IF EXISTS app.cupomauto RENAME COLUMN descporte TO desc_porte;
ALTER TABLE IF EXISTS app.cupomauto RENAME COLUMN numeroauto TO numero_auto;
ALTER TABLE IF EXISTS app.cupomauto RENAME COLUMN valorconformidade TO valor_conformidade;
ALTER TABLE IF EXISTS app.cupomauto RENAME COLUMN valorgerado TO valor_gerado;
ALTER TABLE IF EXISTS app.cupomauto RENAME COLUMN valorporte TO valor_porte;
ALTER TABLE IF EXISTS app.cupomauto RENAME COLUMN numeroconformidade TO numero_conformidade;
ALTER TABLE IF EXISTS app.cupomauto RENAME COLUMN percconformidade TO perc_conformidade;
ALTER TABLE IF EXISTS app.cupomauto RENAME COLUMN percporte TO perc_porte;

-- geraauto
ALTER TABLE IF EXISTS app.geraauto RENAME COLUMN datageraauto TO data_geraauto;
ALTER TABLE IF EXISTS app.geraauto RENAME COLUMN horageraauto TO hora_geraauto;
ALTER TABLE IF EXISTS app.geraauto RENAME COLUMN idusuario TO id_usuario;
-- status permanece o mesmo
ALTER TABLE IF EXISTS app.geraauto RENAME COLUMN numeroprocesso TO numero_processo;
ALTER TABLE IF EXISTS app.geraauto RENAME COLUMN tipopenalidade TO tipo_penalidade;
-- valor permanece o mesmo
ALTER TABLE IF EXISTS app.geraauto RENAME COLUMN grauinfracao TO grau_infracao;
ALTER TABLE IF EXISTS app.geraauto RENAME COLUMN idtramitacao TO id_tramitacao;

-- resposta
ALTER TABLE IF EXISTS app.resposta RENAME COLUMN dataresposta TO data_resposta;
-- idforum já está correto (JoinColumn explícito)
ALTER TABLE IF EXISTS app.resposta RENAME COLUMN textoresposta TO texto_resposta;
