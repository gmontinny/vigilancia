package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ProdutoCategoriaDTO;
import br.gov.mt.vigilancia.saude.service.ProdutoCategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller para gerenciamento de categorias de produtos.
 * Fornece operações CRUD completas para categorias de produtos sujeitos à vigilância sanitária.
 */
@RestController
@RequestMapping("/produtocategorias")
@Tag(name = "Categorias de Produtos", description = "Gerenciamento de categorias de produtos")
@SecurityRequirement(name = "bearerAuth")
public class ProdutoCategoriaController {

    @Autowired
    private ProdutoCategoriaService produtocategoriaService;

    /**
     * Lista todas as categorias de produtos cadastradas.
     * 
     * @return Lista de categorias de produtos
     */
    @GetMapping
    @Operation(
        summary = "Listar categorias de produtos",
        description = "Retorna a lista de todas as categorias de produtos cadastradas no sistema"
    )
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    @ApiResponse(responseCode = "401", description = "Não autorizado")
    public ResponseEntity<List<ProdutoCategoriaDTO>> getAllProdutocategorias() {
        return ResponseEntity.ok(produtocategoriaService.findAll());
    }

    /**
     * Busca uma categoria de produto por ID.
     * 
     * @param id ID da categoria de produto
     * @return Categoria de produto encontrada
     */
    @GetMapping("/{id}")
    @Operation(
        summary = "Buscar categoria por ID",
        description = "Retorna uma categoria de produto específica pelo seu ID"
    )
    @ApiResponse(responseCode = "200", description = "Categoria encontrada")
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    @ApiResponse(responseCode = "401", description = "Não autorizado")
    public ResponseEntity<ProdutoCategoriaDTO> getProdutocategoriaById(
        @Parameter(description = "ID da categoria de produto", example = "1")
        @PathVariable Integer id) {
        return produtocategoriaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Cria uma nova categoria de produto.
     * 
     * @param produtocategoriaDTO Dados da categoria a ser criada
     * @return Categoria criada
     */
    @PostMapping
    @Operation(
        summary = "Criar categoria de produto",
        description = "Cria uma nova categoria de produto no sistema"
    )
    @ApiResponse(responseCode = "200", description = "Categoria criada com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "401", description = "Não autorizado")
    public ResponseEntity<ProdutoCategoriaDTO> createProdutocategoria(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Dados da categoria de produto",
            content = @Content(schema = @Schema(implementation = ProdutoCategoriaDTO.class))
        )
        @RequestBody @Valid ProdutoCategoriaDTO produtocategoriaDTO) {
        return ResponseEntity.ok(produtocategoriaService.save(produtocategoriaDTO));
    }

    /**
     * Atualiza uma categoria de produto existente.
     * 
     * @param id ID da categoria a ser atualizada
     * @param produtocategoriaDTO Novos dados da categoria
     * @return Categoria atualizada
     */
    @PutMapping("/{id}")
    @Operation(
        summary = "Atualizar categoria de produto",
        description = "Atualiza os dados de uma categoria de produto existente"
    )
    @ApiResponse(responseCode = "200", description = "Categoria atualizada com sucesso")
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "401", description = "Não autorizado")
    public ResponseEntity<ProdutoCategoriaDTO> updateProdutocategoria(
        @Parameter(description = "ID da categoria de produto", example = "1")
        @PathVariable Integer id,
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Novos dados da categoria de produto",
            content = @Content(schema = @Schema(implementation = ProdutoCategoriaDTO.class))
        )
        @RequestBody @Valid ProdutoCategoriaDTO produtocategoriaDTO) {
        return produtocategoriaService.findById(id)
                .map(existingProdutocategoriaDTO -> {
                    produtocategoriaDTO.setIdprodutocategoria(id);
                    return ResponseEntity.ok(produtocategoriaService.save(produtocategoriaDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Remove uma categoria de produto.
     * 
     * @param id ID da categoria a ser removida
     * @return Resposta vazia
     */
    @DeleteMapping("/{id}")
    @Operation(
        summary = "Remover categoria de produto",
        description = "Remove uma categoria de produto do sistema"
    )
    @ApiResponse(responseCode = "204", description = "Categoria removida com sucesso")
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    @ApiResponse(responseCode = "401", description = "Não autorizado")
    public ResponseEntity<Void> deleteProdutocategoria(
        @Parameter(description = "ID da categoria de produto", example = "1")
        @PathVariable Integer id) {
        produtocategoriaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
