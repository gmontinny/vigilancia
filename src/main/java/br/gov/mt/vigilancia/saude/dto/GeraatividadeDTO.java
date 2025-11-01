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
public class GeraatividadeDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idgeraatividade;
    private Date dataatividade;
    private Time horaatividade;
    private Integer idusuario;
    private Integer statusgeraatividade;
}
