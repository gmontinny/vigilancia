package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.FabrilDTO;
import br.gov.mt.vigilancia.saude.service.FabrilService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fabris")
@RequiredArgsConstructor
public class FabrilController {

    private final FabrilService fabrilService;

    @GetMapping
    public ResponseEntity<List<FabrilDTO>> findAll() {
        return ResponseEntity.ok(fabrilService.findAll());
    }
}
