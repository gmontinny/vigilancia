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
@Table(name = "conselho")
public class Conselho {

    @Id
    @SequenceGenerator(name = "conselho_idconselho_seq", sequenceName = "conselho_idconselho_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "conselho_idconselho_seq")
    private Integer id;

    @NotBlank(message = "Nome é um campo obrigatório!")
    @Size(min = 3, message = "Nome deve ter no mínimo 3 caracteres!")
    private String nome;
}
