package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ReclamacaoDTO;
import br.gov.mt.vigilancia.saude.service.ReclamacaoService;
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
 * Controller para gerenciamento de reclamações.
 */
@RestController
@RequestMapping("/reclamacoes")
@RequiredArgsConstructor
@Tag(name = "Reclamações", description = "Consulta de reclamações")
@SecurityRequirement(name = "bearerAuth")
public class ReclamacaoController {

    private final ReclamacaoService reclamacaoService;

    @GetMapping
    @Operation(summary = "Listar reclamações", description = "Retorna todas as reclamações cadastradas")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<ReclamacaoDTO>> findAll() {
        return ResponseEntity.ok(reclamacaoService.findAll());
    }
}
