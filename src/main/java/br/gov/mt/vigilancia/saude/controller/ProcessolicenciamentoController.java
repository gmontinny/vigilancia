package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ProcessolicenciamentoDTO;
import br.gov.mt.vigilancia.saude.service.ProcessolicenciamentoService;
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
@RequestMapping("/processolicenciamentos")
@Tag(name = "Processo Licenciamento", description = "Operações CRUD para processos de licenciamento")
public class ProcessolicenciamentoController {

    @Autowired
    private ProcessolicenciamentoService processolicenciamentoService;

    @GetMapping
    @Operation(summary = "Listar processos de licenciamento", description = "Retorna a lista completa de processos de licenciamento")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<ProcessolicenciamentoDTO>> getAllProcessolicenciamentos() {
        return ResponseEntity.ok(processolicenciamentoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar processo por ID", description = "Retorna um processo de licenciamento pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ProcessolicenciamentoDTO> getProcessolicenciamentoById(@Parameter(description = "ID do processo", example = "1") @PathVariable Integer id) {
        return processolicenciamentoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar processo", description = "Cria um novo processo de licenciamento")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ProcessolicenciamentoDTO> createProcessolicenciamento(@Valid @RequestBody ProcessolicenciamentoDTO processolicenciamentoDTO) {
        return ResponseEntity.ok(processolicenciamentoService.save(processolicenciamentoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar processo", description = "Atualiza um processo de licenciamento existente")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ProcessolicenciamentoDTO> updateProcessolicenciamento(@Parameter(description = "ID do processo", example = "1") @PathVariable Integer id, @Valid @RequestBody ProcessolicenciamentoDTO processolicenciamentoDTO) {
        return processolicenciamentoService.findById(id)
                .map(existingProcessolicenciamentoDTO -> {
                    processolicenciamentoDTO.setIdprocessolicenciamento(id);
                    return ResponseEntity.ok(processolicenciamentoService.save(processolicenciamentoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir processo", description = "Remove um processo de licenciamento pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteProcessolicenciamento(@Parameter(description = "ID do processo", example = "1") @PathVariable Integer id) {
        processolicenciamentoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
