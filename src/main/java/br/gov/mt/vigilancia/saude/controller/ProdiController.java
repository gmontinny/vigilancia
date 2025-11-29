package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ProdiDTO;
import br.gov.mt.vigilancia.saude.service.ProdiService;
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
 * Controller para consulta de prodis.
 */
@RestController
@RequestMapping("/prodis")
@RequiredArgsConstructor
@Tag(name = "Prodis", description = "Consulta de prodis")
@SecurityRequirement(name = "bearerAuth")
public class ProdiController {

    private final ProdiService prodiService;

    @GetMapping
    @Operation(summary = "Listar prodis", description = "Retorna todos os prodis cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<ProdiDTO>> findAll() {
        return ResponseEntity.ok(prodiService.findAll());
    }
}
