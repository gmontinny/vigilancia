package br.gov.mt.vigilancia.saude.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RelatorioDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idrelatorio;
    private String descricaorelatorio;
    private String nomerelatorio;
    private List<ItensrelatorioDTO> itensrelatorios;
}
