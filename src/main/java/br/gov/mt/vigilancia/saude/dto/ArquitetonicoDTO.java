package br.gov.mt.vigilancia.saude.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArquitetonicoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idarquitetonicos;
    private Date dataanalisearquitetonicos;
    private Integer situacaoarquitetonicos;
    private Integer numerotramitacao;
    private Integer analisearquitetonico;
    private String textoarquitetonico;
}
