package br.gov.mt.vigilancia.saude.dto.totp;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TotpVerifyRequest {
    @Schema(description = "Código TOTP de 6 dígitos gerado pelo app autenticador", example = "123456")
    @NotBlank
    private String code;
}
