package br.gov.mt.vigilancia.saude.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponsavelTecnicoDTO {
    private Integer id;
    private String nome;
    private String cpf;
    private String numeroConselho;
    private Integer idConselho;
}
