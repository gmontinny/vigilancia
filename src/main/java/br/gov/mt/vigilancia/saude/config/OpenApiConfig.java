package br.gov.mt.vigilancia.saude.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

/**
 * Configuração da documentação OpenAPI/Swagger para a API de Vigilância Sanitária.
 * Define informações gerais da API, esquemas de segurança e servidores.
 */
@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "API Vigilância Sanitária",
        version = "1.0.0",
        description = """
            API REST para o sistema de Vigilância Sanitária do Estado de Mato Grosso.
            
            ## Autenticação
            Esta API utiliza autenticação JWT (JSON Web Token). Para acessar endpoints protegidos:
            1. Faça login através do endpoint `/auth/login`
            2. Use o token retornado no header `Authorization: Bearer {token}`
            3. Renove o token quando necessário através do endpoint `/auth/refresh`
            
            ## Usuário de Teste
            - **Email**: admin@local
            - **Senha**: admin
            """,
        contact = @Contact(
            name = "Equipe de Vigilância Sanitária",
            email = "vigilancia@saude.mt.gov.br"
        ),
        license = @License(
            name = "Governo do Estado de Mato Grosso"
        )
    ),
    servers = {
        @Server(
            url = "http://localhost:8081",
            description = "Servidor de Desenvolvimento"
        ),
        @Server(
            url = "https://api-vigilancia.saude.mt.gov.br",
            description = "Servidor de Produção"
        )
    }
)
@SecurityScheme(
    name = "bearerAuth",
    type = SecuritySchemeType.HTTP,
    scheme = "bearer",
    bearerFormat = "JWT",
    description = "Token JWT obtido através do endpoint de login"
)
public class OpenApiConfig {
}