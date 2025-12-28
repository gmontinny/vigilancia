## Sumário de Endpoints

- Documentação interativa (Swagger UI): http://localhost:8081/swagger-ui/index.html
- Contrato OpenAPI (JSON): http://localhost:8081/v3/api-docs
- Lista completa de endpoints (CRUD e leitura): ver docs/README_ENDPOINTS.md

Principais grupos:
- Autenticação: `/auth/login`, `/auth/refresh`, `/auth/me`
- Usuários: `/usuarios` (CRUD)
- 2FA TOTP: `/usuarios/{id}/totp/register`, `/usuarios/{id}/totp/verify`, `/usuarios/{id}/totp/disable`
- Demais domínios de negócio: ver docs/README_ENDPOINTS.md ou Swagger UI

## Build, testes e qualidade
- Compilar e rodar testes:
  ```bash
  ./gradlew clean test
  ```
- Ver relatórios de testes: `build/reports/tests/test/index.html`.

## Documentação da API (OpenAPI/Swagger)

A API possui documentação completa via OpenAPI 3.0 com Swagger UI:

- **Swagger UI**: `http://localhost:8081/swagger-ui.html`
- **OpenAPI JSON**: `http://localhost:8081/v3/api-docs`

### Características da Documentação:
- **130 controllers** totalmente documentados
- **Autenticação JWT** configurada (`bearerAuth`)
- **Tags organizadas** por domínio de negócio
- **Validação de entrada** com `@Valid`
- **Códigos de resposta HTTP** apropriados
- **Parâmetros documentados** com `@Parameter`
- **Operações CRUD** padronizadas

### Configuração OpenAPI:
```yaml
info:
  title: API Vigilância Sanitária
  description: Sistema de Vigilância Sanitária - Backend Spring Boot
  version: 1.0.0
security:
  - bearerAuth: []
```

## Dicas de desenvolvimento
- **Lombok**: assegure-se de ter o plugin do Lombok no IDE e annotation processing habilitado
- **MapStruct**: gere mapeamentos na build; erros de compilação podem apontar para mapeamentos faltantes
- **OpenAPI**: use `@Tag`, `@Operation`, `@ApiResponse` para documentar novos endpoints
- **Validação**: sempre use `@Valid` em endpoints POST/PUT
- **Perfis**: se existirem perfis (ex.: `dev`, `prod`), ajuste as propriedades conforme o ambiente

## CORS — Suporte a Frontend Angular (porta 4200) e domínios distintos

Esta API está preparada para CORS, permitindo que um frontend (ex.: Angular 18) rode em origem distinta como `http://localhost:4200` em desenvolvimento, ou um DNS diferente em produção.

Como funciona:
- O CORS é habilitado via `http.cors()` no `SecurityConfig` e um bean `CorsConfigurationSource` parametrizável.
- Por padrão, a origem `http://localhost:4200` está liberada para facilitar o desenvolvimento.
- Pré‑flight `OPTIONS` está liberado globalmente.

Parâmetros (em `application.yml`, com sobrescrita via variáveis de ambiente):
```yaml
security:
  cors:
    allowed-origins: ${SECURITY_CORS_ALLOWED_ORIGINS:http://localhost:4200}
    allowed-methods: ${SECURITY_CORS_ALLOWED_METHODS:GET,POST,PUT,PATCH,DELETE,OPTIONS}
    allowed-headers: ${SECURITY_CORS_ALLOWED_HEADERS:Authorization,Content-Type,Accept}
    allow-credentials: ${SECURITY_CORS_ALLOW_CREDENTIALS:true}
```

Exemplos de configuração:
- Desenvolvimento (Angular local):
  - Windows PowerShell:
    ```powershell
    $env:SECURITY_CORS_ALLOWED_ORIGINS = "http://localhost:4200"
    ```
  - Linux/macOS Bash:
    ```bash
    export SECURITY_CORS_ALLOWED_ORIGINS="http://localhost:4200"
    ```
- Produção (DNS do app):
  - Permitir múltiplas origens separadas por vírgula:
    ```bash
    export SECURITY_CORS_ALLOWED_ORIGINS="https://app.seudominio.gov.br,https://admin.seudominio.gov.br"
    ```

Quando usar Proxy vs CORS no Angular:
- Proxy (mesma origem) — recomendado para desenvolvimento: configure `proxy.conf.json` no Angular e chame `/api/...`. Vantagens: evita CORS e cookies/credenciais funcionam sem ajustes.
- CORS (origens distintas) — comum em produção quando front e back estão em domínios diferentes: aponte `environment.apiBaseUrl` para o backend e garanta que a origem do frontend esteja listada em `SECURITY_CORS_ALLOWED_ORIGENS`.

Observações:
- Se usar JWT no header `Authorization`, mantenha `allowed-headers` com `Authorization` e `Content-Type`.
- Para cookies/sessão, deixe `allow-credentials: true` e configure o front para enviar credenciais.
- O preflight (`OPTIONS`) é automaticamente tratado pelo Spring Security e liberado neste projeto.

## Segurança e boas práticas
- Não commitar `.env` com segredos reais. Inclua um `/.gitignore` apropriado e mantenha apenas um `.env.example` sem segredos.
- Rotacione senhas usadas em ambientes locais compartilhados.

## Exemplos de arquivos auxiliares
Crie um arquivo de exemplo para documentação das variáveis:

`.env.example`
```dotenv
POSTGRES_USER=
POSTGRES_PASSWORD=
POSTGRES_DB=vigilancia
PGADMIN_DEFAULT_EMAIL=admin@example.com
PGADMIN_DEFAULT_PASSWORD=adminsecret

# JWT (para desenvolvimento; em produção use segredos fortes)
JWT_SECRET_BASE64=c3ByaW5nLWJvb3Qtsecrect-seed-key-should-be-long-enough-for-HS256
JWT_ISSUER=vigilancia
JWT_EXP_SECONDS=3600
```

## Autenticação e autorização (JWT)
A aplicação foi migrada de HTTP Basic para JWT, mantendo o domínio existente de `Usuario`, `Permissao` e `Tabela`. O objetivo é segurança stateless, melhor integração com frontends e escalabilidade.

- Contexto da migração
  - Antes: HTTP Basic com validação de credenciais a cada requisição.
  - Agora: `POST /auth/login` emite um token JWT assinado (HS256) com as authorities do usuário; as requisições subsequentes usam `Authorization: Bearer <token>`.
  - O Hibernate/JPA e o domínio de permissões permanecem os mesmos; apenas a camada de autenticação/filtragem foi trocada.

- UserDetails e authorities
  - `AppUserDetails` (`src/main/java/br/gov/mt/vigilancia/saude/security/AppUserDetails.java`) monta as authorities a partir das flags de `Permissao`.
  - Formato: `PERM_<TABELA>:<OPERACAO>` (ex.: `PERM_USUARIO:SELECT`, `PERM_ORDEMSERVICO:UPDATE`). O nome da tabela vem de `Tabela.nome` (UPPERCASE).

- Carregamento de usuários
  - `UsuarioDetailsService` (`src/main/java/br/gov/mt/vigilancia/saude/security/UsuarioDetailsService.java`) busca por email com `left join fetch` de permissões/tabela.

- Configuração de segurança (JWT)
  - `SecurityConfig` (`src/main/java/br/gov/mt/vigilancia/saude/config/SecurityConfig.java`):
    - Stateless (`SessionCreationPolicy.STATELESS`), CSRF desabilitado, CORS default.
    - Rotas públicas: `/`, `/health`, `/actuator/health`, `/actuator/info`, `POST /auth/login`.
    - Filtro: `JwtAuthenticationFilter` antes de `UsernamePasswordAuthenticationFilter`.
  - `JwtTokenService`: geração/validação do token; inclui claims `uid` e `auth` (lista de authorities).

- Variáveis de ambiente / configuração
  - `application.yml` expõe:
    ```yaml
    security:
      jwt:
        secret: ${JWT_SECRET_BASE64:c3ByaW5nLWJvb3Qtsecrect-seed-key-should-be-long-enough-for-HS256}
        issuer: ${JWT_ISSUER:vigilancia}
        expiration: ${JWT_EXP_SECONDS:3600}
    ```
  - Em produção, defina:
    - `JWT_SECRET_BASE64`: chave Base64 (>= 256 bits) para HS256.
    - `JWT_ISSUER`: identificador do emissor (ex.: `vigilancia`).
    - `JWT_EXP_SECONDS`: tempo de expiração em segundos (ex.: `3600`).

- Endpoints de autenticação
  - `POST /auth/login` — body:
    ```json
    { "email": "admin@local", "senha": "admin" }
    ```
    Resposta:
    ```json
    {
      "token": "<JWT>",
      "tokenType": "Bearer",
      "expiresIn": 3600,
      "userId": 1,
      "email": "admin@local",
      "authorities": ["PERM_USUARIO:SELECT", "..."]
    }
    ```
  - `POST /auth/refresh` — gera um novo token a partir de um token anterior (até mesmo expirado). Envie o token anterior no cabeçalho:
    ```bash
    curl -s -X POST http://localhost:8081/auth/refresh \
      -H "Authorization: Bearer <token_antigo>"
    ```
    Resposta: igual ao login (novo `token`, `expiresIn` reiniciado).
  - `GET /auth/me` — requer `Authorization: Bearer <token>`; retorna dados do usuário autenticado e suas authorities.

- Protegendo endpoints por authority
  - No `SecurityConfig`, restrinja por authority conforme necessário (exemplo):
    ```
    http.authorizeHttpRequests(auth -> auth
        .requestMatchers("/some/admin/**").hasAuthority("PERM_USUARIO:UPDATE")
        .anyRequest().authenticated()
    );
    ```
  - Também é possível usar `@PreAuthorize("hasAuthority('PERM_TABELA:OPERACAO')")` em métodos.

### Como testar rapidamente (JWT)
1) Rode a aplicação (Flyway aplicará as migrações, incluindo a V9 com seed):
   ```bash
   ./gradlew bootRun
   ```
2) Faça login e capture o token:
   ```bash
   TOKEN=$(curl -s -X POST http://localhost:8081/auth/login \
     -H "Content-Type: application/json" \
     -d '{"email":"admin@local","senha":"admin"}' | jq -r .token)
   ```
   Sem `jq`, apenas copie o campo `token` do JSON de resposta.
3) Chame um endpoint protegido usando o token:
   ```bash
   curl -H "Authorization: Bearer $TOKEN" http://localhost:8081/auth/me
   ```

### Observações importantes
- Hash de senha: deve ser BCrypt, compatível com `BCryptPasswordEncoder`.
- Authorities são derivadas das flags de `Permissao` e do nome de `Tabela` associado.
- Seeds para testes: a migração `V9__seed_usuario_permissao_tabela.sql` cria o usuário `admin@local` (senha `admin`, BCrypt) e permissões amplas para facilitar validação dos fluxos.

## Troubleshooting
- PgAdmin não conecta ao `db`:
  - Verifique se o serviço `db` está saudável (`docker compose ps`).
  - Use host `db` quando conectar a partir do container `pgadmin` e `localhost` quando conectar de fora dos containers.
- Erros de migração Flyway:
  - Confira a ordem e o nome dos arquivos em `db/migration`.
- Verifique a compatibilidade da SQL com PostgreSQL 15.

---

## Status do Projeto

### Progresso de Desenvolvimento
- ✅ **130 Controllers** - 100% documentados com OpenAPI
- ✅ **CRUD Completo** - 45+ controllers com operações completas
- ✅ **Autenticação JWT** - Sistema stateless implementado
- ✅ **Migrações Flyway** - 22 versões aplicadas
- ✅ **Mapeamento JPA** - Entidades alinhadas com banco legado
- ✅ **Documentação API** - Swagger UI funcional

### Arquitetura Implementada
- **Backend**: Spring Boot 3.x + Java 21
- **Banco**: PostgreSQL 15 com schema `app`
- **Segurança**: JWT com authorities baseadas em permissões
- **Documentação**: OpenAPI 3.0 + Swagger UI
- **Mapeamento**: MapStruct para Entity ↔ DTO
- **Migrações**: Flyway para versionamento do banco
- **Containerização**: Docker Compose para desenvolvimento

### Próximos Passos
- [ ] Implementar testes unitários e integração
- [ ] Configurar profiles para diferentes ambientes
- [ ] Implementar cache com Redis
- [ ] Configurar monitoramento com Actuator
- [ ] Deploy em ambiente de produção

---

**Mantido por**: Equipe de Vigilância Sanitária  
**Última atualização**: 2025-01-08  
**Versão da API**: 1.0.0


---

## Histórico de Atualizações

### 2025-01-08 - CRUD Completo e Documentação OpenAPI
- ✅ **130 Controllers documentados** com OpenAPI/Swagger
- ✅ **45+ Controllers com CRUD completo** (GET, POST, PUT, DELETE)
- ✅ **Configuração OpenAPI** com autenticação JWT
- ✅ **Validação padronizada** com `@Valid` em todos os endpoints
- ✅ **Códigos de resposta HTTP** apropriados (200, 404, 204)
- ✅ **Documentação de parâmetros** com `@Parameter`
- ✅ **Tags organizadas** por domínio de negócio
- ✅ **Services com métodos CRUD** (findById, save, update, delete)
- ✅ **Mapeadores MapStruct** atualizados
- ✅ **Tipos de ID consistentes** (Integer/String conforme entidade)

### 2025-11-08 - Estabilização do Build

Este projeto recebeu ajustes para estabilizar o build, alinhar mapeamentos JPA e concluir migrações de banco de dados.

### Migrações Flyway

Este projeto recebeu ajustes para estabilizar o build, alinhar mapeamentos JPA e concluir migrações de banco de dados.

### Migrações Flyway
- V25__itens_termocolheita_produtocategoria.sql
  - Cria as tabelas: `produtocategoria`, `termocolheita`, `itensembalagem`, `itenscolheita`, `itensdocumento`, `itensexiberoteiro`, `itensgaleria` no schema `app`.
  - Sequences com `INCREMENT BY 50` e `setval` idempotente.
  - FK `termocolheita.idprodutocategoria` → `REFERENCES app.produtocategoria` (sem fixar o nome da coluna da PK) para compatibilidade com esquemas legados.
- V26__add_nomeprodutocategoria.sql
  - Adiciona a coluna `nomeprodutocategoria` (nullable) em `app.produtocategoria` caso não exista e tenta preencher a partir de colunas legadas (`nome`, `descricao`, `categoria`).
- V27__ajusta_incremento_seq_produtocategoria.sql
  - Ajusta a sequência `app.produtocategoria_idprodutocategoria_seq` para `INCREMENT BY 50`, alinhando ao `allocationSize` do JPA.

### Ajustes de entidades (JPA)
- ProdutoCategoria
  - `@Table(name = "produtocategoria", schema = "app")`.
  - Campo Java `idprodutocategoria` mapeado para a coluna física `id` com `@Column(name = "id")`.
  - `@SequenceGenerator(sequenceName = "app.produtocategoria_idprodutocategoria_seq", allocationSize = 50)`.
  - Relação com `Reclamacao`: `@OneToMany(mappedBy = "produtoCategoria")` (corrigido).
- Termocolheita, Itenscolheita, Itensdocumento, Itensembalagem, Itensexiberoteiro, Itensgaleria
  - `@Table(schema = "app")` definido para evitar divergências de snake_case do Hibernate com a DDL do Flyway.

### Ajustes nos mappers (MapStruct)
- ReclamacaoMapper: `produtoCategoria.idprodutocategoria` ↔ `idProdutoCategoria` (DTO).
- TermocolheitaMapper: `produtocategoria.idprodutocategoria` e `motivo.id` mapeados corretamente.
- ProdutoCategoriaMapper: `@Mapping(target = "reclamacaos", ignore = true)` ao criar entidade.
- ItensembalagemMapper: mapeamentos aninhados corrigidos (`estabelecimento.id`).

### Endpoints afetados
- `ProdutoCategoriaController`
  - `GET /produtocategorias`
  - `GET /produtocategorias/{id}`
  - `POST /produtocategorias`
  - `PUT /produtocategorias/{id}`
  - `DELETE /produtocategorias/{id}`

### Como validar
1) Rodar migrações: `./gradlew flywayMigrate`
2) Rodar testes: `./gradlew test` ou subir a aplicação (`bootRun`).
3) Verificar:
   - Colunas `id` e `nomeprodutocategoria` em `app.produtocategoria` presentes.
   - Sequência `app.produtocategoria_idprodutocategoria_seq` com `INCREMENT BY 50`.
   - Relacionamento `ProdutoCategoria` ↔ `Reclamacao` válido (`mappedBy = produtoCategoria`).

## Princípio preferencial: mapear entidades para o banco existente (sem renomear via migração)

Contexto: Em ambientes com base de dados legada, os nomes reais das tabelas/colunas normalmente seguem snake_case e podem divergir dos nomes em Java (CamelCase). Para evitar retrabalho, instabilidade e migrações desnecessárias, este projeto adota o seguinte princípio operacional:

- Priorize o mapeamento via anotações JPA/Hibernate nas entidades para alinhar com a estrutura já existente no banco.
- Evite criar migrações apenas para renomear colunas/tabelas quando o objetivo é somente compatibilizar nomes entre código e banco.
- Use migrações (Flyway) apenas quando houver necessidade real de mudança estrutural (criar tabela nova, adicionar coluna nova requerida pela regra de negócio, índices, FKs que não existem, etc.).

### Como aplicar na prática

1) Tabela existente com nomes diferentes do código:
- Use `@Table(schema = "app", name = "tabela_existente")` na entidade.
- Para cada campo, use `@Column(name = "nome_real_no_banco")` com `length`, `nullable` e `columnDefinition` quando necessário.
- Para relacionamentos, use `@JoinColumn(name = "fk_no_banco")` e qualifique `schema` na entidade de destino quando aplicável.

2) Sequence e geração de ID:
- Aponte o gerador para a sequence real: `@SequenceGenerator(sequenceName = "app.minha_sequence", allocationSize = 1)`.
- Ajuste `allocationSize` para refletir o incremento real da sequence no banco (em legados costuma ser 1). Só use 50 se a sequence também estiver com incremento 50.

3) Validação de schema do Hibernate:
- Se estiver habilitada, a aplicação só deve falhar por ausência de estrutura essencial (tabela/coluna inexistente), não por diferenças de nomenclatura. O mapeamento via `@Column/@JoinColumn` resolve a nomenclatura.

4) Quando criar migração (Flyway):
- Casos válidos: criação de novas tabelas/colunas requeridas pelas regras de negócio, novos índices, novas FKs que não existem no legado.
- Casos a evitar: renomear coluna/tabela apenas para "combinar" com o Java.

5) Exemplo real no projeto — OrdemServico
- Tabela existente: `app.ordemservico` com colunas como `data_conclusao`, `data_ordem_servico`, `usuario_conclusao`, etc.
- Entidade `OrdemServico` mapeada com:
  - `@Table(name = "ordemservico", schema = "app")`
  - `@Column(name = "data_conclusao")` para o campo Java `dataconclusao`
  - `@Column(name = "data_ordem_servico")` para `dataordemservico`
  - `@JoinColumn(name = "idacao")` e `@JoinColumn(name = "numprocesso")`
  - Sequence: `@SequenceGenerator(sequenceName = "app.ordemservico_idordemservico_seq", allocationSize = 1)`

6) Checklist rápido ao encontrar erro de validação do Hibernate (missing table/column):
- A tabela existe? Se sim, adicione/ajuste `@Table(schema, name)`.
- A coluna existe com outro nome (snake_case)? Adicione `@Column(name = ...)`.
- A FK existe com outro nome? Ajuste `@JoinColumn(name = ...)`.
- A sequence tem incremento diferente? Ajuste `allocationSize` para o valor real.
- Só crie migração se a estrutura realmente não existir e precisar ser criada.

7) Convenções para novos mapeamentos
- Prefira campos `String` com `@Column(length = X)` quando precisar validar tamanho em nível de schema.
- Em `LocalDate/Date/LocalDateTime/Time`, explicite `@Temporal` quando utilizando `java.util.Date`.
- MapStruct: aponte para os nomes efetivos das propriedades nas entidades (não confundir com nomes de coluna no banco).

Com esse fluxo, evitamos scripts desnecessários, aceleramos a entrega e mantemos compatibilidade com o banco legado sem "bagunçar" o schema.


### Exemplo completo — 2FA TOTP (registro, verificação e desabilitação)

Pré‑requisitos:
- Aplicação em execução (por padrão em http://localhost:8081)
- Um usuário existente com `id` conhecido (ex.: `1`)
- Token JWT válido (use as rotas `/auth/login` e `/auth/me` se necessário)

1) Obtenha um token JWT
```bash
curl -s -X POST http://localhost:8081/auth/login \
  -H "Content-Type: application/json" \
  -d '{"email":"admin@local","senha":"admin"}'
```
Copie o valor de `token` da resposta e exporte em uma variável (PowerShell):
```powershell
$env:TOKEN = "<cole-o-token-aqui>"
```

2) Iniciar o registro TOTP (gera segredo, otpauth e QR Code em Data URI)
```bash
curl -s -X POST http://localhost:8081/usuarios/1/totp/register \
  -H "Authorization: Bearer $TOKEN"
```
Resposta (exemplo):
```json
{
  "otpauthUrl": "otpauth://totp/vigilancia:admin%40local?secret=ABCDEF123...&issuer=vigilancia&algorithm=SHA1&digits=6&period=30",
  "qrCodeDataUri": "data:image/png;base64,iVBORw0KGgoAAAANSUhEU...",
  "issuer": "vigilancia",
  "accountLabel": "admin@local"
}
```

Exibir o QR Code no frontend (HTML simples):
```html
<img alt="QR TOTP" src="data:image/png;base64, ..." />
```
Ou use diretamente `qrCodeDataUri` do JSON: `<img src="{qrCodeDataUri}" />`.
Alternativa sem QR: configure no app autenticador usando a `otpauthUrl` (ou informe o `secret` manualmente, se suportado).

3) Verificar e habilitar o TOTP (informe o código de 6 dígitos do app)
```bash
curl -i -X POST http://localhost:8081/usuarios/1/totp/verify \
  -H "Authorization: Bearer $TOKEN" \
  -H "Content-Type: application/json" \
  -d '{"code":"123456"}'
```
Respostas esperadas:
- `200 OK`: código válido, 2FA habilitado para o usuário
- `400 Bad Request`: código inválido ou segredo não registrado
- `404 Not Found`: usuário não existe

4) Conferir status do usuário (campo `totpEnabled`)
```bash
curl -s http://localhost:8081/usuarios/1 \
  -H "Authorization: Bearer $TOKEN"
```
Verifique `"totpEnabled": true` no JSON retornado.

5) Desabilitar o TOTP (exige validar com o código atual)
```bash
curl -i -X POST http://localhost:8081/usuarios/1/totp/disable \
  -H "Authorization: Bearer $TOKEN" \
  -H "Content-Type: application/json" \
  -d '{"code":"123456"}'
```
Respostas:
- `200 OK`: 2FA desabilitado (o segredo é removido)
- `400 Bad Request`: código inválido
- `404 Not Found`: usuário não existe

Dicas e observações importantes:
- Sincronize o relógio do servidor e do dispositivo (o TOTP depende de tempo). Há tolerância de ±1 passo (≈30s).
- O segredo TOTP não é exposto pela API. Apenas `totpEnabled` é visível no `UsuarioDTO`.
- Proteja esses endpoints com JWT. Evite logar códigos TOTP em produção.
- Recomendado implementar rate limiting e auditoria para tentativas de verificação.

---

## Exemplo Frontend Angular 18 — Integração com TOTP (2FA)

Este guia documenta como integrar um frontend Angular 18 com os endpoints TOTP deste backend. Inclui as variações solicitadas:
- Opção A: consumo em mesma origem via proxy do Angular (dev)
- Opção B: consumo via domínio distinto (CORS)
- Uso de HttpClient puro (serviço Angular)
- Interceptor de JWT (Bearer) e guarda de rota simples

Pré‑requisitos assumidos:
- O login no frontend já está implementado e fornece um token JWT (armazenado em `localStorage` ou `sessionStorage`).
- O `userId` do usuário autenticado é conhecido. Nos exemplos, usaremos `userId = 1` apenas como placeholder.
- Backend rodando em `http://localhost:8081`.

### Sumário
- Opção A — Proxy (mesma origem) no Angular
- Opção B — Domínio distinto (CORS)
- Serviço Angular: `TotpApiService`
- Interceptor JWT (Bearer)
- Guarda de rota (`AuthGuard`) simples
- Componentes: Registrar (QR), Verificar, Desabilitar
- Observações de segurança e UX

### Opção A — Mesma origem via proxy (Angular dev‑server)

1) Crie `proxy.conf.json` no projeto Angular:
```json
{
  "/api": {
    "target": "http://localhost:8081",
    "secure": false,
    "changeOrigin": true,
    "logLevel": "debug",
    "pathRewrite": { "^/api": "" }
  }
}
```

2) Ajuste o script de start no `package.json` do frontend:
```json
{
  "scripts": {
    "start": "ng serve --proxy-config proxy.conf.json"
  }
}
```

3) Nas chamadas HTTP, use o prefixo `/api` (ex.: `/api/usuarios/1/totp/register`). O proxy encaminha para `http://localhost:8081/usuarios/1/totp/register`.

### Opção B — Domínio distinto (CORS)

- Use a URL completa do backend nas chamadas Angular (ex.: `http://localhost:8081`).
- Garanta CORS permitido no backend para a origem do frontend (ex.: `http://localhost:4200`). A aplicação já possui CORS default; ajuste se necessário na configuração de segurança.

`environment.ts` (dev) no frontend:
```ts
export const environment = {
  production: false,
  apiBaseUrl: 'http://localhost:8081'
};
```

### Serviço Angular — TotpApiService (HttpClient)

`totp-api.service.ts`
```ts
import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface TotpRegisterResponse {
  otpauthUrl: string;
  qrCodeDataUri: string;
  issuer: string;
  accountLabel: string;
}

@Injectable({ providedIn: 'root' })
export class TotpApiService {
  private readonly http = inject(HttpClient);
  // Use '/api' se estiver com proxy (Opção A), ou environment.apiBaseUrl (Opção B)
  private readonly base = '/api'; // ou: environment.apiBaseUrl

  register(userId: number): Observable<TotpRegisterResponse> {
    return this.http.post<TotpRegisterResponse>(`${this.base}/usuarios/${userId}/totp/register`, {});
  }

  verify(userId: number, code: string): Observable<void> {
    return this.http.post<void>(`${this.base}/usuarios/${userId}/totp/verify`, { code });
  }

  disable(userId: number, code: string): Observable<void> {
    return this.http.post<void>(`${this.base}/usuarios/${userId}/totp/disable`, { code });
  }
}
```

### Interceptor JWT (Bearer)

`jwt.interceptor.ts`
```ts
import { Injectable } from '@angular/core';
import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class JwtInterceptor implements HttpInterceptor {
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const token = localStorage.getItem('token'); // ou sessionStorage
    if (token) {
      req = req.clone({ setHeaders: { Authorization: `Bearer ${token}` } });
    }
    return next.handle(req);
  }
}
```

Registro do interceptor (providers no bootstrap — Angular 16+):
```ts
import { bootstrapApplication } from '@angular/platform-browser';
import { provideHttpClient, withInterceptors } from '@angular/common/http';
import { AppComponent } from './app/app.component';
import { JwtInterceptor } from './app/core/jwt.interceptor';

bootstrapApplication(AppComponent, {
  providers: [
    provideHttpClient(withInterceptors([ (req, next) => new JwtInterceptor().intercept(req, next) ]))
  ]
});
```

Se utilizar `NgModule`, registre com `HTTP_INTERCEPTORS` no `providers`.

### Guarda de rota (AuthGuard) simples

`auth.guard.ts`
```ts
import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';

export const authGuard: CanActivateFn = (route, state) => {
  const router = inject(Router);
  const token = localStorage.getItem('token');
  if (!token) {
    router.navigate(['/login'], { queryParams: { returnUrl: state.url } });
    return false;
  }
  return true;
};
```

Uso nas rotas:
```ts
import { Routes } from '@angular/router';
import { TotpRegisterComponent } from './totp/totp-register.component';
import { TotpVerifyComponent } from './totp/totp-verify.component';
import { TotpDisableComponent } from './totp/totp-disable.component';
import { authGuard } from './core/auth.guard';

export const routes: Routes = [
  { path: 'totp/register', component: TotpRegisterComponent, canActivate: [authGuard] },
  { path: 'totp/verify', component: TotpVerifyComponent, canActivate: [authGuard] },
  { path: 'totp/disable', component: TotpDisableComponent, canActivate: [authGuard] }
];
```

### Componentes de UI

1) Registrar TOTP e exibir QR Code (Data URI)

`totp-register.component.ts`
```ts
import { Component, inject, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TotpApiService, TotpRegisterResponse } from '../core/totp-api.service';

@Component({
  selector: 'app-totp-register',
  standalone: true,
  imports: [CommonModule],
  template: `
    <button (click)="onRegister()">Gerar QR Code</button>
    <div *ngIf="qrDataUri() as data">
      <p>Escaneie no app autenticador:</p>
      <img [src]="data" alt="QR Code" />
    </div>
  `
})
export class TotpRegisterComponent {
  private readonly api = inject(TotpApiService);
  qrDataUri = signal<string | null>(null);
  private userId = 1; // obter da sessão/usuário autenticado

  onRegister() {
    this.api.register(this.userId).subscribe((resp: TotpRegisterResponse) => {
      this.qrDataUri.set(resp.qrCodeDataUri);
    });
  }
}
```

2) Verificar e habilitar TOTP

`totp-verify.component.ts`
```ts
import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { TotpApiService } from '../core/totp-api.service';

@Component({
  selector: 'app-totp-verify',
  standalone: true,
  imports: [CommonModule, FormsModule],
  template: `
    <form (ngSubmit)="onSubmit()">
      <label>Código TOTP</label>
      <input name="code" [(ngModel)]="code" maxlength="6" required />
      <button type="submit">Verificar</button>
    </form>
    <p *ngIf="message">{{ message }}</p>
  `
})
export class TotpVerifyComponent {
  private readonly api = inject(TotpApiService);
  code = '';
  message = '';
  private userId = 1;

  onSubmit() {
    this.api.verify(this.userId, this.code).subscribe({
      next: () => this.message = '2FA habilitado com sucesso!',
      error: () => this.message = 'Código inválido ou expirado.'
    });
  }
}
```

3) Desabilitar TOTP

`totp-disable.component.ts`
```ts
import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { TotpApiService } from '../core/totp-api.service';

@Component({
  selector: 'app-totp-disable',
  standalone: true,
  imports: [CommonModule, FormsModule],
  template: `
    <form (ngSubmit)="onSubmit()">
      <label>Confirme com o código TOTP atual</label>
      <input name="code" [(ngModel)]="code" maxlength="6" required />
      <button type="submit">Desabilitar 2FA</button>
    </form>
    <p *ngIf="message">{{ message }}</p>
  `
})
export class TotpDisableComponent {
  private readonly api = inject(TotpApiService);
  code = '';
  message = '';
  private userId = 1;

  onSubmit() {
    this.api.disable(this.userId, this.code).subscribe({
      next: () => this.message = '2FA desabilitado.',
      error: () => this.message = 'Código inválido.'
    });
  }
}
```

### Observações de segurança e UX
- Não logue códigos TOTP em produção.
- Trate mensagens de erro (400/404) de forma clara e segura no frontend.
- Considere rate limiting no backend e retry/backoff no frontend.
- Garanta sincronização de hora entre cliente e servidor.
- Para produção, avalie estratégias seguras de armazenamento do token e proteção adicional (CSRF quando aplicável).

Com isso, o frontend Angular 18 consegue consumir os endpoints:
- `POST /usuarios/{id}/totp/register`
- `POST /usuarios/{id}/totp/verify`
- `POST /usuarios/{id}/totp/disable`
