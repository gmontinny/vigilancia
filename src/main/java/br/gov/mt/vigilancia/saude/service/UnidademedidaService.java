package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.UnidademedidaDTO;
import br.gov.mt.vigilancia.saude.mapper.UnidademedidaMapper;
import br.gov.mt.vigilancia.saude.repository.UnidademedidaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UnidademedidaService {

    private final UnidademedidaRepository unidademedidaRepository;
    private final UnidademedidaMapper unidademedidaMapper;

    public List<UnidademedidaDTO> findAll() {
        return unidademedidaRepository.findAll()
                .stream()
                .map(unidademedidaMapper::toDto)
                .collect(Collectors.toList());
    }
}
