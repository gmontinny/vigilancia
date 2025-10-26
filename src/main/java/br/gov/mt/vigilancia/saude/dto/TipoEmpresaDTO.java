package br.gov.mt.vigilancia.saude.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TipoEmpresaDTO {
    private Integer id;
    private String descricao;
    private String sigla;
}
