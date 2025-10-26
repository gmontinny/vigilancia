package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.AlvaraDTO;
import br.gov.mt.vigilancia.saude.mapper.AlvaraMapper;
import br.gov.mt.vigilancia.saude.repository.AlvaraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlvaraService {

    private final AlvaraRepository alvaraRepository;
    private final AlvaraMapper alvaraMapper;

    public List<AlvaraDTO> findAll() {
        return alvaraRepository.findAll()
                .stream()
                .map(alvaraMapper::toDto)
                .collect(Collectors.toList());
    }
}
