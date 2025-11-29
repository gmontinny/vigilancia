package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ArquivodocumentoDTO;
import br.gov.mt.vigilancia.saude.service.ArquivodocumentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller para gerenciamento de arquivos de documentos.
 */
@RestController
@RequestMapping("/arquivodocumentos")
@Tag(name = "Arquivos de Documentos", description = "Gerenciamento de arquivos de documentos")
@SecurityRequirement(name = "bearerAuth")
public class ArquivodocumentoController {

    @Autowired
    private ArquivodocumentoService arquivodocumentoService;

    @GetMapping
    @Operation(summary = "Listar arquivos de documentos", description = "Retorna todos os arquivos de documentos")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<ArquivodocumentoDTO>> getAllArquivodocumentos() {
        return ResponseEntity.ok(arquivodocumentoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar arquivo por ID", description = "Retorna um arquivo de documento específico")
    @ApiResponse(responseCode = "200", description = "Arquivo encontrado")
    @ApiResponse(responseCode = "404", description = "Arquivo não encontrado")
    public ResponseEntity<ArquivodocumentoDTO> getArquivodocumentoById(
        @Parameter(description = "ID do arquivo") @PathVariable Integer id) {
        return arquivodocumentoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar arquivo de documento", description = "Cria um novo arquivo de documento")
    @ApiResponse(responseCode = "200", description = "Arquivo criado com sucesso")
    public ResponseEntity<ArquivodocumentoDTO> createArquivodocumento(@RequestBody @Valid ArquivodocumentoDTO arquivodocumentoDTO) {
        return ResponseEntity.ok(arquivodocumentoService.save(arquivodocumentoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar arquivo", description = "Atualiza um arquivo de documento existente")
    @ApiResponse(responseCode = "200", description = "Arquivo atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Arquivo não encontrado")
    public ResponseEntity<ArquivodocumentoDTO> updateArquivodocumento(
        @Parameter(description = "ID do arquivo") @PathVariable Integer id, 
        @RequestBody @Valid ArquivodocumentoDTO arquivodocumentoDTO) {
        return arquivodocumentoService.findById(id)
                .map(existingArquivodocumentoDTO -> {
                    arquivodocumentoDTO.setIdarquivo(id);
                    return ResponseEntity.ok(arquivodocumentoService.save(arquivodocumentoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover arquivo", description = "Remove um arquivo de documento do sistema")
    @ApiResponse(responseCode = "204", description = "Arquivo removido com sucesso")
    public ResponseEntity<Void> deleteArquivodocumento(
        @Parameter(description = "ID do arquivo") @PathVariable Integer id) {
        arquivodocumentoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
