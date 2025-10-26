package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.GeraprodiDTO;
import br.gov.mt.vigilancia.saude.service.GeraprodiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/geraprodis")
public class GeraprodiController {

    @Autowired
    private GeraprodiService geraprodiService;

    @GetMapping
    public List<GeraprodiDTO> getAllGeraprodis() {
        return geraprodiService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeraprodiDTO> getGeraprodiById(@PathVariable Integer id) {
        return geraprodiService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public GeraprodiDTO createGeraprodi(@RequestBody GeraprodiDTO geraprodiDTO) {
        return geraprodiService.save(geraprodiDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeraprodiDTO> updateGeraprodi(@PathVariable Integer id, @RequestBody GeraprodiDTO geraprodiDTO) {
        return geraprodiService.findById(id)
                .map(existingGeraprodi -> {
                    geraprodiDTO.setIdGeraprodi(id);
                    return ResponseEntity.ok(geraprodiService.save(geraprodiDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGeraprodi(@PathVariable Integer id) {
        if (geraprodiService.findById(id).isPresent()) {
            geraprodiService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
