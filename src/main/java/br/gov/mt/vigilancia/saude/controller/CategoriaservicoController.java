package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.CategoriaservicoDTO;
import br.gov.mt.vigilancia.saude.service.CategoriaservicoService;
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
@RequestMapping("/categoriaservicos")
@Tag(name = "Categoria de Serviço", description = "Operações CRUD para categorias de serviço")
public class CategoriaservicoController {

    @Autowired
    private CategoriaservicoService categoriaservicoService;

    @GetMapping
    @Operation(summary = "Listar categorias de serviço", description = "Retorna a lista completa de categorias de serviço cadastradas")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoriaservicoDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<CategoriaservicoDTO>> getAllCategoriaservicos() {
        return ResponseEntity.ok(categoriaservicoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar categoria de serviço por ID", description = "Retorna uma categoria de serviço pelo seu identificador")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoriaservicoDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<CategoriaservicoDTO> getCategoriaservicoById(
            @Parameter(description = "Identificador da categoria de serviço", example = "1") @PathVariable Integer id) {
        return categoriaservicoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar categoria de serviço", description = "Cria uma nova categoria de serviço")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro criado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoriaservicoDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<CategoriaservicoDTO> createCategoriaservico(@Valid @RequestBody CategoriaservicoDTO categoriaservicoDTO) {
        return ResponseEntity.ok(categoriaservicoService.save(categoriaservicoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar categoria de serviço", description = "Atualiza uma categoria de serviço existente pelo seu ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoriaservicoDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<CategoriaservicoDTO> updateCategoriaservico(
            @Parameter(description = "Identificador da categoria de serviço", example = "1") @PathVariable Integer id,
            @Valid @RequestBody CategoriaservicoDTO categoriaservicoDTO) {
        return categoriaservicoService.findById(id)
                .map(existingCategoriaservicoDTO -> {
                    categoriaservicoDTO.setIdcategoriaservico(id);
                    return ResponseEntity.ok(categoriaservicoService.save(categoriaservicoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir categoria de serviço", description = "Remove uma categoria de serviço pelo seu ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteCategoriaservico(
            @Parameter(description = "Identificador da categoria de serviço", example = "1") @PathVariable Integer id) {
        categoriaservicoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
