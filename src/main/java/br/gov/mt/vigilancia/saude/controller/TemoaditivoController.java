package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.TemoaditivoDTO;
import br.gov.mt.vigilancia.saude.service.TemoaditivoService;
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
@RequestMapping("/temoaditivos")
@Tag(name = "Termo Aditivo", description = "Operações CRUD para termos aditivos")
public class TemoaditivoController {

    @Autowired
    private TemoaditivoService temoaditivoService;

    @GetMapping
    @Operation(summary = "Listar termos aditivos", description = "Retorna a lista completa de termos aditivos")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<TemoaditivoDTO>> getAllTemoaditivos() {
        return ResponseEntity.ok(temoaditivoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar termo por ID", description = "Retorna um termo aditivo pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<TemoaditivoDTO> getTemoaditivoById(@Parameter(description = "ID do termo", example = "1") @PathVariable Integer id) {
        return temoaditivoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar termo aditivo", description = "Cria um novo termo aditivo")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<TemoaditivoDTO> createTemoaditivo(@Valid @RequestBody TemoaditivoDTO temoaditivoDTO) {
        return ResponseEntity.ok(temoaditivoService.save(temoaditivoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar termo aditivo", description = "Atualiza um termo aditivo existente")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<TemoaditivoDTO> updateTemoaditivo(@Parameter(description = "ID do termo", example = "1") @PathVariable Integer id, @Valid @RequestBody TemoaditivoDTO temoaditivoDTO) {
        return temoaditivoService.findById(id)
                .map(existingTemoaditivoDTO -> {
                    temoaditivoDTO.setIdtermoaditivo(id);
                    return ResponseEntity.ok(temoaditivoService.save(temoaditivoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir termo aditivo", description = "Remove um termo aditivo pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteTemoaditivo(@Parameter(description = "ID do termo", example = "1") @PathVariable Integer id) {
        temoaditivoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}