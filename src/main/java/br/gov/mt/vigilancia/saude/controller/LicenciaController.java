package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.LicenciaDTO;
import br.gov.mt.vigilancia.saude.service.LicenciaService;
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
 * Controller para consulta de licenças.
 */
@RestController
@RequestMapping("/licencias")
@RequiredArgsConstructor
@Tag(name = "Licenças", description = "Consulta de licenças")
@SecurityRequirement(name = "bearerAuth")
public class LicenciaController {

    private final LicenciaService licenciaService;

    @GetMapping
    @Operation(summary = "Listar licenças", description = "Retorna todas as licenças cadastradas")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<LicenciaDTO>> findAll() {
        return ResponseEntity.ok(licenciaService.findAll());
    }
}
