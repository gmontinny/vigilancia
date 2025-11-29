package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ResponsavelTecnicoDTO;
import br.gov.mt.vigilancia.saude.service.ResponsavelTecnicoService;
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
 * Controller para gerenciamento de responsáveis técnicos.
 */
@RestController
@RequestMapping("/responsaveis-tecnicos")
@RequiredArgsConstructor
@Tag(name = "Responsáveis Técnicos", description = "Consulta de responsáveis técnicos")
@SecurityRequirement(name = "bearerAuth")
public class ResponsavelTecnicoController {

    private final ResponsavelTecnicoService responsavelTecnicoService;

    @GetMapping
    @Operation(summary = "Listar responsáveis técnicos", description = "Retorna todos os responsáveis técnicos cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<ResponsavelTecnicoDTO>> findAll() {
        return ResponseEntity.ok(responsavelTecnicoService.findAll());
    }
}
