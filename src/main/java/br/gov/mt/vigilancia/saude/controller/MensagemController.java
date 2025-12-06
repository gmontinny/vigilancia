package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.MensagemDTO;
import br.gov.mt.vigilancia.saude.service.MensagemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @Operation(
            summary = "Listar mensagens",
            description = "Retorna a lista completa de mensagens cadastradas no sistema"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Lista de mensagens retornada com sucesso",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = MensagemDTO.class)
            )
    )
    @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<MensagemDTO>> findAll() {
        return ResponseEntity.ok(mensagemService.findAll());
    }
}
