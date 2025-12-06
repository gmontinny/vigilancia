package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.FabrilDTO;
import br.gov.mt.vigilancia.saude.service.FabrilService;
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
 * Controller para gerenciamento de dados fabris.
 * Fornece endpoints para consulta de informações relacionadas a estabelecimentos fabris.
 */
@RestController
@RequestMapping("/fabris")
@RequiredArgsConstructor
@Tag(name = "Fabris", description = "Operações de consulta de dados fabris")
public class FabrilController {

    private final FabrilService fabrilService;

    /**
     * Lista todos os registros fabris cadastrados no sistema.
     *
     * @return Lista de dados fabris
     */
    @GetMapping
    @Operation(
            summary = "Listar dados fabris",
            description = "Retorna a lista completa de dados fabris cadastrados no sistema"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Lista de dados fabris retornada com sucesso",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = FabrilDTO.class)
            )
    )
    @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<FabrilDTO>> findAll() {
        return ResponseEntity.ok(fabrilService.findAll());
    }
}
