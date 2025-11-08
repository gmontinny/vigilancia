-- V27: Ajuste do incremento da sequência de ProdutoCategoria para alinhar com allocationSize=50
-- Objetivo: corrigir a inconsistência detectada pelo Hibernate
-- Erro: sequence [app.produtocategoria_idprodutocategoria_seq] defined inconsistent increment-size; found [1] but expecting [50]

-- Garante o schema
CREATE SCHEMA IF NOT EXISTS app;

-- Ajusta o incremento da sequência para 50, conforme padrão das migrações V23–V25
ALTER SEQUENCE IF EXISTS app.produtocategoria_idprodutocategoria_seq INCREMENT BY 50;
