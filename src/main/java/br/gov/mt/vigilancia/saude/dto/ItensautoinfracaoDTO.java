package br.gov.mt.vigilancia.saude.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItensautoinfracaoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer iditensautoinfracao;
    private Integer numeroauto;
    private String valoritens;
    private String textoitens;
    private String tiporisco;
    private Integer idlegislacao;
}
