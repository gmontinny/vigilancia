package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.GeraatividadeDTO;
import br.gov.mt.vigilancia.saude.service.GeraatividadeService;
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
@RequestMapping("/geraatividades")
@Tag(name = "Gera Atividades", description = "Operações CRUD para geração de atividades")
public class GeraatividadeController {

    @Autowired
    private GeraatividadeService geraatividadeService;

    @GetMapping
    @Operation(summary = "Listar gerações de atividades", description = "Retorna a lista completa de gerações de atividades")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GeraatividadeDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<GeraatividadeDTO>> getAllGeraatividades() {
        return ResponseEntity.ok(geraatividadeService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar geração de atividade por ID", description = "Retorna uma geração de atividade pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GeraatividadeDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<GeraatividadeDTO> getGeraatividadeById(@Parameter(description = "Identificador da geração de atividade", example = "1") @PathVariable Integer id) {
        return geraatividadeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar geração de atividade", description = "Cria uma nova geração de atividade")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GeraatividadeDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<GeraatividadeDTO> createGeraatividade(@Valid @RequestBody GeraatividadeDTO geraatividadeDTO) {
        return ResponseEntity.ok(geraatividadeService.save(geraatividadeDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar geração de atividade", description = "Atualiza uma geração de atividade existente pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GeraatividadeDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<GeraatividadeDTO> updateGeraatividade(@Parameter(description = "Identificador da geração de atividade", example = "1") @PathVariable Integer id, @Valid @RequestBody GeraatividadeDTO geraatividadeDTO) {
        return geraatividadeService.findById(id)
                .map(existingGeraatividadeDTO -> {
                    geraatividadeDTO.setIdgeraatividade(id);
                    return ResponseEntity.ok(geraatividadeService.save(geraatividadeDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir geração de atividade", description = "Remove uma geração de atividade pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteGeraatividade(@Parameter(description = "Identificador da geração de atividade", example = "1") @PathVariable Integer id) {
        geraatividadeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
