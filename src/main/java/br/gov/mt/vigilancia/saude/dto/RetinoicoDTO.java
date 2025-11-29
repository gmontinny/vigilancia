package br.gov.mt.vigilancia.saude.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RetinoicoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idretinoico;
    private Integer statusretinoico;
    private Date dataretinoico;
    private String numprocesso;
    private Integer tiporetinoico;
}
