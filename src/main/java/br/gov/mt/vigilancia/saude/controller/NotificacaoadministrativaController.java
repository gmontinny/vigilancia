package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.NotificacaoadministrativaDTO;
import br.gov.mt.vigilancia.saude.service.NotificacaoadministrativaService;
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
@RequestMapping("/notificacaoadministrativas")
@Tag(name = "Notificação Administrativa", description = "Operações CRUD para notificações administrativas")
public class NotificacaoadministrativaController {

    @Autowired
    private NotificacaoadministrativaService notificacaoadministrativaService;

    @GetMapping
    @Operation(summary = "Listar notificações administrativas", description = "Retorna a lista completa de notificações administrativas")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<NotificacaoadministrativaDTO>> getAllNotificacaoadministrativas() {
        return ResponseEntity.ok(notificacaoadministrativaService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar notificação por ID", description = "Retorna uma notificação administrativa pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<NotificacaoadministrativaDTO> getNotificacaoadministrativaById(@Parameter(description = "ID da notificação", example = "1") @PathVariable Integer id) {
        return notificacaoadministrativaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar notificação", description = "Cria uma nova notificação administrativa")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<NotificacaoadministrativaDTO> createNotificacaoadministrativa(@Valid @RequestBody NotificacaoadministrativaDTO notificacaoadministrativaDTO) {
        return ResponseEntity.ok(notificacaoadministrativaService.save(notificacaoadministrativaDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar notificação", description = "Atualiza uma notificação administrativa existente")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<NotificacaoadministrativaDTO> updateNotificacaoadministrativa(@Parameter(description = "ID da notificação", example = "1") @PathVariable Integer id, @Valid @RequestBody NotificacaoadministrativaDTO notificacaoadministrativaDTO) {
        return notificacaoadministrativaService.findById(id)
                .map(existingNotificacaoadministrativaDTO -> {
                    notificacaoadministrativaDTO.setIdnotificacaoadministrativa(id);
                    return ResponseEntity.ok(notificacaoadministrativaService.save(notificacaoadministrativaDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir notificação", description = "Remove uma notificação administrativa pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteNotificacaoadministrativa(@Parameter(description = "ID da notificação", example = "1") @PathVariable Integer id) {
        notificacaoadministrativaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
