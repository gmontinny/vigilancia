package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.NotificacaoDTO;
import br.gov.mt.vigilancia.saude.service.NotificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notificacoes")
public class NotificacaoController {

    @Autowired
    private NotificacaoService notificacaoService;

    @GetMapping
    public ResponseEntity<List<NotificacaoDTO>> getAllNotificacoes() {
        return ResponseEntity.ok(notificacaoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificacaoDTO> getNotificacaoById(@PathVariable Integer id) {
        return notificacaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<NotificacaoDTO> createNotificacao(@RequestBody NotificacaoDTO notificacaoDTO) {
        return ResponseEntity.ok(notificacaoService.save(notificacaoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotificacaoDTO> updateNotificacao(@PathVariable Integer id, @RequestBody NotificacaoDTO notificacaoDTO) {
        return notificacaoService.findById(id)
                .map(existingNotificacaoDTO -> {
                    notificacaoDTO.setIdnotificacao(id);
                    return ResponseEntity.ok(notificacaoService.save(notificacaoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotificacao(@PathVariable Integer id) {
        notificacaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
