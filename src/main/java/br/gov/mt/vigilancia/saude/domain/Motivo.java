package br.gov.mt.vigilancia.saude.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
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
@Table(name = "motivo")
public class Motivo {

    @Id
    @SequenceGenerator(name = "motivo_idmotivo_seq", sequenceName = "motivo_idmotivo_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "motivo_idmotivo_seq")
    private Integer id;

    @NotBlank(message = "Descrição do motivo é um campo obrigatório!")
    @Size(min = 5, message = "Descrição do motivo deve ter no mínimo 5 caracteres!")
    private String descricao;

    // Relacionamento com Termocolheita será adicionado posteriormente
    // @OneToMany(mappedBy = "motivo")
    // private List<Termocolheita> termocolheitas;
}
