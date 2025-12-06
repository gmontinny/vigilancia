package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ItensroteiroDTO;
import br.gov.mt.vigilancia.saude.service.ItensroteiroService;
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
@RequestMapping("/itensroteiros")
@Tag(name = "Itens de Roteiro", description = "Operações CRUD para itens de roteiro")
public class ItensroteiroController {

    @Autowired
    private ItensroteiroService itensroteiroService;

    @GetMapping
    @Operation(summary = "Listar itens de roteiro", description = "Retorna a lista completa de itens de roteiro cadastrados")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItensroteiroDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<ItensroteiroDTO>> getAllItensroteiros() {
        return ResponseEntity.ok(itensroteiroService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar item de roteiro por ID", description = "Retorna um item de roteiro pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItensroteiroDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ItensroteiroDTO> getItensroteiroById(@Parameter(description = "Identificador do item de roteiro", example = "1") @PathVariable Integer id) {
        return itensroteiroService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar item de roteiro", description = "Cria um novo item de roteiro")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItensroteiroDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ItensroteiroDTO> createItensroteiro(@Valid @RequestBody ItensroteiroDTO itensroteiroDTO) {
        return ResponseEntity.ok(itensroteiroService.save(itensroteiroDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar item de roteiro", description = "Atualiza um item de roteiro existente pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItensroteiroDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ItensroteiroDTO> updateItensroteiro(@Parameter(description = "Identificador do item de roteiro", example = "1") @PathVariable Integer id, @Valid @RequestBody ItensroteiroDTO itensroteiroDTO) {
        return itensroteiroService.findById(id)
                .map(existingItensroteiroDTO -> {
                    itensroteiroDTO.setIditensroteiro(id);
                    return ResponseEntity.ok(itensroteiroService.save(itensroteiroDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir item de roteiro", description = "Remove um item de roteiro pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteItensroteiro(@Parameter(description = "Identificador do item de roteiro", example = "1") @PathVariable Integer id) {
        itensroteiroService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
