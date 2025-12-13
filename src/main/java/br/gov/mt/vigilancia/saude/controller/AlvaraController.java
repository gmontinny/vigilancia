package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.AlvaraDTO;
import br.gov.mt.vigilancia.saude.service.AlvaraService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller para consulta de alvarás sanitários.
 */
@RestController
@RequestMapping("/alvaras")
@RequiredArgsConstructor
@Tag(name = "Alvarás", description = "Consulta de alvarás sanitários")
@SecurityRequirement(name = "bearerAuth")
public class AlvaraController {

    private final AlvaraService alvaraService;

    @GetMapping
    @Operation(summary = "Listar alvarás", description = "Retorna todos os alvarás sanitários cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<AlvaraDTO>> findAll() {
        return ResponseEntity.ok(alvaraService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar alvará por ID", description = "Retorna um alvará sanitário pelo seu identificador")
    @ApiResponse(responseCode = "200", description = "Alvará encontrado")
    @ApiResponse(responseCode = "404", description = "Alvará não encontrado")
    public ResponseEntity<AlvaraDTO> findById(@Parameter(description = "ID do alvará", example = "1") @PathVariable Integer id) {
        return alvaraService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar alvará", description = "Cria um novo alvará sanitário")
    @ApiResponse(responseCode = "200", description = "Alvará criado com sucesso")
    public ResponseEntity<AlvaraDTO> create(@Valid @RequestBody AlvaraDTO alvaraDTO) {
        return ResponseEntity.ok(alvaraService.save(alvaraDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar alvará", description = "Atualiza um alvará sanitário existente")
    @ApiResponse(responseCode = "200", description = "Alvará atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Alvará não encontrado")
    public ResponseEntity<AlvaraDTO> update(@Parameter(description = "ID do alvará", example = "1") @PathVariable Integer id, @Valid @RequestBody AlvaraDTO alvaraDTO) {
        return alvaraService.findById(id)
                .map(existing -> {
                    alvaraDTO.setId(id);
                    return ResponseEntity.ok(alvaraService.save(alvaraDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir alvará", description = "Remove um alvará sanitário pelo seu ID")
    @ApiResponse(responseCode = "204", description = "Alvará excluído com sucesso")
    @ApiResponse(responseCode = "404", description = "Alvará não encontrado")
    public ResponseEntity<Void> delete(@Parameter(description = "ID do alvará", example = "1") @PathVariable Integer id) {
        alvaraService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
