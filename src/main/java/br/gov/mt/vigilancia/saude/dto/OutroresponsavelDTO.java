package br.gov.mt.vigilancia.saude.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OutroresponsavelDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idoutrosresponsaveis;
    private Integer idconselho;
    private String nomeresponsavel;
    private Integer numeroestabelecimento;
    private String setorresponsavel;
    private String numeroconselho;
    private String cpfresponsavel;
    private Integer statusbaixa;
}
