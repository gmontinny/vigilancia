package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.ResponsavelTecnicoDTO;
import br.gov.mt.vigilancia.saude.mapper.ResponsavelTecnicoMapper;
import br.gov.mt.vigilancia.saude.repository.ResponsavelTecnicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ResponsavelTecnicoService {

    private final ResponsavelTecnicoRepository responsavelTecnicoRepository;
    private final ResponsavelTecnicoMapper responsavelTecnicoMapper;

    public List<ResponsavelTecnicoDTO> findAll() {
        return responsavelTecnicoRepository.findAll()
                .stream()
                .map(responsavelTecnicoMapper::toDto)
                .collect(Collectors.toList());
    }
}
