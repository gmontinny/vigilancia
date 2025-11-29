package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.OrdemServicoDTO;
import br.gov.mt.vigilancia.saude.service.OrdemServicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller para gerenciamento de ordens de serviço.
 */
@RestController
@RequestMapping("/ordemservicos")
@Tag(name = "Ordens de Serviço", description = "Gerenciamento de ordens de serviço")
@SecurityRequirement(name = "bearerAuth")
public class OrdemServicoController {

    @Autowired
    private OrdemServicoService ordemservicoService;

    @GetMapping
    @Operation(summary = "Listar ordens de serviço", description = "Retorna todas as ordens de serviço")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<OrdemServicoDTO>> getAllOrdemservicos() {
        return ResponseEntity.ok(ordemservicoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar ordem por ID", description = "Retorna uma ordem de serviço específica")
    @ApiResponse(responseCode = "200", description = "Ordem encontrada")
    @ApiResponse(responseCode = "404", description = "Ordem não encontrada")
    public ResponseEntity<OrdemServicoDTO> getOrdemservicoById(
        @Parameter(description = "ID da ordem de serviço") @PathVariable Integer id) {
        return ordemservicoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar ordem de serviço", description = "Cria uma nova ordem de serviço")
    @ApiResponse(responseCode = "200", description = "Ordem criada com sucesso")
    public ResponseEntity<OrdemServicoDTO> createOrdemservico(@RequestBody @Valid OrdemServicoDTO ordemservicoDTO) {
        return ResponseEntity.ok(ordemservicoService.save(ordemservicoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar ordem", description = "Atualiza uma ordem de serviço existente")
    @ApiResponse(responseCode = "200", description = "Ordem atualizada com sucesso")
    @ApiResponse(responseCode = "404", description = "Ordem não encontrada")
    public ResponseEntity<OrdemServicoDTO> updateOrdemservico(
        @Parameter(description = "ID da ordem de serviço") @PathVariable Integer id, 
        @RequestBody @Valid OrdemServicoDTO ordemservicoDTO) {
        return ordemservicoService.findById(id)
                .map(existingOrdemservicoDTO -> {
                    ordemservicoDTO.setIdordemservico(id);
                    return ResponseEntity.ok(ordemservicoService.save(ordemservicoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover ordem", description = "Remove uma ordem de serviço do sistema")
    @ApiResponse(responseCode = "204", description = "Ordem removida com sucesso")
    public ResponseEntity<Void> deleteOrdemservico(
        @Parameter(description = "ID da ordem de serviço") @PathVariable Integer id) {
        ordemservicoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
