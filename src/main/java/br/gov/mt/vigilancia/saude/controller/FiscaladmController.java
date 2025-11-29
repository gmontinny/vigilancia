package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.FiscaladmDTO;
import br.gov.mt.vigilancia.saude.service.FiscaladmService;
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
 * Controller para gerenciamento de fiscais administrativos.
 */
@RestController
@RequestMapping("/fiscaladms")
@Tag(name = "Fiscais Administrativos", description = "Gerenciamento de fiscais administrativos")
@SecurityRequirement(name = "bearerAuth")
public class FiscaladmController {

    @Autowired
    private FiscaladmService fiscaladmService;

    @GetMapping
    @Operation(summary = "Listar fiscais administrativos", description = "Retorna todos os fiscais administrativos")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<FiscaladmDTO>> getAllFiscaladms() {
        return ResponseEntity.ok(fiscaladmService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar fiscal por ID", description = "Retorna um fiscal administrativo específico")
    @ApiResponse(responseCode = "200", description = "Fiscal encontrado")
    @ApiResponse(responseCode = "404", description = "Fiscal não encontrado")
    public ResponseEntity<FiscaladmDTO> getFiscaladmById(
        @Parameter(description = "ID do fiscal") @PathVariable Integer id) {
        return fiscaladmService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar fiscal administrativo", description = "Cria um novo fiscal administrativo")
    @ApiResponse(responseCode = "200", description = "Fiscal criado com sucesso")
    public ResponseEntity<FiscaladmDTO> createFiscaladm(@RequestBody @Valid FiscaladmDTO fiscaladmDTO) {
        return ResponseEntity.ok(fiscaladmService.save(fiscaladmDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar fiscal", description = "Atualiza um fiscal administrativo existente")
    @ApiResponse(responseCode = "200", description = "Fiscal atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Fiscal não encontrado")
    public ResponseEntity<FiscaladmDTO> updateFiscaladm(
        @Parameter(description = "ID do fiscal") @PathVariable Integer id, 
        @RequestBody @Valid FiscaladmDTO fiscaladmDTO) {
        return fiscaladmService.findById(id)
                .map(existingFiscaladm -> {
                    fiscaladmDTO.setIdFiscaladm(id);
                    return ResponseEntity.ok(fiscaladmService.save(fiscaladmDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover fiscal", description = "Remove um fiscal administrativo do sistema")
    @ApiResponse(responseCode = "204", description = "Fiscal removido com sucesso")
    @ApiResponse(responseCode = "404", description = "Fiscal não encontrado")
    public ResponseEntity<Void> deleteFiscaladm(
        @Parameter(description = "ID do fiscal") @PathVariable Integer id) {
        if (fiscaladmService.findById(id).isPresent()) {
            fiscaladmService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
