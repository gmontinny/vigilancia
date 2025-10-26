package br.gov.mt.vigilancia.saude.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class BaixaDTO {
    private Integer id;
    private LocalDate dataBaixa;
    private String numeroProcesso;
    private Integer idEstabelecimento;
    private Integer idResponsavelTecnico;
}
