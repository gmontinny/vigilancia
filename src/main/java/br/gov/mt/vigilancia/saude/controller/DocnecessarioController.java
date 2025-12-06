package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.DocnecessarioDTO;
import br.gov.mt.vigilancia.saude.service.DocnecessarioService;
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
@RequestMapping("/docnecessarios")
@Tag(name = "Documentos Necessários", description = "Operações CRUD para documentos necessários")
public class DocnecessarioController {

    @Autowired
    private DocnecessarioService docnecessarioService;

    @GetMapping
    @Operation(summary = "Listar documentos necessários", description = "Retorna a lista completa de documentos necessários cadastrados")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = DocnecessarioDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<DocnecessarioDTO>> getAllDocnecessarios() {
        return ResponseEntity.ok(docnecessarioService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar documento necessário por ID", description = "Retorna um documento necessário pelo seu identificador")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = DocnecessarioDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<DocnecessarioDTO> getDocnecessarioById(
            @Parameter(description = "Identificador do documento necessário", example = "1") @PathVariable Integer id) {
        return docnecessarioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar documento necessário", description = "Cria um novo documento necessário")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro criado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = DocnecessarioDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<DocnecessarioDTO> createDocnecessario(@Valid @RequestBody DocnecessarioDTO docnecessarioDTO) {
        return ResponseEntity.ok(docnecessarioService.save(docnecessarioDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar documento necessário", description = "Atualiza um documento necessário existente pelo seu ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = DocnecessarioDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<DocnecessarioDTO> updateDocnecessario(
            @Parameter(description = "Identificador do documento necessário", example = "1") @PathVariable Integer id,
            @Valid @RequestBody DocnecessarioDTO docnecessarioDTO) {
        return docnecessarioService.findById(id)
                .map(existingDocnecessarioDTO -> {
                    docnecessarioDTO.setIddocnecessario(id);
                    return ResponseEntity.ok(docnecessarioService.save(docnecessarioDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir documento necessário", description = "Remove um documento necessário pelo seu ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteDocnecessario(
            @Parameter(description = "Identificador do documento necessário", example = "1") @PathVariable Integer id) {
        docnecessarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
