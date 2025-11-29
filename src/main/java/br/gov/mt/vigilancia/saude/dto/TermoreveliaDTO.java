package br.gov.mt.vigilancia.saude.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TermoreveliaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idtermorevelia;
    private String coordenadorresponsavel;
    private String imagemassinatura;
    private String textorevelia;
}
