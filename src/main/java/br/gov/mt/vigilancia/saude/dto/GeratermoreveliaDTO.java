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
public class GeratermoreveliaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idtermorevelia;
    private Date datarevelia;
    private Time horarevelia;
    private Integer numeroauto;
}
