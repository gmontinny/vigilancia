package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.ConselhoDTO;
import br.gov.mt.vigilancia.saude.mapper.ConselhoMapper;
import br.gov.mt.vigilancia.saude.repository.ConselhoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ConselhoService {

    private final ConselhoRepository conselhoRepository;
    private final ConselhoMapper conselhoMapper;

    public List<ConselhoDTO> findAll() {
        return conselhoRepository.findAll()
                .stream()
                .map(conselhoMapper::toDto)
                .collect(Collectors.toList());
    }

    public java.util.Optional<ConselhoDTO> findById(Integer id) {
        return conselhoRepository.findById(id)
                .map(conselhoMapper::toDto);
    }

    public ConselhoDTO save(ConselhoDTO conselhoDTO) {
        var entity = conselhoMapper.toEntity(conselhoDTO);
        var saved = conselhoRepository.save(entity);
        return conselhoMapper.toDto(saved);
    }

    public void deleteById(Integer id) {
        conselhoRepository.deleteById(id);
    }
}
