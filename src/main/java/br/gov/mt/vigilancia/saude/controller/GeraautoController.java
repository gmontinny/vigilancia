package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.GeraautoDTO;
import br.gov.mt.vigilancia.saude.service.GeraautoService;
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
 * Controller para consulta de geradores de auto (sistema legado).
 */
@RestController
@RequestMapping("/geraautos")
@RequiredArgsConstructor
@Tag(name = "Geradores de Auto", description = "Consulta de geradores de auto (sistema legado)")
@SecurityRequirement(name = "bearerAuth")
public class GeraautoController {

    private final GeraautoService geraautoService;

    @GetMapping
    @Operation(summary = "Listar geradores de auto", description = "Retorna todos os geradores de auto cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<GeraautoDTO>> findAll() {
        return ResponseEntity.ok(geraautoService.findAll());
    }
}
