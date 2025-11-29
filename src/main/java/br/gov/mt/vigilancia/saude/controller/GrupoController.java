package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.GrupoDTO;
import br.gov.mt.vigilancia.saude.service.GrupoService;
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
 * Controller para consulta de grupos.
 */
@RestController
@RequestMapping("/grupos")
@RequiredArgsConstructor
@Tag(name = "Grupos", description = "Consulta de grupos")
@SecurityRequirement(name = "bearerAuth")
public class GrupoController {

    private final GrupoService grupoService;

    @GetMapping
    @Operation(summary = "Listar grupos", description = "Retorna todos os grupos cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<GrupoDTO>> findAll() {
        return ResponseEntity.ok(grupoService.findAll());
    }
}
