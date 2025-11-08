package br.gov.mt.vigilancia.saude.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItensdocumentoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer iditensdocumento;
    private String nomearquivo;
    private Integer numerodocumento;
    private String oldarquivo;
    private String tipoarquivo;
    private Integer status;
}
