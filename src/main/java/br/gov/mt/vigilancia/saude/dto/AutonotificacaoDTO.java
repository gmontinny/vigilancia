package br.gov.mt.vigilancia.saude.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutonotificacaoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idautonotificacao;
    private String descricaonotificacao;
    private Integer prazo;
    private Integer idtramitacao;
}
