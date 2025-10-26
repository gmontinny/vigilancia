package br.gov.mt.vigilancia.saude.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DocumentoDTO {
    private Integer id;
    private String descricao;
    private Integer restricao;
    // private List<DocnecessarioDTO> docNecessarios;
}
