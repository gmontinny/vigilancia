package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ProcessoDTO;
import br.gov.mt.vigilancia.saude.service.ProcessoService;
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
 * Controller para gerenciamento de processos administrativos.
 * Fornece endpoints para consulta de processos do sistema de vigilância sanitária.
 */
@RestController
@RequestMapping("/processos")
@RequiredArgsConstructor
@Tag(name = "Processos", description = "Gerenciamento de processos administrativos")
@SecurityRequirement(name = "bearerAuth")
public class ProcessoController {

    private final ProcessoService processoService;

    /**
     * Lista todos os processos cadastrados no sistema.
     * 
     * @return Lista de processos
     */
    @GetMapping
    @Operation(
        summary = "Listar processos",
        description = "Retorna a lista de todos os processos administrativos cadastrados"
    )
    @ApiResponse(responseCode = "200", description = "Lista de processos retornada com sucesso")
    @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido ou ausente")
    public ResponseEntity<List<ProcessoDTO>> findAll() {
        return ResponseEntity.ok(processoService.findAll());
    }
}
