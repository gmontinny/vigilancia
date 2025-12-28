package br.gov.mt.vigilancia.saude.config;

import br.gov.mt.vigilancia.saude.security.JwtAuthenticationFilter;
import br.gov.mt.vigilancia.saude.security.UsuarioDetailsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UsuarioDetailsService userDetailsService;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    // Propriedades CORS parametrizáveis (valores padrão cobrem Angular dev em 4200)
    @Value("${security.cors.allowed-origins:http://localhost:4200}")
    private String corsAllowedOrigins;

    @Value("${security.cors.allowed-methods:GET,POST,PUT,PATCH,DELETE,OPTIONS}")
    private String corsAllowedMethods;

    @Value("${security.cors.allowed-headers:Authorization,Content-Type,Accept}")
    private String corsAllowedHeaders;

    @Value("${security.cors.allow-credentials:true}")
    private boolean corsAllowCredentials;

    public SecurityConfig(UsuarioDetailsService userDetailsService, JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.userDetailsService = userDetailsService;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    // Expõe explicitamente um AuthenticationManager usando nosso DaoAuthenticationProvider (BCrypt)
    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(List.of(daoAuthenticationProvider()));
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .cors(Customizer.withDefaults())
            .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                // Libera preflight CORS em toda a API
                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .requestMatchers(
                    "/",
                    "/health",
                    "/actuator/health",
                    "/actuator/info",
                    "/auth/login",
                    "/auth/refresh",
                    "/auth/dev/**",
                    // Swagger/OpenAPI (springdoc)
                    "/v3/api-docs",
                    "/v3/api-docs/**",
                    "/swagger-ui.html",
                    "/swagger-ui/**",
                    "/webjars/**"
                ).permitAll()
                .anyRequest().authenticated()
            )
            .authenticationProvider(daoAuthenticationProvider());

        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        // allowed origins
        config.setAllowedOrigins(Arrays.stream(corsAllowedOrigins.split(",")).map(String::trim).filter(s -> !s.isBlank()).toList());
        // allowed methods
        config.setAllowedMethods(Arrays.stream(corsAllowedMethods.split(",")).map(String::trim).filter(s -> !s.isBlank()).toList());
        // allowed headers
        config.setAllowedHeaders(Arrays.stream(corsAllowedHeaders.split(",")).map(String::trim).filter(s -> !s.isBlank()).toList());
        // expor cabeçalhos úteis para clientes
        config.setExposedHeaders(List.of("Authorization", "WWW-Authenticate"));
        // permitir envio de cookies/autorização se necessário
        config.setAllowCredentials(corsAllowCredentials);
        // tempo de cache do preflight
        config.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}
