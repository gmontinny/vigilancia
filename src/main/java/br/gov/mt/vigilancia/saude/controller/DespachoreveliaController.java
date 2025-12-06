package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.DespachoreveliaDTO;
import br.gov.mt.vigilancia.saude.service.DespachoreveliaService;
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
@RequestMapping("/despachorevelias")
@Tag(name = "Despacho Revelia", description = "Operações CRUD para despachos de revelia")
public class DespachoreveliaController {

    @Autowired
    private DespachoreveliaService despachoreveliaService;

    @GetMapping
    @Operation(summary = "Listar despachos de revelia", description = "Retorna a lista completa de despachos de revelia")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<DespachoreveliaDTO>> getAllDespachorevelias() {
        return ResponseEntity.ok(despachoreveliaService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar despacho por ID", description = "Retorna um despacho de revelia pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<DespachoreveliaDTO> getDespachoreveliaById(@Parameter(description = "ID do despacho", example = "1") @PathVariable Integer id) {
        return despachoreveliaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar despacho", description = "Cria um novo despacho de revelia")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<DespachoreveliaDTO> createDespachorevelia(@Valid @RequestBody DespachoreveliaDTO despachoreveliaDTO) {
        return ResponseEntity.ok(despachoreveliaService.save(despachoreveliaDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar despacho", description = "Atualiza um despacho de revelia existente")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<DespachoreveliaDTO> updateDespachorevelia(@Parameter(description = "ID do despacho", example = "1") @PathVariable Integer id, @Valid @RequestBody DespachoreveliaDTO despachoreveliaDTO) {
        return despachoreveliaService.findById(id)
                .map(existingDespachoreveliaDTO -> {
                    despachoreveliaDTO.setIddespachorevelia(id);
                    return ResponseEntity.ok(despachoreveliaService.save(despachoreveliaDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir despacho", description = "Remove um despacho de revelia pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteDespachorevelia(@Parameter(description = "ID do despacho", example = "1") @PathVariable Integer id) {
        despachoreveliaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
