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
@Table(name = "roteiro", schema = "app")
public class Roteiro {

    @Id
    @SequenceGenerator(name = "roteiro_idroteiro_seq", sequenceName = "app.roteiro_idroteiro_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roteiro_idroteiro_seq")
    private Integer id;

    @NotBlank(message = "Descrição do roteiro é um campo obrigatório!")
    private String descricao;

    private Integer situacao;

    // Relacionamento com Montarroteiro será adicionado posteriormente
    // @OneToMany(mappedBy = "roteiro")
    // private List<Montarroteiro> montarRoteiros;
}
