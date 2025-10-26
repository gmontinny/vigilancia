package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.GrupoDTO;
import br.gov.mt.vigilancia.saude.mapper.GrupoMapper;
import br.gov.mt.vigilancia.saude.repository.GrupoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GrupoService {

    private final GrupoRepository grupoRepository;
    private final GrupoMapper grupoMapper;

    public List<GrupoDTO> findAll() {
        return grupoRepository.findAll()
                .stream()
                .map(grupoMapper::toDto)
                .collect(Collectors.toList());
    }
}
