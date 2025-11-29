package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.FiscalDTO;
import br.gov.mt.vigilancia.saude.service.FiscalService;
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
 * Controller para gerenciamento de fiscais.
 */
@RestController
@RequestMapping("/fiscais")
@RequiredArgsConstructor
@Tag(name = "Fiscais", description = "Consulta de fiscais")
@SecurityRequirement(name = "bearerAuth")
public class FiscalController {

    private final FiscalService fiscalService;

    @GetMapping
    @Operation(summary = "Listar fiscais", description = "Retorna todos os fiscais cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<FiscalDTO>> findAll() {
        return ResponseEntity.ok(fiscalService.findAll());
    }
}
