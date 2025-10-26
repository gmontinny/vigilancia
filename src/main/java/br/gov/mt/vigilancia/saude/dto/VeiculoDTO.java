package br.gov.mt.vigilancia.saude.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VeiculoDTO {
    private Integer id;
    private String chassi;
    private String placa;
    private String numeroProcesso;
    private String placaCaminhao;
    private String chassiCaminhao;
    private Integer idCategoria;
    private Integer idEstabelecimento;
}
