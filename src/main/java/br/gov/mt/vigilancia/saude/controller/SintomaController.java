package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.SintomaDTO;
import br.gov.mt.vigilancia.saude.service.SintomaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sintomas")
@RequiredArgsConstructor
public class SintomaController {

    private final SintomaService sintomaService;

    @GetMapping
    public ResponseEntity<List<SintomaDTO>> findAll() {
        return ResponseEntity.ok(sintomaService.findAll());
    }
}
