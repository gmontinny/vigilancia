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
import br.gov.mt.vigilancia.saude.exception.ApiError;
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
     * @param request Dados de login: informar senha e (email OU cpf)
     * @return Token JWT e informações do usuário autenticado
     */
    @PostMapping("/login")
    @Operation(
        summary = "Fazer login",
        description = "Autentica um usuário com email e senha OU cpf e senha, retornando um token JWT válido",
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            required = true,
            description = "Informe senha e (email OU cpf)",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = LoginRequest.class),
                examples = {
                    @ExampleObject(
                        name = "Login por Email",
                        value = "{\"email\": \"admin@local\", \"senha\": \"admin\"}"
                    ),
                    @ExampleObject(
                        name = "Login por CPF",
                        value = "{\"cpf\": \"123.456.789-00\", \"senha\": \"admin\"}"
                    )
                }
            )
        )
    )
    @ApiResponse(
        responseCode = "200",
        description = "Login realizado com sucesso",
        content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = AuthResponse.class),
            examples = @ExampleObject(name = "Sucesso",
                    value = "{\n  \"token\": \"<JWT>\",\n  \"tokenType\": \"Bearer\",\n  \"expiresIn\": 3600,\n  \"userId\": 1,\n  \"email\": \"admin@local\",\n  \"authorities\": [\"PERM_USUARIO:SELECT\"]\n}"))
    )
    @ApiResponse(
        responseCode = "401",
        description = "Credenciais inválidas",
        content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = ApiError.class),
            examples = @ExampleObject(name = "Não autorizado",
                    value = "{\n  \"timestamp\": \"2025-11-29T08:37:00Z\",\n  \"status\": 401,\n  \"error\": \"Unauthorized\",\n  \"message\": \"Credenciais inválidas\",\n  \"path\": \"/auth/login\"\n}"))
    )
    @ApiResponse(
        responseCode = "500",
        description = "Erro interno do servidor",
        content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = ApiError.class),
            examples = @ExampleObject(name = "Erro interno",
                    value = "{\n  \"timestamp\": \"2025-11-29T08:37:00Z\",\n  \"status\": 500,\n  \"error\": \"Internal Server Error\",\n  \"message\": \"Ocorreu um erro inesperado\",\n  \"path\": \"/auth/login\"\n}"))
    )
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid LoginRequest request) {
        try {
            String email = request.getEmail();
            String cpf = request.getCpf();
            boolean hasEmail = StringUtils.hasText(email);
            boolean hasCpf = StringUtils.hasText(cpf);
            if (!hasEmail && !hasCpf) {
                log.warn("[AUTH] Login attempt without email or cpf");
                return ResponseEntity.status(401).build();
            }

            // Normaliza CPF (mantém somente dígitos)
            if (hasCpf) {
                cpf = cpf.replaceAll("\\D", "");
            }

            log.debug("[AUTH] Login attempt for {}:{}", hasEmail ? "email" : "cpf", hasEmail ? email : cpf);
            // Autenticação manual para eliminar interferência de providers errados
            AppUserDetails principal = (AppUserDetails) (hasEmail
                    ? userDetailsService.loadUserByUsername(email)
                    : userDetailsService.loadUserByCpf(cpf));
            log.debug("[AUTH] User loaded id="+principal.getId()+", email="+principal.getUsername()+", enabled="+principal.isEnabled());
            boolean matches = passwordEncoder.matches(request.getSenha(), principal.getPassword());
            log.debug("[AUTH] Password matches? {}", matches);
            if (!matches) {
                if (hasEmail) {
                    log.warn("[AUTH] Invalid password for email={}", email);
                } else {
                    log.warn("[AUTH] Invalid password for cpf={}", cpf);
                }
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
            if (hasEmail) {
                log.debug("[AUTH] Login success for email={} with {} authorities", email, authorities.size());
            } else {
                log.debug("[AUTH] Login success for cpf={} with {} authorities", cpf, authorities.size());
            }
            return ResponseEntity.ok(resp);
        } catch (UsernameNotFoundException ex) {
            String identifier = StringUtils.hasText(request.getEmail()) ? request.getEmail() : request.getCpf();
            log.warn("[AUTH] User not found: {}", identifier);
            return ResponseEntity.status(401).build();
        } catch (Exception e) {
            String identifier = StringUtils.hasText(request.getEmail()) ? request.getEmail() : request.getCpf();
            log.error("[AUTH] Unexpected error on login for {}", identifier, e);
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
    @ApiResponse(
        responseCode = "200",
        description = "Dados do usuário retornados com sucesso",
        content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = AuthResponse.class),
            examples = @ExampleObject(name = "Sucesso",
                    value = "{\n  \"token\": null,\n  \"tokenType\": \"Bearer\",\n  \"expiresIn\": 0,\n  \"userId\": null,\n  \"email\": \"admin@local\",\n  \"authorities\": [\"PERM_USUARIO:SELECT\"]\n}"))
    )
    @ApiResponse(
        responseCode = "401",
        description = "Token JWT inválido ou ausente",
        content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = ApiError.class),
            examples = @ExampleObject(name = "Não autorizado",
                    value = "{\n  \"timestamp\": \"2025-11-29T08:37:00Z\",\n  \"status\": 401,\n  \"error\": \"Unauthorized\",\n  \"message\": \"Token inválido ou ausente\",\n  \"path\": \"/auth/me\"\n}"))
    )
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
    @ApiResponse(
        responseCode = "200",
        description = "Token renovado com sucesso",
        content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = AuthResponse.class),
            examples = @ExampleObject(name = "Sucesso",
                    value = "{\n  \"token\": \"<NOVO_JWT>\",\n  \"tokenType\": \"Bearer\",\n  \"expiresIn\": 3600,\n  \"userId\": 1,\n  \"email\": \"admin@local\",\n  \"authorities\": [\"PERM_USUARIO:SELECT\"]\n}"))
    )
    @ApiResponse(
        responseCode = "401",
        description = "Token inválido ou usuário não encontrado",
        content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = ApiError.class),
            examples = @ExampleObject(name = "Não autorizado",
                    value = "{\n  \"timestamp\": \"2025-11-29T08:37:00Z\",\n  \"status\": 401,\n  \"error\": \"Unauthorized\",\n  \"message\": \"Token inválido\",\n  \"path\": \"/auth/refresh\"\n}"))
    )
    @ApiResponse(
        responseCode = "500",
        description = "Erro interno do servidor",
        content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = ApiError.class),
            examples = @ExampleObject(name = "Erro interno",
                    value = "{\n  \"timestamp\": \"2025-11-29T08:37:00Z\",\n  \"status\": 500,\n  \"error\": \"Internal Server Error\",\n  \"message\": \"Ocorreu um erro inesperado\",\n  \"path\": \"/auth/refresh\"\n}"))
    )
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
