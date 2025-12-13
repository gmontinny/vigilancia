package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.GaleriaDTO;
import br.gov.mt.vigilancia.saude.service.GaleriaService;
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
 * Controller para consulta de galerias.
 */
@RestController
@RequestMapping("/galerias")
@RequiredArgsConstructor
@Tag(name = "Galerias", description = "Consulta de galerias")
@SecurityRequirement(name = "bearerAuth")
public class GaleriaController {

    private final GaleriaService galeriaService;

    @GetMapping
    @Operation(summary = "Listar galerias", description = "Retorna todas as galerias cadastradas")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<GaleriaDTO>> findAll() {
        return ResponseEntity.ok(galeriaService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar galeria por ID", description = "Retorna uma galeria específica pelo ID")
    @ApiResponse(responseCode = "200", description = "Galeria encontrada")
    @ApiResponse(responseCode = "404", description = "Galeria não encontrada")
    public ResponseEntity<GaleriaDTO> findById(@Parameter(description = "ID da galeria") @PathVariable Integer id) {
        return ResponseEntity.ok(galeriaService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Criar galeria", description = "Cria uma nova galeria")
    @ApiResponse(responseCode = "200", description = "Galeria criada com sucesso")
    public ResponseEntity<GaleriaDTO> create(@Valid @RequestBody GaleriaDTO galeriaDTO) {
        return ResponseEntity.ok(galeriaService.save(galeriaDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar galeria", description = "Atualiza uma galeria existente")
    @ApiResponse(responseCode = "200", description = "Galeria atualizada com sucesso")
    @ApiResponse(responseCode = "404", description = "Galeria não encontrada")
    public ResponseEntity<GaleriaDTO> update(@Parameter(description = "ID da galeria") @PathVariable Integer id, @Valid @RequestBody GaleriaDTO galeriaDTO) {
        return ResponseEntity.ok(galeriaService.update(id, galeriaDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir galeria", description = "Exclui uma galeria")
    @ApiResponse(responseCode = "204", description = "Galeria excluída com sucesso")
    @ApiResponse(responseCode = "404", description = "Galeria não encontrada")
    public ResponseEntity<Void> delete(@Parameter(description = "ID da galeria") @PathVariable Integer id) {
        galeriaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
