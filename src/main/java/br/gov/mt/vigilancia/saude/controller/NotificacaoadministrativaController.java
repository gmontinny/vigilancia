package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.NotificacaoadministrativaDTO;
import br.gov.mt.vigilancia.saude.service.NotificacaoadministrativaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notificacaoadministrativas")
public class NotificacaoadministrativaController {

    @Autowired
    private NotificacaoadministrativaService notificacaoadministrativaService;

    @GetMapping
    public ResponseEntity<List<NotificacaoadministrativaDTO>> getAllNotificacaoadministrativas() {
        return ResponseEntity.ok(notificacaoadministrativaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificacaoadministrativaDTO> getNotificacaoadministrativaById(@PathVariable Integer id) {
        return notificacaoadministrativaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<NotificacaoadministrativaDTO> createNotificacaoadministrativa(@RequestBody NotificacaoadministrativaDTO notificacaoadministrativaDTO) {
        return ResponseEntity.ok(notificacaoadministrativaService.save(notificacaoadministrativaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotificacaoadministrativaDTO> updateNotificacaoadministrativa(@PathVariable Integer id, @RequestBody NotificacaoadministrativaDTO notificacaoadministrativaDTO) {
        return notificacaoadministrativaService.findById(id)
                .map(existingNotificacaoadministrativaDTO -> {
                    notificacaoadministrativaDTO.setIdnotificacaoadministrativa(id);
                    return ResponseEntity.ok(notificacaoadministrativaService.save(notificacaoadministrativaDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotificacaoadministrativa(@PathVariable Integer id) {
        notificacaoadministrativaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
