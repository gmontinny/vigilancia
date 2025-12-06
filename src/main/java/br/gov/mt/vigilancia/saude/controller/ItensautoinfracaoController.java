package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ItensautoinfracaoDTO;
import br.gov.mt.vigilancia.saude.service.ItensautoinfracaoService;
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
@RequestMapping("/itensautoinfracoes")
@Tag(name = "Itens de Auto de Infração", description = "Operações CRUD para itens de auto de infração")
public class ItensautoinfracaoController {

    @Autowired
    private ItensautoinfracaoService itensautoinfracaoService;

    @GetMapping
    @Operation(summary = "Listar itens de auto de infração", description = "Retorna a lista completa de itens de auto de infração cadastrados")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItensautoinfracaoDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<ItensautoinfracaoDTO>> getAllItensautoinfracoes() {
        return ResponseEntity.ok(itensautoinfracaoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar item de auto de infração por ID", description = "Retorna um item de auto de infração pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItensautoinfracaoDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ItensautoinfracaoDTO> getItensautoinfracaoById(@Parameter(description = "Identificador do item de auto de infração", example = "1") @PathVariable Integer id) {
        return itensautoinfracaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar item de auto de infração", description = "Cria um novo item de auto de infração")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItensautoinfracaoDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ItensautoinfracaoDTO> createItensautoinfracao(@Valid @RequestBody ItensautoinfracaoDTO itensautoinfracaoDTO) {
        return ResponseEntity.ok(itensautoinfracaoService.save(itensautoinfracaoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar item de auto de infração", description = "Atualiza um item de auto de infração existente pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItensautoinfracaoDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ItensautoinfracaoDTO> updateItensautoinfracao(@Parameter(description = "Identificador do item de auto de infração", example = "1") @PathVariable Integer id, @Valid @RequestBody ItensautoinfracaoDTO itensautoinfracaoDTO) {
        return itensautoinfracaoService.findById(id)
                .map(existingItensautoinfracaoDTO -> {
                    itensautoinfracaoDTO.setIditensautoinfracao(id);
                    return ResponseEntity.ok(itensautoinfracaoService.save(itensautoinfracaoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir item de auto de infração", description = "Remove um item de auto de infração pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteItensautoinfracao(@Parameter(description = "Identificador do item de auto de infração", example = "1") @PathVariable Integer id) {
        itensautoinfracaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
