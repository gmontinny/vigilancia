package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ConselhoDTO;
import br.gov.mt.vigilancia.saude.service.ConselhoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller para gerenciamento de conselhos profissionais.
 * Fornece endpoints para consulta de conselhos de classe (CRM, CRF, etc.).
 */
@RestController
@RequestMapping("/conselhos")
@RequiredArgsConstructor
@Tag(name = "Conselhos", description = "Gerenciamento de conselhos profissionais")
@SecurityRequirement(name = "bearerAuth")
public class ConselhoController {

    private final ConselhoService conselhoService;

    @GetMapping
    @Operation(summary = "Listar conselhos profissionais", description = "Retorna a lista de todos os conselhos profissionais cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista de conselhos retornada com sucesso")
    @ApiResponse(responseCode = "401", description = "Não autorizado")
    public ResponseEntity<List<ConselhoDTO>> findAll() {
        return ResponseEntity.ok(conselhoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar conselho por ID", description = "Retorna um conselho profissional pelo seu identificador")
    @ApiResponse(responseCode = "200", description = "Conselho encontrado")
    @ApiResponse(responseCode = "404", description = "Conselho não encontrado")
    public ResponseEntity<ConselhoDTO> findById(@PathVariable Integer id) {
        return conselhoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar conselho", description = "Cria um novo conselho profissional")
    @ApiResponse(responseCode = "200", description = "Conselho criado com sucesso")
    public ResponseEntity<ConselhoDTO> create(@Valid @RequestBody ConselhoDTO conselhoDTO) {
        return ResponseEntity.ok(conselhoService.save(conselhoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar conselho", description = "Atualiza um conselho profissional existente")
    @ApiResponse(responseCode = "200", description = "Conselho atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Conselho não encontrado")
    public ResponseEntity<ConselhoDTO> update(@PathVariable Integer id, @Valid @RequestBody ConselhoDTO conselhoDTO) {
        return conselhoService.findById(id)
                .map(existing -> {
                    conselhoDTO.setId(id);
                    return ResponseEntity.ok(conselhoService.save(conselhoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir conselho", description = "Remove um conselho profissional pelo seu ID")
    @ApiResponse(responseCode = "204", description = "Conselho excluído com sucesso")
    @ApiResponse(responseCode = "404", description = "Conselho não encontrado")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        conselhoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
