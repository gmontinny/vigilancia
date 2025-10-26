package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.LicenciaDTO;
import br.gov.mt.vigilancia.saude.mapper.LicenciaMapper;
import br.gov.mt.vigilancia.saude.repository.LicenciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LicenciaService {

    private final LicenciaRepository licenciaRepository;
    private final LicenciaMapper licenciaMapper;

    public List<LicenciaDTO> findAll() {
        return licenciaRepository.findAll()
                .stream()
                .map(licenciaMapper::toDto)
                .collect(Collectors.toList());
    }
}
