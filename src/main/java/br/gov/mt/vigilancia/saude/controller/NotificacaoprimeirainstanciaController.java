package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.NotificacaoprimeirainstanciaDTO;
import br.gov.mt.vigilancia.saude.service.NotificacaoprimeirainstanciaService;
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
@RequestMapping("/notificacaoprimeirainstancias")
@Tag(name = "Notificação Primeira Instância", description = "Operações CRUD para notificações de primeira instância")
public class NotificacaoprimeirainstanciaController {

    @Autowired
    private NotificacaoprimeirainstanciaService notificacaoprimeirainstanciaService;

    @GetMapping
    @Operation(summary = "Listar notificações de primeira instância", description = "Retorna a lista completa de notificações de primeira instância")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<NotificacaoprimeirainstanciaDTO>> getAllNotificacaoprimeirainstancias() {
        return ResponseEntity.ok(notificacaoprimeirainstanciaService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar notificação por ID", description = "Retorna uma notificação de primeira instância pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<NotificacaoprimeirainstanciaDTO> getNotificacaoprimeirainstanciaById(@Parameter(description = "ID da notificação", example = "1") @PathVariable Integer id) {
        return notificacaoprimeirainstanciaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar notificação", description = "Cria uma nova notificação de primeira instância")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<NotificacaoprimeirainstanciaDTO> createNotificacaoprimeirainstancia(@Valid @RequestBody NotificacaoprimeirainstanciaDTO notificacaoprimeirainstanciaDTO) {
        return ResponseEntity.ok(notificacaoprimeirainstanciaService.save(notificacaoprimeirainstanciaDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar notificação", description = "Atualiza uma notificação de primeira instância existente")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<NotificacaoprimeirainstanciaDTO> updateNotificacaoprimeirainstancia(@Parameter(description = "ID da notificação", example = "1") @PathVariable Integer id, @Valid @RequestBody NotificacaoprimeirainstanciaDTO notificacaoprimeirainstanciaDTO) {
        return notificacaoprimeirainstanciaService.findById(id)
                .map(existingNotificacaoprimeirainstanciaDTO -> {
                    notificacaoprimeirainstanciaDTO.setIdprimeirainstancia(id);
                    return ResponseEntity.ok(notificacaoprimeirainstanciaService.save(notificacaoprimeirainstanciaDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir notificação", description = "Remove uma notificação de primeira instância pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteNotificacaoprimeirainstancia(@Parameter(description = "ID da notificação", example = "1") @PathVariable Integer id) {
        notificacaoprimeirainstanciaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
