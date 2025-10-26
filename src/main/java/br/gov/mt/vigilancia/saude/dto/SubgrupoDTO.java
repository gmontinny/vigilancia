package br.gov.mt.vigilancia.saude.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubgrupoDTO {
    private Integer id;
    private String nome;
    private Integer idGrupo;
}
