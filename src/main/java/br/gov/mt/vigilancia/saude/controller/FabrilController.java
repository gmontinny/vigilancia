package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.FabrilDTO;
import br.gov.mt.vigilancia.saude.service.FabrilService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller para gerenciamento de dados fabris.
 * Fornece endpoints para consulta de informações relacionadas a estabelecimentos fabris.
 */
@RestController
@RequestMapping("/fabris")
@RequiredArgsConstructor
@Tag(name = "Fabris", description = "Operações de consulta de dados fabris")
public class FabrilController {

    private final FabrilService fabrilService;

    /**
     * Lista todos os registros fabris cadastrados no sistema.
     *
     * @return Lista de dados fabris
     */
    @GetMapping
    @Operation(summary = "Listar dados fabris", description = "Retorna a lista completa de dados fabris cadastrados no sistema")
    @ApiResponse(responseCode = "200", description = "Lista de dados fabris retornada com sucesso")
    @ApiResponse(responseCode = "401", description = "Não autorizado")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<FabrilDTO>> findAll() {
        return ResponseEntity.ok(fabrilService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar dado fabril por ID", description = "Retorna um dado fabril pelo seu identificador")
    @ApiResponse(responseCode = "200", description = "Dado fabril encontrado")
    @ApiResponse(responseCode = "404", description = "Dado fabril não encontrado")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<FabrilDTO> findById(@Parameter(description = "ID do dado fabril", example = "1") @PathVariable Integer id) {
        return fabrilService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar dado fabril", description = "Cria um novo dado fabril")
    @ApiResponse(responseCode = "200", description = "Dado fabril criado com sucesso")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<FabrilDTO> create(@Valid @RequestBody FabrilDTO fabrilDTO) {
        return ResponseEntity.ok(fabrilService.save(fabrilDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar dado fabril", description = "Atualiza um dado fabril existente")
    @ApiResponse(responseCode = "200", description = "Dado fabril atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Dado fabril não encontrado")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<FabrilDTO> update(@Parameter(description = "ID do dado fabril", example = "1") @PathVariable Integer id, @Valid @RequestBody FabrilDTO fabrilDTO) {
        return fabrilService.findById(id)
                .map(existing -> {
                    fabrilDTO.setId(id);
                    return ResponseEntity.ok(fabrilService.save(fabrilDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir dado fabril", description = "Remove um dado fabril pelo seu ID")
    @ApiResponse(responseCode = "204", description = "Dado fabril excluído com sucesso")
    @ApiResponse(responseCode = "404", description = "Dado fabril não encontrado")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> delete(@Parameter(description = "ID do dado fabril", example = "1") @PathVariable Integer id) {
        fabrilService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
