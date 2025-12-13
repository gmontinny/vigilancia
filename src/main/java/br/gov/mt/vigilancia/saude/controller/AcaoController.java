package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.AcaoDTO;
import br.gov.mt.vigilancia.saude.service.AcaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    @Operation(summary = "Buscar ação por ID", description = "Retorna uma ação específica pelo ID")
    @ApiResponse(responseCode = "200", description = "Ação encontrada")
    @ApiResponse(responseCode = "404", description = "Ação não encontrada")
    public ResponseEntity<AcaoDTO> findById(@Parameter(description = "ID da ação") @PathVariable Integer id) {
        return ResponseEntity.ok(acaoService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Criar ação", description = "Cria uma nova ação")
    @ApiResponse(responseCode = "200", description = "Ação criada com sucesso")
    public ResponseEntity<AcaoDTO> create(@Valid @RequestBody AcaoDTO acaoDTO) {
        return ResponseEntity.ok(acaoService.save(acaoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar ação", description = "Atualiza uma ação existente")
    @ApiResponse(responseCode = "200", description = "Ação atualizada com sucesso")
    @ApiResponse(responseCode = "404", description = "Ação não encontrada")
    public ResponseEntity<AcaoDTO> update(@Parameter(description = "ID da ação") @PathVariable Integer id, @Valid @RequestBody AcaoDTO acaoDTO) {
        return ResponseEntity.ok(acaoService.update(id, acaoDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir ação", description = "Exclui uma ação")
    @ApiResponse(responseCode = "204", description = "Ação excluída com sucesso")
    @ApiResponse(responseCode = "404", description = "Ação não encontrada")
    public ResponseEntity<Void> delete(@Parameter(description = "ID da ação") @PathVariable Integer id) {
        acaoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
