package br.gov.mt.vigilancia.saude.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller para verificação de saúde da aplicação.
 * Fornece endpoint simples para monitoramento e health checks.
 */
@RestController
@RequestMapping("/health")
@Tag(name = "Health", description = "Endpoints para verificação de saúde da aplicação")
public class HealthController {

    /**
 * Verifica se a aplicação está funcionando.
 * 
 * @return Mensagem confirmando que a aplicação está rodando
 */
    @GetMapping
    @Operation(
        summary = "Health Check",
        description = "Verifica se a aplicação está funcionando corretamente"
    )
    @ApiResponse(responseCode = "200", description = "Aplicação funcionando normalmente")
    public String healthCheck() {
        return "Application is running!";
    }
}
