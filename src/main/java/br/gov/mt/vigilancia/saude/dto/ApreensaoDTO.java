package br.gov.mt.vigilancia.saude.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ApreensaoDTO {
    private Integer id;
    private Integer descarte;
    private String marca;
    private Integer numeroAuto;
    private Integer quantidade;
    private String produto;
    private String localDescarte;
    private LocalDate validade;
    private String lote;
    private String volume;
    private LocalDate dataFabricante;
    private Integer idUnidadeMedida;
}
