package br.gov.mt.vigilancia.saude.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItenscategoriaservicoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer iditenscategoriaservico;
    private String descitenscategoriaservico;
    private Integer numeroservico;
}
