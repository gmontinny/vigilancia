package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.DocumentoDTO;
import br.gov.mt.vigilancia.saude.service.DocumentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller para consulta de documentos.
 */
@RestController
@RequestMapping("/documentos")
@RequiredArgsConstructor
@Tag(name = "Documentos", description = "Consulta de documentos")
@SecurityRequirement(name = "bearerAuth")
public class DocumentoController {

    private final DocumentoService documentoService;

    @GetMapping
    @Operation(summary = "Listar documentos", description = "Retorna todos os documentos cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<DocumentoDTO>> findAll() {
        return ResponseEntity.ok(documentoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar documento por ID", description = "Retorna um documento específico pelo ID")
    @ApiResponse(responseCode = "200", description = "Documento encontrado")
    @ApiResponse(responseCode = "404", description = "Documento não encontrado")
    public ResponseEntity<DocumentoDTO> findById(@Parameter(description = "ID do documento") @PathVariable Integer id) {
        return ResponseEntity.ok(documentoService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Criar documento", description = "Cria um novo documento")
    @ApiResponse(responseCode = "200", description = "Documento criado com sucesso")
    public ResponseEntity<DocumentoDTO> create(@Valid @RequestBody DocumentoDTO documentoDTO) {
        return ResponseEntity.ok(documentoService.save(documentoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar documento", description = "Atualiza um documento existente")
    @ApiResponse(responseCode = "200", description = "Documento atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Documento não encontrado")
    public ResponseEntity<DocumentoDTO> update(@Parameter(description = "ID do documento") @PathVariable Integer id, @Valid @RequestBody DocumentoDTO documentoDTO) {
        return ResponseEntity.ok(documentoService.update(id, documentoDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir documento", description = "Exclui um documento")
    @ApiResponse(responseCode = "204", description = "Documento excluído com sucesso")
    @ApiResponse(responseCode = "404", description = "Documento não encontrado")
    public ResponseEntity<Void> delete(@Parameter(description = "ID do documento") @PathVariable Integer id) {
        documentoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
