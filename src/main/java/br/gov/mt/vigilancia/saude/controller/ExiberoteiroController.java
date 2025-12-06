package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ExiberoteiroDTO;
import br.gov.mt.vigilancia.saude.service.ExiberoteiroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exiberoteiros")
@Tag(name = "Exibir Roteiros", description = "Operações CRUD para exibição de roteiros")
public class ExiberoteiroController {

    @Autowired
    private ExiberoteiroService exiberoteiroService;

    @GetMapping
    @Operation(summary = "Listar roteiros para exibição", description = "Retorna a lista completa de roteiros para exibição cadastrados")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExiberoteiroDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<ExiberoteiroDTO>> getAllExiberoteiros() {
        return ResponseEntity.ok(exiberoteiroService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar roteiro por ID", description = "Retorna um roteiro para exibição pelo seu identificador")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExiberoteiroDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ExiberoteiroDTO> getExiberoteiroById(
            @Parameter(description = "Identificador do roteiro", example = "1") @PathVariable Integer id) {
        return exiberoteiroService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar roteiro para exibição", description = "Cria um novo roteiro para exibição")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro criado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExiberoteiroDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ExiberoteiroDTO> createExiberoteiro(@Valid @RequestBody ExiberoteiroDTO exiberoteiroDTO) {
        return ResponseEntity.ok(exiberoteiroService.save(exiberoteiroDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar roteiro", description = "Atualiza um roteiro para exibição existente pelo seu ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExiberoteiroDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ExiberoteiroDTO> updateExiberoteiro(
            @Parameter(description = "Identificador do roteiro", example = "1") @PathVariable Integer id,
            @Valid @RequestBody ExiberoteiroDTO exiberoteiroDTO) {
        return exiberoteiroService.findById(id)
                .map(existingExiberoteiroDTO -> {
                    exiberoteiroDTO.setIdexiberoteiro(id);
                    return ResponseEntity.ok(exiberoteiroService.save(exiberoteiroDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir roteiro", description = "Remove um roteiro para exibição pelo seu ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteExiberoteiro(
            @Parameter(description = "Identificador do roteiro", example = "1") @PathVariable Integer id) {
        exiberoteiroService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
