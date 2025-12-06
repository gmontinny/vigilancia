package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.CategoriaanaliseDTO;
import br.gov.mt.vigilancia.saude.service.CategoriaanaliseService;
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
@RequestMapping("/categoriaanalises")
@Tag(name = "Categoria de Análise", description = "Operações CRUD para categorias de análise")
public class CategoriaanaliseController {

    @Autowired
    private CategoriaanaliseService categoriaanaliseService;

    @GetMapping
    @Operation(summary = "Listar categorias de análise", description = "Retorna a lista completa de categorias de análise cadastradas")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoriaanaliseDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<CategoriaanaliseDTO>> getAllCategoriaanalises() {
        return ResponseEntity.ok(categoriaanaliseService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar categoria de análise por ID", description = "Retorna uma categoria de análise pelo seu identificador")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoriaanaliseDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<CategoriaanaliseDTO> getCategoriaanaliseById(
            @Parameter(description = "Identificador da categoria de análise", example = "1") @PathVariable Integer id) {
        return categoriaanaliseService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar categoria de análise", description = "Cria uma nova categoria de análise")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro criado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoriaanaliseDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<CategoriaanaliseDTO> createCategoriaanalise(@Valid @RequestBody CategoriaanaliseDTO categoriaanaliseDTO) {
        return ResponseEntity.ok(categoriaanaliseService.save(categoriaanaliseDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar categoria de análise", description = "Atualiza uma categoria de análise existente pelo seu ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoriaanaliseDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<CategoriaanaliseDTO> updateCategoriaanalise(
            @Parameter(description = "Identificador da categoria de análise", example = "1") @PathVariable Integer id,
            @Valid @RequestBody CategoriaanaliseDTO categoriaanaliseDTO) {
        return categoriaanaliseService.findById(id)
                .map(existingCategoriaanaliseDTO -> {
                    categoriaanaliseDTO.setIdcategoriaanalise(id);
                    return ResponseEntity.ok(categoriaanaliseService.save(categoriaanaliseDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir categoria de análise", description = "Remove uma categoria de análise pelo seu ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteCategoriaanalise(
            @Parameter(description = "Identificador da categoria de análise", example = "1") @PathVariable Integer id) {
        categoriaanaliseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
