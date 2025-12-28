package br.gov.mt.vigilancia.saude.dto.totp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TotpRegisterResponse {
    @Schema(description = "URI otpauth para apps TOTP")
    private String otpauthUrl;

    @Schema(description = "QR Code em Data URI (image/png;base64,...) para exibição direta")
    private String qrCodeDataUri;

    @Schema(description = "Issuer usado no TOTP")
    private String issuer;

    @Schema(description = "Conta/label usada no TOTP")
    private String accountLabel;
}
