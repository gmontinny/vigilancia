package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ProcessoadministrativoDTO;
import br.gov.mt.vigilancia.saude.service.ProcessoadministrativoService;
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
@RequestMapping("/processoadministrativos")
@Tag(name = "Processo Administrativo", description = "Operações CRUD para processos administrativos")
public class ProcessoadministrativoController {

    @Autowired
    private ProcessoadministrativoService processoadministrativoService;

    @GetMapping
    @Operation(summary = "Listar processos administrativos", description = "Retorna a lista completa de processos administrativos")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<ProcessoadministrativoDTO>> getAllProcessoadministrativos() {
        return ResponseEntity.ok(processoadministrativoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar processo por ID", description = "Retorna um processo administrativo pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ProcessoadministrativoDTO> getProcessoadministrativoById(@Parameter(description = "ID do processo", example = "1") @PathVariable Integer id) {
        return processoadministrativoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar processo", description = "Cria um novo processo administrativo")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ProcessoadministrativoDTO> createProcessoadministrativo(@Valid @RequestBody ProcessoadministrativoDTO processoadministrativoDTO) {
        return ResponseEntity.ok(processoadministrativoService.save(processoadministrativoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar processo", description = "Atualiza um processo administrativo existente")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ProcessoadministrativoDTO> updateProcessoadministrativo(@Parameter(description = "ID do processo", example = "1") @PathVariable Integer id, @Valid @RequestBody ProcessoadministrativoDTO processoadministrativoDTO) {
        return processoadministrativoService.findById(id)
                .map(existingProcessoadministrativoDTO -> {
                    processoadministrativoDTO.setIdprocessoadministrativo(id);
                    return ResponseEntity.ok(processoadministrativoService.save(processoadministrativoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir processo", description = "Remove um processo administrativo pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteProcessoadministrativo(@Parameter(description = "ID do processo", example = "1") @PathVariable Integer id) {
        processoadministrativoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
