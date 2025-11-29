package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.CupomautoDTO;
import br.gov.mt.vigilancia.saude.service.CupomautoService;
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
 * Controller para consulta de cupons de auto (sistema legado).
 */
@RestController
@RequestMapping("/cupomautos")
@RequiredArgsConstructor
@Tag(name = "Cupons de Auto", description = "Consulta de cupons de auto (sistema legado)")
@SecurityRequirement(name = "bearerAuth")
public class CupomautoController {

    private final CupomautoService cupomautoService;

    @GetMapping
    @Operation(summary = "Listar cupons de auto", description = "Retorna todos os cupons de auto cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<CupomautoDTO>> findAll() {
        return ResponseEntity.ok(cupomautoService.findAll());
    }
}
