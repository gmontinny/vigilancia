package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ProcessosolicitacaoDTO;
import br.gov.mt.vigilancia.saude.service.ProcessosolicitacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/processosolicitacoes")
@Tag(name = "Processo Solicitação", description = "Operações CRUD para processos de solicitação")
public class ProcessosolicitacaoController {

    @Autowired
    private ProcessosolicitacaoService processosolicitacaoService;

    @GetMapping
    @Operation(summary = "Listar processos de solicitação", description = "Retorna a lista completa de processos de solicitação")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<ProcessosolicitacaoDTO>> getAllProcessosolicitacoes() {
        return ResponseEntity.ok(processosolicitacaoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar processo por ID", description = "Retorna um processo de solicitação pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ProcessosolicitacaoDTO> getProcessosolicitacaoById(@Parameter(description = "ID do processo", example = "1") @PathVariable Integer id) {
        return processosolicitacaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar processo", description = "Cria um novo processo de solicitação")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ProcessosolicitacaoDTO> createProcessosolicitacao(@Valid @RequestBody ProcessosolicitacaoDTO processosolicitacaoDTO) {
        return ResponseEntity.ok(processosolicitacaoService.save(processosolicitacaoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar processo", description = "Atualiza um processo de solicitação existente")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ProcessosolicitacaoDTO> updateProcessosolicitacao(@Parameter(description = "ID do processo", example = "1") @PathVariable Integer id, @Valid @RequestBody ProcessosolicitacaoDTO processosolicitacaoDTO) {
        return processosolicitacaoService.findById(id)
                .map(existingProcessosolicitacaoDTO -> {
                    processosolicitacaoDTO.setIdprocessosolicitacao(id);
                    return ResponseEntity.ok(processosolicitacaoService.save(processosolicitacaoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir processo", description = "Remove um processo de solicitação pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteProcessosolicitacao(@Parameter(description = "ID do processo", example = "1") @PathVariable Integer id) {
        processosolicitacaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
