package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.NotificacaorecursoDTO;
import br.gov.mt.vigilancia.saude.service.NotificacaorecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notificacaorecursos")
public class NotificacaorecursoController {

    @Autowired
    private NotificacaorecursoService notificacaorecursoService;

    @GetMapping
    public ResponseEntity<List<NotificacaorecursoDTO>> getAllNotificacaorecursos() {
        return ResponseEntity.ok(notificacaorecursoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificacaorecursoDTO> getNotificacaorecursoById(@PathVariable Integer id) {
        return notificacaorecursoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<NotificacaorecursoDTO> createNotificacaorecurso(@RequestBody NotificacaorecursoDTO notificacaorecursoDTO) {
        return ResponseEntity.ok(notificacaorecursoService.save(notificacaorecursoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotificacaorecursoDTO> updateNotificacaorecurso(@PathVariable Integer id, @RequestBody NotificacaorecursoDTO notificacaorecursoDTO) {
        return notificacaorecursoService.findById(id)
                .map(existingNotificacaorecursoDTO -> {
                    notificacaorecursoDTO.setIdnotificacaorecurso(id);
                    return ResponseEntity.ok(notificacaorecursoService.save(notificacaorecursoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotificacaorecurso(@PathVariable Integer id) {
        notificacaorecursoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
