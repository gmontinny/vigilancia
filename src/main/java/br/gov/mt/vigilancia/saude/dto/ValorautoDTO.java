package br.gov.mt.vigilancia.saude.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValorautoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idvalorauto;
    private Integer grauinfracao;
    private String valor;
    private String valorminimo;
}
