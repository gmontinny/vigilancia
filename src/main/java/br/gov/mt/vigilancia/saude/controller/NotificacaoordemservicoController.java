package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.NotificacaoordemservicoDTO;
import br.gov.mt.vigilancia.saude.service.NotificacaoordemservicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notificacaoordemservicos")
public class NotificacaoordemservicoController {

    @Autowired
    private NotificacaoordemservicoService notificacaoordemservicoService;

    @GetMapping
    public ResponseEntity<List<NotificacaoordemservicoDTO>> getAllNotificacaoordemservicos() {
        return ResponseEntity.ok(notificacaoordemservicoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificacaoordemservicoDTO> getNotificacaoordemservicoById(@PathVariable Integer id) {
        return notificacaoordemservicoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<NotificacaoordemservicoDTO> createNotificacaoordemservico(@RequestBody NotificacaoordemservicoDTO notificacaoordemservicoDTO) {
        return ResponseEntity.ok(notificacaoordemservicoService.save(notificacaoordemservicoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotificacaoordemservicoDTO> updateNotificacaoordemservico(@PathVariable Integer id, @RequestBody NotificacaoordemservicoDTO notificacaoordemservicoDTO) {
        return notificacaoordemservicoService.findById(id)
                .map(existingNotificacaoordemservicoDTO -> {
                    notificacaoordemservicoDTO.setIdnotificacaoordemservico(id);
                    return ResponseEntity.ok(notificacaoordemservicoService.save(notificacaoordemservicoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotificacaoordemservico(@PathVariable Integer id) {
        notificacaoordemservicoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
