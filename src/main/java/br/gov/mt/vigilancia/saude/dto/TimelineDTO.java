package br.gov.mt.vigilancia.saude.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class TimelineDTO {
    private Integer id;
    private LocalDate dataTimeline;
    private Integer idUsuario;
    private Integer situacao;
    private String texto;
    private String numeroProcesso;
    private String tipoSituacao;
    private LocalTime horaTimeline;
}
