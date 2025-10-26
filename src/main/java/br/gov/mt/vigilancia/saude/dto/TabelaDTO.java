package br.gov.mt.vigilancia.saude.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TabelaDTO {
    private Integer id;
    private String nome;
    private String descricao;
    private Integer ordem;
}
