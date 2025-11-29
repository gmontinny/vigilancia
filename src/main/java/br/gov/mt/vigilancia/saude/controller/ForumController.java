package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ForumDTO;
import br.gov.mt.vigilancia.saude.service.ForumService;
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
 * Controller para consulta de fóruns.
 */
@RestController
@RequestMapping("/foruns")
@RequiredArgsConstructor
@Tag(name = "Fóruns", description = "Consulta de fóruns")
@SecurityRequirement(name = "bearerAuth")
public class ForumController {

    private final ForumService forumService;

    @GetMapping
    @Operation(summary = "Listar fóruns", description = "Retorna todos os fóruns cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<ForumDTO>> findAll() {
        return ResponseEntity.ok(forumService.findAll());
    }
}
