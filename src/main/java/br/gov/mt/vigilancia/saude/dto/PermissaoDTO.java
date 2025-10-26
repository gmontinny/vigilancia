package br.gov.mt.vigilancia.saude.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PermissaoDTO {
    private Integer id;
    private Integer deletePermissao;
    private Integer insertPermissao;
    private Integer selectPermissao;
    private Integer updatePermissao;
    private Integer idTabela;
    private Integer idUsuario;
}
