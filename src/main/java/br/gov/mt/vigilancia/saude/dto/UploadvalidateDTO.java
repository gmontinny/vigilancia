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
public class UploadvalidateDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer iduploadvalidate;
    private Date dataupload;
    private String documentoupload;
    private Time horaupload;
    private Integer iddocnecessario;
    private String numprocesso;
    private Integer situacaoupload;
    private String textoupload;
    private Integer validacaoupload;
}
