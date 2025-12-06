package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ItensdocumentoDTO;
import br.gov.mt.vigilancia.saude.service.ItensdocumentoService;
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
@RequestMapping("/itensdocumentos")
@Tag(name = "Itens de Documento", description = "Operações CRUD para itens de documento")
public class ItensdocumentoController {

    @Autowired
    private ItensdocumentoService itensdocumentoService;

    @GetMapping
    @Operation(summary = "Listar itens de documento", description = "Retorna a lista completa de itens de documento cadastrados")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItensdocumentoDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<ItensdocumentoDTO>> getAllItensdocumentos() {
        return ResponseEntity.ok(itensdocumentoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar item de documento por ID", description = "Retorna um item de documento pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItensdocumentoDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ItensdocumentoDTO> getItensdocumentoById(@Parameter(description = "Identificador do item de documento", example = "1") @PathVariable Integer id) {
        return itensdocumentoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar item de documento", description = "Cria um novo item de documento")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItensdocumentoDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ItensdocumentoDTO> createItensdocumento(@Valid @RequestBody ItensdocumentoDTO itensdocumentoDTO) {
        return ResponseEntity.ok(itensdocumentoService.save(itensdocumentoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar item de documento", description = "Atualiza um item de documento existente pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItensdocumentoDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ItensdocumentoDTO> updateItensdocumento(@Parameter(description = "Identificador do item de documento", example = "1") @PathVariable Integer id, @Valid @RequestBody ItensdocumentoDTO itensdocumentoDTO) {
        return itensdocumentoService.findById(id)
                .map(existingItensdocumentoDTO -> {
                    itensdocumentoDTO.setIditensdocumento(id);
                    return ResponseEntity.ok(itensdocumentoService.save(itensdocumentoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir item de documento", description = "Remove um item de documento pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteItensdocumento(@Parameter(description = "Identificador do item de documento", example = "1") @PathVariable Integer id) {
        itensdocumentoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
