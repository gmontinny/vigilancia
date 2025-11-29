package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Timelineadm;
import br.gov.mt.vigilancia.saude.dto.TimelineadmDTO;
import br.gov.mt.vigilancia.saude.mapper.TimelineadmMapper;
import br.gov.mt.vigilancia.saude.repository.TimelineadmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TimelineadmService {

    @Autowired
    private TimelineadmRepository timelineadmRepository;

    @Autowired
    private TimelineadmMapper timelineadmMapper;

    public List<TimelineadmDTO> findAll() {
        return timelineadmRepository.findAll().stream()
                .map(timelineadmMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<TimelineadmDTO> findById(Integer id) {
        return timelineadmRepository.findById(id)
                .map(timelineadmMapper::toDTO);
    }

    public TimelineadmDTO save(TimelineadmDTO timelineadmDTO) {
        Timelineadm timelineadm = timelineadmMapper.toEntity(timelineadmDTO);
        timelineadm = timelineadmRepository.save(timelineadm);
        return timelineadmMapper.toDTO(timelineadm);
    }

    public void deleteById(Integer id) {
        timelineadmRepository.deleteById(id);
    }
}
