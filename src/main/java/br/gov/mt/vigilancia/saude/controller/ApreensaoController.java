package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ApreensaoDTO;
import br.gov.mt.vigilancia.saude.service.ApreensaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/apreensoes")
@RequiredArgsConstructor
public class ApreensaoController {

    private final ApreensaoService apreensaoService;

    @GetMapping
    public ResponseEntity<List<ApreensaoDTO>> findAll() {
        return ResponseEntity.ok(apreensaoService.findAll());
    }
}
