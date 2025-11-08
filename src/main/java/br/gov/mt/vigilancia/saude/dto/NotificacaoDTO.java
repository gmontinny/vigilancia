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
public class NotificacaoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idnotificacao;
    private Date datanotificacao;
    private Integer statusnotificacao;
    private String denotificacao;
    private String paranotificacao;
    private String mensagemnotificacao;
    private Integer totalnotificacao;
    private Time horanotificacao;
    private Long idusuario;
}
