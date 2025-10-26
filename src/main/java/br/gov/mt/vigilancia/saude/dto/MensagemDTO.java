package br.gov.mt.vigilancia.saude.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class MensagemDTO {
    private Integer id;
    private LocalDate dataMensagem;
    private String de;
    private String para;
    private Integer status;
    private String texto;
    private Integer idUsuario;
    private Integer idOrdemServico;
}
