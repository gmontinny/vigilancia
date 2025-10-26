package br.gov.mt.vigilancia.saude.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BpaDTO {
    private Integer id;
    private String descricao;
}
