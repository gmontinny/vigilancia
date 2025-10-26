package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.TabelaDTO;
import br.gov.mt.vigilancia.saude.mapper.TabelaMapper;
import br.gov.mt.vigilancia.saude.repository.TabelaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TabelaService {

    private final TabelaRepository tabelaRepository;
    private final TabelaMapper tabelaMapper;

    public List<TabelaDTO> findAll() {
        return tabelaRepository.findAll()
                .stream()
                .map(tabelaMapper::toDto)
                .collect(Collectors.toList());
    }
}
