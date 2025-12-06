package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.EntregadorDTO;
import br.gov.mt.vigilancia.saude.service.EntregadorService;
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
@RequestMapping("/entregadores")
@Tag(name = "Entregadores", description = "Operações CRUD para entregadores")
public class EntregadorController {

    @Autowired
    private EntregadorService entregadorService;

    @GetMapping
    @Operation(summary = "Listar entregadores", description = "Retorna a lista completa de entregadores cadastrados")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = EntregadorDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<EntregadorDTO>> getAllEntregadores() {
        return ResponseEntity.ok(entregadorService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar entregador por ID", description = "Retorna um entregador pelo seu identificador")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = EntregadorDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<EntregadorDTO> getEntregadorById(
            @Parameter(description = "Identificador do entregador", example = "1") @PathVariable Integer id) {
        return entregadorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar entregador", description = "Cria um novo entregador")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro criado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = EntregadorDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<EntregadorDTO> createEntregador(@Valid @RequestBody EntregadorDTO entregadorDTO) {
        return ResponseEntity.ok(entregadorService.save(entregadorDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar entregador", description = "Atualiza um entregador existente pelo seu ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = EntregadorDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<EntregadorDTO> updateEntregador(
            @Parameter(description = "Identificador do entregador", example = "1") @PathVariable Integer id,
            @Valid @RequestBody EntregadorDTO entregadorDTO) {
        return entregadorService.findById(id)
                .map(existingEntregadorDTO -> {
                    entregadorDTO.setIdentregador(id);
                    return ResponseEntity.ok(entregadorService.save(entregadorDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir entregador", description = "Remove um entregador pelo seu ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteEntregador(
            @Parameter(description = "Identificador do entregador", example = "1") @PathVariable Integer id) {
        entregadorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
