package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.TramitacaoDTO;
import br.gov.mt.vigilancia.saude.service.TramitacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller para gerenciamento de tramitações de processos.
 */
@RestController
@RequestMapping("/tramitacoes")
@Tag(name = "Tramitações", description = "Gerenciamento de tramitações de processos")
@SecurityRequirement(name = "bearerAuth")
public class TramitacaoController {

    @Autowired
    private TramitacaoService tramitacaoService;

    @GetMapping
    @Operation(summary = "Listar tramitações", description = "Retorna todas as tramitações de processos")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<TramitacaoDTO>> getAllTramitacoes() {
        return ResponseEntity.ok(tramitacaoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar tramitação por ID", description = "Retorna uma tramitação específica")
    @ApiResponse(responseCode = "200", description = "Tramitação encontrada")
    @ApiResponse(responseCode = "404", description = "Tramitação não encontrada")
    public ResponseEntity<TramitacaoDTO> getTramitacaoById(
        @Parameter(description = "ID da tramitação") @PathVariable Integer id) {
        return tramitacaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar tramitação", description = "Cria uma nova tramitação de processo")
    @ApiResponse(responseCode = "200", description = "Tramitação criada com sucesso")
    public ResponseEntity<TramitacaoDTO> createTramitacao(@RequestBody @Valid TramitacaoDTO tramitacaoDTO) {
        return ResponseEntity.ok(tramitacaoService.save(tramitacaoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar tramitação", description = "Atualiza uma tramitação existente")
    @ApiResponse(responseCode = "200", description = "Tramitação atualizada com sucesso")
    @ApiResponse(responseCode = "404", description = "Tramitação não encontrada")
    public ResponseEntity<TramitacaoDTO> updateTramitacao(
        @Parameter(description = "ID da tramitação") @PathVariable Integer id, 
        @RequestBody @Valid TramitacaoDTO tramitacaoDTO) {
        return tramitacaoService.findById(id)
                .map(existingTramitacaoDTO -> {
                    tramitacaoDTO.setIdtramitacao(id);
                    return ResponseEntity.ok(tramitacaoService.save(tramitacaoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover tramitação", description = "Remove uma tramitação do sistema")
    @ApiResponse(responseCode = "204", description = "Tramitação removida com sucesso")
    public ResponseEntity<Void> deleteTramitacao(
        @Parameter(description = "ID da tramitação") @PathVariable Integer id) {
        tramitacaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
