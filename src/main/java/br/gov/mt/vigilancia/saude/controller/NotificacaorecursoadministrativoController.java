package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.NotificacaorecursoadministrativoDTO;
import br.gov.mt.vigilancia.saude.service.NotificacaorecursoadministrativoService;
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
@RequestMapping("/notificacaorecursoadministrativos")
@Tag(name = "Notificação Recurso Administrativo", description = "Operações CRUD para notificações de recurso administrativo")
public class NotificacaorecursoadministrativoController {

    @Autowired
    private NotificacaorecursoadministrativoService notificacaorecursoadministrativoService;

    @GetMapping
    @Operation(summary = "Listar notificações de recurso administrativo", description = "Retorna a lista completa de notificações de recurso administrativo")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<NotificacaorecursoadministrativoDTO>> getAllNotificacaorecursoadministrativos() {
        return ResponseEntity.ok(notificacaorecursoadministrativoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar notificação por ID", description = "Retorna uma notificação de recurso administrativo pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<NotificacaorecursoadministrativoDTO> getNotificacaorecursoadministrativoById(@Parameter(description = "ID da notificação", example = "1") @PathVariable Integer id) {
        return notificacaorecursoadministrativoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar notificação", description = "Cria uma nova notificação de recurso administrativo")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<NotificacaorecursoadministrativoDTO> createNotificacaorecursoadministrativo(@Valid @RequestBody NotificacaorecursoadministrativoDTO notificacaorecursoadministrativoDTO) {
        return ResponseEntity.ok(notificacaorecursoadministrativoService.save(notificacaorecursoadministrativoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar notificação", description = "Atualiza uma notificação de recurso administrativo existente")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<NotificacaorecursoadministrativoDTO> updateNotificacaorecursoadministrativo(@Parameter(description = "ID da notificação", example = "1") @PathVariable Integer id, @Valid @RequestBody NotificacaorecursoadministrativoDTO notificacaorecursoadministrativoDTO) {
        return notificacaorecursoadministrativoService.findById(id)
                .map(existingNotificacaorecursoadministrativoDTO -> {
                    notificacaorecursoadministrativoDTO.setIdrecursoadministrativo(id);
                    return ResponseEntity.ok(notificacaorecursoadministrativoService.save(notificacaorecursoadministrativoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir notificação", description = "Remove uma notificação de recurso administrativo pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteNotificacaorecursoadministrativo(@Parameter(description = "ID da notificação", example = "1") @PathVariable Integer id) {
        notificacaorecursoadministrativoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
