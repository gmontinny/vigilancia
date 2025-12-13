package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ApreensaoDTO;
import br.gov.mt.vigilancia.saude.service.ApreensaoService;
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
 * Controller para consulta de apreensões.
 */
@RestController
@RequestMapping("/apreensoes")
@RequiredArgsConstructor
@Tag(name = "Apreensões", description = "Consulta de apreensões")
@io.swagger.v3.oas.annotations.security.SecurityRequirement(name = "bearerAuth")
public class ApreensaoController {

    private final ApreensaoService apreensaoService;

    @GetMapping
    @Operation(summary = "Listar apreensões", description = "Retorna a lista de apreensões cadastradas")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<ApreensaoDTO>> findAll() {
        return ResponseEntity.ok(apreensaoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar apreensão por ID", description = "Retorna uma apreensão pelo seu identificador")
    @ApiResponse(responseCode = "200", description = "Apreensão encontrada")
    @ApiResponse(responseCode = "404", description = "Apreensão não encontrada")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ApreensaoDTO> findById(@Parameter(description = "ID da apreensão", example = "1") @PathVariable Integer id) {
        return apreensaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar apreensão", description = "Cria uma nova apreensão")
    @ApiResponse(responseCode = "200", description = "Apreensão criada com sucesso")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ApreensaoDTO> create(@Valid @RequestBody ApreensaoDTO apreensaoDTO) {
        return ResponseEntity.ok(apreensaoService.save(apreensaoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar apreensão", description = "Atualiza uma apreensão existente")
    @ApiResponse(responseCode = "200", description = "Apreensão atualizada com sucesso")
    @ApiResponse(responseCode = "404", description = "Apreensão não encontrada")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ApreensaoDTO> update(@Parameter(description = "ID da apreensão", example = "1") @PathVariable Integer id, @Valid @RequestBody ApreensaoDTO apreensaoDTO) {
        return apreensaoService.findById(id)
                .map(existing -> {
                    apreensaoDTO.setId(id);
                    return ResponseEntity.ok(apreensaoService.save(apreensaoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir apreensão", description = "Remove uma apreensão pelo seu ID")
    @ApiResponse(responseCode = "204", description = "Apreensão excluída com sucesso")
    @ApiResponse(responseCode = "404", description = "Apreensão não encontrada")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> delete(@Parameter(description = "ID da apreensão", example = "1") @PathVariable Integer id) {
        apreensaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
