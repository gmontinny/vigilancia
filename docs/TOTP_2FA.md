# 2FA TOTP — Registro, verificação e desabilitação

Fluxo de segundo fator baseado em TOTP (Google Authenticator, Authy etc.).

## Endpoints
- `POST /usuarios/{id}/totp/register` — Gera segredo, `otpauth://` e QR Code (Data URI).
- `POST /usuarios/{id}/totp/verify` — Verifica código de 6 dígitos e habilita o 2FA.
- `POST /usuarios/{id}/totp/disable` — Desabilita 2FA validando com código atual.

## Exemplo (registro)
```bash
curl -s -X POST http://localhost:8081/usuarios/1/totp/register \
  -H "Authorization: Bearer <JWT>"
```
Resposta contém `qrCodeDataUri` para exibir diretamente no `<img src="..." />`.

## Verificar e habilitar
```bash
curl -i -X POST http://localhost:8081/usuarios/1/totp/verify \
  -H "Authorization: Bearer <JWT>" \
  -H "Content-Type: application/json" \
  -d '{"code":"123456"}'
```

## Desabilitar
```bash
curl -i -X POST http://localhost:8081/usuarios/1/totp/disable \
  -H "Authorization: Bearer <JWT>" \
  -H "Content-Type: application/json" \
  -d '{"code":"123456"}'
```

## Observações
- Sincronize o relógio do servidor/cliente (tolerância ~±30s).
- O segredo TOTP não é exposto pela API; apenas o status `totpEnabled` é visível.
- Evite logar códigos TOTP em produção; considere rate limiting e auditoria.
