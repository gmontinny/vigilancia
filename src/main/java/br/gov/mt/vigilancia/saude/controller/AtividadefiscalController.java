package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.AtividadefiscalDTO;
import br.gov.mt.vigilancia.saude.service.AtividadefiscalService;
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
 * Controller para gerenciamento de atividades fiscais.
 */
@RestController
@RequestMapping("/atividadefiscais")
@Tag(name = "Atividades Fiscais", description = "Gerenciamento de atividades fiscais")
@SecurityRequirement(name = "bearerAuth")
public class AtividadefiscalController {

    @Autowired
    private AtividadefiscalService atividadefiscalService;

    @GetMapping
    @Operation(summary = "Listar atividades fiscais", description = "Retorna todas as atividades fiscais")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<AtividadefiscalDTO>> getAllAtividadefiscais() {
        return ResponseEntity.ok(atividadefiscalService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar atividade por ID", description = "Retorna uma atividade fiscal específica")
    @ApiResponse(responseCode = "200", description = "Atividade encontrada")
    @ApiResponse(responseCode = "404", description = "Atividade não encontrada")
    public ResponseEntity<AtividadefiscalDTO> getAtividadefiscalById(
        @Parameter(description = "ID da atividade") @PathVariable Integer id) {
        return atividadefiscalService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar atividade fiscal", description = "Cria uma nova atividade fiscal")
    @ApiResponse(responseCode = "200", description = "Atividade criada com sucesso")
    public ResponseEntity<AtividadefiscalDTO> createAtividadefiscal(@RequestBody @Valid AtividadefiscalDTO atividadefiscalDTO) {
        return ResponseEntity.ok(atividadefiscalService.save(atividadefiscalDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar atividade", description = "Atualiza uma atividade fiscal existente")
    @ApiResponse(responseCode = "200", description = "Atividade atualizada com sucesso")
    @ApiResponse(responseCode = "404", description = "Atividade não encontrada")
    public ResponseEntity<AtividadefiscalDTO> updateAtividadefiscal(
        @Parameter(description = "ID da atividade") @PathVariable Integer id, 
        @RequestBody @Valid AtividadefiscalDTO atividadefiscalDTO) {
        return atividadefiscalService.findById(id)
                .map(existingAtividadefiscalDTO -> {
                    atividadefiscalDTO.setIdatividadefiscal(id);
                    return ResponseEntity.ok(atividadefiscalService.save(atividadefiscalDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover atividade", description = "Remove uma atividade fiscal do sistema")
    @ApiResponse(responseCode = "204", description = "Atividade removida com sucesso")
    public ResponseEntity<Void> deleteAtividadefiscal(
        @Parameter(description = "ID da atividade") @PathVariable Integer id) {
        atividadefiscalService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
