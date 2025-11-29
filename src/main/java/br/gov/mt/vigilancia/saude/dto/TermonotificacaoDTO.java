package br.gov.mt.vigilancia.saude.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TermonotificacaoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idtermonotificacao;
    private Date datanotificacao;
    private Time horanotificacao;
    private Long idestabelecimento;
    private Integer numerotramitacao;
    private String textonotificacao;
    private Integer diasnotificacao;
}
