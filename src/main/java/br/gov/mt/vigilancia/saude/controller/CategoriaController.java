package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.CategoriaDTO;
import br.gov.mt.vigilancia.saude.service.CategoriaService;
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
 * Controller para consulta de categorias.
 */
@RestController
@RequestMapping("/categorias")
@RequiredArgsConstructor
@Tag(name = "Categorias", description = "Consulta de categorias")
@SecurityRequirement(name = "bearerAuth")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping
    @Operation(summary = "Listar categorias", description = "Retorna todas as categorias cadastradas")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<CategoriaDTO>> findAll() {
        return ResponseEntity.ok(categoriaService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar categoria por ID", description = "Retorna uma categoria específica pelo ID")
    @ApiResponse(responseCode = "200", description = "Categoria encontrada")
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    public ResponseEntity<CategoriaDTO> findById(@Parameter(description = "ID da categoria") @PathVariable Integer id) {
        return ResponseEntity.ok(categoriaService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Criar categoria", description = "Cria uma nova categoria")
    @ApiResponse(responseCode = "200", description = "Categoria criada com sucesso")
    public ResponseEntity<CategoriaDTO> create(@Valid @RequestBody CategoriaDTO categoriaDTO) {
        return ResponseEntity.ok(categoriaService.save(categoriaDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar categoria", description = "Atualiza uma categoria existente")
    @ApiResponse(responseCode = "200", description = "Categoria atualizada com sucesso")
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    public ResponseEntity<CategoriaDTO> update(@Parameter(description = "ID da categoria") @PathVariable Integer id, @Valid @RequestBody CategoriaDTO categoriaDTO) {
        return ResponseEntity.ok(categoriaService.update(id, categoriaDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir categoria", description = "Exclui uma categoria")
    @ApiResponse(responseCode = "204", description = "Categoria excluída com sucesso")
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    public ResponseEntity<Void> delete(@Parameter(description = "ID da categoria") @PathVariable Integer id) {
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
