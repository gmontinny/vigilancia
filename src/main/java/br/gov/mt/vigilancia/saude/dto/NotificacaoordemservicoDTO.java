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
public class NotificacaoordemservicoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idnotificacaoordemservico;
    private Date datanotificacaoordemservico;
    private Time horanotificacaooredemservico;
    private Integer idordemservico;
    private Long idusuario;
    private Integer statusordemservico;
}
