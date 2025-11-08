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
public class GeratramiteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idgeratramite;
    private Date dtgeratramite;
    private Time hrgeratramite;
}
