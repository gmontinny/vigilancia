package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.EstabelecimentoDTO;
import br.gov.mt.vigilancia.saude.mapper.EstabelecimentoMapper;
import br.gov.mt.vigilancia.saude.repository.EstabelecimentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EstabelecimentoService {

    private final EstabelecimentoRepository estabelecimentoRepository;
    private final EstabelecimentoMapper estabelecimentoMapper;

    public List<EstabelecimentoDTO> findAll() {
        return estabelecimentoRepository.findAll()
                .stream()
                .map(estabelecimentoMapper::toDto)
                .collect(Collectors.toList());
    }
}
