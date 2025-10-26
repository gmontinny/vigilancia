package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.VeiculoDTO;
import br.gov.mt.vigilancia.saude.mapper.VeiculoMapper;
import br.gov.mt.vigilancia.saude.repository.VeiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;
    private final VeiculoMapper veiculoMapper;

    public List<VeiculoDTO> findAll() {
        return veiculoRepository.findAll()
                .stream()
                .map(veiculoMapper::toDto)
                .collect(Collectors.toList());
    }
}
