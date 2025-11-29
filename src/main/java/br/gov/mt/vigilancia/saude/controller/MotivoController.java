package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.MotivoDTO;
import br.gov.mt.vigilancia.saude.service.MotivoService;
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
 * Controller para consulta de motivos.
 */
@RestController
@RequestMapping("/motivos")
@RequiredArgsConstructor
@Tag(name = "Motivos", description = "Consulta de motivos")
@SecurityRequirement(name = "bearerAuth")
public class MotivoController {

    private final MotivoService motivoService;

    @GetMapping
    @Operation(summary = "Listar motivos", description = "Retorna todos os motivos cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<MotivoDTO>> findAll() {
        return ResponseEntity.ok(motivoService.findAll());
    }
}
