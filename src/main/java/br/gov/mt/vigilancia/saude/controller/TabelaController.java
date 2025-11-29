package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.TabelaDTO;
import br.gov.mt.vigilancia.saude.service.TabelaService;
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
 * Controller para gerenciamento de tabelas do sistema.
 */
@RestController
@RequestMapping("/tabelas")
@RequiredArgsConstructor
@Tag(name = "Tabelas", description = "Consulta de tabelas do sistema")
@SecurityRequirement(name = "bearerAuth")
public class TabelaController {

    private final TabelaService tabelaService;

    @GetMapping
    @Operation(summary = "Listar tabelas", description = "Retorna todas as tabelas do sistema")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<TabelaDTO>> findAll() {
        return ResponseEntity.ok(tabelaService.findAll());
    }
}
