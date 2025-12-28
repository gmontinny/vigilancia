-- Adiciona colunas para suporte a 2FA (TOTP) na tabela de usuários
-- Executado no schema configurado (por padrão, 'app')

ALTER TABLE IF EXISTS usuario
    ADD COLUMN IF NOT EXISTS totp_secret TEXT,
    ADD COLUMN IF NOT EXISTS totp_enabled BOOLEAN NOT NULL DEFAULT FALSE;