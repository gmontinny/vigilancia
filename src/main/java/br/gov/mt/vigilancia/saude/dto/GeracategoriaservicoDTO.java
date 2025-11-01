package br.gov.mt.vigilancia.saude.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeracategoriaservicoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idgeracategoriaservico;
    private Date datacategoriaservico;
    private Integer idusuario;
    private Integer status;
}
