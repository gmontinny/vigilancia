package br.gov.mt.vigilancia.saude.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FabrilDTO {
    private Integer id;
    private String bairro;
    private String cep;
    private String cnpj;
    private String email;
    private String fone;
    private String municipio;
    private Integer numero;
    private String razaoSocial;
    private String rua;
    private Integer tipoFabril;
    private String uf;
}
