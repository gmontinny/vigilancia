package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.CategoriaprodutoDTO;
import br.gov.mt.vigilancia.saude.service.CategoriaprodutoService;
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
@RequestMapping("/categoriaprodutos")
@Tag(name = "Categoria de Produto", description = "Operações CRUD para categorias de produto")
public class CategoriaprodutoController {

    @Autowired
    private CategoriaprodutoService categoriaprodutoService;

    @GetMapping
    @Operation(summary = "Listar categorias de produto", description = "Retorna a lista completa de categorias de produto cadastradas")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoriaprodutoDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<CategoriaprodutoDTO>> getAllCategoriaprodutos() {
        return ResponseEntity.ok(categoriaprodutoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar categoria de produto por ID", description = "Retorna uma categoria de produto pelo seu identificador")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoriaprodutoDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<CategoriaprodutoDTO> getCategoriaprodutoById(
            @Parameter(description = "Identificador da categoria de produto", example = "1") @PathVariable Integer id) {
        return categoriaprodutoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar categoria de produto", description = "Cria uma nova categoria de produto")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro criado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoriaprodutoDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<CategoriaprodutoDTO> createCategoriaproduto(@Valid @RequestBody CategoriaprodutoDTO categoriaprodutoDTO) {
        return ResponseEntity.ok(categoriaprodutoService.save(categoriaprodutoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar categoria de produto", description = "Atualiza uma categoria de produto existente pelo seu ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoriaprodutoDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<CategoriaprodutoDTO> updateCategoriaproduto(
            @Parameter(description = "Identificador da categoria de produto", example = "1") @PathVariable Integer id,
            @Valid @RequestBody CategoriaprodutoDTO categoriaprodutoDTO) {
        return categoriaprodutoService.findById(id)
                .map(existingCategoriaprodutoDTO -> {
                    categoriaprodutoDTO.setIdcategoriaproduto(id);
                    return ResponseEntity.ok(categoriaprodutoService.save(categoriaprodutoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir categoria de produto", description = "Remove uma categoria de produto pelo seu ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteCategoriaproduto(
            @Parameter(description = "Identificador da categoria de produto", example = "1") @PathVariable Integer id) {
        categoriaprodutoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
