package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.FarmaceuticoDTO;
import br.gov.mt.vigilancia.saude.service.FarmaceuticoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farmaceuticos")
@Tag(name = "Farmacêuticos", description = "Operações CRUD para farmacêuticos")
public class FarmaceuticoController {

    @Autowired
    private FarmaceuticoService farmaceuticoService;

    @GetMapping
    @Operation(summary = "Listar farmacêuticos", description = "Retorna a lista completa de farmacêuticos cadastrados")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = FarmaceuticoDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<FarmaceuticoDTO>> getAllFarmaceuticos() {
        return ResponseEntity.ok(farmaceuticoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar farmacêutico por ID", description = "Retorna um farmacêutico pelo seu identificador")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = FarmaceuticoDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<FarmaceuticoDTO> getFarmaceuticoById(
            @Parameter(description = "Identificador do farmacêutico", example = "1") @PathVariable Integer id) {
        return farmaceuticoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar farmacêutico", description = "Cria um novo farmacêutico")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro criado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = FarmaceuticoDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<FarmaceuticoDTO> createFarmaceutico(@Valid @RequestBody FarmaceuticoDTO farmaceuticoDTO) {
        return ResponseEntity.ok(farmaceuticoService.save(farmaceuticoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar farmacêutico", description = "Atualiza um farmacêutico existente pelo seu ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = FarmaceuticoDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<FarmaceuticoDTO> updateFarmaceutico(
            @Parameter(description = "Identificador do farmacêutico", example = "1") @PathVariable Integer id,
            @Valid @RequestBody FarmaceuticoDTO farmaceuticoDTO) {
        return farmaceuticoService.findById(id)
                .map(existingFarmaceuticoDTO -> {
                    farmaceuticoDTO.setIdfarmaceuticos(id);
                    return ResponseEntity.ok(farmaceuticoService.save(farmaceuticoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir farmacêutico", description = "Remove um farmacêutico pelo seu ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteFarmaceutico(
            @Parameter(description = "Identificador do farmacêutico", example = "1") @PathVariable Integer id) {
        farmaceuticoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
