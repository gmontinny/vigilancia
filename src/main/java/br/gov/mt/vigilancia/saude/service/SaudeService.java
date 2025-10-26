package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.SaudeDTO;
import br.gov.mt.vigilancia.saude.mapper.SaudeMapper;
import br.gov.mt.vigilancia.saude.repository.SaudeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SaudeService {

    private final SaudeRepository saudeRepository;
    private final SaudeMapper saudeMapper;

    public List<SaudeDTO> findAll() {
        return saudeRepository.findAll()
                .stream()
                .map(saudeMapper::toDto)
                .collect(Collectors.toList());
    }
}
