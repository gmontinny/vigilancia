package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.NotificacaoordemservicoDTO;
import br.gov.mt.vigilancia.saude.service.NotificacaoordemservicoService;
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
@RequestMapping("/notificacaoordemservicos")
@Tag(name = "Notificação Ordem Serviço", description = "Operações CRUD para notificações de ordem de serviço")
public class NotificacaoordemservicoController {

    @Autowired
    private NotificacaoordemservicoService notificacaoordemservicoService;

    @GetMapping
    @Operation(summary = "Listar notificações de OS", description = "Retorna a lista completa de notificações de ordem de serviço")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<NotificacaoordemservicoDTO>> getAllNotificacaoordemservicos() {
        return ResponseEntity.ok(notificacaoordemservicoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar notificação por ID", description = "Retorna uma notificação de OS pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<NotificacaoordemservicoDTO> getNotificacaoordemservicoById(@Parameter(description = "ID da notificação", example = "1") @PathVariable Integer id) {
        return notificacaoordemservicoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar notificação de OS", description = "Cria uma nova notificação de ordem de serviço")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<NotificacaoordemservicoDTO> createNotificacaoordemservico(@Valid @RequestBody NotificacaoordemservicoDTO notificacaoordemservicoDTO) {
        return ResponseEntity.ok(notificacaoordemservicoService.save(notificacaoordemservicoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar notificação de OS", description = "Atualiza uma notificação de ordem de serviço existente")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<NotificacaoordemservicoDTO> updateNotificacaoordemservico(@Parameter(description = "ID da notificação", example = "1") @PathVariable Integer id, @Valid @RequestBody NotificacaoordemservicoDTO notificacaoordemservicoDTO) {
        return notificacaoordemservicoService.findById(id)
                .map(existingNotificacaoordemservicoDTO -> {
                    notificacaoordemservicoDTO.setIdnotificacaoordemservico(id);
                    return ResponseEntity.ok(notificacaoordemservicoService.save(notificacaoordemservicoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir notificação de OS", description = "Remove uma notificação de ordem de serviço pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteNotificacaoordemservico(@Parameter(description = "ID da notificação", example = "1") @PathVariable Integer id) {
        notificacaoordemservicoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
