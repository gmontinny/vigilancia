package br.gov.mt.vigilancia.saude.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItensexiberoteiroDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer iditensexiberoteiro;
    private Integer atende;
    private Integer atendeparcialmente;
    private Integer idexiberoteiro;
    private Integer iditensroteiro;
    private Integer naoatende;
    private Integer naoseaplica;
    private Integer numeroauto;
}
