package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.DespachoinstanciaDTO;
import br.gov.mt.vigilancia.saude.service.DespachoinstanciaService;
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
@RequestMapping("/despachoinstancias")
@Tag(name = "Despacho Instância", description = "Operações CRUD para despachos de instância")
public class DespachoinstanciaController {

    @Autowired
    private DespachoinstanciaService despachoinstanciaService;

    @GetMapping
    @Operation(summary = "Listar despachos de instância", description = "Retorna a lista completa de despachos de instância")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<DespachoinstanciaDTO>> getAllDespachoinstancias() {
        return ResponseEntity.ok(despachoinstanciaService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar despacho por ID", description = "Retorna um despacho de instância pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<DespachoinstanciaDTO> getDespachoinstanciaById(@Parameter(description = "ID do despacho", example = "1") @PathVariable Integer id) {
        return despachoinstanciaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar despacho", description = "Cria um novo despacho de instância")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<DespachoinstanciaDTO> createDespachoinstancia(@Valid @RequestBody DespachoinstanciaDTO despachoinstanciaDTO) {
        return ResponseEntity.ok(despachoinstanciaService.save(despachoinstanciaDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar despacho", description = "Atualiza um despacho de instância existente")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<DespachoinstanciaDTO> updateDespachoinstancia(@Parameter(description = "ID do despacho", example = "1") @PathVariable Integer id, @Valid @RequestBody DespachoinstanciaDTO despachoinstanciaDTO) {
        return despachoinstanciaService.findById(id)
                .map(existingDespachoinstanciaDTO -> {
                    despachoinstanciaDTO.setIddespachoinstancia(id);
                    return ResponseEntity.ok(despachoinstanciaService.save(despachoinstanciaDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir despacho", description = "Remove um despacho de instância pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteDespachoinstancia(@Parameter(description = "ID do despacho", example = "1") @PathVariable Integer id) {
        despachoinstanciaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
