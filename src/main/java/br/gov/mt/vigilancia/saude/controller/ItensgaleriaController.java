package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ItensgaleriaDTO;
import br.gov.mt.vigilancia.saude.service.ItensgaleriaService;
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
@RequestMapping("/itensgalerias")
@Tag(name = "Itens de Galeria", description = "Operações CRUD para itens de galeria")
public class ItensgaleriaController {

    @Autowired
    private ItensgaleriaService itensgaleriaService;

    @GetMapping
    @Operation(summary = "Listar itens de galeria", description = "Retorna a lista completa de itens de galeria cadastrados")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItensgaleriaDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<ItensgaleriaDTO>> getAllItensgalerias() {
        return ResponseEntity.ok(itensgaleriaService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar item de galeria por ID", description = "Retorna um item de galeria pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItensgaleriaDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ItensgaleriaDTO> getItensgaleriaById(@Parameter(description = "Identificador do item de galeria", example = "1") @PathVariable Integer id) {
        return itensgaleriaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar item de galeria", description = "Cria um novo item de galeria")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItensgaleriaDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ItensgaleriaDTO> createItensgaleria(@Valid @RequestBody ItensgaleriaDTO itensgaleriaDTO) {
        return ResponseEntity.ok(itensgaleriaService.save(itensgaleriaDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar item de galeria", description = "Atualiza um item de galeria existente pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItensgaleriaDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ItensgaleriaDTO> updateItensgaleria(@Parameter(description = "Identificador do item de galeria", example = "1") @PathVariable Integer id, @Valid @RequestBody ItensgaleriaDTO itensgaleriaDTO) {
        return itensgaleriaService.findById(id)
                .map(existingItensgaleriaDTO -> {
                    itensgaleriaDTO.setIditensgaleria(id);
                    return ResponseEntity.ok(itensgaleriaService.save(itensgaleriaDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir item de galeria", description = "Remove um item de galeria pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteItensgaleria(@Parameter(description = "Identificador do item de galeria", example = "1") @PathVariable Integer id) {
        itensgaleriaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
