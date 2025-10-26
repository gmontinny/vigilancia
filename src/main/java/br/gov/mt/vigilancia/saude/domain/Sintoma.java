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
@Table(name = "sintomas")
public class Sintoma {

    @Id
    @SequenceGenerator(name = "sintomas_idsintomas_seq", sequenceName = "sintomas_idsintomas_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sintomas_idsintomas_seq")
    private Integer id;

    @NotBlank(message = "Descrição do sintoma é um campo obrigatório!")
    @Size(min = 5, message = "Descrição do sintoma deve ter no mínimo 5 caracteres!")
    private String descricao;
}
