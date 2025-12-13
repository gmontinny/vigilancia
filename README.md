# Projeto Vigilância Sanitária — Backend

## Visão Geral

Backend moderno em Spring Boot para substituir o sistema legado, com foco em arquitetura limpa, performance e manutenibilidade. O projeto evolui a partir das regras de negócio existentes, preservando compatibilidade onde fizer sentido e adotando boas práticas atuais.

## Sumário
- Requisitos
- Configuração rápida (Docker + PostgreSQL)
- Variáveis de ambiente
- Executando a aplicação (dev)
- Estrutura do projeto
- Banco de dados e migrações (Flyway)
- Endpoints disponíveis
- Build, testes e qualidade
- Dicas de desenvolvimento
- Segurança e boas práticas
- Autenticação e autorização (JWT)
- Troubleshooting

## Requisitos
- Java 21 (JDK)
- Gradle (wrapper incluído: `./gradlew` / `gradlew.bat`)
- Docker e Docker Compose (opcional para banco local)

## Configuração rápida (Docker + PostgreSQL)
O projeto inclui um `docker-compose.yml` para subir um PostgreSQL e o PgAdmin.

1. Crie um arquivo `.env` na raiz do projeto (mesmo nível do `docker-compose.yml`). Veja a seção "Variáveis de ambiente" abaixo.
2. Suba os serviços:
   - Windows PowerShell:
     ```powershell
     docker compose up -d
     ```
3. Verifique a saúde do serviço `db` (o compose já tem healthcheck). Quando saudável, o PgAdmin estará em `http://localhost:8080`.

PgAdmin (padrão do `.env`):
- URL: `http://localhost:8080`
- Usuário: valor de `PGADMIN_DEFAULT_EMAIL`
- Senha: valor de `PGADMIN_DEFAULT_PASSWORD`

Dica: no PgAdmin, crie uma conexão para o servidor `db` com host `db`, porta `5432`, usuário e banco conforme seu `.env`.

## Variáveis de ambiente
Crie um arquivo `.env` (não versionado idealmente) com o seguinte conteúdo (exemplo):

```dotenv
POSTGRES_USER=appuser
POSTGRES_PASSWORD=appsecret
POSTGRES_DB=vigilancia
DB_SCHEMA=app
SERVER_PORT=8081
PGADMIN_DEFAULT_EMAIL=admin@example.com
PGADMIN_DEFAULT_PASSWORD=adminsecret
```

Importante:
- Não use credenciais reais em commits. Prefira um `.env.example` (ver abaixo) para documentar os campos.
- Caso já exista um `.env` com credenciais, troque-as localmente e regenere usuários/senhas quando publicar.

Também incluído para referência:
- `docker-compose.yml`: define os serviços `db` (PostgreSQL 15) e `pgadmin`.

## Executando a aplicação (dev)
Você pode rodar a aplicação sem o Docker (se já possuir um PostgreSQL disponível) ou usando o banco do compose.

- Com Gradle Wrapper:
  - Windows:
    ```powershell
    .\\gradlew.bat bootRun
    ```
  - Linux/macOS:
    ```bash
    ./gradlew bootRun
    ```

- Build do jar:
  ```bash
  ./gradlew clean build
  ```
  O artefato será gerado em `build/libs/`.

Configuração de acesso ao banco (application.properties/yaml): verifique as propriedades ativas para apontar para o host, porta, banco, usuário e senha correspondentes.

## Estrutura do projeto
Arquitetura em camadas (pacotes principais em `src/main/java/br/gov/mt/vigilancia`):
- `domain`: Entidades JPA (tabelas do banco)
- `repository`: Spring Data JPA para acesso a dados
- `service`: Regras de negócio
- `controller`: Endpoints REST
- `dto`: Objetos de transferência de dados para API
- `mapper`: MapStruct para mapear Entity ↔ DTO

Arquivos importantes:
- `src/main/resources/db/migration`: scripts Flyway (ex.: `V1__init.sql`)
- `docker-compose.yml` e `.env`: infraestrutura local de DB
- `HELP.md`: links úteis do ecossistema Spring e Gradle

## Banco de dados e migrações (Flyway)
- As migrações residem em `src/main/resources/db/migration` e são aplicadas automaticamente no startup pela Flyway.
- Versões principais já incluídas:
  - V1__init.sql — cria o schema `app` e extensões úteis.
  - V2__domain_schema.sql — base do domínio: `conselho`, `responsavel_tecnico`, `usuario`, `estabelecimento`, `processo` + FKs e índices.
  - V3__grupo_subgrupo.sql — tabelas `grupo` e `subgrupo` com validações básicas.
  - V4__domain_full.sql — amplia o domínio (ex.: `acao`, `endereco`, `tipoempresa`, `ordemservico`, `reclamacao`, `bpa`, `tabela`, `fiscal`, etc.).
  - V5__update_domain.sql — adiciona entidades como `produtos`, `servicos`, `saude`, `forum`, `prodi`, `galeria`, `roteiro`, `motivo`, `baixa`, `sintomas`.
  - V6__categorias_veiculos.sql — cria `categoria` e `veiculo`, com FKs para `estabelecimento` e `categoria`.
  - V7__licencias_mensagens_timelines_unidades_apreensoes.sql — cria `licencia`, `mensagem`, `timeline`, `unidademedida` e `apreensao` com FKs e índices.
  - V8__ajustes_nomes_colunas_servicos.sql — padroniza colunas de `servicos` para snake_case.
  - V9__seed_usuario_permissao_tabela.sql — semeia dados para testes de autenticação/autorização (usuário admin `admin@local`).
  - V10__reseed_admin_password.sql — garante senha BCrypt válida para `admin@local`.
  - V11__cupomauto_documentos_geraauto_resposta_embalagem_fiscaladm_geraprodi.sql — cria tabelas do legado com sequências.
  - V12__rename_columns_snake_case_legacy.sql — renomeia colunas para snake_case, alinhando com Hibernate.
  - V13__administrativo_agrupamento_analiseprocesso_areainspecao_arquitetonico_licenciamento.sql — cria tabelas administrativas com FKs e índices.
  - V14__adjust_sequences_allocation_size.sql — ajusta `INCREMENT BY` das sequências para 50.
  - V15__create_missing_sequences_auto.sql — cria sequências esperadas pelo Hibernate.
  - V16__arquivodocumento_assuntosolicitacao_atividadefiscal_atividades_atividadevigilancia.sql — cria tabelas de documentos e atividades.
  - V17__autoinfracao_tramitacao_autonotificacao_balancomedicamento_bloqueioitenssolicitacao_itenssolicitacao_solicitacao_tipoinspecao_carteirinha.sql — cria tabelas de infrações, tramitações e solicitações.
  - V18__categoriaanalise_categoriaproduto_categoriaroteiro_categoriaservico_despachocontrarazao_itensroteiro_servicosaude_legislacao.sql — cria tabelas de categorias e serviços de saúde.
  - V19__despachos_docnecessario_upload_documentoerrado.sql — cria tabelas de despachos e documentos.
  - V20__embalagem_empresainfracoes_entregador_exiberoteiro_farmaceutico_montarroteiro.sql — cria tabelas de embalagens e roteiros.
  - V21__fix_embalagem_sequence.sql — corrige sequência da tabela embalagem.
- V22__geraatividade_geracategoriaservico_geracodigocertificacao_geradocumento_geragaleria.sql — cria as tabelas do legado para as entidades `Geraatividade`, `Geracategoriaservico`, `Geracodigocertificacao`, `Geradocumento` e `Geragaleria` com sequences (INCREMENT BY 50) e índices de `idusuario` onde aplicável.
- Alinhamento de schema:
  - Hibernate valida no schema `app` via `spring.jpa.properties.hibernate.default_schema=${DB_SCHEMA:app}`.
  - Flyway migra no schema `app` via `spring.flyway.default-schema`/`schemas`.
  - Opcional: acrescente `?currentSchema=app` na URL JDBC para ambientes que não respeitam o `search_path`.
- Para criar uma nova versão, adicione um arquivo `V{N}__sua_descricao.sql` seguindo a sequência numérica e rode a aplicação.

#### Notas sobre a V22
- Arquivo: `src/main/resources/db/migration/V22__geraatividade_geracategoriaservico_geracodigocertificacao_geradocumento_geragaleria.sql`
- Padrões:
  - Schema: `app` (alinhado ao `application.yml`).
  - Sequences com `INCREMENT BY 50` para cada tabela.
  - Tabelas com PK usando `DEFAULT nextval('schema.sequence')`.
  - Índices para colunas `idusuario` onde aplicável.
  - Bloco `DO $$` para ajustar (`setval`) as sequences de acordo com dados existentes (idempotente).
- Tabelas criadas: `geraatividade`, `geracategoriaservico`, `geracodigocertificacao`, `geradocumento`, `geragaleria`.
- Observação: Não foram incluídas FKs, pois as entidades do legado não declaram relações explícitas. Poderá ser evoluído no futuro.

#### Como aplicar a V22
- Ao iniciar a aplicação com banco configurado, a Flyway aplicará automaticamente.
- Alternativas:
  - Via Gradle: `./gradlew flywayMigrate`
  - Subindo via Docker Compose e rodando a aplicação: `docker compose up -d` (db) e depois `./gradlew bootRun` (app)
- Requisitos: variáveis `POSTGRES_USER`, `POSTGRES_PASSWORD`, `POSTGRES_DB` e opcionalmente `DB_SCHEMA` (padrão `app`).

## Execução de migrações com Gradle (Flyway plugin)
O plugin Flyway está configurado no `build.gradle` com as dependências PostgreSQL no buildscript.

### Configuração atual
- Plugin: `org.flywaydb.flyway` 10.20.0
- Dependências no buildscript: `postgresql:42.7.4` e `flyway-database-postgresql:10.20.0`
- Schema padrão: `app`
- Credenciais padrão: `appuser/appsecret` (conforme `.env`)

### Comandos úteis
- Ver informações das migrações:
```bash
./gradlew flywayInfo
```
- Executar migrações:
```bash
./gradlew flywayMigrate
```
- Usar credenciais diferentes:
```bash
./gradlew flywayInfo -Pflyway.user=seuusuario -Pflyway.password=suasenha
```
- Limpar schema (cuidado):
```bash
./gradlew flywayClean
```

### Troubleshooting
- Certifique-se de que o Docker Compose está rodando: `docker compose up -d`
- Verifique se o banco existe e as credenciais estão corretas
- Para debug: `./gradlew flywayInfo --info --stacktrace`

## Endpoints disponíveis
Atualmente mapeados (podem evoluir):
- `POST /auth/login` — autentica e retorna um token JWT
- `POST /auth/refresh` — emite um novo token JWT a partir de um token (possivelmente expirado)
- `GET /auth/me` — informações do usuário autenticado (requer Bearer token)
- `GET /health` — status da aplicação
- `GET /usuarios` — lista usuários
- `GET /processos` — lista processos
- `GET /estabelecimentos` — lista estabelecimentos
- `GET /conselhos` — lista conselhos profissionais
- `GET /responsaveis-tecnicos` — lista responsáveis técnicos
- `GET /tipos-empresa` — lista tipos de empresa
- `GET /enderecos` — lista endereços
- `GET /acoes` — lista ações
- `GET /ordens-servico` — lista ordens de serviço
- `GET /reclamacoes` — lista reclamações
- `GET /produtocategorias` — lista categorias de produto
- `GET /produtocategorias/{id}` — busca categoria por ID
- `POST /produtocategorias` — cria categoria
- `PUT /produtocategorias/{id}` — atualiza categoria
- `DELETE /produtocategorias/{id}` — exclui categoria

### Endpoints CRUD Completos (130 Controllers)

Todos os controllers possuem operações CRUD completas com documentação OpenAPI:

**Padrão de Endpoints:**
- `GET /{resource}` — lista todos os recursos
- `GET /{resource}/{id}` — busca recurso por ID
- `POST /{resource}` — cria novo recurso
- `PUT /{resource}/{id}` — atualiza recurso existente
- `DELETE /{resource}/{id}` — exclui recurso

**Controllers com CRUD Completo:**
- `/acoes` — Ações de vigilância sanitária
- `/administrativos` — Dados administrativos
- `/agrupamentos` — Agrupamentos
- `/alvaras` — Alvarás sanitários
- `/analiseprocessos` — Análises de processo
- `/apreensoes` — Apreensões
- `/areainspecao` — Áreas de inspeção
- `/arquitetonicos` — Dados arquitetônicos
- `/arquivodocumentos` — Arquivos de documento
- `/assuntosolicitacoes` — Assuntos de solicitação
- `/atividadefiscais` — Atividades fiscais
- `/atividadevigilancias` — Atividades de vigilância
- `/autoinfracoes` — Autoinfrações
- `/autonotificacoes` — Autonotificações
- `/baixas` — Baixas
- `/bpas` — BPAs (Boletim de Produção Ambulatorial)
- `/categorias` — Categorias
- `/conselhos` — Conselhos profissionais
- `/cupomauto` — Cupons de auto
- `/documentos` — Documentos
- `/embalagens` — Embalagens
- `/enderecos` — Endereços
- `/estabelecimentos` — Estabelecimentos
- `/fabris` — Dados fabris
- `/fiscais` — Fiscais
- `/fiscaladms` — Fiscais administrativos
- `/galerias` — Galerias
- `/geraauto` — Geradores de auto
- `/geraprodis` — Geradores de PRODI
- `/grupos` — Grupos
- `/licencias` — Licenças
- `/licenciamentos` — Licenciamentos
- `/mensagens` — Mensagens
- `/motivos` — Motivos
- `/permissoes` — Permissões
- `/processos` — Processos administrativos
- `/prodis` — PRODIs
- `/produtos` — Produtos
- `/produtocategorias` — Categorias de produto
- `/reclamacoes` — Reclamações
- `/responsaveis-tecnicos` — Responsáveis técnicos
- `/resposta` — Respostas
- `/roteiros` — Roteiros de inspeção
- `/saudes` — Dados de saúde
- `/servicos` — Serviços
- `/subgrupos` — Subgrupos
- `/tabelas` — Tabelas
- `/tipos-empresa` — Tipos de empresa
- `/tramitacoes` — Tramitações
- `/unidades-medida` — Unidades de medida
- `/usuarios` — Usuários
- `/veiculos` — Veículos

**Controllers Somente Leitura:**
- `/logs` — Lista de logs
- `/foruns` — Lista de fóruns
- `/sintomas` — Lista de sintomas
- `/timelines` — Lista de timelines
- `/ordens-servico` — Lista de ordens de serviço

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
    ```java
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
