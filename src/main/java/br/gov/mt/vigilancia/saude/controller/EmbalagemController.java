package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.EmbalagemDTO;
import br.gov.mt.vigilancia.saude.service.EmbalagemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller para gerenciamento de embalagens de produtos.
 */
@RestController
@RequestMapping("/embalagens")
@Tag(name = "Embalagens", description = "Gerenciamento de embalagens de produtos")
@SecurityRequirement(name = "bearerAuth")
public class EmbalagemController {

    @Autowired
    private EmbalagemService embalagemService;

    @GetMapping
    @Operation(summary = "Listar embalagens", description = "Retorna todas as embalagens cadastradas")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<EmbalagemDTO>> getAllEmbalagens() {
        return ResponseEntity.ok(embalagemService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar embalagem por ID", description = "Retorna uma embalagem específica")
    @ApiResponse(responseCode = "200", description = "Embalagem encontrada")
    @ApiResponse(responseCode = "404", description = "Embalagem não encontrada")
    public ResponseEntity<EmbalagemDTO> getEmbalagemById(
        @Parameter(description = "ID da embalagem") @PathVariable Integer id) {
        return embalagemService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar embalagem", description = "Cria uma nova embalagem")
    @ApiResponse(responseCode = "200", description = "Embalagem criada com sucesso")
    public ResponseEntity<EmbalagemDTO> createEmbalagem(@RequestBody @Valid EmbalagemDTO embalagemDTO) {
        return ResponseEntity.ok(embalagemService.save(embalagemDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar embalagem", description = "Atualiza uma embalagem existente")
    @ApiResponse(responseCode = "200", description = "Embalagem atualizada com sucesso")
    @ApiResponse(responseCode = "404", description = "Embalagem não encontrada")
    public ResponseEntity<EmbalagemDTO> updateEmbalagem(
        @Parameter(description = "ID da embalagem") @PathVariable Integer id, 
        @RequestBody @Valid EmbalagemDTO embalagemDTO) {
        return embalagemService.findById(id)
                .map(existingEmbalagemDTO -> {
                    embalagemDTO.setIdembalagem(id);
                    return ResponseEntity.ok(embalagemService.save(embalagemDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover embalagem", description = "Remove uma embalagem do sistema")
    @ApiResponse(responseCode = "204", description = "Embalagem removida com sucesso")
    public ResponseEntity<Void> deleteEmbalagem(
        @Parameter(description = "ID da embalagem") @PathVariable Integer id) {
        embalagemService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
