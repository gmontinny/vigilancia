package br.gov.mt.vigilancia.saude.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class AlvaraDTO {
    private Integer id;
    private LocalDate dataAlvara;
    private LocalDate dataVencimento;
    private Integer qtImpresso;
    private String numeroProcesso;
    private Integer tipoAlvara;
    private Integer statusAlvara;
    private Integer idEstabelecimento;
}
