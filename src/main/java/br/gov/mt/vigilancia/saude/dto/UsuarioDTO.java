package br.gov.mt.vigilancia.saude.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UsuarioDTO {
    private Integer id;
    private String nome;
    private String cpf;
    private String email;
    private String celular;
    private String imagem;
    private Integer tipo;
    private Integer status;
    private List<EnderecoDTO> enderecos;
    private List<FiscalDTO> fiscais;
    private List<PermissaoDTO> permissoes;
}
