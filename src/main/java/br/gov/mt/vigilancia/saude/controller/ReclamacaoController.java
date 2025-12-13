package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ReclamacaoDTO;
import br.gov.mt.vigilancia.saude.service.ReclamacaoService;
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
 * Controller para gerenciamento de reclamações.
 */
@RestController
@RequestMapping("/reclamacoes")
@RequiredArgsConstructor
@Tag(name = "Reclamações", description = "Consulta de reclamações")
@SecurityRequirement(name = "bearerAuth")
public class ReclamacaoController {

    private final ReclamacaoService reclamacaoService;

    @GetMapping
    @Operation(summary = "Listar reclamações", description = "Retorna todas as reclamações cadastradas")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<ReclamacaoDTO>> findAll() {
        return ResponseEntity.ok(reclamacaoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar reclamação por ID", description = "Retorna uma reclamação específica pelo ID")
    @ApiResponse(responseCode = "200", description = "Reclamação encontrada")
    @ApiResponse(responseCode = "404", description = "Reclamação não encontrada")
    public ResponseEntity<ReclamacaoDTO> findById(@Parameter(description = "ID da reclamação") @PathVariable Integer id) {
        return ResponseEntity.ok(reclamacaoService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Criar reclamação", description = "Cria uma nova reclamação")
    @ApiResponse(responseCode = "200", description = "Reclamação criada com sucesso")
    public ResponseEntity<ReclamacaoDTO> create(@Valid @RequestBody ReclamacaoDTO reclamacaoDTO) {
        return ResponseEntity.ok(reclamacaoService.save(reclamacaoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar reclamação", description = "Atualiza uma reclamação existente")
    @ApiResponse(responseCode = "200", description = "Reclamação atualizada com sucesso")
    @ApiResponse(responseCode = "404", description = "Reclamação não encontrada")
    public ResponseEntity<ReclamacaoDTO> update(@Parameter(description = "ID da reclamação") @PathVariable Integer id, @Valid @RequestBody ReclamacaoDTO reclamacaoDTO) {
        return ResponseEntity.ok(reclamacaoService.update(id, reclamacaoDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir reclamação", description = "Exclui uma reclamação")
    @ApiResponse(responseCode = "204", description = "Reclamação excluída com sucesso")
    @ApiResponse(responseCode = "404", description = "Reclamação não encontrada")
    public ResponseEntity<Void> delete(@Parameter(description = "ID da reclamação") @PathVariable Integer id) {
        reclamacaoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
