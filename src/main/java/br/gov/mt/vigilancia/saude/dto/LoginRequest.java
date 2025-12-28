package br.gov.mt.vigilancia.saude.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class LoginRequest {
    // Email opcional (alternativo ao CPF)
    @Email
    private String email;

    // CPF opcional (alternativo ao email). Aceita com ou sem máscara.
    @Pattern(regexp = "^$|^[0-9.\\-()/ ]{11,18}$", message = "CPF inválido")
    private String cpf;
    @NotBlank
    private String senha;
}
