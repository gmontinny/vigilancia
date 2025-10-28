package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.CarteirinhaDTO;
import br.gov.mt.vigilancia.saude.service.CarteirinhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carteirinhas")
public class CarteirinhaController {

    @Autowired
    private CarteirinhaService carteirinhaService;

    @GetMapping
    public ResponseEntity<List<CarteirinhaDTO>> getAllCarteirinhas() {
        return ResponseEntity.ok(carteirinhaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarteirinhaDTO> getCarteirinhaById(@PathVariable Integer id) {
        return carteirinhaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CarteirinhaDTO> createCarteirinha(@RequestBody CarteirinhaDTO carteirinhaDTO) {
        return ResponseEntity.ok(carteirinhaService.save(carteirinhaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarteirinhaDTO> updateCarteirinha(@PathVariable Integer id, @RequestBody CarteirinhaDTO carteirinhaDTO) {
        return carteirinhaService.findById(id)
                .map(existingCarteirinhaDTO -> {
                    carteirinhaDTO.setIdcarteirinha(id);
                    return ResponseEntity.ok(carteirinhaService.save(carteirinhaDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarteirinha(@PathVariable Integer id) {
        carteirinhaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
