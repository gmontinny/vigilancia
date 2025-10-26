package br.gov.mt.vigilancia.saude.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnaliseprocessoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idanaliseprocesso;
    private String autorizacaoanaliseprocesso;
    private Integer statusanaliseprocesso;
    private String textoanaliseprocesso;
    // Assuming Processo will be handled separately or by ID in DTOs if needed
}
