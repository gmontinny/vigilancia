package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.SintomaDTO;
import br.gov.mt.vigilancia.saude.service.SintomaService;
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
 * Controller para consulta de sintomas.
 */
@RestController
@RequestMapping("/sintomas")
@RequiredArgsConstructor
@Tag(name = "Sintomas", description = "Consulta de sintomas")
@SecurityRequirement(name = "bearerAuth")
public class SintomaController {

    private final SintomaService sintomaService;

    @GetMapping
    @Operation(summary = "Listar sintomas", description = "Retorna todos os sintomas cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<SintomaDTO>> findAll() {
        return ResponseEntity.ok(sintomaService.findAll());
    }
}
