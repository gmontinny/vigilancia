package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ItenssolicitacaoDTO;
import br.gov.mt.vigilancia.saude.service.ItenssolicitacaoService;
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
@RequestMapping("/itenssolicitacoes")
@Tag(name = "Itens de Solicitação", description = "Operações CRUD para itens de solicitação")
public class ItenssolicitacaoController {

    @Autowired
    private ItenssolicitacaoService itenssolicitacaoService;

    @GetMapping
    @Operation(summary = "Listar itens de solicitação", description = "Retorna a lista completa de itens de solicitação cadastrados")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItenssolicitacaoDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<ItenssolicitacaoDTO>> getAllItenssolicitacoes() {
        return ResponseEntity.ok(itenssolicitacaoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar item de solicitação por ID", description = "Retorna um item de solicitação pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItenssolicitacaoDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ItenssolicitacaoDTO> getItenssolicitacaoById(@Parameter(description = "Identificador do item de solicitação", example = "1") @PathVariable Integer id) {
        return itenssolicitacaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar item de solicitação", description = "Cria um novo item de solicitação")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItenssolicitacaoDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ItenssolicitacaoDTO> createItenssolicitacao(@Valid @RequestBody ItenssolicitacaoDTO itenssolicitacaoDTO) {
        return ResponseEntity.ok(itenssolicitacaoService.save(itenssolicitacaoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar item de solicitação", description = "Atualiza um item de solicitação existente pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItenssolicitacaoDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ItenssolicitacaoDTO> updateItenssolicitacao(@Parameter(description = "Identificador do item de solicitação", example = "1") @PathVariable Integer id, @Valid @RequestBody ItenssolicitacaoDTO itenssolicitacaoDTO) {
        return itenssolicitacaoService.findById(id)
                .map(existingItenssolicitacaoDTO -> {
                    itenssolicitacaoDTO.setIditenssolicitacao(id);
                    return ResponseEntity.ok(itenssolicitacaoService.save(itenssolicitacaoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir item de solicitação", description = "Remove um item de solicitação pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteItenssolicitacao(@Parameter(description = "Identificador do item de solicitação", example = "1") @PathVariable Integer id) {
        itenssolicitacaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
