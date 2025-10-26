package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.TimelineDTO;
import br.gov.mt.vigilancia.saude.mapper.TimelineMapper;
import br.gov.mt.vigilancia.saude.repository.TimelineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TimelineService {

    private final TimelineRepository timelineRepository;
    private final TimelineMapper timelineMapper;

    public List<TimelineDTO> findAll() {
        return timelineRepository.findAll()
                .stream()
                .map(timelineMapper::toDto)
                .collect(Collectors.toList());
    }
}
