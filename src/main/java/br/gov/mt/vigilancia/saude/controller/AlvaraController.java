package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.AlvaraDTO;
import br.gov.mt.vigilancia.saude.service.AlvaraService;
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
 * Controller para consulta de alvarás sanitários.
 */
@RestController
@RequestMapping("/alvaras")
@RequiredArgsConstructor
@Tag(name = "Alvarás", description = "Consulta de alvarás sanitários")
@SecurityRequirement(name = "bearerAuth")
public class AlvaraController {

    private final AlvaraService alvaraService;

    @GetMapping
    @Operation(summary = "Listar alvarás", description = "Retorna todos os alvarás sanitários cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<AlvaraDTO>> findAll() {
        return ResponseEntity.ok(alvaraService.findAll());
    }
}
