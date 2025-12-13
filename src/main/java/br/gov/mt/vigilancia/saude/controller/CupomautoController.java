package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.CupomautoDTO;
import br.gov.mt.vigilancia.saude.service.CupomautoService;
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
 * Controller para consulta de cupons de auto (sistema legado).
 */
@RestController
@RequestMapping("/cupomautos")
@RequiredArgsConstructor
@Tag(name = "Cupons de Auto", description = "Consulta de cupons de auto (sistema legado)")
@SecurityRequirement(name = "bearerAuth")
public class CupomautoController {

    private final CupomautoService cupomautoService;

    @GetMapping
    @Operation(summary = "Listar cupons de auto", description = "Retorna todos os cupons de auto cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<CupomautoDTO>> findAll() {
        return ResponseEntity.ok(cupomautoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar cupom por ID", description = "Retorna um cupom de auto pelo seu identificador")
    @ApiResponse(responseCode = "200", description = "Cupom encontrado")
    @ApiResponse(responseCode = "404", description = "Cupom não encontrado")
    public ResponseEntity<CupomautoDTO> findById(@Parameter(description = "ID do cupom", example = "1") @PathVariable Integer id) {
        return cupomautoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar cupom de auto", description = "Cria um novo cupom de auto")
    @ApiResponse(responseCode = "200", description = "Cupom criado com sucesso")
    public ResponseEntity<CupomautoDTO> create(@Valid @RequestBody CupomautoDTO cupomautoDTO) {
        return ResponseEntity.ok(cupomautoService.save(cupomautoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar cupom de auto", description = "Atualiza um cupom de auto existente")
    @ApiResponse(responseCode = "200", description = "Cupom atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Cupom não encontrado")
    public ResponseEntity<CupomautoDTO> update(@Parameter(description = "ID do cupom", example = "1") @PathVariable Integer id, @Valid @RequestBody CupomautoDTO cupomautoDTO) {
        return cupomautoService.findById(id)
                .map(existing -> {
                    cupomautoDTO.setId(id);
                    return ResponseEntity.ok(cupomautoService.save(cupomautoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir cupom de auto", description = "Remove um cupom de auto pelo seu ID")
    @ApiResponse(responseCode = "204", description = "Cupom excluído com sucesso")
    @ApiResponse(responseCode = "404", description = "Cupom não encontrado")
    public ResponseEntity<Void> delete(@Parameter(description = "ID do cupom", example = "1") @PathVariable Integer id) {
        cupomautoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
