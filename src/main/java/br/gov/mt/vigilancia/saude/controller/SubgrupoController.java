package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.SubgrupoDTO;
import br.gov.mt.vigilancia.saude.service.SubgrupoService;
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
 * Controller para consulta de subgrupos.
 */
@RestController
@RequestMapping("/subgrupos")
@RequiredArgsConstructor
@Tag(name = "Subgrupos", description = "Consulta de subgrupos")
@SecurityRequirement(name = "bearerAuth")
public class SubgrupoController {

    private final SubgrupoService subgrupoService;

    @GetMapping
    @Operation(summary = "Listar subgrupos", description = "Retorna todos os subgrupos cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<SubgrupoDTO>> findAll() {
        return ResponseEntity.ok(subgrupoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar subgrupo por ID", description = "Retorna um subgrupo pelo seu identificador")
    @ApiResponse(responseCode = "200", description = "Subgrupo encontrado")
    @ApiResponse(responseCode = "404", description = "Subgrupo não encontrado")
    public ResponseEntity<SubgrupoDTO> findById(@Parameter(description = "ID do subgrupo", example = "1") @PathVariable Integer id) {
        return subgrupoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar subgrupo", description = "Cria um novo subgrupo")
    @ApiResponse(responseCode = "200", description = "Subgrupo criado com sucesso")
    public ResponseEntity<SubgrupoDTO> create(@Valid @RequestBody SubgrupoDTO subgrupoDTO) {
        return ResponseEntity.ok(subgrupoService.save(subgrupoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar subgrupo", description = "Atualiza um subgrupo existente")
    @ApiResponse(responseCode = "200", description = "Subgrupo atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Subgrupo não encontrado")
    public ResponseEntity<SubgrupoDTO> update(@Parameter(description = "ID do subgrupo", example = "1") @PathVariable Integer id, @Valid @RequestBody SubgrupoDTO subgrupoDTO) {
        return subgrupoService.findById(id)
                .map(existing -> {
                    subgrupoDTO.setId(id);
                    return ResponseEntity.ok(subgrupoService.save(subgrupoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir subgrupo", description = "Remove um subgrupo pelo seu ID")
    @ApiResponse(responseCode = "204", description = "Subgrupo excluído com sucesso")
    @ApiResponse(responseCode = "404", description = "Subgrupo não encontrado")
    public ResponseEntity<Void> delete(@Parameter(description = "ID do subgrupo", example = "1") @PathVariable Integer id) {
        subgrupoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
