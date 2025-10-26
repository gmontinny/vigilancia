package br.gov.mt.vigilancia.saude.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "subgrupo")
public class Subgrupo {

    @Id
    @SequenceGenerator(name = "subgrupo_idsubgrupo_seq", sequenceName = "subgrupo_idsubgrupo_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subgrupo_idsubgrupo_seq")
    private Integer id;

    @NotBlank(message = "Nome do subgrupo é um campo obrigatório!")
    @Size(min = 5, message = "Nome do subgrupo deve ter no mínimo 5 caracteres!")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "idgrupo")
    @NotNull(message = "Grupo é um campo obrigatório!")
    private Grupo grupo;
}
