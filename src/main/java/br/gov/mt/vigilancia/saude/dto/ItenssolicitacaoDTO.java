package br.gov.mt.vigilancia.saude.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItenssolicitacaoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer iditenssolicitacao;
    private String nomeitenssolicitacao;
    private Integer restritoitenssolicitacao;
    private Integer idsolicitacao;
}
