package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.SubgrupoDTO;
import br.gov.mt.vigilancia.saude.service.SubgrupoService;
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
 * Controller para consulta de subgrupos.
 */
@RestController
@RequestMapping("/subgrupos")
@RequiredArgsConstructor
@Tag(name = "Subgrupos", description = "Consulta de subgrupos")
@SecurityRequirement(name = "bearerAuth")
public class SubgrupoController {

    private final SubgrupoService subgrupoService;

    @GetMapping
    @Operation(summary = "Listar subgrupos", description = "Retorna todos os subgrupos cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<SubgrupoDTO>> findAll() {
        return ResponseEntity.ok(subgrupoService.findAll());
    }
}
