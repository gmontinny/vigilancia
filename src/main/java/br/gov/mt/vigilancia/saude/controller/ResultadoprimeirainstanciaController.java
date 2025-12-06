package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ResultadoprimeirainstanciaDTO;
import br.gov.mt.vigilancia.saude.service.ResultadoprimeirainstanciaService;
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
@RequestMapping("/resultadoprimeirainstancias")
@Tag(name = "Resultado Primeira Instância", description = "Operações CRUD para resultados de primeira instância")
public class ResultadoprimeirainstanciaController {

    @Autowired
    private ResultadoprimeirainstanciaService resultadoprimeirainstanciaService;

    @GetMapping
    @Operation(summary = "Listar resultados de primeira instância", description = "Retorna a lista completa de resultados de primeira instância")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<ResultadoprimeirainstanciaDTO>> getAllResultadoprimeirainstancias() {
        return ResponseEntity.ok(resultadoprimeirainstanciaService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar resultado por ID", description = "Retorna um resultado de primeira instância pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ResultadoprimeirainstanciaDTO> getResultadoprimeirainstanciaById(@Parameter(description = "ID do resultado", example = "1") @PathVariable Integer id) {
        return resultadoprimeirainstanciaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar resultado", description = "Cria um novo resultado de primeira instância")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ResultadoprimeirainstanciaDTO> createResultadoprimeirainstancia(@Valid @RequestBody ResultadoprimeirainstanciaDTO resultadoprimeirainstanciaDTO) {
        return ResponseEntity.ok(resultadoprimeirainstanciaService.save(resultadoprimeirainstanciaDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar resultado", description = "Atualiza um resultado de primeira instância existente")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ResultadoprimeirainstanciaDTO> updateResultadoprimeirainstancia(@Parameter(description = "ID do resultado", example = "1") @PathVariable Integer id, @Valid @RequestBody ResultadoprimeirainstanciaDTO resultadoprimeirainstanciaDTO) {
        return resultadoprimeirainstanciaService.findById(id)
                .map(existingResultadoprimeirainstanciaDTO -> {
                    resultadoprimeirainstanciaDTO.setIdresultadoprimeira(id);
                    return ResponseEntity.ok(resultadoprimeirainstanciaService.save(resultadoprimeirainstanciaDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir resultado", description = "Remove um resultado de primeira instância pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteResultadoprimeirainstancia(@Parameter(description = "ID do resultado", example = "1") @PathVariable Integer id) {
        resultadoprimeirainstanciaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
