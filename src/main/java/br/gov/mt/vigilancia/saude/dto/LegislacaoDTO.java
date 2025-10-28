package br.gov.mt.vigilancia.saude.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LegislacaoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idlegislacao;
    private String artigolegislacao;
    private String descricaolegislacao;
    private String incisolegislacao;
    private Integer decretolegislacao;
    private String leilegislacao;
    private String paragrafolegislacao;
    private String valorlegislacao;
    private String riscolegislacao;
}
