package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.TermonotificacaoDTO;
import br.gov.mt.vigilancia.saude.service.TermonotificacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
@RequestMapping("/termonotificacoes")
@Tag(name = "Termo Notificação", description = "Operações CRUD para termos de notificação")
public class TermonotificacaoController {

    @Autowired
    private TermonotificacaoService termonotificacaoService;

    @GetMapping
    @Operation(summary = "Listar termos de notificação", description = "Retorna a lista completa de termos de notificação")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<TermonotificacaoDTO>> getAllTermonotificacoes() {
        return ResponseEntity.ok(termonotificacaoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar termo por ID", description = "Retorna um termo de notificação pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<TermonotificacaoDTO> getTermonotificacaoById(@Parameter(description = "ID do termo", example = "1") @PathVariable Integer id) {
        return termonotificacaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar termo de notificação", description = "Cria um novo termo de notificação")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<TermonotificacaoDTO> createTermonotificacao(@Valid @RequestBody TermonotificacaoDTO termonotificacaoDTO) {
        return ResponseEntity.ok(termonotificacaoService.save(termonotificacaoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar termo de notificação", description = "Atualiza um termo de notificação existente")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<TermonotificacaoDTO> updateTermonotificacao(@Parameter(description = "ID do termo", example = "1") @PathVariable Integer id, @Valid @RequestBody TermonotificacaoDTO termonotificacaoDTO) {
        return termonotificacaoService.findById(id)
                .map(existingTermonotificacaoDTO -> {
                    termonotificacaoDTO.setIdtermonotificacao(id);
                    return ResponseEntity.ok(termonotificacaoService.save(termonotificacaoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir termo de notificação", description = "Remove um termo de notificação pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteTermonotificacao(@Parameter(description = "ID do termo", example = "1") @PathVariable Integer id) {
        termonotificacaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}