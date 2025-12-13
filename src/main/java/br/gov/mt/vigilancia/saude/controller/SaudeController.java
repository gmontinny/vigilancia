package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.SaudeDTO;
import br.gov.mt.vigilancia.saude.service.SaudeService;
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
 * Controller para consulta de dados de saúde.
 */
@RestController
@RequestMapping("/saudes")
@RequiredArgsConstructor
@Tag(name = "Saúde", description = "Consulta de dados de saúde")
@SecurityRequirement(name = "bearerAuth")
public class SaudeController {

    private final SaudeService saudeService;

    @GetMapping
    @Operation(summary = "Listar dados de saúde", description = "Retorna todos os dados de saúde cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<SaudeDTO>> findAll() {
        return ResponseEntity.ok(saudeService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar saúde por ID", description = "Retorna um dado de saúde específico pelo ID")
    @ApiResponse(responseCode = "200", description = "Saúde encontrada")
    @ApiResponse(responseCode = "404", description = "Saúde não encontrada")
    public ResponseEntity<SaudeDTO> findById(@Parameter(description = "ID da saúde") @PathVariable Integer id) {
        return ResponseEntity.ok(saudeService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Criar saúde", description = "Cria um novo dado de saúde")
    @ApiResponse(responseCode = "200", description = "Saúde criada com sucesso")
    public ResponseEntity<SaudeDTO> create(@Valid @RequestBody SaudeDTO saudeDTO) {
        return ResponseEntity.ok(saudeService.save(saudeDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar saúde", description = "Atualiza um dado de saúde existente")
    @ApiResponse(responseCode = "200", description = "Saúde atualizada com sucesso")
    @ApiResponse(responseCode = "404", description = "Saúde não encontrada")
    public ResponseEntity<SaudeDTO> update(@Parameter(description = "ID da saúde") @PathVariable Integer id, @Valid @RequestBody SaudeDTO saudeDTO) {
        return ResponseEntity.ok(saudeService.update(id, saudeDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir saúde", description = "Exclui um dado de saúde")
    @ApiResponse(responseCode = "204", description = "Saúde excluída com sucesso")
    @ApiResponse(responseCode = "404", description = "Saúde não encontrada")
    public ResponseEntity<Void> delete(@Parameter(description = "ID da saúde") @PathVariable Integer id) {
        saudeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
