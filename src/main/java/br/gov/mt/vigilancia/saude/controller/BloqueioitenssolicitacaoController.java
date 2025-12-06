package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.BloqueioitenssolicitacaoDTO;
import br.gov.mt.vigilancia.saude.service.BloqueioitenssolicitacaoService;
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

/**
 * Controller para gerenciamento de bloqueios de itens de solicitação.
 * Fornece endpoints para operações CRUD de bloqueios de itens em solicitações.
 */
@RestController
@RequestMapping("/bloqueioitenssolicitacoes")
@Tag(name = "Bloqueio de Itens de Solicitação", description = "Operações CRUD para bloqueios de itens de solicitação")
public class BloqueioitenssolicitacaoController {

    @Autowired
    private BloqueioitenssolicitacaoService bloqueioitenssolicitacaoService;

    /**
     * Lista todos os bloqueios de itens de solicitação cadastrados.
     *
     * @return Lista de bloqueios de itens de solicitação
     */
    @GetMapping
    @Operation(
            summary = "Listar bloqueios de itens de solicitação",
            description = "Retorna a lista completa de bloqueios de itens de solicitação cadastrados"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Lista retornada com sucesso",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = BloqueioitenssolicitacaoDTO.class)
                    )
            ),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<BloqueioitenssolicitacaoDTO>> getAllBloqueioitenssolicitacoes() {
        return ResponseEntity.ok(bloqueioitenssolicitacaoService.findAll());
    }

    /**
     * Busca bloqueio de itens de solicitação por ID.
     *
     * @param id Identificador do bloqueio
     * @return Bloqueio encontrado
     */
    @GetMapping("/{id}")
    @Operation(
            summary = "Buscar bloqueio por ID",
            description = "Retorna um bloqueio de itens de solicitação pelo seu identificador"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Registro encontrado",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = BloqueioitenssolicitacaoDTO.class)
                    )
            ),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<BloqueioitenssolicitacaoDTO> getBloqueioitenssolicitacaoById(
            @Parameter(description = "Identificador do bloqueio de itens de solicitação", example = "1")
            @PathVariable Integer id) {
        return bloqueioitenssolicitacaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Cria novo bloqueio de itens de solicitação.
     *
     * @param bloqueioitenssolicitacaoDTO Bloqueio a ser criado
     * @return Bloqueio criado
     */
    @PostMapping
    @Operation(
            summary = "Criar bloqueio de itens de solicitação",
            description = "Cria um novo bloqueio de itens de solicitação"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Registro criado com sucesso",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = BloqueioitenssolicitacaoDTO.class)
                    )
            ),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<BloqueioitenssolicitacaoDTO> createBloqueioitenssolicitacao(
            @Valid @RequestBody BloqueioitenssolicitacaoDTO bloqueioitenssolicitacaoDTO) {
        return ResponseEntity.ok(bloqueioitenssolicitacaoService.save(bloqueioitenssolicitacaoDTO));
    }

    /**
     * Atualiza bloqueio de itens de solicitação existente.
     *
     * @param id Identificador do bloqueio
     * @param bloqueioitenssolicitacaoDTO Bloqueio atualizado
     * @return Bloqueio atualizado
     */
    @PutMapping("/{id}")
    @Operation(
            summary = "Atualizar bloqueio de itens de solicitação",
            description = "Atualiza um bloqueio de itens de solicitação existente pelo seu ID"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Registro atualizado com sucesso",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = BloqueioitenssolicitacaoDTO.class)
                    )
            ),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<BloqueioitenssolicitacaoDTO> updateBloqueioitenssolicitacao(
            @Parameter(description = "Identificador do bloqueio de itens de solicitação", example = "1")
            @PathVariable Integer id,
            @Valid @RequestBody BloqueioitenssolicitacaoDTO bloqueioitenssolicitacaoDTO) {
        return bloqueioitenssolicitacaoService.findById(id)
                .map(existingBloqueioitenssolicitacaoDTO -> {
                    bloqueioitenssolicitacaoDTO.setIdbloqueioitenssolicitacao(id);
                    return ResponseEntity.ok(bloqueioitenssolicitacaoService.save(bloqueioitenssolicitacaoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Exclui bloqueio de itens de solicitação por ID.
     *
     * @param id Identificador do bloqueio
     * @return Resposta vazia
     */
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Excluir bloqueio de itens de solicitação",
            description = "Remove um bloqueio de itens de solicitação pelo seu ID"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteBloqueioitenssolicitacao(
            @Parameter(description = "Identificador do bloqueio de itens de solicitação", example = "1")
            @PathVariable Integer id) {
        bloqueioitenssolicitacaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
