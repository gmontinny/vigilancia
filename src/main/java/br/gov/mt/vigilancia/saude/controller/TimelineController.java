package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.TimelineDTO;
import br.gov.mt.vigilancia.saude.service.TimelineService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
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
 * Controller para gerenciamento de timelines do sistema.
 * Fornece endpoints para consulta de linhas do tempo de processos e atividades.
 */
@RestController
@RequestMapping("/timelines")
@RequiredArgsConstructor
@Tag(name = "Timelines", description = "Operações de consulta de linhas do tempo")
public class TimelineController {

    private final TimelineService timelineService;

    /**
     * Lista todas as timelines cadastradas no sistema.
     *
     * @return Lista de timelines
     */
    @GetMapping
    @Operation(
            summary = "Listar timelines",
            description = "Retorna a lista completa de linhas do tempo cadastradas no sistema"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Lista de timelines retornada com sucesso",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = TimelineDTO.class)
            )
    )
    @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<TimelineDTO>> findAll() {
        return ResponseEntity.ok(timelineService.findAll());
    }
}
