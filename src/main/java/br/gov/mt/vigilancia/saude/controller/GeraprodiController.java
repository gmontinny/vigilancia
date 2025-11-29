package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.GeraprodiDTO;
import br.gov.mt.vigilancia.saude.service.GeraprodiService;
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
 * Controller para gerenciamento de geraprodis (sistema legado).
 */
@RestController
@RequestMapping("/geraprodis")
@Tag(name = "Geraprodis", description = "Gerenciamento de geraprodis do sistema legado")
@SecurityRequirement(name = "bearerAuth")
public class GeraprodiController {

    @Autowired
    private GeraprodiService geraprodiService;

    @GetMapping
    @Operation(summary = "Listar geraprodis", description = "Retorna todos os geraprodis cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<GeraprodiDTO>> getAllGeraprodis() {
        return ResponseEntity.ok(geraprodiService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar geraprodi por ID", description = "Retorna um geraprodi específico")
    @ApiResponse(responseCode = "200", description = "Geraprodi encontrado")
    @ApiResponse(responseCode = "404", description = "Geraprodi não encontrado")
    public ResponseEntity<GeraprodiDTO> getGeraprodiById(
        @Parameter(description = "ID do geraprodi") @PathVariable Integer id) {
        return geraprodiService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar geraprodi", description = "Cria um novo geraprodi")
    @ApiResponse(responseCode = "200", description = "Geraprodi criado com sucesso")
    public ResponseEntity<GeraprodiDTO> createGeraprodi(@RequestBody @Valid GeraprodiDTO geraprodiDTO) {
        return ResponseEntity.ok(geraprodiService.save(geraprodiDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar geraprodi", description = "Atualiza um geraprodi existente")
    @ApiResponse(responseCode = "200", description = "Geraprodi atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Geraprodi não encontrado")
    public ResponseEntity<GeraprodiDTO> updateGeraprodi(
        @Parameter(description = "ID do geraprodi") @PathVariable Integer id, 
        @RequestBody @Valid GeraprodiDTO geraprodiDTO) {
        return geraprodiService.findById(id)
                .map(existingGeraprodi -> {
                    geraprodiDTO.setIdGeraprodi(id);
                    return ResponseEntity.ok(geraprodiService.save(geraprodiDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover geraprodi", description = "Remove um geraprodi do sistema")
    @ApiResponse(responseCode = "204", description = "Geraprodi removido com sucesso")
    @ApiResponse(responseCode = "404", description = "Geraprodi não encontrado")
    public ResponseEntity<Void> deleteGeraprodi(
        @Parameter(description = "ID do geraprodi") @PathVariable Integer id) {
        if (geraprodiService.findById(id).isPresent()) {
            geraprodiService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
