package br.gov.mt.vigilancia.saude.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CupomautoDTO {
    private Integer id;
    private String descConformidade;
    private String descPorte;
    private Integer numeroAuto;
    private String valorConformidade;
    private String valorGerado;
    private String valorPorte;
    private Integer numeroConformidade;
    private Integer percConformidade;
    private Integer percPorte;
}
