-- V10__reseed_admin_password.sql
-- Garante a senha BCrypt válida para o usuário admin@local e mantém ativo (status=1)
-- Idempotente: atualiza se existir, insere caso não exista

DO $$
BEGIN
    IF EXISTS (SELECT 1 FROM usuario WHERE lower(email) = lower('admin@local')) THEN
        UPDATE usuario
        SET senha = '$2a$10$7KNoH3tC4c6Yz2Wm2p1qUOCk1a7yGq0jH4c8XYY1xq1xv9rFzDwBC',
            status = COALESCE(status, 1)
        WHERE lower(email) = lower('admin@local');
    ELSE
        INSERT INTO usuario (
            id, nome, cpf, email, senha, celular, imagem, sexo, advogado, status, tipo,
            auditor, administrativo, status_envio, coordenador, recurso_humano
        ) VALUES (
            nextval('usuario_idusuario_seq'),
            'Administrador',
            '00000000000',
            'admin@local',
            '$2a$10$7KNoH3tC4c6Yz2Wm2p1qUOCk1a7yGq0jH4c8XYY1xq1xv9rFzDwBC',
            NULL, NULL, NULL, NULL,
            1, -- status habilitado
            1, -- tipo admin
            NULL, NULL, NULL, NULL, NULL
        );
    END IF;
END$$;