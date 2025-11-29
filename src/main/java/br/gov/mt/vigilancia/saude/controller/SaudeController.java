package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.SaudeDTO;
import br.gov.mt.vigilancia.saude.service.SaudeService;
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
 * Controller para consulta de dados de saúde.
 */
@RestController
@RequestMapping("/saudes")
@RequiredArgsConstructor
@Tag(name = "Saúde", description = "Consulta de dados de saúde")
@SecurityRequirement(name = "bearerAuth")
public class SaudeController {

    private final SaudeService saudeService;

    @GetMapping
    @Operation(summary = "Listar dados de saúde", description = "Retorna todos os dados de saúde cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<SaudeDTO>> findAll() {
        return ResponseEntity.ok(saudeService.findAll());
    }
}
