package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.domain.Usuario;
import br.gov.mt.vigilancia.saude.dto.totp.TotpRegisterResponse;
import br.gov.mt.vigilancia.saude.dto.totp.TotpVerifyRequest;
import br.gov.mt.vigilancia.saude.repository.UsuarioRepository;
import br.gov.mt.vigilancia.saude.service.TotpService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuarios/{id}/totp")
@RequiredArgsConstructor
@Tag(name = "2FA TOTP", description = "Endpoints para registrar, verificar e desabilitar TOTP (2FA)")
@SecurityRequirement(name = "bearerAuth")
public class TotpController {

    private final UsuarioRepository usuarioRepository;
    private final TotpService totpService;

    @Value("${spring.application.name:vigilancia}")
    private String issuer;

    @PostMapping("/register")
    @Operation(
            summary = "Iniciar registro TOTP",
            description = "Gera um segredo TOTP para o usuário, retorna a URL otpauth e o QR Code (Data URI). Não habilita o 2FA até verificação.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Dados para configurar TOTP retornados",
                            content = @Content(schema = @Schema(implementation = TotpRegisterResponse.class))),
                    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
            }
    )
    public ResponseEntity<TotpRegisterResponse> register(
            @Parameter(description = "ID do usuário", example = "1")
            @PathVariable Integer id
    ) {
        Optional<Usuario> opt = usuarioRepository.findById(id);
        if (opt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Usuario usuario = opt.get();
        String secret = totpService.generateSecret();
        usuario.setTotpSecret(secret);
        usuario.setTotpEnabled(Boolean.FALSE);
        usuarioRepository.save(usuario);

        String accountLabel = usuario.getEmail() != null ? usuario.getEmail() : ("usuario-" + usuario.getId());
        String otpauth = totpService.buildOtpAuthUrl(issuer, accountLabel, secret);
        String qrDataUri = totpService.generateQrCodeDataUri(issuer, accountLabel, secret);

        TotpRegisterResponse resp = TotpRegisterResponse.builder()
                .otpauthUrl(otpauth)
                .qrCodeDataUri(qrDataUri)
                .issuer(issuer)
                .accountLabel(accountLabel)
                .build();
        return ResponseEntity.ok(resp);
    }

    @PostMapping("/verify")
    @Operation(
            summary = "Verificar e habilitar TOTP",
            description = "Verifica o código informado; em caso de sucesso habilita o 2FA para o usuário.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "TOTP verificado e habilitado"),
                    @ApiResponse(responseCode = "400", description = "Código inválido ou segredo ausente"),
                    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
            }
    )
    public ResponseEntity<Void> verify(
            @Parameter(description = "ID do usuário", example = "1")
            @PathVariable Integer id,
            @Valid @RequestBody TotpVerifyRequest body
    ) {
        Optional<Usuario> opt = usuarioRepository.findById(id);
        if (opt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Usuario usuario = opt.get();
        String secret = usuario.getTotpSecret();
        if (secret == null || secret.isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        boolean ok = totpService.verifyCode(secret, body.getCode());
        if (!ok) {
            return ResponseEntity.badRequest().build();
        }
        usuario.setTotpEnabled(Boolean.TRUE);
        usuarioRepository.save(usuario);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/disable")
    @Operation(
            summary = "Desabilitar TOTP",
            description = "Desabilita o 2FA do usuário após validação do código atual.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "TOTP desabilitado"),
                    @ApiResponse(responseCode = "400", description = "Código inválido"),
                    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
            }
    )
    public ResponseEntity<Void> disable(
            @Parameter(description = "ID do usuário", example = "1")
            @PathVariable Integer id,
            @Valid @RequestBody TotpVerifyRequest body
    ) {
        Optional<Usuario> opt = usuarioRepository.findById(id);
        if (opt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Usuario usuario = opt.get();
        String secret = usuario.getTotpSecret();
        boolean ok = totpService.verifyCode(secret, body.getCode());
        if (!ok) {
            return ResponseEntity.badRequest().build();
        }
        usuario.setTotpEnabled(Boolean.FALSE);
        usuario.setTotpSecret(null);
        usuarioRepository.save(usuario);
        return ResponseEntity.ok().build();
    }
}
