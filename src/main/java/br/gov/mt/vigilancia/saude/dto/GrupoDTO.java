package br.gov.mt.vigilancia.saude.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GrupoDTO {
    private Integer id;
    private String nome;
    private List<SubgrupoDTO> subgrupos;
}
