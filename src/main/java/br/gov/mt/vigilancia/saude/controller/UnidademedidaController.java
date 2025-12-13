package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.UnidademedidaDTO;
import br.gov.mt.vigilancia.saude.service.UnidademedidaService;
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
 * Controller para consulta de unidades de medida.
 */
@RestController
@RequestMapping("/unidades-medida")
@RequiredArgsConstructor
@Tag(name = "Unidades de Medida", description = "Consulta de unidades de medida")
@SecurityRequirement(name = "bearerAuth")
public class UnidademedidaController {

    private final UnidademedidaService unidademedidaService;

    @GetMapping
    @Operation(summary = "Listar unidades de medida", description = "Retorna todas as unidades de medida cadastradas")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<UnidademedidaDTO>> findAll() {
        return ResponseEntity.ok(unidademedidaService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar unidade de medida por ID", description = "Retorna uma unidade de medida específica pelo ID")
    @ApiResponse(responseCode = "200", description = "Unidade de medida encontrada")
    @ApiResponse(responseCode = "404", description = "Unidade de medida não encontrada")
    public ResponseEntity<UnidademedidaDTO> findById(@Parameter(description = "ID da unidade de medida") @PathVariable Integer id) {
        return ResponseEntity.ok(unidademedidaService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Criar unidade de medida", description = "Cria uma nova unidade de medida")
    @ApiResponse(responseCode = "200", description = "Unidade de medida criada com sucesso")
    public ResponseEntity<UnidademedidaDTO> create(@Valid @RequestBody UnidademedidaDTO unidademedidaDTO) {
        return ResponseEntity.ok(unidademedidaService.save(unidademedidaDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar unidade de medida", description = "Atualiza uma unidade de medida existente")
    @ApiResponse(responseCode = "200", description = "Unidade de medida atualizada com sucesso")
    @ApiResponse(responseCode = "404", description = "Unidade de medida não encontrada")
    public ResponseEntity<UnidademedidaDTO> update(@Parameter(description = "ID da unidade de medida") @PathVariable Integer id, @Valid @RequestBody UnidademedidaDTO unidademedidaDTO) {
        return ResponseEntity.ok(unidademedidaService.update(id, unidademedidaDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir unidade de medida", description = "Exclui uma unidade de medida")
    @ApiResponse(responseCode = "204", description = "Unidade de medida excluída com sucesso")
    @ApiResponse(responseCode = "404", description = "Unidade de medida não encontrada")
    public ResponseEntity<Void> delete(@Parameter(description = "ID da unidade de medida") @PathVariable Integer id) {
        unidademedidaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
