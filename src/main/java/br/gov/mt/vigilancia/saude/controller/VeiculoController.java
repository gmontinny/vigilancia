package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.VeiculoDTO;
import br.gov.mt.vigilancia.saude.service.VeiculoService;
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
 * Controller para consulta de veículos.
 */
@RestController
@RequestMapping("/veiculos")
@RequiredArgsConstructor
@Tag(name = "Veículos", description = "Consulta de veículos")
@SecurityRequirement(name = "bearerAuth")
public class VeiculoController {

    private final VeiculoService veiculoService;

    @GetMapping
    @Operation(summary = "Listar veículos", description = "Retorna todos os veículos cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<VeiculoDTO>> findAll() {
        return ResponseEntity.ok(veiculoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar veículo por ID", description = "Retorna um veículo pelo seu identificador")
    @ApiResponse(responseCode = "200", description = "Veículo encontrado")
    @ApiResponse(responseCode = "404", description = "Veículo não encontrado")
    public ResponseEntity<VeiculoDTO> findById(@Parameter(description = "ID do veículo", example = "1") @PathVariable Integer id) {
        return veiculoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar veículo", description = "Cria um novo veículo")
    @ApiResponse(responseCode = "200", description = "Veículo criado com sucesso")
    public ResponseEntity<VeiculoDTO> create(@Valid @RequestBody VeiculoDTO veiculoDTO) {
        return ResponseEntity.ok(veiculoService.save(veiculoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar veículo", description = "Atualiza um veículo existente")
    @ApiResponse(responseCode = "200", description = "Veículo atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Veículo não encontrado")
    public ResponseEntity<VeiculoDTO> update(@Parameter(description = "ID do veículo", example = "1") @PathVariable Integer id, @Valid @RequestBody VeiculoDTO veiculoDTO) {
        return veiculoService.findById(id)
                .map(existing -> {
                    veiculoDTO.setId(id);
                    return ResponseEntity.ok(veiculoService.save(veiculoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir veículo", description = "Remove um veículo pelo seu ID")
    @ApiResponse(responseCode = "204", description = "Veículo excluído com sucesso")
    @ApiResponse(responseCode = "404", description = "Veículo não encontrado")
    public ResponseEntity<Void> delete(@Parameter(description = "ID do veículo", example = "1") @PathVariable Integer id) {
        veiculoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
