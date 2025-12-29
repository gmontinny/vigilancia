# Ambiente de Desenvolvimento — Docker Compose e Perfis

Guia rápido para subir dependências e rodar a aplicação localmente.

## Serviços via Docker Compose
Arquivo: `docker-compose.yml`

Serviços disponíveis:
- `db` (PostgreSQL 15) — expõe `5432:5432` e usa variáveis de `.env`.
- `pgadmin` — interface web para o PostgreSQL (`http://localhost:8080`).
- `mailhog` — SMTP/UI para e‑mails de dev (`1025` e `http://localhost:8025`).

Subir tudo:
```bash
docker compose up -d
```
Subir apenas o Mailhog:
```bash
docker compose up -d mailhog
```

## Variáveis de ambiente (.env)
Exemplos importantes:
```dotenv
POSTGRES_USER=gmontinny
POSTGRES_PASSWORD=Gmontinny2025
POSTGRES_DB=vigilancia
SERVER_PORT=8081
JWT_SECRET_BASE64=...
SECURITY_CORS_ALLOWED_ORIGINS=http://localhost:4200
MAIL_HOST=localhost
MAIL_PORT=1025
MAIL_FROM=no-reply@local
APP_FRONTEND_RESET_URL=http://localhost:4200/new-password
```

## Executar o backend (perfil dev)
Windows PowerShell:
```powershell
$env:SPRING_PROFILES_ACTIVE = "dev"; ./gradlew clean bootRun
```

## Healthcheck
```bash
curl -s http://localhost:8081/actuator/health
```

## Dicas
- Faça `./gradlew clean` após adicionar novas dependências (DevTools não carrega JARs novos).
- Verifique conflitos de porta (5432, 8080, 1025, 8025, 8081).
- Flyway aplica migrações automaticamente ao iniciar (`spring.flyway.enabled=true`).
