package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.NotificacaosegundainstanciaDTO;
import br.gov.mt.vigilancia.saude.service.NotificacaosegundainstanciaService;
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
@RequestMapping("/notificacaosegundainstancias")
@Tag(name = "Notificação Segunda Instância", description = "Operações CRUD para notificações de segunda instância")
public class NotificacaosegundainstanciaController {

    @Autowired
    private NotificacaosegundainstanciaService notificacaosegundainstanciaService;

    @GetMapping
    @Operation(summary = "Listar notificações de segunda instância", description = "Retorna a lista completa de notificações de segunda instância")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<NotificacaosegundainstanciaDTO>> getAllNotificacaosegundainstancias() {
        return ResponseEntity.ok(notificacaosegundainstanciaService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar notificação por ID", description = "Retorna uma notificação de segunda instância pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<NotificacaosegundainstanciaDTO> getNotificacaosegundainstanciaById(@Parameter(description = "ID da notificação", example = "1") @PathVariable Integer id) {
        return notificacaosegundainstanciaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar notificação", description = "Cria uma nova notificação de segunda instância")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<NotificacaosegundainstanciaDTO> createNotificacaosegundainstancia(@Valid @RequestBody NotificacaosegundainstanciaDTO notificacaosegundainstanciaDTO) {
        return ResponseEntity.ok(notificacaosegundainstanciaService.save(notificacaosegundainstanciaDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar notificação", description = "Atualiza uma notificação de segunda instância existente")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<NotificacaosegundainstanciaDTO> updateNotificacaosegundainstancia(@Parameter(description = "ID da notificação", example = "1") @PathVariable Integer id, @Valid @RequestBody NotificacaosegundainstanciaDTO notificacaosegundainstanciaDTO) {
        return notificacaosegundainstanciaService.findById(id)
                .map(existingNotificacaosegundainstanciaDTO -> {
                    notificacaosegundainstanciaDTO.setIdsegundainstancia(id);
                    return ResponseEntity.ok(notificacaosegundainstanciaService.save(notificacaosegundainstanciaDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir notificação", description = "Remove uma notificação de segunda instância pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteNotificacaosegundainstancia(@Parameter(description = "ID da notificação", example = "1") @PathVariable Integer id) {
        notificacaosegundainstanciaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
