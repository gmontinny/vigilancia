package br.gov.mt.vigilancia.saude.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificacaousuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idnotificacaousuario;
    private Integer idusuario;
    private Integer numerodocumento;
}
