package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.GeraitensprodiDTO;
import br.gov.mt.vigilancia.saude.service.GeraitensprodiService;
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
@RequestMapping("/geraitensprodis")
@Tag(name = "Gera Itens Prodi", description = "Operações CRUD para geração de itens prodi")
public class GeraitensprodiController {

    @Autowired
    private GeraitensprodiService geraitensprodiService;

    @GetMapping
    @Operation(summary = "Listar itens prodi", description = "Retorna a lista completa de itens prodi gerados")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<GeraitensprodiDTO>> getAllGeraitensprodis() {
        return ResponseEntity.ok(geraitensprodiService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar item prodi por ID", description = "Retorna um item prodi pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<GeraitensprodiDTO> getGeraitensprodiById(@Parameter(description = "ID do item prodi", example = "1") @PathVariable Integer id) {
        return geraitensprodiService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar item prodi", description = "Cria um novo item prodi")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<GeraitensprodiDTO> createGeraitensprodi(@Valid @RequestBody GeraitensprodiDTO geraitensprodiDTO) {
        return ResponseEntity.ok(geraitensprodiService.save(geraitensprodiDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar item prodi", description = "Atualiza um item prodi existente")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<GeraitensprodiDTO> updateGeraitensprodi(@Parameter(description = "ID do item prodi", example = "1") @PathVariable Integer id, @Valid @RequestBody GeraitensprodiDTO geraitensprodiDTO) {
        return geraitensprodiService.findById(id)
                .map(existingGeraitensprodiDTO -> {
                    geraitensprodiDTO.setIdgeraitensprodi(id);
                    return ResponseEntity.ok(geraitensprodiService.save(geraitensprodiDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir item prodi", description = "Remove um item prodi pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteGeraitensprodi(@Parameter(description = "ID do item prodi", example = "1") @PathVariable Integer id) {
        geraitensprodiService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
