package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.GrupoDTO;
import br.gov.mt.vigilancia.saude.service.GrupoService;
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
 * Controller para consulta de grupos.
 */
@RestController
@RequestMapping("/grupos")
@RequiredArgsConstructor
@Tag(name = "Grupos", description = "Consulta de grupos")
@SecurityRequirement(name = "bearerAuth")
public class GrupoController {

    private final GrupoService grupoService;

    @GetMapping
    @Operation(summary = "Listar grupos", description = "Retorna todos os grupos cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<GrupoDTO>> findAll() {
        return ResponseEntity.ok(grupoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar grupo por ID", description = "Retorna um grupo pelo seu identificador")
    @ApiResponse(responseCode = "200", description = "Grupo encontrado")
    @ApiResponse(responseCode = "404", description = "Grupo não encontrado")
    public ResponseEntity<GrupoDTO> findById(@Parameter(description = "ID do grupo", example = "1") @PathVariable Integer id) {
        return grupoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar grupo", description = "Cria um novo grupo")
    @ApiResponse(responseCode = "200", description = "Grupo criado com sucesso")
    public ResponseEntity<GrupoDTO> create(@Valid @RequestBody GrupoDTO grupoDTO) {
        return ResponseEntity.ok(grupoService.save(grupoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar grupo", description = "Atualiza um grupo existente")
    @ApiResponse(responseCode = "200", description = "Grupo atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Grupo não encontrado")
    public ResponseEntity<GrupoDTO> update(@Parameter(description = "ID do grupo", example = "1") @PathVariable Integer id, @Valid @RequestBody GrupoDTO grupoDTO) {
        return grupoService.findById(id)
                .map(existing -> {
                    grupoDTO.setId(id);
                    return ResponseEntity.ok(grupoService.save(grupoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir grupo", description = "Remove um grupo pelo seu ID")
    @ApiResponse(responseCode = "204", description = "Grupo excluído com sucesso")
    @ApiResponse(responseCode = "404", description = "Grupo não encontrado")
    public ResponseEntity<Void> delete(@Parameter(description = "ID do grupo", example = "1") @PathVariable Integer id) {
        grupoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
