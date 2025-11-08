package br.gov.mt.vigilancia.saude.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItensembalagemDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer iditensembalagem;
    private Integer idembalagem;
    private Long idestabelecimento;
    private Integer numeroprodi;
    private Integer numeroitensprodi;
}
