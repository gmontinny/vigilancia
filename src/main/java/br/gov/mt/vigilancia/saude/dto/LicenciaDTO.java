package br.gov.mt.vigilancia.saude.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class LicenciaDTO {
    private Integer id;
    private LocalDate dataLicencia;
    private LocalDate dataVencimento;
    private Integer qtImpresso;
    private String observacao;
    private Integer idVeiculo;
    private Integer status;
}
