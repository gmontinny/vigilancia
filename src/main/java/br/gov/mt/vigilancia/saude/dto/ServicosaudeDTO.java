package br.gov.mt.vigilancia.saude.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicosaudeDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idservicosaude;
    private Integer numeroservico;
    private Integer idagrupamento;
    private Integer idcategoriaservico;
    private Integer idcategoriaanalise;
}
