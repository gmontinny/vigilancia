package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ItensembalagemDTO;
import br.gov.mt.vigilancia.saude.service.ItensembalagemService;
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
@RequestMapping("/itensembalagens")
@Tag(name = "Itens de Embalagem", description = "Operações CRUD para itens de embalagem")
public class ItensembalagemController {

    @Autowired
    private ItensembalagemService itensembalagemService;

    @GetMapping
    @Operation(summary = "Listar itens de embalagem", description = "Retorna a lista completa de itens de embalagem cadastrados")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItensembalagemDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<ItensembalagemDTO>> getAllItensembalagens() {
        return ResponseEntity.ok(itensembalagemService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar item de embalagem por ID", description = "Retorna um item de embalagem pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItensembalagemDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ItensembalagemDTO> getItensembalagemById(@Parameter(description = "Identificador do item de embalagem", example = "1") @PathVariable Integer id) {
        return itensembalagemService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar item de embalagem", description = "Cria um novo item de embalagem")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItensembalagemDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ItensembalagemDTO> createItensembalagem(@Valid @RequestBody ItensembalagemDTO itensembalagemDTO) {
        return ResponseEntity.ok(itensembalagemService.save(itensembalagemDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar item de embalagem", description = "Atualiza um item de embalagem existente pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItensembalagemDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ItensembalagemDTO> updateItensembalagem(@Parameter(description = "Identificador do item de embalagem", example = "1") @PathVariable Integer id, @Valid @RequestBody ItensembalagemDTO itensembalagemDTO) {
        return itensembalagemService.findById(id)
                .map(existingItensembalagemDTO -> {
                    itensembalagemDTO.setIditensembalagem(id);
                    return ResponseEntity.ok(itensembalagemService.save(itensembalagemDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir item de embalagem", description = "Remove um item de embalagem pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteItensembalagem(@Parameter(description = "Identificador do item de embalagem", example = "1") @PathVariable Integer id) {
        itensembalagemService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
