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
public class GeracodigocertificacaoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idcodigocertificacao;
    private Date datacertificacao;
    private Time horacertificacao;
    private String chavecertificacao;
}
