package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.BpaDTO;
import br.gov.mt.vigilancia.saude.service.BpaService;
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
 * Controller para consulta de BPAs (Boletim de Produção Ambulatorial).
 */
@RestController
@RequestMapping("/bpas")
@RequiredArgsConstructor
@Tag(name = "BPAs", description = "Consulta de BPAs (Boletim de Produção Ambulatorial)")
@SecurityRequirement(name = "bearerAuth")
public class BpaController {

    private final BpaService bpaService;

    @GetMapping
    @Operation(summary = "Listar BPAs", description = "Retorna todos os BPAs cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<BpaDTO>> findAll() {
        return ResponseEntity.ok(bpaService.findAll());
    }
}
