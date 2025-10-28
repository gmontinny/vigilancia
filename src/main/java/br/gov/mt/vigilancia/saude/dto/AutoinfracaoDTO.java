package br.gov.mt.vigilancia.saude.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutoinfracaoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idautoinfracao;
    private Date dataautoinfracao;
    private Integer grauinfracaoautoinfracao;
    private String textoautoinfracao;
    private Integer gerainterdicao;
    private Integer numeroauto;
    private Integer geraadvertencia;
    private Integer geramulta;
    private String valormulta;
    private String termoadvertencia;
    private String termointerdicao;
    private String textointerdicao;
    private String tipoinfracao;
    private Integer idtramitacao;
}
