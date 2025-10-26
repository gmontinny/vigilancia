package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.AcaoDTO;
import br.gov.mt.vigilancia.saude.mapper.AcaoMapper;
import br.gov.mt.vigilancia.saude.repository.AcaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AcaoService {

    private final AcaoRepository acaoRepository;
    private final AcaoMapper acaoMapper;

    public List<AcaoDTO> findAll() {
        return acaoRepository.findAll()
                .stream()
                .map(acaoMapper::toDto)
                .collect(Collectors.toList());
    }
}
