package br.gov.mt.vigilancia.saude.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdemServicoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idordemservico;
    private Date datafinal;
    private Date datainicial;
    private Date dataordemservico;
    private Date dataconclusao;
    private String usuarioconclusao;
    private Integer situacaoordemservico;
    private String textoconclusao;
    private String textoproblema;
    private Integer prioridadeordemservico;
    private Integer tlsordemservico;
    private Integer tipoordemservico;
    private Time horaordemservico;
    private String tipodocumento;
    private String descricaodocumento;
    private Integer idacao;
    private String numprocesso;
    private List<ReclamacaoDTO> reclamacaos;

    public void setIdordemservico(Integer id) {
        this.idordemservico = id;
    }
}
