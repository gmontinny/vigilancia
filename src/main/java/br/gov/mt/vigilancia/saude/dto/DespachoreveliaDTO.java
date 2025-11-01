package br.gov.mt.vigilancia.saude.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DespachoreveliaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer iddespachorevelia;
    private String secretariodespachorevelia;
    private String textodespachorevelia;
}
