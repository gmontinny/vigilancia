package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.ProcessoDTO;
import br.gov.mt.vigilancia.saude.mapper.ProcessoMapper;
import br.gov.mt.vigilancia.saude.repository.ProcessoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProcessoService {

    private final ProcessoRepository processoRepository;
    private final ProcessoMapper processoMapper;

    public List<ProcessoDTO> findAll() {
        return processoRepository.findAll()
                .stream()
                .map(processoMapper::toDto)
                .collect(Collectors.toList());
    }
}
