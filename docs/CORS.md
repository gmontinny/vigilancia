# CORS — Suporte ao Frontend (Angular 18 e domínios distintos)

A API expõe configuração CORS para permitir que um frontend rode em origem distinta (ex.: `http://localhost:4200`).

## Como funciona
- Habilitado via `http.cors()` e `CorsConfigurationSource` em `SecurityConfig`.
- Pré‑flight `OPTIONS` liberado globalmente.

## Parâmetros (application.yml)
```yaml
security:
  cors:
    allowed-origins: ${SECURITY_CORS_ALLOWED_ORIGINS:http://localhost:4200}
    allowed-methods: ${SECURITY_CORS_ALLOWED_METHODS:GET,POST,PUT,PATCH,DELETE,OPTIONS}
    allowed-headers: ${SECURITY_CORS_ALLOWED_HEADERS:Authorization,Content-Type,Accept}
    allow-credentials: ${SECURITY_CORS_ALLOW_CREDENTIALS:true}
```

## Exemplos de configuração
- Desenvolvimento (Angular local):
  - PowerShell:
    ```powershell
    $env:SECURITY_CORS_ALLOWED_ORIGINS = "http://localhost:4200"
    ```
  - Bash:
    ```bash
    export SECURITY_CORS_ALLOWED_ORIGINS="http://localhost:4200"
    ```
- Produção (múltiplas origens):
  ```bash
  export SECURITY_CORS_ALLOWED_ORIGINS="https://app.seudominio.gov.br,https://admin.seudominio.gov.br"
  ```

## Quando usar Proxy vs CORS no Angular
- Proxy (mesma origem) em dev: configure `proxy.conf.json` e consuma via `/api`.
- CORS (origens distintas) em produção: aponte o `apiBaseUrl` para o backend e libere a(s) origem(ns) no backend.
