package br.gov.mt.vigilancia.saude.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LicenciamentoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idlicenciamento;
    private Date datalicenciamento;
    private Date datavencimento;
    private Integer qtimpresso;
    private String obslicenciamento;
    private Integer statuslicenciamento;
    // Assuming Veiculo will be handled separately or by ID in DTOs if needed
}
