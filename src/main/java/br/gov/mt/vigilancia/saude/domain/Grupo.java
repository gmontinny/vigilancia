package br.gov.mt.vigilancia.saude.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "grupo")
public class Grupo {

    @Id
    @SequenceGenerator(name = "grupo_idgrupo_seq", sequenceName = "grupo_idgrupo_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "grupo_idgrupo_seq")
    private Integer id;

    @NotBlank(message = "Nome do grupo é um campo obrigatório!")
    @Size(min = 5, message = "Nome do grupo deve ter no mínimo 5 caracteres!")
    private String nome;

    @OneToMany(mappedBy = "grupo")
    private List<Subgrupo> subgrupos;
}
