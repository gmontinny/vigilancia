package br.gov.mt.vigilancia.saude.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class GaleriaDTO {
    private Integer id;
    private String capa;
    private LocalDate dataGaleria;
    private LocalTime horaGaleria;
    private Integer sequencia;
    private String titulo;
}
