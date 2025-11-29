package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.LicenciamentoDTO;
import br.gov.mt.vigilancia.saude.service.LicenciamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller para gerenciamento de licenciamentos sanitários.
 */
@RestController
@RequestMapping("/licenciamentos")
@Tag(name = "Licenciamentos", description = "Gerenciamento de licenciamentos sanitários")
@SecurityRequirement(name = "bearerAuth")
public class LicenciamentoController {

    @Autowired
    private LicenciamentoService licenciamentoService;

    @GetMapping
    @Operation(summary = "Listar licenciamentos", description = "Retorna todos os licenciamentos cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<LicenciamentoDTO>> getAllLicenciamentos() {
        return ResponseEntity.ok(licenciamentoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar licenciamento por ID", description = "Retorna um licenciamento específico")
    @ApiResponse(responseCode = "200", description = "Licenciamento encontrado")
    @ApiResponse(responseCode = "404", description = "Licenciamento não encontrado")
    public ResponseEntity<LicenciamentoDTO> getLicenciamentoById(
        @Parameter(description = "ID do licenciamento") @PathVariable Integer id) {
        return licenciamentoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar licenciamento", description = "Cria um novo licenciamento")
    @ApiResponse(responseCode = "200", description = "Licenciamento criado com sucesso")
    public ResponseEntity<LicenciamentoDTO> createLicenciamento(@RequestBody @Valid LicenciamentoDTO licenciamentoDTO) {
        return ResponseEntity.ok(licenciamentoService.save(licenciamentoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar licenciamento", description = "Atualiza um licenciamento existente")
    @ApiResponse(responseCode = "200", description = "Licenciamento atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Licenciamento não encontrado")
    public ResponseEntity<LicenciamentoDTO> updateLicenciamento(
        @Parameter(description = "ID do licenciamento") @PathVariable Integer id, 
        @RequestBody @Valid LicenciamentoDTO licenciamentoDTO) {
        return licenciamentoService.findById(id)
                .map(existingLicenciamentoDTO -> {
                    licenciamentoDTO.setIdlicenciamento(id);
                    return ResponseEntity.ok(licenciamentoService.save(licenciamentoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover licenciamento", description = "Remove um licenciamento do sistema")
    @ApiResponse(responseCode = "204", description = "Licenciamento removido com sucesso")
    public ResponseEntity<Void> deleteLicenciamento(
        @Parameter(description = "ID do licenciamento") @PathVariable Integer id) {
        licenciamentoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
