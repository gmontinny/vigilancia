package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.RoteiroDTO;
import br.gov.mt.vigilancia.saude.mapper.RoteiroMapper;
import br.gov.mt.vigilancia.saude.repository.RoteiroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoteiroService {

    private final RoteiroRepository roteiroRepository;
    private final RoteiroMapper roteiroMapper;

    public List<RoteiroDTO> findAll() {
        return roteiroRepository.findAll()
                .stream()
                .map(roteiroMapper::toDto)
                .collect(Collectors.toList());
    }
}
