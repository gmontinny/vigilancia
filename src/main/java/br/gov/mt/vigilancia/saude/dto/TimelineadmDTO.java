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
public class TimelineadmDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idtimelineadm;
    private Date data;
    private Time hora;
    private String numprocesso;
    private String processogerado;
    private String situacao;
}
