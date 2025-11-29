package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.AutonotificacaoDTO;
import br.gov.mt.vigilancia.saude.service.AutonotificacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller para gerenciamento de autonotificações.
 */
@RestController
@RequestMapping("/autonotificacoes")
@Tag(name = "Autonotificações", description = "Gerenciamento de autonotificações")
@io.swagger.v3.oas.annotations.security.SecurityRequirement(name = "bearerAuth")
public class AutonotificacaoController {

    @Autowired
    private AutonotificacaoService autonotificacaoService;

    @GetMapping
    @Operation(summary = "Listar autonotificações", description = "Retorna a lista de autonotificações cadastradas")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AutonotificacaoDTO.class)))
    })
    public ResponseEntity<List<AutonotificacaoDTO>> getAllAutonotificacoes() {
        return ResponseEntity.ok(autonotificacaoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar autonotificação por ID", description = "Retorna uma autonotificação pelo seu identificador")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro encontrado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AutonotificacaoDTO.class))),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    public ResponseEntity<AutonotificacaoDTO> getAutonotificacaoById(
            @Parameter(description = "Identificador da autonotificação", example = "1")
            @PathVariable Integer id) {
        return autonotificacaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar autonotificação", description = "Cria uma nova autonotificação")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Registro criado com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AutonotificacaoDTO.class)))
    })
    public ResponseEntity<AutonotificacaoDTO> createAutonotificacao(
            @RequestBody(description = "Dados da autonotificação a ser criada", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AutonotificacaoDTO.class)))
            @org.springframework.web.bind.annotation.RequestBody @Valid AutonotificacaoDTO autonotificacaoDTO) {
        return ResponseEntity.ok(autonotificacaoService.save(autonotificacaoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar autonotificação", description = "Atualiza uma autonotificação existente pelo seu ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Registro atualizado",
                content = @Content(mediaType = "application/json",
                        schema = @Schema(implementation = AutonotificacaoDTO.class))),
        @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    public ResponseEntity<AutonotificacaoDTO> updateAutonotificacao(
            @Parameter(description = "Identificador da autonotificação", example = "1")
            @PathVariable Integer id,
            @RequestBody(description = "Dados da autonotificação para atualização", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AutonotificacaoDTO.class)))
            @org.springframework.web.bind.annotation.RequestBody @Valid AutonotificacaoDTO autonotificacaoDTO) {
        return autonotificacaoService.findById(id)
                .map(existingAutonotificacaoDTO -> {
                    autonotificacaoDTO.setIdautonotificacao(id);
                    return ResponseEntity.ok(autonotificacaoService.save(autonotificacaoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir autonotificação", description = "Remove uma autonotificação pelo seu ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    public ResponseEntity<Void> deleteAutonotificacao(
            @Parameter(description = "Identificador da autonotificação", example = "1")
            @PathVariable Integer id) {
        autonotificacaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
