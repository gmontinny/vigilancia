package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.CategoriaroteiroDTO;
import br.gov.mt.vigilancia.saude.service.CategoriaroteiroService;
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
@RequestMapping("/categoriaroteiros")
@Tag(name = "Categoria de Roteiro", description = "Operações CRUD para categorias de roteiro")
public class CategoriaroteiroController {

    @Autowired
    private CategoriaroteiroService categoriaroteiroService;

    @GetMapping
    @Operation(summary = "Listar categorias de roteiro", description = "Retorna a lista completa de categorias de roteiro cadastradas")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoriaroteiroDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<CategoriaroteiroDTO>> getAllCategoriaroteiros() {
        return ResponseEntity.ok(categoriaroteiroService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar categoria de roteiro por ID", description = "Retorna uma categoria de roteiro pelo seu identificador")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoriaroteiroDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<CategoriaroteiroDTO> getCategoriaroteiroById(
            @Parameter(description = "Identificador da categoria de roteiro", example = "1") @PathVariable Integer id) {
        return categoriaroteiroService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar categoria de roteiro", description = "Cria uma nova categoria de roteiro")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro criado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoriaroteiroDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<CategoriaroteiroDTO> createCategoriaroteiro(@Valid @RequestBody CategoriaroteiroDTO categoriaroteiroDTO) {
        return ResponseEntity.ok(categoriaroteiroService.save(categoriaroteiroDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar categoria de roteiro", description = "Atualiza uma categoria de roteiro existente pelo seu ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoriaroteiroDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<CategoriaroteiroDTO> updateCategoriaroteiro(
            @Parameter(description = "Identificador da categoria de roteiro", example = "1") @PathVariable Integer id,
            @Valid @RequestBody CategoriaroteiroDTO categoriaroteiroDTO) {
        return categoriaroteiroService.findById(id)
                .map(existingCategoriaroteiroDTO -> {
                    categoriaroteiroDTO.setIdcategoriaroteiro(id);
                    return ResponseEntity.ok(categoriaroteiroService.save(categoriaroteiroDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir categoria de roteiro", description = "Remove uma categoria de roteiro pelo seu ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteCategoriaroteiro(
            @Parameter(description = "Identificador da categoria de roteiro", example = "1") @PathVariable Integer id) {
        categoriaroteiroService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
