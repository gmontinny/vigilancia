package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.SolicitacaoDTO;
import br.gov.mt.vigilancia.saude.service.SolicitacaoService;
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
@RequestMapping("/solicitacoes")
@Tag(name = "Solicitações", description = "Operações CRUD para solicitações")
public class SolicitacaoController {

    @Autowired
    private SolicitacaoService solicitacaoService;

    @GetMapping
    @Operation(summary = "Listar solicitações", description = "Retorna a lista completa de solicitações cadastradas")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SolicitacaoDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<SolicitacaoDTO>> getAllSolicitacoes() {
        return ResponseEntity.ok(solicitacaoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar solicitação por ID", description = "Retorna uma solicitação pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SolicitacaoDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<SolicitacaoDTO> getSolicitacaoById(@Parameter(description = "Identificador da solicitação", example = "1") @PathVariable Integer id) {
        return solicitacaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar solicitação", description = "Cria uma nova solicitação")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SolicitacaoDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<SolicitacaoDTO> createSolicitacao(@Valid @RequestBody SolicitacaoDTO solicitacaoDTO) {
        return ResponseEntity.ok(solicitacaoService.save(solicitacaoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar solicitação", description = "Atualiza uma solicitação existente pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SolicitacaoDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<SolicitacaoDTO> updateSolicitacao(@Parameter(description = "Identificador da solicitação", example = "1") @PathVariable Integer id, @Valid @RequestBody SolicitacaoDTO solicitacaoDTO) {
        return solicitacaoService.findById(id)
                .map(existingSolicitacaoDTO -> {
                    solicitacaoDTO.setIdsolicitacao(id);
                    return ResponseEntity.ok(solicitacaoService.save(solicitacaoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir solicitação", description = "Remove uma solicitação pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteSolicitacao(@Parameter(description = "Identificador da solicitação", example = "1") @PathVariable Integer id) {
        solicitacaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
