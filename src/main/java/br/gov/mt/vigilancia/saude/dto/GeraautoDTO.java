package br.gov.mt.vigilancia.saude.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class GeraautoDTO {
    private Integer id;
    private LocalDate dataGeraauto;
    private LocalTime horaGeraauto;
    private Integer idUsuario;
    private Integer status;
    private String numeroProcesso;
    private String tipoPenalidade;
    private String valor;
    private Integer grauInfracao;
    private Integer idTramitacao;
}
