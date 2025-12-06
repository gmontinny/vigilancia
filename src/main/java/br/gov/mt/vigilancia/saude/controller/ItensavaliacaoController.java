package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ItensavaliacaoDTO;
import br.gov.mt.vigilancia.saude.service.ItensavaliacaoService;
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
@RequestMapping("/itensavaliacoes")
@Tag(name = "Itens de Avaliação", description = "Operações CRUD para itens de avaliação")
public class ItensavaliacaoController {

    @Autowired
    private ItensavaliacaoService itensavaliacaoService;

    @GetMapping
    @Operation(summary = "Listar itens de avaliação", description = "Retorna a lista completa de itens de avaliação cadastrados")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItensavaliacaoDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<ItensavaliacaoDTO>> getAllItensavaliacoes() {
        return ResponseEntity.ok(itensavaliacaoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar item de avaliação por ID", description = "Retorna um item de avaliação pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItensavaliacaoDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ItensavaliacaoDTO> getItensavaliacaoById(@Parameter(description = "Identificador do item de avaliação", example = "1") @PathVariable Integer id) {
        return itensavaliacaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar item de avaliação", description = "Cria um novo item de avaliação")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItensavaliacaoDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ItensavaliacaoDTO> createItensavaliacao(@Valid @RequestBody ItensavaliacaoDTO itensavaliacaoDTO) {
        return ResponseEntity.ok(itensavaliacaoService.save(itensavaliacaoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar item de avaliação", description = "Atualiza um item de avaliação existente pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItensavaliacaoDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ItensavaliacaoDTO> updateItensavaliacao(@Parameter(description = "Identificador do item de avaliação", example = "1") @PathVariable Integer id, @Valid @RequestBody ItensavaliacaoDTO itensavaliacaoDTO) {
        return itensavaliacaoService.findById(id)
                .map(existingItensavaliacaoDTO -> {
                    itensavaliacaoDTO.setIditensavaliacao(id);
                    return ResponseEntity.ok(itensavaliacaoService.save(itensavaliacaoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir item de avaliação", description = "Remove um item de avaliação pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteItensavaliacao(@Parameter(description = "Identificador do item de avaliação", example = "1") @PathVariable Integer id) {
        itensavaliacaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
