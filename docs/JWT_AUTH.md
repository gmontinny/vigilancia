# Autenticação e autorização (JWT)

O backend utiliza JWT (stateless) no lugar de HTTP Basic. O login emite um token assinado (HS256) contendo as authorities do usuário.

## Endpoints
- `POST /auth/login` — Informe senha e um identificador (email OU cpf).
- `POST /auth/refresh` — Gera um novo token a partir de um token anterior (até mesmo expirado).
- `GET /auth/me` — Retorna dados do usuário autenticado (requer Bearer token).

## Exemplo de login (por e‑mail)
```bash
curl -s -X POST http://localhost:8081/auth/login \
  -H "Content-Type: application/json" \
  -d '{"email":"admin@local","senha":"admin"}'
```

## Protegendo endpoints por authority
No `SecurityConfig`:
```java
http.authorizeHttpRequests(auth -> auth
    .requestMatchers("/admin/**").hasAuthority("PERM_USUARIO:UPDATE")
    .anyRequest().authenticated()
);
```
Ou por anotação:
```java
@PreAuthorize("hasAuthority('PERM_TABELA:OPERACAO')")
```

## Configuração
```yaml
security:
  jwt:
    secret: ${JWT_SECRET_BASE64:...}
    issuer: ${JWT_ISSUER:vigilancia}
    expiration: ${JWT_EXP_SECONDS:3600}
```
Em produção, defina segredos fortes e rotação de chaves quando necessário.
