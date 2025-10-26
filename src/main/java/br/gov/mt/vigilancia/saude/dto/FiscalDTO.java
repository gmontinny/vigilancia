package br.gov.mt.vigilancia.saude.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FiscalDTO {
    private Integer id;
    private Integer status;
    private Integer numeroTramitacao;
    private Integer responsavelFiscal;
    private Integer totalNotificacao;
    private Integer idUsuario;
}
