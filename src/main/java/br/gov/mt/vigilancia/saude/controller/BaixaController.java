package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.BaixaDTO;
import br.gov.mt.vigilancia.saude.service.BaixaService;
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
 * Controller para consulta de baixas.
 */
@RestController
@RequestMapping("/baixas")
@RequiredArgsConstructor
@Tag(name = "Baixas", description = "Consulta de baixas")
@SecurityRequirement(name = "bearerAuth")
public class BaixaController {

    private final BaixaService baixaService;

    @GetMapping
    @Operation(summary = "Listar baixas", description = "Retorna todas as baixas cadastradas")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<BaixaDTO>> findAll() {
        return ResponseEntity.ok(baixaService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar baixa por ID", description = "Retorna uma baixa pelo seu identificador")
    @ApiResponse(responseCode = "200", description = "Baixa encontrada")
    @ApiResponse(responseCode = "404", description = "Baixa não encontrada")
    public ResponseEntity<BaixaDTO> findById(@Parameter(description = "ID da baixa", example = "1") @PathVariable Integer id) {
        return baixaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar baixa", description = "Cria uma nova baixa")
    @ApiResponse(responseCode = "200", description = "Baixa criada com sucesso")
    public ResponseEntity<BaixaDTO> create(@Valid @RequestBody BaixaDTO baixaDTO) {
        return ResponseEntity.ok(baixaService.save(baixaDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar baixa", description = "Atualiza uma baixa existente")
    @ApiResponse(responseCode = "200", description = "Baixa atualizada com sucesso")
    @ApiResponse(responseCode = "404", description = "Baixa não encontrada")
    public ResponseEntity<BaixaDTO> update(@Parameter(description = "ID da baixa", example = "1") @PathVariable Integer id, @Valid @RequestBody BaixaDTO baixaDTO) {
        return baixaService.findById(id)
                .map(existing -> {
                    baixaDTO.setId(id);
                    return ResponseEntity.ok(baixaService.save(baixaDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir baixa", description = "Remove uma baixa pelo seu ID")
    @ApiResponse(responseCode = "204", description = "Baixa excluída com sucesso")
    @ApiResponse(responseCode = "404", description = "Baixa não encontrada")
    public ResponseEntity<Void> delete(@Parameter(description = "ID da baixa", example = "1") @PathVariable Integer id) {
        baixaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
