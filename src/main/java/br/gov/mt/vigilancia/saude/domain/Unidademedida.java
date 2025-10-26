package br.gov.mt.vigilancia.saude.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "unidademedida")
public class Unidademedida {

    @Id
    @SequenceGenerator(name = "unidademedida_idunidademedida_seq", sequenceName = "unidademedida_idunidademedida_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unidademedida_idunidademedida_seq")
    private Integer id;

    @NotBlank(message = "Descrição da unidade é um campo obrigatório!")
    private String descricao;

    @NotBlank(message = "Sigla da unidade é um campo obrigatório!")
    private String sigla;

    // Relacionamento com Apreensao será adicionado posteriormente
    // @OneToMany(mappedBy = "unidademedida")
    // private List<Apreensao> apreensoes;
}
