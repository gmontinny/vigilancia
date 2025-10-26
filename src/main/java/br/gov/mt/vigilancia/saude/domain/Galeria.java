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

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "galeria")
public class Galeria {

    @Id
    @SequenceGenerator(name = "galeria_idgaleria_seq", sequenceName = "galeria_idgaleria_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "galeria_idgaleria_seq")
    private Integer id;

    @NotBlank(message = "Capa da galeria é um campo obrigatório!")
    private String capa;

    private LocalDate dataGaleria;

    private LocalTime horaGaleria;

    private Integer sequencia;

    @NotBlank(message = "Título da galeria é um campo obrigatório!")
    private String titulo;
}
