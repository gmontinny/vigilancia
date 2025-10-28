package br.gov.mt.vigilancia.saude.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DespachocontrarazaoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer iddespachocontrarazao;
    private String gerenteresponsavel;
    private String imagemassinatura;
    private String textodespacho;
}
