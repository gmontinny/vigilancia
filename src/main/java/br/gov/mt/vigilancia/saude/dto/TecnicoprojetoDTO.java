package br.gov.mt.vigilancia.saude.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TecnicoprojetoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idtecnicoprojeto;
    private String celulartecnicoprojeto;
    private String emailtecnicoprojeto;
    private Integer idconselho;
    private String nometecnicoprojeto;
    private String numprocesso;
    private String cpftecnicoprojeto;
    private String numeroconselho;
}
