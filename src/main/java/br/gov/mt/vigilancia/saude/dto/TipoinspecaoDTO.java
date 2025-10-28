package br.gov.mt.vigilancia.saude.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoinspecaoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idtipoinspecao;
    private String descricaotipoinspecao;
    private Integer analiseprocesso;
    private Integer autoinfracao;
    private Integer notificacao;
    private Integer colheita;
    private Integer arquitetonico;
    private Integer administrativo;
}
