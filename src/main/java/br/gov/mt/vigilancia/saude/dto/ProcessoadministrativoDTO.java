package br.gov.mt.vigilancia.saude.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProcessoadministrativoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idprocessoadministrativo;
    private Date dataprocesso;
    private Date dataciencia;
    private Integer indicadorcontrarazao;
    private Integer numeroauto;
    private String numprocesso;
    private String textorazao;
    private String textoresposta;
    private String processogerado;
    private Integer tiporesultado;
    private Integer fiscalresponsavel;
    private Integer fiscalcontraresposta;
    private Integer tiposituacao;
}
