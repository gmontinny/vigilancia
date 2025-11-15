package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.NotificacaorecursoadministrativoDTO;
import br.gov.mt.vigilancia.saude.service.NotificacaorecursoadministrativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notificacaorecursoadministrativos")
public class NotificacaorecursoadministrativoController {

    @Autowired
    private NotificacaorecursoadministrativoService notificacaorecursoadministrativoService;

    @GetMapping
    public ResponseEntity<List<NotificacaorecursoadministrativoDTO>> getAllNotificacaorecursoadministrativos() {
        return ResponseEntity.ok(notificacaorecursoadministrativoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificacaorecursoadministrativoDTO> getNotificacaorecursoadministrativoById(@PathVariable Integer id) {
        return notificacaorecursoadministrativoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<NotificacaorecursoadministrativoDTO> createNotificacaorecursoadministrativo(@RequestBody NotificacaorecursoadministrativoDTO notificacaorecursoadministrativoDTO) {
        return ResponseEntity.ok(notificacaorecursoadministrativoService.save(notificacaorecursoadministrativoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotificacaorecursoadministrativoDTO> updateNotificacaorecursoadministrativo(@PathVariable Integer id, @RequestBody NotificacaorecursoadministrativoDTO notificacaorecursoadministrativoDTO) {
        return notificacaorecursoadministrativoService.findById(id)
                .map(existingNotificacaorecursoadministrativoDTO -> {
                    notificacaorecursoadministrativoDTO.setIdrecursoadministrativo(id);
                    return ResponseEntity.ok(notificacaorecursoadministrativoService.save(notificacaorecursoadministrativoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotificacaorecursoadministrativo(@PathVariable Integer id) {
        notificacaorecursoadministrativoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
