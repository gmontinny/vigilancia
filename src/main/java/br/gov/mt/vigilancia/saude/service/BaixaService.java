package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.BaixaDTO;
import br.gov.mt.vigilancia.saude.mapper.BaixaMapper;
import br.gov.mt.vigilancia.saude.repository.BaixaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BaixaService {

    private final BaixaRepository baixaRepository;
    private final BaixaMapper baixaMapper;

    public List<BaixaDTO> findAll() {
        return baixaRepository.findAll()
                .stream()
                .map(baixaMapper::toDto)
                .collect(Collectors.toList());
    }
}
