package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.NotificacaorecursoDTO;
import br.gov.mt.vigilancia.saude.service.NotificacaorecursoService;
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
@RequestMapping("/notificacaorecursos")
@Tag(name = "Notificação Recurso", description = "Operações CRUD para notificações de recurso")
public class NotificacaorecursoController {

    @Autowired
    private NotificacaorecursoService notificacaorecursoService;

    @GetMapping
    @Operation(summary = "Listar notificações de recurso", description = "Retorna a lista completa de notificações de recurso")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<NotificacaorecursoDTO>> getAllNotificacaorecursos() {
        return ResponseEntity.ok(notificacaorecursoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar notificação por ID", description = "Retorna uma notificação de recurso pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<NotificacaorecursoDTO> getNotificacaorecursoById(@Parameter(description = "ID da notificação", example = "1") @PathVariable Integer id) {
        return notificacaorecursoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar notificação de recurso", description = "Cria uma nova notificação de recurso")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<NotificacaorecursoDTO> createNotificacaorecurso(@Valid @RequestBody NotificacaorecursoDTO notificacaorecursoDTO) {
        return ResponseEntity.ok(notificacaorecursoService.save(notificacaorecursoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar notificação de recurso", description = "Atualiza uma notificação de recurso existente")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<NotificacaorecursoDTO> updateNotificacaorecurso(@Parameter(description = "ID da notificação", example = "1") @PathVariable Integer id, @Valid @RequestBody NotificacaorecursoDTO notificacaorecursoDTO) {
        return notificacaorecursoService.findById(id)
                .map(existingNotificacaorecursoDTO -> {
                    notificacaorecursoDTO.setIdnotificacaorecurso(id);
                    return ResponseEntity.ok(notificacaorecursoService.save(notificacaorecursoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir notificação de recurso", description = "Remove uma notificação de recurso pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteNotificacaorecurso(@Parameter(description = "ID da notificação", example = "1") @PathVariable Integer id) {
        notificacaorecursoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
