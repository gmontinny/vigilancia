package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.BpaDTO;
import br.gov.mt.vigilancia.saude.mapper.BpaMapper;
import br.gov.mt.vigilancia.saude.repository.BpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BpaService {

    private final BpaRepository bpaRepository;
    private final BpaMapper bpaMapper;

    public List<BpaDTO> findAll() {
        return bpaRepository.findAll()
                .stream()
                .map(bpaMapper::toDto)
                .collect(Collectors.toList());
    }
}
