package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.BpaDTO;
import br.gov.mt.vigilancia.saude.service.BpaService;
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
 * Controller para consulta de BPAs (Boletim de Produção Ambulatorial).
 */
@RestController
@RequestMapping("/bpas")
@RequiredArgsConstructor
@Tag(name = "BPAs", description = "Consulta de BPAs (Boletim de Produção Ambulatorial)")
@SecurityRequirement(name = "bearerAuth")
public class BpaController {

    private final BpaService bpaService;

    @GetMapping
    @Operation(summary = "Listar BPAs", description = "Retorna todos os BPAs cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<BpaDTO>> findAll() {
        return ResponseEntity.ok(bpaService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar BPA por ID", description = "Retorna um BPA específico pelo ID")
    @ApiResponse(responseCode = "200", description = "BPA encontrado")
    @ApiResponse(responseCode = "404", description = "BPA não encontrado")
    public ResponseEntity<BpaDTO> findById(@Parameter(description = "ID do BPA") @PathVariable Integer id) {
        return ResponseEntity.ok(bpaService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Criar BPA", description = "Cria um novo BPA")
    @ApiResponse(responseCode = "200", description = "BPA criado com sucesso")
    public ResponseEntity<BpaDTO> create(@Valid @RequestBody BpaDTO bpaDTO) {
        return ResponseEntity.ok(bpaService.save(bpaDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar BPA", description = "Atualiza um BPA existente")
    @ApiResponse(responseCode = "200", description = "BPA atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "BPA não encontrado")
    public ResponseEntity<BpaDTO> update(@Parameter(description = "ID do BPA") @PathVariable Integer id, @Valid @RequestBody BpaDTO bpaDTO) {
        return ResponseEntity.ok(bpaService.update(id, bpaDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir BPA", description = "Exclui um BPA")
    @ApiResponse(responseCode = "204", description = "BPA excluído com sucesso")
    @ApiResponse(responseCode = "404", description = "BPA não encontrado")
    public ResponseEntity<Void> delete(@Parameter(description = "ID do BPA") @PathVariable Integer id) {
        bpaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
