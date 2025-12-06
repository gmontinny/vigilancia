package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.NotificacaoDTO;
import br.gov.mt.vigilancia.saude.service.NotificacaoService;
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
@RequestMapping("/notificacoes")
@Tag(name = "Notificação", description = "Operações CRUD para notificações")
public class NotificacaoController {

    @Autowired
    private NotificacaoService notificacaoService;

    @GetMapping
    @Operation(summary = "Listar notificações", description = "Retorna a lista completa de notificações")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<NotificacaoDTO>> getAllNotificacoes() {
        return ResponseEntity.ok(notificacaoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar notificação por ID", description = "Retorna uma notificação pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<NotificacaoDTO> getNotificacaoById(@Parameter(description = "ID da notificação", example = "1") @PathVariable Integer id) {
        return notificacaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar notificação", description = "Cria uma nova notificação")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<NotificacaoDTO> createNotificacao(@Valid @RequestBody NotificacaoDTO notificacaoDTO) {
        return ResponseEntity.ok(notificacaoService.save(notificacaoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar notificação", description = "Atualiza uma notificação existente")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<NotificacaoDTO> updateNotificacao(@Parameter(description = "ID da notificação", example = "1") @PathVariable Integer id, @Valid @RequestBody NotificacaoDTO notificacaoDTO) {
        return notificacaoService.findById(id)
                .map(existingNotificacaoDTO -> {
                    notificacaoDTO.setIdnotificacao(id);
                    return ResponseEntity.ok(notificacaoService.save(notificacaoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir notificação", description = "Remove uma notificação pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteNotificacao(@Parameter(description = "ID da notificação", example = "1") @PathVariable Integer id) {
        notificacaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
