package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.LogDTO;
import br.gov.mt.vigilancia.saude.mapper.LogMapper;
import br.gov.mt.vigilancia.saude.repository.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LogService {

    private final LogRepository logRepository;
    private final LogMapper logMapper;

    public List<LogDTO> findAll() {
        return logRepository.findAll()
                .stream()
                .map(logMapper::toDto)
                .collect(Collectors.toList());
    }
}
