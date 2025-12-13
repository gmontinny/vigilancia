package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.LicenciaDTO;
import br.gov.mt.vigilancia.saude.service.LicenciaService;
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
 * Controller para consulta de licenças.
 */
@RestController
@RequestMapping("/licencias")
@RequiredArgsConstructor
@Tag(name = "Licenças", description = "Consulta de licenças")
@SecurityRequirement(name = "bearerAuth")
public class LicenciaController {

    private final LicenciaService licenciaService;

    @GetMapping
    @Operation(summary = "Listar licenças", description = "Retorna todas as licenças cadastradas")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<LicenciaDTO>> findAll() {
        return ResponseEntity.ok(licenciaService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar licença por ID", description = "Retorna uma licença específica pelo ID")
    @ApiResponse(responseCode = "200", description = "Licença encontrada")
    @ApiResponse(responseCode = "404", description = "Licença não encontrada")
    public ResponseEntity<LicenciaDTO> findById(@Parameter(description = "ID da licença") @PathVariable Integer id) {
        return ResponseEntity.ok(licenciaService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Criar licença", description = "Cria uma nova licença")
    @ApiResponse(responseCode = "200", description = "Licença criada com sucesso")
    public ResponseEntity<LicenciaDTO> create(@Valid @RequestBody LicenciaDTO licenciaDTO) {
        return ResponseEntity.ok(licenciaService.save(licenciaDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar licença", description = "Atualiza uma licença existente")
    @ApiResponse(responseCode = "200", description = "Licença atualizada com sucesso")
    @ApiResponse(responseCode = "404", description = "Licença não encontrada")
    public ResponseEntity<LicenciaDTO> update(@Parameter(description = "ID da licença") @PathVariable Integer id, @Valid @RequestBody LicenciaDTO licenciaDTO) {
        return ResponseEntity.ok(licenciaService.update(id, licenciaDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir licença", description = "Exclui uma licença")
    @ApiResponse(responseCode = "204", description = "Licença excluída com sucesso")
    @ApiResponse(responseCode = "404", description = "Licença não encontrada")
    public ResponseEntity<Void> delete(@Parameter(description = "ID da licença") @PathVariable Integer id) {
        licenciaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
