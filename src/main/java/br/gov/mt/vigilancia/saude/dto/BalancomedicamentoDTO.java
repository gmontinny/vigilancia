package br.gov.mt.vigilancia.saude.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BalancomedicamentoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idbalanco;
    private Integer bmpoanual;
    private Integer bmpotrimestral;
    private Integer bspoanual;
    private Integer bspotrimestral;
    private Date dataentrega;
    private Integer livroreceituario;
    private Integer mesreferencia;
    private Integer qtdareceitaa;
    private Integer qtdareceitab;
    private Integer rmnramensal;
    private Integer rmnrb2mensal;
    private Integer rmvmensal;
    private Integer statusbalanco;
    private String textobalanco;
    private Integer trimestrebmpo;
    private Integer trimestrebspo;
    private Integer idusuario;
    private Integer balancoanual;
    private String entregador;
    private Long idestabelecimento;
}
