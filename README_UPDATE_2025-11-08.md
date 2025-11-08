# Atualização 2025-11-08

Este arquivo registra decisões e diretrizes aplicadas hoje para evitar retrabalho em futuras correções.

## Diretriz confirmada: NÃO criar migração apenas para “renomear” coluna/tabela
- Quando o objetivo é apenas compatibilizar nomes entre Java e banco legado, usar mapeamento por anotações nas entidades.
- Migrações (Flyway) só para mudanças estruturais necessárias (criar tabela nova, coluna nova funcional, índices, FKs inexistentes, seed de dados, etc.).

### Como proceder (checklist)
1. Ajustar a entidade com o nome exato da tabela e schema:
   - `@Table(schema = "app", name = "...")`.
2. Ajustar cada atributo com o nome real da coluna:
   - `@Column(name = "snake_case_no_banco", length = X, nullable = Y)`.
3. Ajustar FKs com o nome correto da coluna:
   - `@JoinColumn(name = "id_fk_no_banco")`.
4. Ajustar sequence e allocation size para refletir o banco legado:
   - `@SequenceGenerator(sequenceName = "app.minha_sequence", allocationSize = 1)`.
5. Validar startup; se aparecer “missing column/table”, repetir os passos 1–3 para o(s) campo(s) citados.

### Exemplo aplicado: OrdemServico
- Tabela real: `app.ordemservico`.
- Anotações aplicadas em `OrdemServico.java`:
  - `@Table(name = "ordemservico", schema = "app")`.
  - `@Column(name = "data_conclusao")`, `@Column(name = "data_ordem_servico")`, `@Column(name = "usuario_conclusao")`, etc.
  - `@JoinColumn(name = "idacao")` e `@JoinColumn(name = "numprocesso")`.
  - `@SequenceGenerator(sequenceName = "app.ordemservico_idordemservico_seq", allocationSize = 1)`.

## Nota sobre V28
- A V28 permanece apenas para casos onde as tabelas de fato não existam. Quando a estrutura já existe, o alinhamento deve ser feito via anotações, não por renomeação em SQL.
