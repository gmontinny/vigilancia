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
}
