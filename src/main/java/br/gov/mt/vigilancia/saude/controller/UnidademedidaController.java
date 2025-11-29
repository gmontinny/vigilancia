package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.UnidademedidaDTO;
import br.gov.mt.vigilancia.saude.service.UnidademedidaService;
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
 * Controller para consulta de unidades de medida.
 */
@RestController
@RequestMapping("/unidades-medida")
@RequiredArgsConstructor
@Tag(name = "Unidades de Medida", description = "Consulta de unidades de medida")
@SecurityRequirement(name = "bearerAuth")
public class UnidademedidaController {

    private final UnidademedidaService unidademedidaService;

    @GetMapping
    @Operation(summary = "Listar unidades de medida", description = "Retorna todas as unidades de medida cadastradas")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<UnidademedidaDTO>> findAll() {
        return ResponseEntity.ok(unidademedidaService.findAll());
    }
}
