package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ProdutoDTO;
import br.gov.mt.vigilancia.saude.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller para consulta de produtos.
 */
@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
@Tag(name = "Produtos", description = "Consulta de produtos")
@SecurityRequirement(name = "bearerAuth")
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping
    @Operation(summary = "Listar produtos", description = "Retorna todos os produtos cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<ProdutoDTO>> findAll() {
        return ResponseEntity.ok(produtoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar produto por ID", description = "Retorna um produto específico pelo ID")
    @ApiResponse(responseCode = "200", description = "Produto encontrado")
    @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    public ResponseEntity<ProdutoDTO> findById(@Parameter(description = "ID do produto") @PathVariable Integer id) {
        return ResponseEntity.ok(produtoService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Criar produto", description = "Cria um novo produto")
    @ApiResponse(responseCode = "200", description = "Produto criado com sucesso")
    public ResponseEntity<ProdutoDTO> create(@Valid @RequestBody ProdutoDTO produtoDTO) {
        return ResponseEntity.ok(produtoService.save(produtoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar produto", description = "Atualiza um produto existente")
    @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    public ResponseEntity<ProdutoDTO> update(@Parameter(description = "ID do produto") @PathVariable Integer id, @Valid @RequestBody ProdutoDTO produtoDTO) {
        return ResponseEntity.ok(produtoService.update(id, produtoDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir produto", description = "Exclui um produto")
    @ApiResponse(responseCode = "204", description = "Produto excluído com sucesso")
    @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    public ResponseEntity<Void> delete(@Parameter(description = "ID do produto") @PathVariable Integer id) {
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
