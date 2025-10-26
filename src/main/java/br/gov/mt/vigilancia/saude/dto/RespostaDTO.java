package br.gov.mt.vigilancia.saude.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class RespostaDTO {
    private Integer id;
    private LocalDateTime dataResposta;
    private Integer idForum;
    private String textoResposta;
}
