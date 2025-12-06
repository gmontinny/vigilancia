package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.GestaodocumentoDTO;
import br.gov.mt.vigilancia.saude.service.GestaodocumentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
@RequestMapping("/gestaodocumentos")
@Tag(name = "Gestão Documento", description = "Operações CRUD para gestão de documentos")
public class GestaodocumentoController {

    @Autowired
    private GestaodocumentoService gestaodocumentoService;

    @GetMapping
    @Operation(summary = "Listar documentos", description = "Retorna a lista completa de documentos em gestão")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<GestaodocumentoDTO>> getAllGestaodocumentos() {
        return ResponseEntity.ok(gestaodocumentoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar documento por ID", description = "Retorna um documento em gestão pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<GestaodocumentoDTO> getGestaodocumentoById(@Parameter(description = "ID do documento", example = "1") @PathVariable Integer id) {
        return gestaodocumentoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar documento", description = "Cria um novo documento em gestão")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<GestaodocumentoDTO> createGestaodocumento(@Valid @RequestBody GestaodocumentoDTO gestaodocumentoDTO) {
        return ResponseEntity.ok(gestaodocumentoService.save(gestaodocumentoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar documento", description = "Atualiza um documento em gestão existente")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<GestaodocumentoDTO> updateGestaodocumento(@Parameter(description = "ID do documento", example = "1") @PathVariable Integer id, @Valid @RequestBody GestaodocumentoDTO gestaodocumentoDTO) {
        return gestaodocumentoService.findById(id)
                .map(existingGestaodocumentoDTO -> {
                    gestaodocumentoDTO.setIdgestaodocumento(id);
                    return ResponseEntity.ok(gestaodocumentoService.save(gestaodocumentoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir documento", description = "Remove um documento em gestão pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteGestaodocumento(@Parameter(description = "ID do documento", example = "1") @PathVariable Integer id) {
        gestaodocumentoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
