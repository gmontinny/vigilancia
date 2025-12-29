package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.PasswordResetToken;
import br.gov.mt.vigilancia.saude.domain.Usuario;
import br.gov.mt.vigilancia.saude.repository.PasswordResetTokenRepository;
import br.gov.mt.vigilancia.saude.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.time.OffsetDateTime;
import java.util.Base64;
import java.util.Optional;

@Service
public class ResetPasswordService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordResetTokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;

    @Value("${app.frontend.reset-password-url}")
    private String frontendResetUrl;

    @Value("${app.mail.from:no-reply@local}")
    private String from;

    public ResetPasswordService(UsuarioRepository usuarioRepository,
                                PasswordResetTokenRepository tokenRepository,
                                PasswordEncoder passwordEncoder,
                                EmailService emailService) {
        this.usuarioRepository = usuarioRepository;
        this.tokenRepository = tokenRepository;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
    }

    @Transactional
    public void solicitarRedefinicao(String email) {
        Optional<Usuario> opt = usuarioRepository.findByEmailWithPermissoes(email);
        if (opt.isEmpty()) {
            // Evita user enumeration: retorna sempre OK sem fazer nada
            return;
        }
        Usuario usuario = opt.get();
        // Remove tokens antigos do usuário
        tokenRepository.deleteByUsuario_Id(usuario.getId());

        // Gera token seguro e salva
        String token = generateToken();
        PasswordResetToken entity = PasswordResetToken.builder()
                .usuario(usuario)
                .token(token)
                .expiresAt(OffsetDateTime.now().plusHours(2))
                .build();
        tokenRepository.save(entity);

        // Monta link para o front: ex: https://app/#/new-password?token=...
        String link = frontendResetUrl + (frontendResetUrl.contains("?") ? "&" : "?") + "token=" + token;

        String subject = "Redefinição de senha";
        String body = "Olá,\n\nRecebemos uma solicitação para redefinir sua senha. " +
                "Clique no link abaixo para continuar (válido por 2 horas):\n" + link +
                "\n\nSe você não fez essa solicitação, ignore este e-mail.";

        emailService.send(usuario.getEmail(), subject, body);
    }

    @Transactional
    public boolean redefinirSenha(String token, String novaSenha) {
        Optional<PasswordResetToken> opt = tokenRepository.findByToken(token);
        if (opt.isEmpty()) return false;

        PasswordResetToken prt = opt.get();
        if (prt.isUsed() || prt.isExpired()) return false;

        Usuario usuario = prt.getUsuario();
        usuario.setSenha(passwordEncoder.encode(novaSenha));
        usuarioRepository.save(usuario);

        prt.setUsedAt(OffsetDateTime.now());
        tokenRepository.save(prt);
        return true;
    }

    private String generateToken() {
        byte[] bytes = new byte[48];
        new SecureRandom().nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }
}
