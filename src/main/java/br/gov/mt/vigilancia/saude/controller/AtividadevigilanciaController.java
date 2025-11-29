package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.AtividadevigilanciaDTO;
import br.gov.mt.vigilancia.saude.service.AtividadevigilanciaService;
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
 * Controller para gerenciamento de atividades de vigilância sanitária.
 */
@RestController
@RequestMapping("/atividadevigilancias")
@Tag(name = "Atividades de Vigilância", description = "Gerenciamento de atividades de vigilância sanitária")
@SecurityRequirement(name = "bearerAuth")
public class AtividadevigilanciaController {

    @Autowired
    private AtividadevigilanciaService atividadevigilanciaService;

    @GetMapping
    @Operation(summary = "Listar atividades de vigilância", description = "Retorna todas as atividades de vigilância")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<AtividadevigilanciaDTO>> getAllAtividadevigilancias() {
        return ResponseEntity.ok(atividadevigilanciaService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar atividade por ID", description = "Retorna uma atividade de vigilância específica")
    @ApiResponse(responseCode = "200", description = "Atividade encontrada")
    @ApiResponse(responseCode = "404", description = "Atividade não encontrada")
    public ResponseEntity<AtividadevigilanciaDTO> getAtividadevigilanciaById(
        @Parameter(description = "ID da atividade") @PathVariable Integer id) {
        return atividadevigilanciaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar atividade de vigilância", description = "Cria uma nova atividade de vigilância")
    @ApiResponse(responseCode = "200", description = "Atividade criada com sucesso")
    public ResponseEntity<AtividadevigilanciaDTO> createAtividadevigilancia(@RequestBody @Valid AtividadevigilanciaDTO atividadevigilanciaDTO) {
        return ResponseEntity.ok(atividadevigilanciaService.save(atividadevigilanciaDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar atividade", description = "Atualiza uma atividade de vigilância existente")
    @ApiResponse(responseCode = "200", description = "Atividade atualizada com sucesso")
    @ApiResponse(responseCode = "404", description = "Atividade não encontrada")
    public ResponseEntity<AtividadevigilanciaDTO> updateAtividadevigilancia(
        @Parameter(description = "ID da atividade") @PathVariable Integer id, 
        @RequestBody @Valid AtividadevigilanciaDTO atividadevigilanciaDTO) {
        return atividadevigilanciaService.findById(id)
                .map(existingAtividadevigilanciaDTO -> {
                    atividadevigilanciaDTO.setIdatividade(id);
                    return ResponseEntity.ok(atividadevigilanciaService.save(atividadevigilanciaDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover atividade", description = "Remove uma atividade de vigilância do sistema")
    @ApiResponse(responseCode = "204", description = "Atividade removida com sucesso")
    public ResponseEntity<Void> deleteAtividadevigilancia(
        @Parameter(description = "ID da atividade") @PathVariable Integer id) {
        atividadevigilanciaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
