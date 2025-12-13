package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.UploadrestricaoDTO;
import br.gov.mt.vigilancia.saude.service.UploadrestricaoService;
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
@RequestMapping("/uploadrestricoes")
@Tag(name = "Upload Restrição", description = "Operações CRUD para uploads de restrições")
public class UploadrestricaoController {

    @Autowired
    private UploadrestricaoService uploadrestricaoService;

    @GetMapping
    @Operation(summary = "Listar uploads de restrições", description = "Retorna a lista completa de uploads de restrições")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<UploadrestricaoDTO>> getAllUploadrestricoes() {
        return ResponseEntity.ok(uploadrestricaoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar upload por ID", description = "Retorna um upload de restrição pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<UploadrestricaoDTO> getUploadrestricaoById(@Parameter(description = "ID do upload", example = "1") @PathVariable Integer id) {
        return uploadrestricaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar upload de restrição", description = "Cria um novo upload de restrição")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<UploadrestricaoDTO> createUploadrestricao(@Valid @RequestBody UploadrestricaoDTO uploadrestricaoDTO) {
        return ResponseEntity.ok(uploadrestricaoService.save(uploadrestricaoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar upload de restrição", description = "Atualiza um upload de restrição existente")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<UploadrestricaoDTO> updateUploadrestricao(@Parameter(description = "ID do upload", example = "1") @PathVariable Integer id, @Valid @RequestBody UploadrestricaoDTO uploadrestricaoDTO) {
        return uploadrestricaoService.findById(id)
                .map(existingUploadrestricaoDTO -> {
                    uploadrestricaoDTO.setIduploadrestricao(id);
                    return ResponseEntity.ok(uploadrestricaoService.save(uploadrestricaoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir upload de restrição", description = "Remove um upload de restrição pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteUploadrestricao(@Parameter(description = "ID do upload", example = "1") @PathVariable Integer id) {
        uploadrestricaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}