package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.UploadnecessarioDTO;
import br.gov.mt.vigilancia.saude.service.UploadnecessarioService;
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
@RequestMapping("/uploadnecessarios")
@Tag(name = "Upload Necessário", description = "Operações CRUD para uploads necessários")
public class UploadnecessarioController {

    @Autowired
    private UploadnecessarioService uploadnecessarioService;

    @GetMapping
    @Operation(summary = "Listar uploads necessários", description = "Retorna a lista completa de uploads necessários")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<UploadnecessarioDTO>> getAllUploadnecessarios() {
        return ResponseEntity.ok(uploadnecessarioService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar upload por ID", description = "Retorna um upload necessário pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<UploadnecessarioDTO> getUploadnecessarioById(@Parameter(description = "ID do upload", example = "1") @PathVariable Integer id) {
        return uploadnecessarioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar upload necessário", description = "Cria um novo upload necessário")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<UploadnecessarioDTO> createUploadnecessario(@Valid @RequestBody UploadnecessarioDTO uploadnecessarioDTO) {
        return ResponseEntity.ok(uploadnecessarioService.save(uploadnecessarioDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar upload necessário", description = "Atualiza um upload necessário existente")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<UploadnecessarioDTO> updateUploadnecessario(@Parameter(description = "ID do upload", example = "1") @PathVariable Integer id, @Valid @RequestBody UploadnecessarioDTO uploadnecessarioDTO) {
        return uploadnecessarioService.findById(id)
                .map(existingUploadnecessarioDTO -> {
                    uploadnecessarioDTO.setIduploadnecessario(id);
                    return ResponseEntity.ok(uploadnecessarioService.save(uploadnecessarioDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir upload necessário", description = "Remove um upload necessário pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteUploadnecessario(@Parameter(description = "ID do upload", example = "1") @PathVariable Integer id) {
        uploadnecessarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}