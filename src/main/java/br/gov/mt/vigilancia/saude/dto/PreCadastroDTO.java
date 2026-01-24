package br.gov.mt.vigilancia.saude.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PreCadastroDTO {

    @NotBlank(message = "Nome é um campo obrigatório!")
    @Size(min = 5, message = "Nome deve ter no mínimo 5 caracteres!")
    @Schema(description = "Nome completo", example = "João da Silva")
    private String nome;

    @NotBlank(message = "CPF é um campo obrigatório!")
    @Schema(description = "CPF do usuário", example = "000.000.000-00")
    private String cpf;

    @NotBlank(message = "Celular é um campo obrigatório!")
    @Schema(description = "Número de celular", example = "(65) 99999-9999")
    private String celular;

    @NotBlank(message = "Email é um campo obrigatório!")
    @Email(message = "Email inválido!")
    @Schema(description = "Endereço de e-mail", example = "joao@exemplo.com")
    private String email;

    @NotNull(message = "Sexo é um campo obrigatório!")
    @Schema(description = "Sexo (1=Masculino, 2=Feminino, 3=Outros)", example = "1")
    private Integer sexo;

    @NotBlank(message = "Senha é um campo obrigatório!")
    @Size(min = 5, message = "Senha deve ter no mínimo 5 caracteres!")
    @Schema(description = "Senha do usuário", example = "123456")
    private String senha;

    @NotBlank(message = "Confirmação de senha é obrigatória!")
    @Schema(description = "Confirmação da senha", example = "123456")
    private String confirmarSenha;
}
