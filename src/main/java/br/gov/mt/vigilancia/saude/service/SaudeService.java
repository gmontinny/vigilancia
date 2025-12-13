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

    public SaudeDTO findById(Integer id) {
        return saudeRepository.findById(id)
                .map(saudeMapper::toDto)
                .orElse(null);
    }

    public SaudeDTO save(SaudeDTO saudeDTO) {
        var entity = saudeMapper.toEntity(saudeDTO);
        var saved = saudeRepository.save(entity);
        return saudeMapper.toDto(saved);
    }

    public SaudeDTO update(Integer id, SaudeDTO saudeDTO) {
        return saudeRepository.findById(id)
                .map(existing -> {
                    var entity = saudeMapper.toEntity(saudeDTO);
                    return saudeMapper.toDto(saudeRepository.save(entity));
                })
                .orElse(null);
    }

    public void delete(Integer id) {
        saudeRepository.deleteById(id);
    }
}
