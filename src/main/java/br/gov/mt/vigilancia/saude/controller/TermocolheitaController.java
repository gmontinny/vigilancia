package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.TermocolheitaDTO;
import br.gov.mt.vigilancia.saude.service.TermocolheitaService;
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
@RequestMapping("/termocolheitas")
@Tag(name = "Termo Colheita", description = "Operações CRUD para termos de colheita")
public class TermocolheitaController {

    @Autowired
    private TermocolheitaService termocolheitaService;

    @GetMapping
    @Operation(summary = "Listar termos de colheita", description = "Retorna a lista completa de termos de colheita")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<TermocolheitaDTO>> getAllTermocolheitas() {
        return ResponseEntity.ok(termocolheitaService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar termo por ID", description = "Retorna um termo de colheita pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<TermocolheitaDTO> getTermocolheitaById(@Parameter(description = "ID do termo", example = "1") @PathVariable Integer id) {
        return termocolheitaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar termo de colheita", description = "Cria um novo termo de colheita")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<TermocolheitaDTO> createTermocolheita(@Valid @RequestBody TermocolheitaDTO termocolheitaDTO) {
        return ResponseEntity.ok(termocolheitaService.save(termocolheitaDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar termo de colheita", description = "Atualiza um termo de colheita existente")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<TermocolheitaDTO> updateTermocolheita(@Parameter(description = "ID do termo", example = "1") @PathVariable Integer id, @Valid @RequestBody TermocolheitaDTO termocolheitaDTO) {
        return termocolheitaService.findById(id)
                .map(existingTermocolheitaDTO -> {
                    termocolheitaDTO.setIdtermocolheita(id);
                    return ResponseEntity.ok(termocolheitaService.save(termocolheitaDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir termo de colheita", description = "Remove um termo de colheita pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteTermocolheita(@Parameter(description = "ID do termo", example = "1") @PathVariable Integer id) {
        termocolheitaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}