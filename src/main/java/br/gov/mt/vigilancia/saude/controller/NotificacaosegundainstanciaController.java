package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.NotificacaosegundainstanciaDTO;
import br.gov.mt.vigilancia.saude.service.NotificacaosegundainstanciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notificacaosegundainstancias")
public class NotificacaosegundainstanciaController {

    @Autowired
    private NotificacaosegundainstanciaService notificacaosegundainstanciaService;

    @GetMapping
    public ResponseEntity<List<NotificacaosegundainstanciaDTO>> getAllNotificacaosegundainstancias() {
        return ResponseEntity.ok(notificacaosegundainstanciaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificacaosegundainstanciaDTO> getNotificacaosegundainstanciaById(@PathVariable Integer id) {
        return notificacaosegundainstanciaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<NotificacaosegundainstanciaDTO> createNotificacaosegundainstancia(@RequestBody NotificacaosegundainstanciaDTO notificacaosegundainstanciaDTO) {
        return ResponseEntity.ok(notificacaosegundainstanciaService.save(notificacaosegundainstanciaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotificacaosegundainstanciaDTO> updateNotificacaosegundainstancia(@PathVariable Integer id, @RequestBody NotificacaosegundainstanciaDTO notificacaosegundainstanciaDTO) {
        return notificacaosegundainstanciaService.findById(id)
                .map(existingNotificacaosegundainstanciaDTO -> {
                    notificacaosegundainstanciaDTO.setIdsegundainstancia(id);
                    return ResponseEntity.ok(notificacaosegundainstanciaService.save(notificacaosegundainstanciaDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotificacaosegundainstancia(@PathVariable Integer id) {
        notificacaosegundainstanciaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
