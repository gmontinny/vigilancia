# Mailhog — Envio de e‑mail em desenvolvimento (SMTP local)

O Mailhog captura e exibe e‑mails enviados pela aplicação em ambiente de desenvolvimento, evitando o envio real.

## Pré‑requisitos
- Docker instalado.
- Backend em modo `dev` ou com variáveis de e‑mail apontando para o Mailhog.

## Subir o Mailhog
### Via Docker Compose (recomendado)
```bash
docker compose up -d mailhog
```

### Alternativa (container avulso)
```bash
docker run -d --name mailhog -p 1025:1025 -p 8025:8025 mailhog/mailhog:latest
```

## Acessos
- UI Web: http://localhost:8025
- SMTP: localhost:1025

## Configuração do backend (defaults para dev)
As variáveis abaixo já possuem valores padrão em `application.yml`/`.env`:
```dotenv
MAIL_HOST=localhost
MAIL_PORT=1025
MAIL_FROM=no-reply@local
MAIL_USERNAME=
MAIL_PASSWORD=
MAIL_SMTP_AUTH=false
MAIL_SMTP_STARTTLS=false
```

## Executar o backend
Windows PowerShell:
```powershell
$env:SPRING_PROFILES_ACTIVE = "dev"; ./gradlew clean bootRun
```

## Testar o fluxo (exemplo com cURL)
1. Solicite o link de redefinição de senha:
```bash
curl -i -X POST http://localhost:8081/auth/password/forgot \
  -H "Content-Type: application/json" \
  -d '{"email":"admin@local"}'
```
2. Abra o Mailhog, copie o parâmetro `token` da URL recebida e finalize:
```bash
curl -i -X POST http://localhost:8081/auth/password/reset \
  -H "Content-Type: application/json" \
  -d '{"token":"<TOKEN>","novaSenha":"novaSenha123"}'
```

## Verificação automática (PowerShell) — opcional
```powershell
$ErrorActionPreference = 'Stop'
$health = Invoke-RestMethod -Uri "http://localhost:8081/actuator/health" -TimeoutSec 5
if ($health.status -ne 'UP') { throw "Backend não está UP" }
Invoke-RestMethod -Method Post -Uri http://localhost:8081/auth/password/forgot -ContentType 'application/json' -Body '{"email":"admin@local"}' | Out-Null
Start-Sleep -Seconds 1
$json = Invoke-RestMethod -Uri "http://localhost:8025/api/v2/messages?limit=1" -TimeoutSec 5
$body = $json.items[0].Content.Body
$joined = $body -replace "=`r`n", ""
$decoded = [Regex]::Replace($joined, "=([0-9A-F]{2})", { param($m) [char]([Convert]::ToInt32($m.Groups[1].Value,16)) })
$match = [Regex]::Match($decoded, "token=([A-Za-z0-9_\-]+)")
if (-not $match.Success) { throw "Token não encontrado no e-mail do Mailhog" }
$token = $match.Groups[1].Value
$payload = @{ token = $token; novaSenha = "novaSenha123" } | ConvertTo-Json -Compress
$resp = Invoke-WebRequest -UseBasicParsing -Method Post -Uri http://localhost:8081/auth/password/reset -ContentType 'application/json' -Body $payload
"RESET: $($resp.StatusCode) $($resp.StatusDescription)"
```

## Troubleshooting
- Após adicionar dependências, faça restart limpo: `./gradlew clean bootRun` (DevTools não carrega novos JARs automaticamente).
- Conflito de nome do container `mailhog`: `docker rm -f mailhog` antes de subir novamente, ou use o serviço via Compose.
- Verifique se as portas `1025` e `8025` estão livres.
