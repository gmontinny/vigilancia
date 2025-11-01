package br.gov.mt.vigilancia.saude.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FarmaceuticoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idfarmaceuticos;
    private Integer administracaofarmaceuticos;
    private Integer afericaofarmaceuticos;
    private Integer atencaofarmaceuticos;
    private Integer entregafarmaceuticos;
    private Integer inalacaofarmaceuticos;
    private Integer perfuracaofarmaceuticos;
    private String quaisfarmaceuticos;
    private String numprocesso;
}
