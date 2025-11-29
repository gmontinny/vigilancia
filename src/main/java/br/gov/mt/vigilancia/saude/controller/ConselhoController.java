package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ConselhoDTO;
import br.gov.mt.vigilancia.saude.service.ConselhoService;
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
 * Controller para gerenciamento de conselhos profissionais.
 * Fornece endpoints para consulta de conselhos de classe (CRM, CRF, etc.).
 */
@RestController
@RequestMapping("/conselhos")
@RequiredArgsConstructor
@Tag(name = "Conselhos", description = "Gerenciamento de conselhos profissionais")
@SecurityRequirement(name = "bearerAuth")
public class ConselhoController {

    private final ConselhoService conselhoService;

    /**
     * Lista todos os conselhos profissionais cadastrados.
     * 
     * @return Lista de conselhos profissionais
     */
    @GetMapping
    @Operation(
        summary = "Listar conselhos profissionais",
        description = "Retorna a lista de todos os conselhos profissionais cadastrados (CRM, CRF, etc.)"
    )
    @ApiResponse(responseCode = "200", description = "Lista de conselhos retornada com sucesso")
    @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido ou ausente")
    public ResponseEntity<List<ConselhoDTO>> findAll() {
        return ResponseEntity.ok(conselhoService.findAll());
    }
}
