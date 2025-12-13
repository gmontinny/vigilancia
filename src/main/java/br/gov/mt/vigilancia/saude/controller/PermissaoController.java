package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.PermissaoDTO;
import br.gov.mt.vigilancia.saude.service.PermissaoService;
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
 * Controller para gerenciamento de permissões do sistema.
 */
@RestController
@RequestMapping("/permissoes")
@RequiredArgsConstructor
@Tag(name = "Permissões", description = "Consulta de permissões do sistema")
@SecurityRequirement(name = "bearerAuth")
public class PermissaoController {

    private final PermissaoService permissaoService;

    @GetMapping
    @Operation(summary = "Listar permissões", description = "Retorna todas as permissões do sistema")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<PermissaoDTO>> findAll() {
        return ResponseEntity.ok(permissaoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar permissão por ID", description = "Retorna uma permissão pelo seu identificador")
    @ApiResponse(responseCode = "200", description = "Permissão encontrada")
    @ApiResponse(responseCode = "404", description = "Permissão não encontrada")
    public ResponseEntity<PermissaoDTO> findById(@Parameter(description = "ID da permissão", example = "1") @PathVariable Integer id) {
        return permissaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar permissão", description = "Cria uma nova permissão no sistema")
    @ApiResponse(responseCode = "200", description = "Permissão criada com sucesso")
    public ResponseEntity<PermissaoDTO> create(@Valid @RequestBody PermissaoDTO permissaoDTO) {
        return ResponseEntity.ok(permissaoService.save(permissaoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar permissão", description = "Atualiza uma permissão existente")
    @ApiResponse(responseCode = "200", description = "Permissão atualizada com sucesso")
    @ApiResponse(responseCode = "404", description = "Permissão não encontrada")
    public ResponseEntity<PermissaoDTO> update(@Parameter(description = "ID da permissão", example = "1") @PathVariable Integer id, @Valid @RequestBody PermissaoDTO permissaoDTO) {
        return permissaoService.findById(id)
                .map(existing -> {
                    permissaoDTO.setId(id);
                    return ResponseEntity.ok(permissaoService.save(permissaoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir permissão", description = "Remove uma permissão pelo seu ID")
    @ApiResponse(responseCode = "204", description = "Permissão excluída com sucesso")
    @ApiResponse(responseCode = "404", description = "Permissão não encontrada")
    public ResponseEntity<Void> delete(@Parameter(description = "ID da permissão", example = "1") @PathVariable Integer id) {
        permissaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
