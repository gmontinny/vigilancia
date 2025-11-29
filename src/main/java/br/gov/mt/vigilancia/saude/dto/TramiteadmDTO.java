package br.gov.mt.vigilancia.saude.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TramiteadmDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idtramiteadm;
    private Date datafinal;
    private Date datainicial;
    private Integer idusuario;
    private Integer numerotramiteadm;
    private String numprocesso;
    private String situacao;
    private Integer status;
    private Integer numeroauto;
}
