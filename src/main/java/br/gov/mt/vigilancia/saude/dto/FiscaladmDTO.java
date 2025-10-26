package br.gov.mt.vigilancia.saude.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FiscaladmDTO {
    private Integer idFiscaladm;

    @NotNull(message = "Usuario campo obrigatorio !")
    private Integer idUsuario;

    private Integer responsavelFiscal;

    private Integer statusFiscal;

    private Integer numeroTramiteAdm;
}
