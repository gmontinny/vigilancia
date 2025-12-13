package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.FiscalDTO;
import br.gov.mt.vigilancia.saude.service.FiscalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller para gerenciamento de fiscais.
 */
@RestController
@RequestMapping("/fiscais")
@RequiredArgsConstructor
@Tag(name = "Fiscais", description = "Consulta de fiscais")
@SecurityRequirement(name = "bearerAuth")
public class FiscalController {

    private final FiscalService fiscalService;

    @GetMapping
    @Operation(summary = "Listar fiscais", description = "Retorna todos os fiscais cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<FiscalDTO>> findAll() {
        return ResponseEntity.ok(fiscalService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar fiscal por ID", description = "Retorna um fiscal específico pelo ID")
    @ApiResponse(responseCode = "200", description = "Fiscal encontrado")
    @ApiResponse(responseCode = "404", description = "Fiscal não encontrado")
    public ResponseEntity<FiscalDTO> findById(@Parameter(description = "ID do fiscal") @PathVariable Integer id) {
        return ResponseEntity.ok(fiscalService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Criar fiscal", description = "Cria um novo fiscal")
    @ApiResponse(responseCode = "200", description = "Fiscal criado com sucesso")
    public ResponseEntity<FiscalDTO> create(@Valid @RequestBody FiscalDTO fiscalDTO) {
        return ResponseEntity.ok(fiscalService.save(fiscalDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar fiscal", description = "Atualiza um fiscal existente")
    @ApiResponse(responseCode = "200", description = "Fiscal atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Fiscal não encontrado")
    public ResponseEntity<FiscalDTO> update(@Parameter(description = "ID do fiscal") @PathVariable Integer id, @Valid @RequestBody FiscalDTO fiscalDTO) {
        return ResponseEntity.ok(fiscalService.update(id, fiscalDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir fiscal", description = "Exclui um fiscal")
    @ApiResponse(responseCode = "204", description = "Fiscal excluído com sucesso")
    @ApiResponse(responseCode = "404", description = "Fiscal não encontrado")
    public ResponseEntity<Void> delete(@Parameter(description = "ID do fiscal") @PathVariable Integer id) {
        fiscalService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
