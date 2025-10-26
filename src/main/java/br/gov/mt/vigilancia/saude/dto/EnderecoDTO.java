package br.gov.mt.vigilancia.saude.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EnderecoDTO {
    private Integer id;
    private String bairro;
    private String cep;
    private String complemento;
    private String logradouro;
    private Integer numero;
    private String longitude;
    private String latitude;
    private Integer idUsuario;
}
