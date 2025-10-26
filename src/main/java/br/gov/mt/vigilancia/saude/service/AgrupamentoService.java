package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Agrupamento;
import br.gov.mt.vigilancia.saude.dto.AgrupamentoDTO;
import br.gov.mt.vigilancia.saude.mapper.AgrupamentoMapper;
import br.gov.mt.vigilancia.saude.repository.AgrupamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AgrupamentoService {

    @Autowired
    private AgrupamentoRepository agrupamentoRepository;

    @Autowired
    private AgrupamentoMapper agrupamentoMapper;

    public List<AgrupamentoDTO> findAll() {
        return agrupamentoRepository.findAll().stream()
                .map(agrupamentoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<AgrupamentoDTO> findById(Integer id) {
        return agrupamentoRepository.findById(id)
                .map(agrupamentoMapper::toDTO);
    }

    public AgrupamentoDTO save(AgrupamentoDTO agrupamentoDTO) {
        Agrupamento agrupamento = agrupamentoMapper.toEntity(agrupamentoDTO);
        agrupamento = agrupamentoRepository.save(agrupamento);
        return agrupamentoMapper.toDTO(agrupamento);
    }

    public void deleteById(Integer id) {
        agrupamentoRepository.deleteById(id);
    }
}
