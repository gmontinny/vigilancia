package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.RoteiroDTO;
import br.gov.mt.vigilancia.saude.service.RoteiroService;
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
 * Controller para consulta de roteiros de inspeção.
 */
@RestController
@RequestMapping("/roteiros")
@RequiredArgsConstructor
@Tag(name = "Roteiros", description = "Consulta de roteiros de inspeção")
@SecurityRequirement(name = "bearerAuth")
public class RoteiroController {

    private final RoteiroService roteiroService;

    @GetMapping
    @Operation(summary = "Listar roteiros", description = "Retorna todos os roteiros de inspeção cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<RoteiroDTO>> findAll() {
        return ResponseEntity.ok(roteiroService.findAll());
    }
}
