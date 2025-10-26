-- Flyway baseline migration
-- Creates schema and extensions required by the application

CREATE SCHEMA IF NOT EXISTS app;

-- Optional useful extensions
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE EXTENSION IF NOT EXISTS pgcrypto;

-- Ensure default privileges and search_path for the app user when present
DO $$
BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM pg_roles WHERE rolname = current_user
    ) THEN
        -- no-op
        NULL;
    END IF;
END$$;

-- Example table (placeholder) — remove or replace when modeling legacy domain
CREATE TABLE IF NOT EXISTS app.app_info (
    id            UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name          TEXT NOT NULL,
    created_at    TIMESTAMPTZ NOT NULL DEFAULT now()
);

INSERT INTO app.app_info (name)
VALUES ('vigilancia')
ON CONFLICT DO NOTHING;