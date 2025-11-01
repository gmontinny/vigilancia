package br.gov.mt.vigilancia.saude.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntregadorDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer identregador;
    private String celentregador;
    private String cpfentregador;
    private String emailentregador;
    private String nomeentregador;
    private String numprocesso;
    private String imagementregador;
    private String telentregador;
}
