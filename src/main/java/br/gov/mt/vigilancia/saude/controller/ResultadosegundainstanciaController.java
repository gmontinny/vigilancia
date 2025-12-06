package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ResultadosegundainstanciaDTO;
import br.gov.mt.vigilancia.saude.service.ResultadosegundainstanciaService;
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
@RequestMapping("/resultadosegundainstancias")
@Tag(name = "Resultado Segunda Instância", description = "Operações CRUD para resultados de segunda instância")
public class ResultadosegundainstanciaController {

    @Autowired
    private ResultadosegundainstanciaService resultadosegundainstanciaService;

    @GetMapping
    @Operation(summary = "Listar resultados de segunda instância", description = "Retorna a lista completa de resultados de segunda instância")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<ResultadosegundainstanciaDTO>> getAllResultadosegundainstancias() {
        return ResponseEntity.ok(resultadosegundainstanciaService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar resultado por ID", description = "Retorna um resultado de segunda instância pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ResultadosegundainstanciaDTO> getResultadosegundainstanciaById(@Parameter(description = "ID do resultado", example = "1") @PathVariable Integer id) {
        return resultadosegundainstanciaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar resultado", description = "Cria um novo resultado de segunda instância")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ResultadosegundainstanciaDTO> createResultadosegundainstancia(@Valid @RequestBody ResultadosegundainstanciaDTO resultadosegundainstanciaDTO) {
        return ResponseEntity.ok(resultadosegundainstanciaService.save(resultadosegundainstanciaDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar resultado", description = "Atualiza um resultado de segunda instância existente")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ResultadosegundainstanciaDTO> updateResultadosegundainstancia(@Parameter(description = "ID do resultado", example = "1") @PathVariable Integer id, @Valid @RequestBody ResultadosegundainstanciaDTO resultadosegundainstanciaDTO) {
        return resultadosegundainstanciaService.findById(id)
                .map(existingResultadosegundainstanciaDTO -> {
                    resultadosegundainstanciaDTO.setIdresultadosegunda(id);
                    return ResponseEntity.ok(resultadosegundainstanciaService.save(resultadosegundainstanciaDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir resultado", description = "Remove um resultado de segunda instância pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteResultadosegundainstancia(@Parameter(description = "ID do resultado", example = "1") @PathVariable Integer id) {
        resultadosegundainstanciaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
