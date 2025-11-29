package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.AssuntosolicitacaoDTO;
import br.gov.mt.vigilancia.saude.service.AssuntosolicitacaoService;
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
 * Controller para gerenciamento de assuntos de solicitação.
 */
@RestController
@RequestMapping("/assuntosolicitacoes")
@Tag(name = "Assuntos de Solicitação", description = "Gerenciamento de assuntos de solicitação")
@SecurityRequirement(name = "bearerAuth")
public class AssuntosolicitacaoController {

    @Autowired
    private AssuntosolicitacaoService assuntosolicitacaoService;

    @GetMapping
    @Operation(summary = "Listar assuntos de solicitação", description = "Retorna todos os assuntos de solicitação")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<AssuntosolicitacaoDTO>> getAllAssuntosolicitacoes() {
        return ResponseEntity.ok(assuntosolicitacaoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar assunto por ID", description = "Retorna um assunto de solicitação específico")
    @ApiResponse(responseCode = "200", description = "Assunto encontrado")
    @ApiResponse(responseCode = "404", description = "Assunto não encontrado")
    public ResponseEntity<AssuntosolicitacaoDTO> getAssuntosolicitacaoById(
        @Parameter(description = "ID do assunto") @PathVariable Integer id) {
        return assuntosolicitacaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar assunto de solicitação", description = "Cria um novo assunto de solicitação")
    @ApiResponse(responseCode = "200", description = "Assunto criado com sucesso")
    public ResponseEntity<AssuntosolicitacaoDTO> createAssuntosolicitacao(@RequestBody @Valid AssuntosolicitacaoDTO assuntosolicitacaoDTO) {
        return ResponseEntity.ok(assuntosolicitacaoService.save(assuntosolicitacaoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar assunto", description = "Atualiza um assunto de solicitação existente")
    @ApiResponse(responseCode = "200", description = "Assunto atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Assunto não encontrado")
    public ResponseEntity<AssuntosolicitacaoDTO> updateAssuntosolicitacao(
        @Parameter(description = "ID do assunto") @PathVariable Integer id, 
        @RequestBody @Valid AssuntosolicitacaoDTO assuntosolicitacaoDTO) {
        return assuntosolicitacaoService.findById(id)
                .map(existingAssuntosolicitacaoDTO -> {
                    assuntosolicitacaoDTO.setIdassunto(id);
                    return ResponseEntity.ok(assuntosolicitacaoService.save(assuntosolicitacaoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover assunto", description = "Remove um assunto de solicitação do sistema")
    @ApiResponse(responseCode = "204", description = "Assunto removido com sucesso")
    public ResponseEntity<Void> deleteAssuntosolicitacao(
        @Parameter(description = "ID do assunto") @PathVariable Integer id) {
        assuntosolicitacaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
