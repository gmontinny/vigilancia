# Lista completa de Endpoints

Esta seção complementa o README principal com a listagem dos endpoints expostos pela API. Para exploração interativa e sempre atualizada, utilize o Swagger UI.

- Swagger UI: http://localhost:8081/swagger-ui/index.html
- OpenAPI JSON: http://localhost:8081/v3/api-docs

## Padrão de Endpoints CRUD

- `GET /{resource}` — lista todos os recursos
- `GET /{resource}/{id}` — busca recurso por ID
- `POST /{resource}` — cria novo recurso
- `PUT /{resource}/{id}` — atualiza recurso existente
- `DELETE /{resource}/{id}` — exclui recurso

## Grupos principais

- Autenticação: `/auth/login`, `/auth/refresh`, `/auth/me`
- Usuários: `/usuarios` (CRUD)
- 2FA TOTP: `/usuarios/{id}/totp/register`, `/usuarios/{id}/totp/verify`, `/usuarios/{id}/totp/disable`

## Controllers com CRUD (amostra)

Observação: a lista completa pode ser consultada no Swagger UI. Abaixo uma amostra dos domínios mapeados:

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

## Somente leitura (amostra)

- `/logs` — Lista de logs
- `/foruns` — Lista de fóruns
- `/sintomas` — Lista de sintomas
- `/timelines` — Lista de timelines
- `/ordens-servico` — Lista de ordens de serviço

Para a lista completa com descrições, parâmetros e exemplos, consulte o Swagger UI.
