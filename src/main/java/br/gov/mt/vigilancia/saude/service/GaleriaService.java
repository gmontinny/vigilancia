package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.GaleriaDTO;
import br.gov.mt.vigilancia.saude.mapper.GaleriaMapper;
import br.gov.mt.vigilancia.saude.repository.GaleriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GaleriaService {

    private final GaleriaRepository galeriaRepository;
    private final GaleriaMapper galeriaMapper;

    public List<GaleriaDTO> findAll() {
        return galeriaRepository.findAll()
                .stream()
                .map(galeriaMapper::toDto)
                .collect(Collectors.toList());
    }
}
