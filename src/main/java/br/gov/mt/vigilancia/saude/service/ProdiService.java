package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.ProdiDTO;
import br.gov.mt.vigilancia.saude.mapper.ProdiMapper;
import br.gov.mt.vigilancia.saude.repository.ProdiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProdiService {

    private final ProdiRepository prodiRepository;
    private final ProdiMapper prodiMapper;

    public List<ProdiDTO> findAll() {
        return prodiRepository.findAll()
                .stream()
                .map(prodiMapper::toDto)
                .collect(Collectors.toList());
    }
}
