package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.TimelineadmDTO;
import br.gov.mt.vigilancia.saude.service.TimelineadmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/timelineadms")
public class TimelineadmController {

    @Autowired
    private TimelineadmService timelineadmService;

    @GetMapping
    public ResponseEntity<List<TimelineadmDTO>> getAllTimelineadms() {
        return ResponseEntity.ok(timelineadmService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimelineadmDTO> getTimelineadmById(@PathVariable Integer id) {
        return timelineadmService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TimelineadmDTO> createTimelineadm(@RequestBody TimelineadmDTO timelineadmDTO) {
        return ResponseEntity.ok(timelineadmService.save(timelineadmDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TimelineadmDTO> updateTimelineadm(@PathVariable Integer id, @RequestBody TimelineadmDTO timelineadmDTO) {
        return timelineadmService.findById(id)
                .map(existingTimelineadmDTO -> {
                    timelineadmDTO.setIdtimelineadm(id);
                    return ResponseEntity.ok(timelineadmService.save(timelineadmDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTimelineadm(@PathVariable Integer id) {
        timelineadmService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
