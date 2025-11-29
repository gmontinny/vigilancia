package br.gov.mt.vigilancia.saude.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultadosegundainstanciaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idresultadosegunda;
    private Date datalancada;
    private Integer idusuario;
    private String numprocesso;
    private String tipoprocedencia;
}
