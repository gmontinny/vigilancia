package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.RelatorioDTO;
import br.gov.mt.vigilancia.saude.service.RelatorioService;
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
@RequestMapping("/relatorios")
@Tag(name = "Relatório", description = "Operações CRUD para relatórios")
public class RelatorioController {

    @Autowired
    private RelatorioService relatorioService;

    @GetMapping
    @Operation(summary = "Listar relatórios", description = "Retorna a lista completa de relatórios")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<RelatorioDTO>> getAllRelatorios() {
        return ResponseEntity.ok(relatorioService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar relatório por ID", description = "Retorna um relatório pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<RelatorioDTO> getRelatorioById(@Parameter(description = "ID do relatório", example = "1") @PathVariable Integer id) {
        return relatorioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar relatório", description = "Cria um novo relatório")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<RelatorioDTO> createRelatorio(@Valid @RequestBody RelatorioDTO relatorioDTO) {
        return ResponseEntity.ok(relatorioService.save(relatorioDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar relatório", description = "Atualiza um relatório existente")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<RelatorioDTO> updateRelatorio(@Parameter(description = "ID do relatório", example = "1") @PathVariable Integer id, @Valid @RequestBody RelatorioDTO relatorioDTO) {
        return relatorioService.findById(id)
                .map(existingRelatorioDTO -> {
                    relatorioDTO.setIdrelatorio(id);
                    return ResponseEntity.ok(relatorioService.save(relatorioDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir relatório", description = "Remove um relatório pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteRelatorio(@Parameter(description = "ID do relatório", example = "1") @PathVariable Integer id) {
        relatorioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
