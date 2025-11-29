package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ApreensaoDTO;
import br.gov.mt.vigilancia.saude.service.ApreensaoService;
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
 * Controller para consulta de apreensões.
 */
@RestController
@RequestMapping("/apreensoes")
@RequiredArgsConstructor
@Tag(name = "Apreensões", description = "Consulta de apreensões")
@io.swagger.v3.oas.annotations.security.SecurityRequirement(name = "bearerAuth")
public class ApreensaoController {

    private final ApreensaoService apreensaoService;

    @GetMapping
    @Operation(summary = "Listar apreensões", description = "Retorna a lista de apreensões cadastradas")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApreensaoDTO.class)))
    })
    public ResponseEntity<List<ApreensaoDTO>> findAll() {
        return ResponseEntity.ok(apreensaoService.findAll());
    }
}
