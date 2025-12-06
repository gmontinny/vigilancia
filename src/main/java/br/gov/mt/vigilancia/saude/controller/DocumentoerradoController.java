package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.DocumentoerradoDTO;
import br.gov.mt.vigilancia.saude.service.DocumentoerradoService;
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
@RequestMapping("/documentoserrados")
@Tag(name = "Documentos Errados", description = "Operações CRUD para documentos errados")
public class DocumentoerradoController {

    @Autowired
    private DocumentoerradoService documentoerradoService;

    @GetMapping
    @Operation(summary = "Listar documentos errados", description = "Retorna a lista completa de documentos errados cadastrados")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = DocumentoerradoDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<DocumentoerradoDTO>> getAllDocumentoserrados() {
        return ResponseEntity.ok(documentoerradoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar documento errado por ID", description = "Retorna um documento errado pelo seu identificador")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = DocumentoerradoDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<DocumentoerradoDTO> getDocumentoerradoById(
            @Parameter(description = "Identificador do documento errado", example = "1") @PathVariable Integer id) {
        return documentoerradoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar documento errado", description = "Cria um novo documento errado")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro criado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = DocumentoerradoDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<DocumentoerradoDTO> createDocumentoerrado(@Valid @RequestBody DocumentoerradoDTO documentoerradoDTO) {
        return ResponseEntity.ok(documentoerradoService.save(documentoerradoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar documento errado", description = "Atualiza um documento errado existente pelo seu ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = DocumentoerradoDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<DocumentoerradoDTO> updateDocumentoerrado(
            @Parameter(description = "Identificador do documento errado", example = "1") @PathVariable Integer id,
            @Valid @RequestBody DocumentoerradoDTO documentoerradoDTO) {
        return documentoerradoService.findById(id)
                .map(existingDocumentoerradoDTO -> {
                    documentoerradoDTO.setIddocumentoerrado(id);
                    return ResponseEntity.ok(documentoerradoService.save(documentoerradoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir documento errado", description = "Remove um documento errado pelo seu ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteDocumentoerrado(
            @Parameter(description = "Identificador do documento errado", example = "1") @PathVariable Integer id) {
        documentoerradoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
