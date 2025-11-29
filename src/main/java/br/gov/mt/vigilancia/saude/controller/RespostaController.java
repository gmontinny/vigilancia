package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.RespostaDTO;
import br.gov.mt.vigilancia.saude.service.RespostaService;
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
 * Controller para consulta de respostas.
 */
@RestController
@RequestMapping("/respostas")
@RequiredArgsConstructor
@Tag(name = "Respostas", description = "Consulta de respostas")
@SecurityRequirement(name = "bearerAuth")
public class RespostaController {

    private final RespostaService respostaService;

    @GetMapping
    @Operation(summary = "Listar respostas", description = "Retorna todas as respostas cadastradas")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<RespostaDTO>> findAll() {
        return ResponseEntity.ok(respostaService.findAll());
    }
}
