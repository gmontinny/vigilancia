package br.gov.mt.vigilancia.saude.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocalizacaoarquivoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idlocalizacaoarquivo;
    private String numprocesso;
    private Integer tipolocalizacao;
    private Integer prateleira;
}
