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
public class TramitacaoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idtramitacao;
    private Date datafinal;
    private Date datainicial;
    private Date dataresposta;
    private String usuarioresposta;
    private Time horatramitacao;
    private Integer tipocolheita;
    private Integer tipoauto;
    private Integer tiponotificacao;
    private Integer tipoarquitetonico;
    private Integer tipoadministrativo;
    private Integer tipooperacao;
    private Integer prioridadetramite;
    private Integer numerotramitacao;
    private Integer statustramitacao;
    private Integer situacaotramitacao;
    private Integer leutramitacao;
    private String textotramitacao;
    private String textoresposta;
    private Integer idordemservico;
    private Integer idtipoinspecao;
}
