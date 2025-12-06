package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ArquitetonicoDTO;
import br.gov.mt.vigilancia.saude.service.ArquitetonicoService;
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
 * Controller para gerenciamento de dados arquitetônicos.
 * Fornece endpoints para operações CRUD de informações arquitetônicas.
 */
@RestController
@RequestMapping("/arquitetonicos")
@Tag(name = "Arquitetônicos", description = "Operações CRUD para dados arquitetônicos")
public class ArquitetonicoController {

    @Autowired
    private ArquitetonicoService arquitetonicoService;

    /**
     * Lista todos os dados arquitetônicos cadastrados.
     *
     * @return Lista de dados arquitetônicos
     */
    @GetMapping
    @Operation(
            summary = "Listar dados arquitetônicos",
            description = "Retorna a lista completa de dados arquitetônicos cadastrados"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Lista retornada com sucesso",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ArquitetonicoDTO.class)
                    )
            ),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<ArquitetonicoDTO>> getAllArquitetonicos() {
        return ResponseEntity.ok(arquitetonicoService.findAll());
    }

    /**
     * Busca dados arquitetônicos por ID.
     *
     * @param id Identificador dos dados arquitetônicos
     * @return Dados arquitetônicos encontrados
     */
    @GetMapping("/{id}")
    @Operation(
            summary = "Buscar dados arquitetônicos por ID",
            description = "Retorna dados arquitetônicos pelo seu identificador"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Registro encontrado",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ArquitetonicoDTO.class)
                    )
            ),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ArquitetonicoDTO> getArquitetonicoById(
            @Parameter(description = "Identificador dos dados arquitetônicos", example = "1")
            @PathVariable Integer id) {
        return arquitetonicoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Cria novos dados arquitetônicos.
     *
     * @param arquitetonicoDTO Dados arquitetônicos a serem criados
     * @return Dados arquitetônicos criados
     */
    @PostMapping
    @Operation(
            summary = "Criar dados arquitetônicos",
            description = "Cria um novo registro de dados arquitetônicos"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Registro criado com sucesso",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ArquitetonicoDTO.class)
                    )
            ),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ArquitetonicoDTO> createArquitetonico(
            @Valid @RequestBody ArquitetonicoDTO arquitetonicoDTO) {
        return ResponseEntity.ok(arquitetonicoService.save(arquitetonicoDTO));
    }

    /**
     * Atualiza dados arquitetônicos existentes.
     *
     * @param id Identificador dos dados arquitetônicos
     * @param arquitetonicoDTO Dados arquitetônicos atualizados
     * @return Dados arquitetônicos atualizados
     */
    @PutMapping("/{id}")
    @Operation(
            summary = "Atualizar dados arquitetônicos",
            description = "Atualiza dados arquitetônicos existentes pelo seu ID"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Registro atualizado com sucesso",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ArquitetonicoDTO.class)
                    )
            ),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ArquitetonicoDTO> updateArquitetonico(
            @Parameter(description = "Identificador dos dados arquitetônicos", example = "1")
            @PathVariable Integer id,
            @Valid @RequestBody ArquitetonicoDTO arquitetonicoDTO) {
        return arquitetonicoService.findById(id)
                .map(existingArquitetonicoDTO -> {
                    arquitetonicoDTO.setIdarquitetonicos(id);
                    return ResponseEntity.ok(arquitetonicoService.save(arquitetonicoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Exclui dados arquitetônicos por ID.
     *
     * @param id Identificador dos dados arquitetônicos
     * @return Resposta vazia
     */
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Excluir dados arquitetônicos",
            description = "Remove dados arquitetônicos pelo seu ID"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteArquitetonico(
            @Parameter(description = "Identificador dos dados arquitetônicos", example = "1")
            @PathVariable Integer id) {
        arquitetonicoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
