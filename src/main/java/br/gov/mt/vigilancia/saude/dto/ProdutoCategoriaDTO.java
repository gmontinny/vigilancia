package br.gov.mt.vigilancia.saude.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProdutoCategoriaDTO {
    private Integer id;
    private String nome;
}
