package br.gov.mt.vigilancia.saude.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProdiDTO {
    private Integer id;
    private String cnpjEmpresa;
    private String cnpjFabricante;
    private String numeroProcesso;
    private Integer numeroProdi;
}
