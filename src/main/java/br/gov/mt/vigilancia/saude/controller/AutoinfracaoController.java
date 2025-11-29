package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.AutoinfracaoDTO;
import br.gov.mt.vigilancia.saude.service.AutoinfracaoService;
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
 * Controller para gerenciamento de autos de infração.
 */
@RestController
@RequestMapping("/autoinfracoes")
@Tag(name = "Autos de Infração", description = "Gerenciamento de autos de infração")
@SecurityRequirement(name = "bearerAuth")
public class AutoinfracaoController {

    @Autowired
    private AutoinfracaoService autoinfracaoService;

    @GetMapping
    @Operation(summary = "Listar autos de infração", description = "Retorna todos os autos de infração")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<AutoinfracaoDTO>> getAllAutoinfracoes() {
        return ResponseEntity.ok(autoinfracaoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar auto por ID", description = "Retorna um auto de infração específico")
    @ApiResponse(responseCode = "200", description = "Auto encontrado")
    @ApiResponse(responseCode = "404", description = "Auto não encontrado")
    public ResponseEntity<AutoinfracaoDTO> getAutoinfracaoById(
        @Parameter(description = "ID do auto de infração") @PathVariable Integer id) {
        return autoinfracaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar auto de infração", description = "Cria um novo auto de infração")
    @ApiResponse(responseCode = "200", description = "Auto criado com sucesso")
    public ResponseEntity<AutoinfracaoDTO> createAutoinfracao(@RequestBody @Valid AutoinfracaoDTO autoinfracaoDTO) {
        return ResponseEntity.ok(autoinfracaoService.save(autoinfracaoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar auto", description = "Atualiza um auto de infração existente")
    @ApiResponse(responseCode = "200", description = "Auto atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Auto não encontrado")
    public ResponseEntity<AutoinfracaoDTO> updateAutoinfracao(
        @Parameter(description = "ID do auto de infração") @PathVariable Integer id, 
        @RequestBody @Valid AutoinfracaoDTO autoinfracaoDTO) {
        return autoinfracaoService.findById(id)
                .map(existingAutoinfracaoDTO -> {
                    autoinfracaoDTO.setIdautoinfracao(id);
                    return ResponseEntity.ok(autoinfracaoService.save(autoinfracaoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover auto", description = "Remove um auto de infração do sistema")
    @ApiResponse(responseCode = "204", description = "Auto removido com sucesso")
    public ResponseEntity<Void> deleteAutoinfracao(
        @Parameter(description = "ID do auto de infração") @PathVariable Integer id) {
        autoinfracaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
