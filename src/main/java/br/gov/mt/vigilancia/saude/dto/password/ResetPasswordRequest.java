package br.gov.mt.vigilancia.saude.dto.password;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ResetPasswordRequest {
    @NotBlank
    private String token;

    @NotBlank
    @Size(min = 5, message = "Senha deve ter no mínimo 5 caracteres!")
    private String novaSenha;
}
