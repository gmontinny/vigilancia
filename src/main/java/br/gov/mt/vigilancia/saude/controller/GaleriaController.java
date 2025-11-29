package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.GaleriaDTO;
import br.gov.mt.vigilancia.saude.service.GaleriaService;
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
 * Controller para consulta de galerias.
 */
@RestController
@RequestMapping("/galerias")
@RequiredArgsConstructor
@Tag(name = "Galerias", description = "Consulta de galerias")
@SecurityRequirement(name = "bearerAuth")
public class GaleriaController {

    private final GaleriaService galeriaService;

    @GetMapping
    @Operation(summary = "Listar galerias", description = "Retorna todas as galerias cadastradas")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<GaleriaDTO>> findAll() {
        return ResponseEntity.ok(galeriaService.findAll());
    }
}
