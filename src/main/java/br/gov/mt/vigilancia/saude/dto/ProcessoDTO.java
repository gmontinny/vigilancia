package br.gov.mt.vigilancia.saude.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ProcessoDTO {

    private String numeroProcesso;
    private LocalDate dataEntrada;
    private Integer status;
    private Integer resultado;
    private String observacao;
    private String enderecoArquitetonico;
    private Integer idUsuario;

}
