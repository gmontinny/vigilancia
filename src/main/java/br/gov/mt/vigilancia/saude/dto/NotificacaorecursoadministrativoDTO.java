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
public class NotificacaorecursoadministrativoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idrecursoadministrativo;
    private Date datarecursoadministrativo;
    private Time horarecursoadministrativo;
    private String textorecursoadministrativo;
    private String coordenador;
    private String assinatura;
}
