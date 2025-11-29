package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.security.AppUserDetails;
import br.gov.mt.vigilancia.saude.security.JwtTokenService;
import br.gov.mt.vigilancia.saude.security.UsuarioDetailsService;
import br.gov.mt.vigilancia.saude.dto.AuthResponse;
import br.gov.mt.vigilancia.saude.dto.LoginRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller responsável pela autenticação e autorização de usuários.
 * Implementa autenticação JWT com endpoints para login, refresh de token e consulta de usuário autenticado.
 */
@RestController
@RequestMapping("/auth")
@Tag(name = "Autenticação", description = "Endpoints para autenticação e gerenciamento de tokens JWT")
public class AuthController {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(AuthController.class);

    private final AuthenticationManager authenticationManager;
    private final JwtTokenService jwtTokenService;
    private final UsuarioDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public AuthController(AuthenticationManager authenticationManager,
                          JwtTokenService jwtTokenService,
                          UsuarioDetailsService usuarioDetailsService,
                          PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenService = jwtTokenService;
        this.userDetailsService = usuarioDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Autentica um usuário e retorna um token JWT.
     * 
     * @param request Dados de login (email e senha)
     * @return Token JWT e informações do usuário autenticado
     */
    @PostMapping("/login")
    @Operation(
        summary = "Fazer login",
        description = "Autentica um usuário com email e senha, retornando um token JWT válido",
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = LoginRequest.class),
                examples = @ExampleObject(
                    name = "Login Admin",
                    value = "{\"email\": \"admin@local\", \"senha\": \"admin\"}"
                )
            )
        )
    )
    @ApiResponse(responseCode = "200", description = "Login realizado com sucesso", 
                content = @Content(schema = @Schema(implementation = AuthResponse.class)))
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid LoginRequest request) {
        try {
            log.debug("[AUTH] Login attempt for email={}", request.getEmail());
            // Autenticação manual para eliminar interferência de providers errados
            AppUserDetails principal = (AppUserDetails) userDetailsService.loadUserByUsername(request.getEmail());
            log.debug("[AUTH] User loaded id="+principal.getId()+", email="+principal.getUsername()+", enabled="+principal.isEnabled());
            boolean matches = passwordEncoder.matches(request.getSenha(), principal.getPassword());
            log.debug("[AUTH] Password matches? {}", matches);
            if (!matches) {
                log.warn("[AUTH] Invalid password for email={}", request.getEmail());
                return ResponseEntity.status(401).build();
            }
            // Autenticou: popula SecurityContext e emite token
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    principal, null, principal.getAuthorities()
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String token = jwtTokenService.generateToken(principal);
            List<String> authorities = principal.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());
            AuthResponse resp = AuthResponse.builder()
                    .token(token)
                    .tokenType("Bearer")
                    .expiresIn(jwtTokenService.getExpirationSeconds())
                    .userId(principal.getId())
                    .email(principal.getUsername())
                    .authorities(authorities)
                    .build();
            log.debug("[AUTH] Login success for email={} with {} authorities", request.getEmail(), authorities.size());
            return ResponseEntity.ok(resp);
        } catch (UsernameNotFoundException ex) {
            log.warn("[AUTH] User not found: {}", request.getEmail());
            return ResponseEntity.status(401).build();
        } catch (Exception e) {
            log.error("[AUTH] Unexpected error on login for {}", request.getEmail(), e);
            return ResponseEntity.status(500).build();
        }
    }

    /**
     * Retorna informações do usuário autenticado.
     * 
     * @return Dados do usuário autenticado e suas permissões
     */
    @GetMapping("/me")
    @Operation(
        summary = "Dados do usuário autenticado",
        description = "Retorna informações do usuário atualmente autenticado e suas permissões"
    )
    @ApiResponse(responseCode = "200", description = "Dados do usuário retornados com sucesso",
                content = @Content(schema = @Schema(implementation = AuthResponse.class)))
    @ApiResponse(responseCode = "401", description = "Token JWT inválido ou ausente")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<AuthResponse> me() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated()) {
            return ResponseEntity.status(401).build();
        }
        String username = auth.getName();
        List<String> authorities = auth.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        AuthResponse resp = AuthResponse.builder()
                .token(null)
                .tokenType("Bearer")
                .expiresIn(0)
                .userId(null)
                .email(username)
                .authorities(authorities)
                .build();
        return ResponseEntity.ok(resp);
    }

    /**
     * Renova um token JWT existente.
     * 
     * @param authorization Header Authorization com o token atual (Bearer token)
     * @return Novo token JWT com validade renovada
     */
    @PostMapping("/refresh")
    @Operation(
        summary = "Renovar token JWT",
        description = "Gera um novo token JWT a partir de um token existente (mesmo que expirado)"
    )
    @ApiResponse(responseCode = "200", description = "Token renovado com sucesso",
                content = @Content(schema = @Schema(implementation = AuthResponse.class)))
    @ApiResponse(responseCode = "401", description = "Token inválido ou usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<AuthResponse> refresh(
        @Parameter(description = "Token JWT no formato 'Bearer {token}'", example = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...")
        @RequestHeader(value = HttpHeaders.AUTHORIZATION, required = false) String authorization) {
        try {
            if (!StringUtils.hasText(authorization) || !authorization.startsWith("Bearer ")) {
                return ResponseEntity.status(401).build();
            }
            String token = authorization.substring(7);
            var claims = jwtTokenService.parseTokenAllowExpired(token);
            String email = claims.getSubject();
            // Recarrega usuário atual para garantir que authorities estejam atualizadas
            AppUserDetails principal = (AppUserDetails) userDetailsService.loadUserByUsername(email);
            String newToken = jwtTokenService.generateToken(principal);
            List<String> authorities = principal.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());
            AuthResponse resp = AuthResponse.builder()
                    .token(newToken)
                    .tokenType("Bearer")
                    .expiresIn(jwtTokenService.getExpirationSeconds())
                    .userId(principal.getId())
                    .email(principal.getUsername())
                    .authorities(authorities)
                    .build();
            return ResponseEntity.ok(resp);
        } catch (UsernameNotFoundException ex) {
            return ResponseEntity.status(401).build();
        } catch (Exception e) {
            log.error("[AUTH] Unexpected error on refresh", e);
            return ResponseEntity.status(500).build();
        }
    }
}
