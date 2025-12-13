package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.GeraautoDTO;
import br.gov.mt.vigilancia.saude.service.GeraautoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller para consulta de geradores de auto (sistema legado).
 */
@RestController
@RequestMapping("/geraautos")
@RequiredArgsConstructor
@Tag(name = "Geradores de Auto", description = "Consulta de geradores de auto (sistema legado)")
@SecurityRequirement(name = "bearerAuth")
public class GeraautoController {

    private final GeraautoService geraautoService;

    @GetMapping
    @Operation(summary = "Listar geradores de auto", description = "Retorna todos os geradores de auto cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<GeraautoDTO>> findAll() {
        return ResponseEntity.ok(geraautoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar gerador de auto por ID", description = "Retorna um gerador de auto específico pelo ID")
    @ApiResponse(responseCode = "200", description = "Gerador de auto encontrado")
    @ApiResponse(responseCode = "404", description = "Gerador de auto não encontrado")
    public ResponseEntity<GeraautoDTO> findById(@Parameter(description = "ID do gerador de auto") @PathVariable Integer id) {
        return ResponseEntity.ok(geraautoService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Criar gerador de auto", description = "Cria um novo gerador de auto")
    @ApiResponse(responseCode = "200", description = "Gerador de auto criado com sucesso")
    public ResponseEntity<GeraautoDTO> create(@Valid @RequestBody GeraautoDTO geraautoDTO) {
        return ResponseEntity.ok(geraautoService.save(geraautoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar gerador de auto", description = "Atualiza um gerador de auto existente")
    @ApiResponse(responseCode = "200", description = "Gerador de auto atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Gerador de auto não encontrado")
    public ResponseEntity<GeraautoDTO> update(@Parameter(description = "ID do gerador de auto") @PathVariable Integer id, @Valid @RequestBody GeraautoDTO geraautoDTO) {
        return ResponseEntity.ok(geraautoService.update(id, geraautoDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir gerador de auto", description = "Exclui um gerador de auto")
    @ApiResponse(responseCode = "204", description = "Gerador de auto excluído com sucesso")
    @ApiResponse(responseCode = "404", description = "Gerador de auto não encontrado")
    public ResponseEntity<Void> delete(@Parameter(description = "ID do gerador de auto") @PathVariable Integer id) {
        geraautoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
