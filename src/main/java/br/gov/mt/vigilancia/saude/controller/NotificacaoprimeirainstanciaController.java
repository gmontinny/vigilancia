package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.NotificacaoprimeirainstanciaDTO;
import br.gov.mt.vigilancia.saude.service.NotificacaoprimeirainstanciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notificacaoprimeirainstancias")
public class NotificacaoprimeirainstanciaController {

    @Autowired
    private NotificacaoprimeirainstanciaService notificacaoprimeirainstanciaService;

    @GetMapping
    public ResponseEntity<List<NotificacaoprimeirainstanciaDTO>> getAllNotificacaoprimeirainstancias() {
        return ResponseEntity.ok(notificacaoprimeirainstanciaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificacaoprimeirainstanciaDTO> getNotificacaoprimeirainstanciaById(@PathVariable Integer id) {
        return notificacaoprimeirainstanciaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<NotificacaoprimeirainstanciaDTO> createNotificacaoprimeirainstancia(@RequestBody NotificacaoprimeirainstanciaDTO notificacaoprimeirainstanciaDTO) {
        return ResponseEntity.ok(notificacaoprimeirainstanciaService.save(notificacaoprimeirainstanciaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotificacaoprimeirainstanciaDTO> updateNotificacaoprimeirainstancia(@PathVariable Integer id, @RequestBody NotificacaoprimeirainstanciaDTO notificacaoprimeirainstanciaDTO) {
        return notificacaoprimeirainstanciaService.findById(id)
                .map(existingNotificacaoprimeirainstanciaDTO -> {
                    notificacaoprimeirainstanciaDTO.setIdprimeirainstancia(id);
                    return ResponseEntity.ok(notificacaoprimeirainstanciaService.save(notificacaoprimeirainstanciaDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotificacaoprimeirainstancia(@PathVariable Integer id) {
        notificacaoprimeirainstanciaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
