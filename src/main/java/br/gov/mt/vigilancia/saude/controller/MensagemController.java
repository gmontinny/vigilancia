package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.MensagemDTO;
import br.gov.mt.vigilancia.saude.service.MensagemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller para gerenciamento de mensagens do sistema.
 * Fornece endpoints para consulta de mensagens e notificações.
 */
@RestController
@RequestMapping("/mensagens")
@RequiredArgsConstructor
@Tag(name = "Mensagens", description = "Operações de consulta de mensagens do sistema")
public class MensagemController {

    private final MensagemService mensagemService;

    /**
     * Lista todas as mensagens cadastradas no sistema.
     *
     * @return Lista de mensagens
     */
    @GetMapping
    @Operation(summary = "Listar mensagens", description = "Retorna a lista completa de mensagens cadastradas no sistema")
    @ApiResponse(responseCode = "200", description = "Lista de mensagens retornada com sucesso")
    @ApiResponse(responseCode = "401", description = "Não autorizado")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<MensagemDTO>> findAll() {
        return ResponseEntity.ok(mensagemService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar mensagem por ID", description = "Retorna uma mensagem pelo seu identificador")
    @ApiResponse(responseCode = "200", description = "Mensagem encontrada")
    @ApiResponse(responseCode = "404", description = "Mensagem não encontrada")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<MensagemDTO> findById(@Parameter(description = "ID da mensagem", example = "1") @PathVariable Integer id) {
        return mensagemService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar mensagem", description = "Cria uma nova mensagem no sistema")
    @ApiResponse(responseCode = "200", description = "Mensagem criada com sucesso")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<MensagemDTO> create(@Valid @RequestBody MensagemDTO mensagemDTO) {
        return ResponseEntity.ok(mensagemService.save(mensagemDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar mensagem", description = "Atualiza uma mensagem existente")
    @ApiResponse(responseCode = "200", description = "Mensagem atualizada com sucesso")
    @ApiResponse(responseCode = "404", description = "Mensagem não encontrada")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<MensagemDTO> update(@Parameter(description = "ID da mensagem", example = "1") @PathVariable Integer id, @Valid @RequestBody MensagemDTO mensagemDTO) {
        return mensagemService.findById(id)
                .map(existing -> {
                    mensagemDTO.setId(id);
                    return ResponseEntity.ok(mensagemService.save(mensagemDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir mensagem", description = "Remove uma mensagem pelo seu ID")
    @ApiResponse(responseCode = "204", description = "Mensagem excluída com sucesso")
    @ApiResponse(responseCode = "404", description = "Mensagem não encontrada")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> delete(@Parameter(description = "ID da mensagem", example = "1") @PathVariable Integer id) {
        mensagemService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
