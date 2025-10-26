package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.SintomaDTO;
import br.gov.mt.vigilancia.saude.mapper.SintomaMapper;
import br.gov.mt.vigilancia.saude.repository.SintomaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SintomaService {

    private final SintomaRepository sintomaRepository;
    private final SintomaMapper sintomaMapper;

    public List<SintomaDTO> findAll() {
        return sintomaRepository.findAll()
                .stream()
                .map(sintomaMapper::toDto)
                .collect(Collectors.toList());
    }
}
