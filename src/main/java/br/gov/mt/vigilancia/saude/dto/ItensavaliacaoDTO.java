package br.gov.mt.vigilancia.saude.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItensavaliacaoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer iditensavaliacao;
    private Date datafinal;
    private Date datarecebimento;
    private Integer prazo;
    private Integer responsavel;
    private Integer status;
    private String texto;
    private Integer idgestaodocumento;
}
