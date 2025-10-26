package br.gov.mt.vigilancia.saude.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class LogDTO {
    private Integer id;
    private LocalDate dataLog;
    private LocalTime horaLog;
    private Integer idUsuario;
}
