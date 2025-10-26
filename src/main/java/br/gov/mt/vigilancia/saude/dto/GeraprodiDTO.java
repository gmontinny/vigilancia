package br.gov.mt.vigilancia.saude.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GeraprodiDTO {
    private Integer idGeraprodi;
    private Date dataProdi;
    private Time horaProdi;
    private Integer idUsuario;
    private Integer statusProdi;
}
