package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.FiscalDTO;
import br.gov.mt.vigilancia.saude.mapper.FiscalMapper;
import br.gov.mt.vigilancia.saude.repository.FiscalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FiscalService {

    private final FiscalRepository fiscalRepository;
    private final FiscalMapper fiscalMapper;

    public List<FiscalDTO> findAll() {
        return fiscalRepository.findAll()
                .stream()
                .map(fiscalMapper::toDto)
                .collect(Collectors.toList());
    }
}
