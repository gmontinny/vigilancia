package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ProcessoDTO;
import br.gov.mt.vigilancia.saude.service.ProcessoService;
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
 * Controller para gerenciamento de processos administrativos.
 * Fornece endpoints para consulta de processos do sistema de vigilância sanitária.
 */
@RestController
@RequestMapping("/processos")
@RequiredArgsConstructor
@Tag(name = "Processos", description = "Gerenciamento de processos administrativos")
@SecurityRequirement(name = "bearerAuth")
public class ProcessoController {

    private final ProcessoService processoService;

    /**
     * Lista todos os processos cadastrados no sistema.
     * 
     * @return Lista de processos
     */
    @GetMapping
    @Operation(
        summary = "Listar processos",
        description = "Retorna a lista de todos os processos administrativos cadastrados"
    )
    @ApiResponse(responseCode = "200", description = "Lista de processos retornada com sucesso")
    @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido ou ausente")
    public ResponseEntity<List<ProcessoDTO>> findAll() {
        return ResponseEntity.ok(processoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar processo por ID", description = "Retorna um processo específico pelo ID")
    @ApiResponse(responseCode = "200", description = "Processo encontrado")
    @ApiResponse(responseCode = "404", description = "Processo não encontrado")
    public ResponseEntity<ProcessoDTO> findById(@Parameter(description = "ID do processo") @PathVariable String id) {
        return ResponseEntity.ok(processoService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Criar processo", description = "Cria um novo processo")
    @ApiResponse(responseCode = "200", description = "Processo criado com sucesso")
    public ResponseEntity<ProcessoDTO> create(@Valid @RequestBody ProcessoDTO processoDTO) {
        return ResponseEntity.ok(processoService.save(processoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar processo", description = "Atualiza um processo existente")
    @ApiResponse(responseCode = "200", description = "Processo atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Processo não encontrado")
    public ResponseEntity<ProcessoDTO> update(@Parameter(description = "ID do processo") @PathVariable String id, @Valid @RequestBody ProcessoDTO processoDTO) {
        return ResponseEntity.ok(processoService.update(id, processoDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir processo", description = "Exclui um processo")
    @ApiResponse(responseCode = "204", description = "Processo excluído com sucesso")
    @ApiResponse(responseCode = "404", description = "Processo não encontrado")
    public ResponseEntity<Void> delete(@Parameter(description = "ID do processo") @PathVariable String id) {
        processoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
