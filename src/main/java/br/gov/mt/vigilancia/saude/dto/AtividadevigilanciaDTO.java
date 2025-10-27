package br.gov.mt.vigilancia.saude.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AtividadevigilanciaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idatividade;
    private Integer liberacao;
    private Integer numeroatividade;
    // Assuming Licenciamento will be handled separately or by ID in DTOs if needed
}
