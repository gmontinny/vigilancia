package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.TimelineadmDTO;
import br.gov.mt.vigilancia.saude.service.TimelineadmService;
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
@RequestMapping("/timelineadms")
@Tag(name = "Timeline Administrativo", description = "Operações CRUD para timeline administrativo")
public class TimelineadmController {

    @Autowired
    private TimelineadmService timelineadmService;

    @GetMapping
    @Operation(summary = "Listar timeline administrativo", description = "Retorna a lista completa de timeline administrativo")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<TimelineadmDTO>> getAllTimelineadms() {
        return ResponseEntity.ok(timelineadmService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar timeline por ID", description = "Retorna um timeline administrativo pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<TimelineadmDTO> getTimelineadmById(@Parameter(description = "ID do timeline", example = "1") @PathVariable Integer id) {
        return timelineadmService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar timeline administrativo", description = "Cria um novo timeline administrativo")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<TimelineadmDTO> createTimelineadm(@Valid @RequestBody TimelineadmDTO timelineadmDTO) {
        return ResponseEntity.ok(timelineadmService.save(timelineadmDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar timeline administrativo", description = "Atualiza um timeline administrativo existente")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<TimelineadmDTO> updateTimelineadm(@Parameter(description = "ID do timeline", example = "1") @PathVariable Integer id, @Valid @RequestBody TimelineadmDTO timelineadmDTO) {
        return timelineadmService.findById(id)
                .map(existingTimelineadmDTO -> {
                    timelineadmDTO.setIdtimelineadm(id);
                    return ResponseEntity.ok(timelineadmService.save(timelineadmDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir timeline administrativo", description = "Remove um timeline administrativo pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteTimelineadm(@Parameter(description = "ID do timeline", example = "1") @PathVariable Integer id) {
        timelineadmService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}