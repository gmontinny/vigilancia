package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.LogDTO;
import br.gov.mt.vigilancia.saude.service.LogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller para consulta de logs do sistema.
 */
@RestController
@RequestMapping("/logs")
@RequiredArgsConstructor
@Tag(name = "Logs", description = "Consulta de logs do sistema")
@SecurityRequirement(name = "bearerAuth")
public class LogController {

    private final LogService logService;

    @GetMapping
    @Operation(summary = "Listar logs", description = "Retorna todos os logs do sistema")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<LogDTO>> findAll() {
        return ResponseEntity.ok(logService.findAll());
    }
}
