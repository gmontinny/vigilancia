package br.gov.mt.vigilancia.saude.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentoerradoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer iddocumentoerrado;
    private Date datadocumentoerrado;
    private Time horadocumentoerrado;
    private String arquivodocumentoerrado;
    private Integer iduploadnecessario;
}
