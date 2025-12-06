package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.DespachoimprocedenciaDTO;
import br.gov.mt.vigilancia.saude.service.DespachoimprocedenciaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
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
@RequestMapping("/despachoimprocedencias")
@Tag(name = "Despacho Improcedência", description = "Operações CRUD para despachos de improcedência")
public class DespachoimprocedenciaController {

    @Autowired
    private DespachoimprocedenciaService despachoimprocedenciaService;

    @GetMapping
    @Operation(summary = "Listar despachos de improcedência", description = "Retorna a lista completa de despachos de improcedência")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<DespachoimprocedenciaDTO>> getAllDespachoimprocedencias() {
        return ResponseEntity.ok(despachoimprocedenciaService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar despacho por ID", description = "Retorna um despacho de improcedência pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<DespachoimprocedenciaDTO> getDespachoimprocedenciaById(@Parameter(description = "ID do despacho", example = "1") @PathVariable Integer id) {
        return despachoimprocedenciaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar despacho", description = "Cria um novo despacho de improcedência")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<DespachoimprocedenciaDTO> createDespachoimprocedencia(@Valid @RequestBody DespachoimprocedenciaDTO despachoimprocedenciaDTO) {
        return ResponseEntity.ok(despachoimprocedenciaService.save(despachoimprocedenciaDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar despacho", description = "Atualiza um despacho de improcedência existente")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<DespachoimprocedenciaDTO> updateDespachoimprocedencia(@Parameter(description = "ID do despacho", example = "1") @PathVariable Integer id, @Valid @RequestBody DespachoimprocedenciaDTO despachoimprocedenciaDTO) {
        return despachoimprocedenciaService.findById(id)
                .map(existingDespachoimprocedenciaDTO -> {
                    despachoimprocedenciaDTO.setIddespachoimprocedencia(id);
                    return ResponseEntity.ok(despachoimprocedenciaService.save(despachoimprocedenciaDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir despacho", description = "Remove um despacho de improcedência pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteDespachoimprocedencia(@Parameter(description = "ID do despacho", example = "1") @PathVariable Integer id) {
        despachoimprocedenciaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
