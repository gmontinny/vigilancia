package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.AcaoDTO;
import br.gov.mt.vigilancia.saude.service.AcaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller para gerenciamento de ações de vigilância sanitária.
 */
@RestController
@RequestMapping("/acoes")
@RequiredArgsConstructor
@Tag(name = "Ações", description = "Consulta de ações de vigilância sanitária")
@SecurityRequirement(name = "bearerAuth")
public class AcaoController {

    private final AcaoService acaoService;

    @GetMapping
    @Operation(summary = "Listar ações", description = "Retorna a lista de ações cadastradas")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AcaoDTO.class)))
    })
    public ResponseEntity<List<AcaoDTO>> findAll() {
        return ResponseEntity.ok(acaoService.findAll());
    }
}
