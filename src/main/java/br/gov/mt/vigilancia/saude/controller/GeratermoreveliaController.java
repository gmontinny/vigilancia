package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.GeratermoreveliaDTO;
import br.gov.mt.vigilancia.saude.service.GeratermoreveliaService;
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
@RequestMapping("/geratermorevelias")
@Tag(name = "Gera Termo Revelia", description = "Operações CRUD para geração de termos de revelia")
public class GeratermoreveliaController {

    @Autowired
    private GeratermoreveliaService geratermoreveliaService;

    @GetMapping
    @Operation(summary = "Listar termos de revelia", description = "Retorna a lista completa de termos de revelia gerados")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<GeratermoreveliaDTO>> getAllGeratermorevelias() {
        return ResponseEntity.ok(geratermoreveliaService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar termo por ID", description = "Retorna um termo de revelia pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<GeratermoreveliaDTO> getGeratermoreveliaById(@Parameter(description = "ID do termo", example = "1") @PathVariable Integer id) {
        return geratermoreveliaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar termo de revelia", description = "Cria um novo termo de revelia")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<GeratermoreveliaDTO> createGeratermorevelia(@Valid @RequestBody GeratermoreveliaDTO geratermoreveliaDTO) {
        return ResponseEntity.ok(geratermoreveliaService.save(geratermoreveliaDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar termo de revelia", description = "Atualiza um termo de revelia existente")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<GeratermoreveliaDTO> updateGeratermorevelia(@Parameter(description = "ID do termo", example = "1") @PathVariable Integer id, @Valid @RequestBody GeratermoreveliaDTO geratermoreveliaDTO) {
        return geratermoreveliaService.findById(id)
                .map(existingGeratermoreveliaDTO -> {
                    geratermoreveliaDTO.setIdtermorevelia(id);
                    return ResponseEntity.ok(geratermoreveliaService.save(geratermoreveliaDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir termo de revelia", description = "Remove um termo de revelia pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteGeratermorevelia(@Parameter(description = "ID do termo", example = "1") @PathVariable Integer id) {
        geratermoreveliaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
