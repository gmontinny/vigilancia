package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.PermissaoDTO;
import br.gov.mt.vigilancia.saude.service.PermissaoService;
import io.swagger.v3.oas.annotations.Operation;
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
 * Controller para gerenciamento de permissões do sistema.
 */
@RestController
@RequestMapping("/permissoes")
@RequiredArgsConstructor
@Tag(name = "Permissões", description = "Consulta de permissões do sistema")
@SecurityRequirement(name = "bearerAuth")
public class PermissaoController {

    private final PermissaoService permissaoService;

    @GetMapping
    @Operation(summary = "Listar permissões", description = "Retorna todas as permissões do sistema")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<PermissaoDTO>> findAll() {
        return ResponseEntity.ok(permissaoService.findAll());
    }
}
