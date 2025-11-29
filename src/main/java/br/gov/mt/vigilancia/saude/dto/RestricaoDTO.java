package br.gov.mt.vigilancia.saude.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestricaoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idrestricao;
    private Date datarestricao;
    private Long idestabelecimento;
    private Long idusuario;
    private Integer statusrestricao;
    private String textorestricao;
}
