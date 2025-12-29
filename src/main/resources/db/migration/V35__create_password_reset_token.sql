CREATE SEQUENCE IF NOT EXISTS password_reset_token_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS password_reset_token (
    id BIGINT PRIMARY KEY DEFAULT nextval('password_reset_token_id_seq'),
    idusuario INTEGER NOT NULL REFERENCES usuario(id),
    token VARCHAR(120) NOT NULL UNIQUE,
    expires_at TIMESTAMPTZ NOT NULL,
    used_at TIMESTAMPTZ NULL
);

CREATE INDEX IF NOT EXISTS idx_password_reset_token_user ON password_reset_token(idusuario);
