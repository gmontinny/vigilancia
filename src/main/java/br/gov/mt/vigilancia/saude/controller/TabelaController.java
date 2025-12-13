package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.TabelaDTO;
import br.gov.mt.vigilancia.saude.service.TabelaService;
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
 * Controller para gerenciamento de tabelas do sistema.
 */
@RestController
@RequestMapping("/tabelas")
@RequiredArgsConstructor
@Tag(name = "Tabelas", description = "Consulta de tabelas do sistema")
@SecurityRequirement(name = "bearerAuth")
public class TabelaController {

    private final TabelaService tabelaService;

    @GetMapping
    @Operation(summary = "Listar tabelas", description = "Retorna todas as tabelas do sistema")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<TabelaDTO>> findAll() {
        return ResponseEntity.ok(tabelaService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar tabela por ID", description = "Retorna uma tabela pelo seu identificador")
    @ApiResponse(responseCode = "200", description = "Tabela encontrada")
    @ApiResponse(responseCode = "404", description = "Tabela não encontrada")
    public ResponseEntity<TabelaDTO> findById(@Parameter(description = "ID da tabela", example = "1") @PathVariable Integer id) {
        return tabelaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar tabela", description = "Cria uma nova tabela no sistema")
    @ApiResponse(responseCode = "200", description = "Tabela criada com sucesso")
    public ResponseEntity<TabelaDTO> create(@Valid @RequestBody TabelaDTO tabelaDTO) {
        return ResponseEntity.ok(tabelaService.save(tabelaDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar tabela", description = "Atualiza uma tabela existente")
    @ApiResponse(responseCode = "200", description = "Tabela atualizada com sucesso")
    @ApiResponse(responseCode = "404", description = "Tabela não encontrada")
    public ResponseEntity<TabelaDTO> update(@Parameter(description = "ID da tabela", example = "1") @PathVariable Integer id, @Valid @RequestBody TabelaDTO tabelaDTO) {
        return tabelaService.findById(id)
                .map(existing -> {
                    tabelaDTO.setId(id);
                    return ResponseEntity.ok(tabelaService.save(tabelaDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir tabela", description = "Remove uma tabela pelo seu ID")
    @ApiResponse(responseCode = "204", description = "Tabela excluída com sucesso")
    @ApiResponse(responseCode = "404", description = "Tabela não encontrada")
    public ResponseEntity<Void> delete(@Parameter(description = "ID da tabela", example = "1") @PathVariable Integer id) {
        tabelaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
