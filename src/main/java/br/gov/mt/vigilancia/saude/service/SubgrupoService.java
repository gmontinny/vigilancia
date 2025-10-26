package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.SubgrupoDTO;
import br.gov.mt.vigilancia.saude.mapper.SubgrupoMapper;
import br.gov.mt.vigilancia.saude.repository.SubgrupoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubgrupoService {

    private final SubgrupoRepository subgrupoRepository;
    private final SubgrupoMapper subgrupoMapper;

    public List<SubgrupoDTO> findAll() {
        return subgrupoRepository.findAll()
                .stream()
                .map(subgrupoMapper::toDto)
                .collect(Collectors.toList());
    }
}
