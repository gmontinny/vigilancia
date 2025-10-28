package br.gov.mt.vigilancia.saude.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItensroteiroDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer iditensroteiro;
    private Integer numeroroteiro;
    private Integer idlegislacao755;
    private Integer gerainfracao;
    private Integer criticidade;
    private String descricaoitensroteiro;
    private Integer idcategoriaroteiro;
    private Integer idlegislacao;
}
