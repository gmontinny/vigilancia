package br.gov.mt.vigilancia.saude.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class EstabelecimentoDTO {

    private Integer id;
    private String razaoSocial;
    private String nomeFantasia;
    private String cnpj;
    private String email;
    private String telefone;
    private String celular;
    private String cep;
    private String endereco;
    private Integer numero;
    private String bairro;
    private Integer idUsuario;
    private Integer idResponsavelTecnico;
    private Integer idTipoEmpresa;

}
