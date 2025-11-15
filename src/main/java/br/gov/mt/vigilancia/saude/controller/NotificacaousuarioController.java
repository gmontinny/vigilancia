package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.NotificacaousuarioDTO;
import br.gov.mt.vigilancia.saude.service.NotificacaousuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notificacaousuarios")
public class NotificacaousuarioController {

    @Autowired
    private NotificacaousuarioService notificacaousuarioService;

    @GetMapping
    public ResponseEntity<List<NotificacaousuarioDTO>> getAllNotificacaousuarios() {
        return ResponseEntity.ok(notificacaousuarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificacaousuarioDTO> getNotificacaousuarioById(@PathVariable Integer id) {
        return notificacaousuarioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<NotificacaousuarioDTO> createNotificacaousuario(@RequestBody NotificacaousuarioDTO notificacaousuarioDTO) {
        return ResponseEntity.ok(notificacaousuarioService.save(notificacaousuarioDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotificacaousuarioDTO> updateNotificacaousuario(@PathVariable Integer id, @RequestBody NotificacaousuarioDTO notificacaousuarioDTO) {
        return notificacaousuarioService.findById(id)
                .map(existingNotificacaousuarioDTO -> {
                    notificacaousuarioDTO.setIdnotificacaousuario(id);
                    return ResponseEntity.ok(notificacaousuarioService.save(notificacaousuarioDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotificacaousuario(@PathVariable Integer id) {
        notificacaousuarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
