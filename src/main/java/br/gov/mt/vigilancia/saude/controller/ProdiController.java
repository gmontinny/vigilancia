package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ProdiDTO;
import br.gov.mt.vigilancia.saude.service.ProdiService;
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
 * Controller para consulta de prodis.
 */
@RestController
@RequestMapping("/prodis")
@RequiredArgsConstructor
@Tag(name = "Prodis", description = "Consulta de prodis")
@SecurityRequirement(name = "bearerAuth")
public class ProdiController {

    private final ProdiService prodiService;

    @GetMapping
    @Operation(summary = "Listar prodis", description = "Retorna todos os prodis cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<ProdiDTO>> findAll() {
        return ResponseEntity.ok(prodiService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar prodi por ID", description = "Retorna um prodi pelo seu identificador")
    @ApiResponse(responseCode = "200", description = "Prodi encontrado")
    @ApiResponse(responseCode = "404", description = "Prodi não encontrado")
    public ResponseEntity<ProdiDTO> findById(@Parameter(description = "ID do prodi", example = "1") @PathVariable Integer id) {
        return prodiService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar prodi", description = "Cria um novo prodi")
    @ApiResponse(responseCode = "200", description = "Prodi criado com sucesso")
    public ResponseEntity<ProdiDTO> create(@Valid @RequestBody ProdiDTO prodiDTO) {
        return ResponseEntity.ok(prodiService.save(prodiDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar prodi", description = "Atualiza um prodi existente")
    @ApiResponse(responseCode = "200", description = "Prodi atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Prodi não encontrado")
    public ResponseEntity<ProdiDTO> update(@Parameter(description = "ID do prodi", example = "1") @PathVariable Integer id, @Valid @RequestBody ProdiDTO prodiDTO) {
        return prodiService.findById(id)
                .map(existing -> {
                    prodiDTO.setId(id);
                    return ResponseEntity.ok(prodiService.save(prodiDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir prodi", description = "Remove um prodi pelo seu ID")
    @ApiResponse(responseCode = "204", description = "Prodi excluído com sucesso")
    @ApiResponse(responseCode = "404", description = "Prodi não encontrado")
    public ResponseEntity<Void> delete(@Parameter(description = "ID do prodi", example = "1") @PathVariable Integer id) {
        prodiService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
