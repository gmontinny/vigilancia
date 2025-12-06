package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ItensrelatorioDTO;
import br.gov.mt.vigilancia.saude.service.ItensrelatorioService;
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
@RequestMapping("/itensrelatorios")
@Tag(name = "Itens de Relatório", description = "Operações CRUD para itens de relatório")
public class ItensrelatorioController {

    @Autowired
    private ItensrelatorioService itensrelatorioService;

    @GetMapping
    @Operation(summary = "Listar itens de relatório", description = "Retorna a lista completa de itens de relatório cadastrados")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItensrelatorioDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<ItensrelatorioDTO>> getAllItensrelatorios() {
        return ResponseEntity.ok(itensrelatorioService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar item de relatório por ID", description = "Retorna um item de relatório pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItensrelatorioDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ItensrelatorioDTO> getItensrelatorioById(@Parameter(description = "Identificador do item de relatório", example = "1") @PathVariable Integer id) {
        return itensrelatorioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar item de relatório", description = "Cria um novo item de relatório")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItensrelatorioDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ItensrelatorioDTO> createItensrelatorio(@Valid @RequestBody ItensrelatorioDTO itensrelatorioDTO) {
        return ResponseEntity.ok(itensrelatorioService.save(itensrelatorioDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar item de relatório", description = "Atualiza um item de relatório existente pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItensrelatorioDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ItensrelatorioDTO> updateItensrelatorio(@Parameter(description = "Identificador do item de relatório", example = "1") @PathVariable Integer id, @Valid @RequestBody ItensrelatorioDTO itensrelatorioDTO) {
        return itensrelatorioService.findById(id)
                .map(existingItensrelatorioDTO -> {
                    itensrelatorioDTO.setIditensrelatorio(id);
                    return ResponseEntity.ok(itensrelatorioService.save(itensrelatorioDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir item de relatório", description = "Remove um item de relatório pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteItensrelatorio(@Parameter(description = "Identificador do item de relatório", example = "1") @PathVariable Integer id) {
        itensrelatorioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
