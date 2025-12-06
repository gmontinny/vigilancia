package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.NotificacaousuarioDTO;
import br.gov.mt.vigilancia.saude.service.NotificacaousuarioService;
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
@RequestMapping("/notificacaousuarios")
@Tag(name = "Notificação Usuário", description = "Operações CRUD para notificações de usuário")
public class NotificacaousuarioController {

    @Autowired
    private NotificacaousuarioService notificacaousuarioService;

    @GetMapping
    @Operation(summary = "Listar notificações de usuário", description = "Retorna a lista completa de notificações de usuário")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<NotificacaousuarioDTO>> getAllNotificacaousuarios() {
        return ResponseEntity.ok(notificacaousuarioService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar notificação por ID", description = "Retorna uma notificação de usuário pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<NotificacaousuarioDTO> getNotificacaousuarioById(@Parameter(description = "ID da notificação", example = "1") @PathVariable Integer id) {
        return notificacaousuarioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar notificação", description = "Cria uma nova notificação de usuário")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<NotificacaousuarioDTO> createNotificacaousuario(@Valid @RequestBody NotificacaousuarioDTO notificacaousuarioDTO) {
        return ResponseEntity.ok(notificacaousuarioService.save(notificacaousuarioDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar notificação", description = "Atualiza uma notificação de usuário existente")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<NotificacaousuarioDTO> updateNotificacaousuario(@Parameter(description = "ID da notificação", example = "1") @PathVariable Integer id, @Valid @RequestBody NotificacaousuarioDTO notificacaousuarioDTO) {
        return notificacaousuarioService.findById(id)
                .map(existingNotificacaousuarioDTO -> {
                    notificacaousuarioDTO.setIdnotificacaousuario(id);
                    return ResponseEntity.ok(notificacaousuarioService.save(notificacaousuarioDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir notificação", description = "Remove uma notificação de usuário pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteNotificacaousuario(@Parameter(description = "ID da notificação", example = "1") @PathVariable Integer id) {
        notificacaousuarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
