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
public class UploadnecessarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer iduploadnecessario;
    private Date dataupload;
    private String documentoupload;
    private Time horaupload;
    private String numprocesso;
    private Integer validacaoupload;
    private Integer situacaoupload;
    private String textoupload;
    private Integer iddocnecessario;
}
