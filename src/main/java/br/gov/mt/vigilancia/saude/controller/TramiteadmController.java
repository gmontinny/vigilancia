package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.TramiteadmDTO;
import br.gov.mt.vigilancia.saude.service.TramiteadmService;
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
@RequestMapping("/tramiteadms")
@Tag(name = "Trâmite Administrativo", description = "Operações CRUD para trâmites administrativos")
public class TramiteadmController {

    @Autowired
    private TramiteadmService tramiteadmService;

    @GetMapping
    @Operation(summary = "Listar trâmites administrativos", description = "Retorna a lista completa de trâmites administrativos")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<TramiteadmDTO>> getAllTramiteadms() {
        return ResponseEntity.ok(tramiteadmService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar trâmite por ID", description = "Retorna um trâmite administrativo pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<TramiteadmDTO> getTramiteadmById(@Parameter(description = "ID do trâmite", example = "1") @PathVariable Integer id) {
        return tramiteadmService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar trâmite administrativo", description = "Cria um novo trâmite administrativo")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<TramiteadmDTO> createTramiteadm(@Valid @RequestBody TramiteadmDTO tramiteadmDTO) {
        return ResponseEntity.ok(tramiteadmService.save(tramiteadmDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar trâmite administrativo", description = "Atualiza um trâmite administrativo existente")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<TramiteadmDTO> updateTramiteadm(@Parameter(description = "ID do trâmite", example = "1") @PathVariable Integer id, @Valid @RequestBody TramiteadmDTO tramiteadmDTO) {
        return tramiteadmService.findById(id)
                .map(existingTramiteadmDTO -> {
                    tramiteadmDTO.setIdtramiteadm(id);
                    return ResponseEntity.ok(tramiteadmService.save(tramiteadmDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir trâmite administrativo", description = "Remove um trâmite administrativo pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteTramiteadm(@Parameter(description = "ID do trâmite", example = "1") @PathVariable Integer id) {
        tramiteadmService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}