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
public class ArquivodocumentoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idarquivo;
    private Date dataarquivo;
    private Time horaarquivo;
    private String nomearquivo;
    private String tamanhoarquivo;
    private String usuarioarquivo;
    private String tipoarquivo;
    private String nomeoriginal;
    private Integer statusarquivo;
    private String textoarquivo;
    private String nomeeditado;
    private String numprocesso;
}
