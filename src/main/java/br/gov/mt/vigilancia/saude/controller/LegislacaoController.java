package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.LegislacaoDTO;
import br.gov.mt.vigilancia.saude.service.LegislacaoService;
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
@RequestMapping("/legislacoes")
@Tag(name = "Legislação", description = "Operações CRUD para legislação")
public class LegislacaoController {

    @Autowired
    private LegislacaoService legislacaoService;

    @GetMapping
    @Operation(summary = "Listar legislações", description = "Retorna a lista completa de legislações cadastradas")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = LegislacaoDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<LegislacaoDTO>> getAllLegislacoes() {
        return ResponseEntity.ok(legislacaoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar legislação por ID", description = "Retorna uma legislação pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = LegislacaoDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<LegislacaoDTO> getLegislacaoById(@Parameter(description = "Identificador da legislação", example = "1") @PathVariable Integer id) {
        return legislacaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar legislação", description = "Cria uma nova legislação")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = LegislacaoDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<LegislacaoDTO> createLegislacao(@Valid @RequestBody LegislacaoDTO legislacaoDTO) {
        return ResponseEntity.ok(legislacaoService.save(legislacaoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar legislação", description = "Atualiza uma legislação existente pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = LegislacaoDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<LegislacaoDTO> updateLegislacao(@Parameter(description = "Identificador da legislação", example = "1") @PathVariable Integer id, @Valid @RequestBody LegislacaoDTO legislacaoDTO) {
        return legislacaoService.findById(id)
                .map(existingLegislacaoDTO -> {
                    legislacaoDTO.setIdlegislacao(id);
                    return ResponseEntity.ok(legislacaoService.save(legislacaoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir legislação", description = "Remove uma legislação pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteLegislacao(@Parameter(description = "Identificador da legislação", example = "1") @PathVariable Integer id) {
        legislacaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
