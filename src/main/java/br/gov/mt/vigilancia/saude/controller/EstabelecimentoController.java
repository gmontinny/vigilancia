package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.EstabelecimentoDTO;
import br.gov.mt.vigilancia.saude.service.EstabelecimentoService;
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
 * Controller para gerenciamento de estabelecimentos.
 * Fornece endpoints para consulta de estabelecimentos sujeitos à vigilância sanitária.
 */
@RestController
@RequestMapping("/estabelecimentos")
@RequiredArgsConstructor
@Tag(name = "Estabelecimentos", description = "Gerenciamento de estabelecimentos sujeitos à vigilância sanitária")
@SecurityRequirement(name = "bearerAuth")
public class EstabelecimentoController {

    private final EstabelecimentoService estabelecimentoService;

    /**
     * Lista todos os estabelecimentos cadastrados no sistema.
     * 
     * @return Lista de estabelecimentos
     */
    @GetMapping
    @Operation(
        summary = "Listar estabelecimentos",
        description = "Retorna a lista de todos os estabelecimentos sujeitos à vigilância sanitária"
    )
    @ApiResponse(responseCode = "200", description = "Lista de estabelecimentos retornada com sucesso")
    @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido ou ausente")
    public ResponseEntity<List<EstabelecimentoDTO>> findAll() {
        return ResponseEntity.ok(estabelecimentoService.findAll());
    }
}
