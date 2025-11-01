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
public class GeragaleriaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idgeragaleria;
    private Date datageragaleria;
    private Time horageragaleria;
    private Integer idusuario;
    private Integer statusgeragaleria;
}
