package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.domain.Usuario;
import br.gov.mt.vigilancia.saude.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

/**
 * DEV-ONLY helper endpoint to reset the admin password to "admin" using the configured PasswordEncoder.
 * IMPORTANT: Remove or restrict this endpoint in production environments.
 */
@RestController
@RequestMapping("/auth/dev")
public class DevAuthAdminController {

    private static final Logger log = LoggerFactory.getLogger(DevAuthAdminController.class);

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public DevAuthAdminController(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/reset-admin")
    public ResponseEntity<?> resetAdminPassword() {
        try {
            var opt = usuarioRepository.findByEmailWithPermissoes("admin@local");
            if (opt.isEmpty()) {
                return ResponseEntity.status(404).body("admin@local not found");
            }
            Usuario u = opt.get();
            String encoded = passwordEncoder.encode("admin");
            u.setSenha(encoded);
            if (u.getStatus() == null || u.getStatus() == 0) {
                u.setStatus(1);
            }
            usuarioRepository.save(u);
            log.info("[DEV] Admin password reset with BCrypt. Hash prefix: {}...", encoded.substring(0, 7));
            return ResponseEntity.ok("admin password reset to 'admin' (BCrypt)");
        } catch (Exception e) {
            log.error("[DEV] Error resetting admin password", e);
            return ResponseEntity.status(500).body("error resetting password");
        }
    }
}
