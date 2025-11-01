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
- Alinhamento de schema:
  - Hibernate valida no schema `app` via `spring.jpa.properties.hibernate.default_schema=${DB_SCHEMA:app}`.
  - Flyway migra no schema `app` via `spring.flyway.default-schema`/`schemas`.
  - Opcional: acrescente `?currentSchema=app` na URL JDBC para ambientes que não respeitam o `search_path`.
- Para criar uma nova versão, adicione um arquivo `V{N}__sua_descricao.sql` seguindo a sequência numérica e rode a aplicação.

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
- `GET /produtos-categoria` — lista categorias de produto
- `GET /fiscais` — lista fiscais
- `GET /tabelas` — lista tabelas
- `GET /permissoes` — lista permissões
- `GET /logs` — lista de logs
- `GET /bpas` — lista de BPAs
- `GET /baixas` — lista de baixas
- `GET /grupos` — lista de grupos
- `GET /subgrupos` — lista de subgrupos
- `GET /alvaras` — lista de alvarás
- `GET /fabris` — lista de fabris
- `GET /motivos` — lista de motivos
- `GET /foruns` — lista de fóruns
- `GET /prodis` — lista de prodis
- `GET /saudes` — lista de saúdes
- `GET /produtos` — lista de produtos
- `GET /galerias` — lista de galerias
- `GET /roteiros` — lista de roteiros
- `GET /servicos` — lista de serviços
- `GET /sintomas` — lista de sintomas
- `GET /categorias` — lista de categorias
- `GET /veiculos` — lista de veículos
- `GET /licencias` — lista de licenças
- `GET /mensagens` — lista de mensagens
- `GET /timelines` — lista de timelines
- `GET /unidades-medida` — lista de unidades de medida
- `GET /apreensoes` — lista de apreensões
- `GET /cupomauto` — lista de cupons de auto
- `GET /documentos` — lista de documentos
- `GET /geraauto` — lista de geraautos
- `GET /resposta` — lista de respostas
- `GET /embalagens` — lista de embalagens
- `GET /embalagens/{id}` — busca embalagem por ID
- `POST /embalagens` — cria nova embalagem
- `PUT /embalagens/{id}` — atualiza embalagem existente
- `DELETE /embalagens/{id}` — deleta embalagem
- `GET /fiscaladms` — lista de fiscaladms
- `GET /fiscaladms/{id}` — busca fiscaladm por ID
- `POST /fiscaladms` — cria novo fiscaladm
- `PUT /fiscaladms/{id}` — atualiza fiscaladm existente
- `DELETE /fiscaladms/{id}` — deleta fiscaladm
- `GET /geraprodis` — lista de geraprodis
- `GET /geraprodis/{id}` — busca geraprodi por ID
- `POST /geraprodis` — cria novo geraprodi
- `PUT /geraprodis/{id}` — atualiza geraprodi existente
- `DELETE /geraprodis/{id}` — deleta geraprodi
- `GET /administrativos` — lista de administrativos
- `GET /agrupamentos` — lista de agrupamentos
- `GET /analiseprocessos` — lista de analises de processo
- `GET /areainspecao` — lista de areas de inspecao
- `GET /arquitetonicos` — lista de arquitetonicos
- `GET /licenciamentos` — lista de licenciamentos
- `GET /licenciamentos/{id}` — busca licenciamento por ID
- `POST /licenciamentos` — cria novo licenciamento
- `PUT /licenciamentos/{id}` — atualiza licenciamento existente
- `DELETE /licenciamentos/{id}` — deleta licenciamento
- `GET /arquivodocumentos` — lista de arquivos de documento
- `GET /arquivodocumentos/{id}` — busca arquivo de documento por ID
- `POST /arquivodocumentos` — cria novo arquivo de documento
- `PUT /arquivodocumentos/{id}` — atualiza arquivo de documento existente
- `DELETE /arquivodocumentos/{id}` — deleta arquivo de documento
- `GET /assuntosolicitacoes` — lista de assuntos de solicitação
- `GET /assuntosolicitacoes/{id}` — busca assunto de solicitação por ID
- `POST /assuntosolicitacoes` — cria novo assunto de solicitação
- `PUT /assuntosolicitacoes/{id}` — atualiza assunto de solicitação existente
- `DELETE /assuntosolicitacoes/{id}` — deleta assunto de solicitação
- `GET /atividadefiscais` — lista de atividades fiscais
- `GET /atividadefiscais/{id}` — busca atividade fiscal por ID
- `POST /atividadefiscais` — cria nova atividade fiscal
- `PUT /atividadefiscais/{id}` — atualiza atividade fiscal existente
- `DELETE /atividadefiscais/{id}` — deleta atividade fiscal
- `GET /atividadevigilancias` — lista de atividades de vigilância
- `GET /atividadevigilancias/{id}` — busca atividade de vigilância por ID
- `POST /atividadevigilancias` — cria nova atividade de vigilância
- `PUT /atividadevigilancias/{id}` — atualiza atividade de vigilância existente
- `DELETE /atividadevigilancias/{id}` — deleta atividade de vigilância
- `GET /autoinfracoes` — lista de autoinfrações
- `GET /autoinfracoes/{id}` — busca autoinfração por ID
- `POST /autoinfracoes` — cria nova autoinfração
- `PUT /autoinfracoes/{id}` — atualiza autoinfração existente
- `DELETE /autoinfracoes/{id}` — deleta autoinfração
- `GET /tramitacoes` — lista de tramitações
- `GET /tramitacoes/{id}` — busca tramitação por ID
- `POST /tramitacoes` — cria nova tramitação
- `PUT /tramitacoes/{id}` — atualiza tramitação existente
- `DELETE /tramitacoes/{id}` — deleta tramitação
- `GET /autonotificacoes` — lista de autonotificações
- `GET /autonotificacoes/{id}` — busca autonotificação por ID
- `POST /autonotificacoes` — cria nova autonotificação
- `PUT /autonotificacoes/{id}` — atualiza autonotificação existente
- `DELETE /autonotificacoes/{id}` — deleta autonotificação

## Build, testes e qualidade
- Compilar e rodar testes:
  ```bash
  ./gradlew clean test
  ```
- Ver relatórios de testes: `build/reports/tests/test/index.html`.

## Dicas de desenvolvimento
- Lombok: assegure-se de ter o plugin do Lombok no IDE e annotation processing habilitado.
- MapStruct: gere mapeamentos na build; erros de compilação podem apontar para mapeamentos faltantes.
- Perfis: se existirem perfis (ex.: `dev`, `prod`), ajuste as propriedades conforme o ambiente.

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

Mantido por: Equipe de Vigilância Sanitária. Atualizado em 2025-11-01.
