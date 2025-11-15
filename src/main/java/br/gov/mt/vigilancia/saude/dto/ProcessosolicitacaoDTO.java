package br.gov.mt.vigilancia.saude.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProcessosolicitacaoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idprocessosolicitacao;
    private String numprocesso;
    private Integer iditenssolicitacao;
}
