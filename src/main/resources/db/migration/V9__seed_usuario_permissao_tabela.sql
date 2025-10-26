-- V9__seed_usuario_permissao_tabela.sql
-- Insere dados para testes de Autenticação e Autorização (JWT)
-- - Tabelas: tabela, usuario, permissao
-- - Usuário admin com permissões completas em algumas tabelas

-- Seed de TABELAS (USUARIO, ORDEMSERVICO, PROCESSO, TABELA, PERMISSAO)
DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM tabela WHERE upper(nome) = 'USUARIO') THEN
        INSERT INTO tabela (id, nome, descricao, ordem) VALUES (nextval('tabela_idtabelas_seq'), 'USUARIO', 'Tabela de usuários', 1);
    END IF;
    IF NOT EXISTS (SELECT 1 FROM tabela WHERE upper(nome) = 'ORDEMSERVICO') THEN
        INSERT INTO tabela (id, nome, descricao, ordem) VALUES (nextval('tabela_idtabelas_seq'), 'ORDEMSERVICO', 'Tabela de ordens de serviço', 2);
    END IF;
    IF NOT EXISTS (SELECT 1 FROM tabela WHERE upper(nome) = 'PROCESSO') THEN
        INSERT INTO tabela (id, nome, descricao, ordem) VALUES (nextval('tabela_idtabelas_seq'), 'PROCESSO', 'Tabela de processos', 3);
    END IF;
    IF NOT EXISTS (SELECT 1 FROM tabela WHERE upper(nome) = 'TABELA') THEN
        INSERT INTO tabela (id, nome, descricao, ordem) VALUES (nextval('tabela_idtabelas_seq'), 'TABELA', 'Catálogo de tabelas', 4);
    END IF;
    IF NOT EXISTS (SELECT 1 FROM tabela WHERE upper(nome) = 'PERMISSAO') THEN
        INSERT INTO tabela (id, nome, descricao, ordem) VALUES (nextval('tabela_idtabelas_seq'), 'PERMISSAO', 'Tabela de permissões', 5);
    END IF;
END$$;

-- Seed de USUÁRIO (admin)
-- Senha: "admin" (exemplo) — bcrypt abaixo
-- $2a$10$7KNoH3tC4c6Yz2Wm2p1qUOCk1a7yGq0jH4c8XYY1xq1xv9rFzDwBC
DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM usuario WHERE lower(email) = lower('admin@local')) THEN
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

-- Concede permissões completas para o admin nas tabelas sem duplicar
DO $$
DECLARE
    v_user_id INTEGER;
BEGIN
    SELECT id INTO v_user_id FROM usuario WHERE lower(email) = lower('admin@local');

    IF v_user_id IS NOT NULL THEN
        -- Helper local: função inline para inserir permissão total se ainda não existir
        -- USUARIO
        IF NOT EXISTS (SELECT 1 FROM permissao p
                       JOIN tabela t ON t.id = p.idtabelas
                       WHERE p.idusuario = v_user_id AND upper(t.nome) = 'USUARIO') THEN
            INSERT INTO permissao (id, delete_permissao, insert_permissao, select_permissao, update_permissao, idtabelas, idusuario)
            VALUES (nextval('permissao_idpermissao_seq'), 1, 1, 1, 1, (SELECT id FROM tabela WHERE upper(nome) = 'USUARIO'), v_user_id);
        END IF;
        -- ORDEMSERVICO
        IF NOT EXISTS (SELECT 1 FROM permissao p
                       JOIN tabela t ON t.id = p.idtabelas
                       WHERE p.idusuario = v_user_id AND upper(t.nome) = 'ORDEMSERVICO') THEN
            INSERT INTO permissao (id, delete_permissao, insert_permissao, select_permissao, update_permissao, idtabelas, idusuario)
            VALUES (nextval('permissao_idpermissao_seq'), 1, 1, 1, 1, (SELECT id FROM tabela WHERE upper(nome) = 'ORDEMSERVICO'), v_user_id);
        END IF;
        -- PROCESSO
        IF NOT EXISTS (SELECT 1 FROM permissao p
                       JOIN tabela t ON t.id = p.idtabelas
                       WHERE p.idusuario = v_user_id AND upper(t.nome) = 'PROCESSO') THEN
            INSERT INTO permissao (id, delete_permissao, insert_permissao, select_permissao, update_permissao, idtabelas, idusuario)
            VALUES (nextval('permissao_idpermissao_seq'), 1, 1, 1, 1, (SELECT id FROM tabela WHERE upper(nome) = 'PROCESSO'), v_user_id);
        END IF;
        -- TABELA
        IF NOT EXISTS (SELECT 1 FROM permissao p
                       JOIN tabela t ON t.id = p.idtabelas
                       WHERE p.idusuario = v_user_id AND upper(t.nome) = 'TABELA') THEN
            INSERT INTO permissao (id, delete_permissao, insert_permissao, select_permissao, update_permissao, idtabelas, idusuario)
            VALUES (nextval('permissao_idpermissao_seq'), 1, 1, 1, 1, (SELECT id FROM tabela WHERE upper(nome) = 'TABELA'), v_user_id);
        END IF;
        -- PERMISSAO
        IF NOT EXISTS (SELECT 1 FROM permissao p
                       JOIN tabela t ON t.id = p.idtabelas
                       WHERE p.idusuario = v_user_id AND upper(t.nome) = 'PERMISSAO') THEN
            INSERT INTO permissao (id, delete_permissao, insert_permissao, select_permissao, update_permissao, idtabelas, idusuario)
            VALUES (nextval('permissao_idpermissao_seq'), 1, 1, 1, 1, (SELECT id FROM tabela WHERE upper(nome) = 'PERMISSAO'), v_user_id);
        END IF;
    END IF;
END$$;