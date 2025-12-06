package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.AtividadesDTO;
import br.gov.mt.vigilancia.saude.service.AtividadesService;
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
 * Controller para gerenciamento de atividades.
 * Fornece endpoints para operações CRUD de atividades do sistema.
 */
@RestController
@RequestMapping("/atividades")
@Tag(name = "Atividades", description = "Operações CRUD para atividades do sistema")
public class AtividadesController {

    @Autowired
    private AtividadesService atividadesService;

    /**
     * Lista todas as atividades cadastradas.
     *
     * @return Lista de atividades
     */
    @GetMapping
    @Operation(
            summary = "Listar atividades",
            description = "Retorna a lista completa de atividades cadastradas no sistema"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Lista retornada com sucesso",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = AtividadesDTO.class)
                    )
            ),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<AtividadesDTO>> getAllAtividades() {
        return ResponseEntity.ok(atividadesService.findAll());
    }

    /**
     * Busca atividade por ID.
     *
     * @param id Identificador da atividade
     * @return Atividade encontrada
     */
    @GetMapping("/{id}")
    @Operation(
            summary = "Buscar atividade por ID",
            description = "Retorna uma atividade pelo seu identificador"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Registro encontrado",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = AtividadesDTO.class)
                    )
            ),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<AtividadesDTO> getAtividadesById(
            @Parameter(description = "Identificador da atividade", example = "1")
            @PathVariable Integer id) {
        return atividadesService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Cria nova atividade.
     *
     * @param atividadesDTO Atividade a ser criada
     * @return Atividade criada
     */
    @PostMapping
    @Operation(
            summary = "Criar atividade",
            description = "Cria uma nova atividade no sistema"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Registro criado com sucesso",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = AtividadesDTO.class)
                    )
            ),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<AtividadesDTO> createAtividades(
            @Valid @RequestBody AtividadesDTO atividadesDTO) {
        return ResponseEntity.ok(atividadesService.save(atividadesDTO));
    }

    /**
     * Atualiza atividade existente.
     *
     * @param id Identificador da atividade
     * @param atividadesDTO Atividade atualizada
     * @return Atividade atualizada
     */
    @PutMapping("/{id}")
    @Operation(
            summary = "Atualizar atividade",
            description = "Atualiza uma atividade existente pelo seu ID"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Registro atualizado com sucesso",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = AtividadesDTO.class)
                    )
            ),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<AtividadesDTO> updateAtividades(
            @Parameter(description = "Identificador da atividade", example = "1")
            @PathVariable Integer id,
            @Valid @RequestBody AtividadesDTO atividadesDTO) {
        return atividadesService.findById(id)
                .map(existingAtividadesDTO -> {
                    atividadesDTO.setIdatividades(id);
                    return ResponseEntity.ok(atividadesService.save(atividadesDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Exclui atividade por ID.
     *
     * @param id Identificador da atividade
     * @return Resposta vazia
     */
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Excluir atividade",
            description = "Remove uma atividade pelo seu ID"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteAtividades(
            @Parameter(description = "Identificador da atividade", example = "1")
            @PathVariable Integer id) {
        atividadesService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
