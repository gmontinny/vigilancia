package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.password.ForgotPasswordRequest;
import br.gov.mt.vigilancia.saude.dto.password.ResetPasswordRequest;
import br.gov.mt.vigilancia.saude.service.ResetPasswordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/password")
@RequiredArgsConstructor
@Tag(name = "Senha", description = "Fluxo de recuperação e redefinição de senha")
public class PasswordController {

    private final ResetPasswordService resetPasswordService;

    @PostMapping("/forgot")
    @Operation(summary = "Solicitar link de redefinição", description = "Envia por e-mail um link para redefinir a senha. Sempre retorna 200.")
    @ApiResponse(responseCode = "200", description = "Solicitação processada")
    public ResponseEntity<Void> forgot(@Valid @RequestBody ForgotPasswordRequest request) {
        resetPasswordService.solicitarRedefinicao(request.getEmail());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/reset")
    @Operation(summary = "Redefinir senha", description = "Valida o token e altera a senha do usuário")
    @ApiResponse(responseCode = "200", description = "Senha alterada com sucesso")
    @ApiResponse(responseCode = "400", description = "Token inválido ou expirado")
    public ResponseEntity<Void> reset(@Valid @RequestBody ResetPasswordRequest request) {
        boolean ok = resetPasswordService.redefinirSenha(request.getToken(), request.getNovaSenha());
        if (!ok) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok().build();
    }
}
