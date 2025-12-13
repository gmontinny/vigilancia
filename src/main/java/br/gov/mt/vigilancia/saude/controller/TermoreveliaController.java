package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.TermoreveliaDTO;
import br.gov.mt.vigilancia.saude.service.TermoreveliaService;
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
@RequestMapping("/termorevelias")
@Tag(name = "Termo Revelia", description = "Operações CRUD para termos de revelia")
public class TermoreveliaController {

    @Autowired
    private TermoreveliaService termoreveliaService;

    @GetMapping
    @Operation(summary = "Listar termos de revelia", description = "Retorna a lista completa de termos de revelia")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<TermoreveliaDTO>> getAllTermorevelias() {
        return ResponseEntity.ok(termoreveliaService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar termo por ID", description = "Retorna um termo de revelia pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<TermoreveliaDTO> getTermoreveliaById(@Parameter(description = "ID do termo", example = "1") @PathVariable Integer id) {
        return termoreveliaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar termo de revelia", description = "Cria um novo termo de revelia")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<TermoreveliaDTO> createTermorevelia(@Valid @RequestBody TermoreveliaDTO termoreveliaDTO) {
        return ResponseEntity.ok(termoreveliaService.save(termoreveliaDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar termo de revelia", description = "Atualiza um termo de revelia existente")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<TermoreveliaDTO> updateTermorevelia(@Parameter(description = "ID do termo", example = "1") @PathVariable Integer id, @Valid @RequestBody TermoreveliaDTO termoreveliaDTO) {
        return termoreveliaService.findById(id)
                .map(existingTermoreveliaDTO -> {
                    termoreveliaDTO.setIdtermorevelia(id);
                    return ResponseEntity.ok(termoreveliaService.save(termoreveliaDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir termo de revelia", description = "Remove um termo de revelia pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteTermorevelia(@Parameter(description = "ID do termo", example = "1") @PathVariable Integer id) {
        termoreveliaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}