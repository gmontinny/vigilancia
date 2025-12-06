package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ItensatividadeDTO;
import br.gov.mt.vigilancia.saude.service.ItensatividadeService;
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
@RequestMapping("/itensatividades")
@Tag(name = "Itens de Atividade", description = "Operações CRUD para itens de atividade")
public class ItensatividadeController {

    @Autowired
    private ItensatividadeService itensatividadeService;

    @GetMapping
    @Operation(summary = "Listar itens de atividade", description = "Retorna a lista completa de itens de atividade cadastrados")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItensatividadeDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<ItensatividadeDTO>> getAllItensatividades() {
        return ResponseEntity.ok(itensatividadeService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar item de atividade por ID", description = "Retorna um item de atividade pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItensatividadeDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ItensatividadeDTO> getItensatividadeById(@Parameter(description = "Identificador do item de atividade", example = "1") @PathVariable Integer id) {
        return itensatividadeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar item de atividade", description = "Cria um novo item de atividade")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItensatividadeDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ItensatividadeDTO> createItensatividade(@Valid @RequestBody ItensatividadeDTO itensatividadeDTO) {
        return ResponseEntity.ok(itensatividadeService.save(itensatividadeDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar item de atividade", description = "Atualiza um item de atividade existente pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItensatividadeDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ItensatividadeDTO> updateItensatividade(@Parameter(description = "Identificador do item de atividade", example = "1") @PathVariable Integer id, @Valid @RequestBody ItensatividadeDTO itensatividadeDTO) {
        return itensatividadeService.findById(id)
                .map(existingItensatividadeDTO -> {
                    itensatividadeDTO.setIditensatividade(id);
                    return ResponseEntity.ok(itensatividadeService.save(itensatividadeDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir item de atividade", description = "Remove um item de atividade pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteItensatividade(@Parameter(description = "Identificador do item de atividade", example = "1") @PathVariable Integer id) {
        itensatividadeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
