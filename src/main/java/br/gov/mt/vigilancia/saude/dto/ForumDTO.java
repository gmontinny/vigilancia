package br.gov.mt.vigilancia.saude.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ForumDTO {
    private Integer id;
    private LocalDateTime dataHora;
    private Integer idOrdemServico;
    private String textoForum;
    private String textoUsuario;
    private Integer statusForum;
    private Integer idUsuario;
}
