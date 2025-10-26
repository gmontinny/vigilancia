package br.gov.mt.vigilancia.saude.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tabela")
public class Tabela {

    @Id
    @SequenceGenerator(name = "tabela_idtabelas_seq", sequenceName = "tabela_idtabelas_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tabela_idtabelas_seq")
    private Integer id;

    @NotBlank(message = "Nome da tabela é um campo obrigatório!")
    private String nome;

    @NotBlank(message = "Descrição da tabela é um campo obrigatório!")
    private String descricao;

    @NotNull(message = "Ordem da tabela é um campo obrigatório!")
    private Integer ordem;
}
