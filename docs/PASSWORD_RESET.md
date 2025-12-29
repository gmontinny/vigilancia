# Recuperação de Senha — Fluxo completo

Endpoints públicos implementados:
- `POST /auth/password/forgot` — Body: `{ "email": "usuario@dominio" }`. Sempre responde `200 OK`. Se o e‑mail existir, envia link com `token` para o frontend.
- `POST /auth/password/reset` — Body: `{ "token": "<token>", "novaSenha": "<senha>" }`. Responde `200 OK` ao sucesso; `400 Bad Request` se token inválido/expirado.

## Configuração necessária
Defina a URL da tela do Angular para nova senha (a API adiciona `?token=...` automaticamente):
```dotenv
APP_FRONTEND_RESET_URL=http://localhost:4200/new-password
```
SMTP para dev (Mailhog):
```dotenv
MAIL_HOST=localhost
MAIL_PORT=1025
MAIL_FROM=no-reply@local
MAIL_SMTP_AUTH=false
MAIL_SMTP_STARTTLS=false
```

## Exemplos de uso
Solicitar o link:
```bash
curl -X POST http://localhost:8081/auth/password/forgot \
  -H "Content-Type: application/json" \
  -d '{"email":"admin@local"}' -i
```
Redefinir a senha (use o `token` recebido por e‑mail):
```bash
curl -X POST http://localhost:8081/auth/password/reset \
  -H "Content-Type: application/json" \
  -d '{"token":"<TOKEN>","novaSenha":"novaSenha123"}' -i
```

## Boas práticas adotadas
- Token randômico seguro (Base64 URL‑safe) com expiração (2h).
- Evita "user enumeration": `/forgot` sempre responde 200.
- Invalida tokens antigos ao gerar novo; marca como usado ao resetar.
- Senhas armazenadas com `BCryptPasswordEncoder`.
