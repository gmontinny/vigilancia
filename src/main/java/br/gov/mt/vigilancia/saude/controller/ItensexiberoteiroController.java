package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ItensexiberoteiroDTO;
import br.gov.mt.vigilancia.saude.service.ItensexiberoteiroService;
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
@RequestMapping("/itensexiberoteiros")
@Tag(name = "Itens de Exibir Roteiro", description = "Operações CRUD para itens de exibir roteiro")
public class ItensexiberoteiroController {

    @Autowired
    private ItensexiberoteiroService itensexiberoteiroService;

    @GetMapping
    @Operation(summary = "Listar itens de exibir roteiro", description = "Retorna a lista completa de itens de exibir roteiro cadastrados")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItensexiberoteiroDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<ItensexiberoteiroDTO>> getAllItensexiberoteiros() {
        return ResponseEntity.ok(itensexiberoteiroService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar item de exibir roteiro por ID", description = "Retorna um item de exibir roteiro pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItensexiberoteiroDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ItensexiberoteiroDTO> getItensexiberoteiroById(@Parameter(description = "Identificador do item de exibir roteiro", example = "1") @PathVariable Integer id) {
        return itensexiberoteiroService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar item de exibir roteiro", description = "Cria um novo item de exibir roteiro")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItensexiberoteiroDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ItensexiberoteiroDTO> createItensexiberoteiro(@Valid @RequestBody ItensexiberoteiroDTO itensexiberoteiroDTO) {
        return ResponseEntity.ok(itensexiberoteiroService.save(itensexiberoteiroDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar item de exibir roteiro", description = "Atualiza um item de exibir roteiro existente pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItensexiberoteiroDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ItensexiberoteiroDTO> updateItensexiberoteiro(@Parameter(description = "Identificador do item de exibir roteiro", example = "1") @PathVariable Integer id, @Valid @RequestBody ItensexiberoteiroDTO itensexiberoteiroDTO) {
        return itensexiberoteiroService.findById(id)
                .map(existingItensexiberoteiroDTO -> {
                    itensexiberoteiroDTO.setIditensexiberoteiro(id);
                    return ResponseEntity.ok(itensexiberoteiroService.save(itensexiberoteiroDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir item de exibir roteiro", description = "Remove um item de exibir roteiro pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteItensexiberoteiro(@Parameter(description = "Identificador do item de exibir roteiro", example = "1") @PathVariable Integer id) {
        itensexiberoteiroService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
