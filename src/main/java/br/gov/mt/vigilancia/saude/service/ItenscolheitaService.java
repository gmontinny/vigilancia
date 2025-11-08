package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Itenscolheita;
import br.gov.mt.vigilancia.saude.dto.ItenscolheitaDTO;
import br.gov.mt.vigilancia.saude.mapper.ItenscolheitaMapper;
import br.gov.mt.vigilancia.saude.repository.ItenscolheitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItenscolheitaService {

    @Autowired
    private ItenscolheitaRepository itenscolheitaRepository;

    @Autowired
    private ItenscolheitaMapper itenscolheitaMapper;

    public List<ItenscolheitaDTO> findAll() {
        return itenscolheitaRepository.findAll().stream()
                .map(itenscolheitaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<ItenscolheitaDTO> findById(Integer id) {
        return itenscolheitaRepository.findById(id)
                .map(itenscolheitaMapper::toDTO);
    }

    public ItenscolheitaDTO save(ItenscolheitaDTO itenscolheitaDTO) {
        Itenscolheita itenscolheita = itenscolheitaMapper.toEntity(itenscolheitaDTO);
        itenscolheita = itenscolheitaRepository.save(itenscolheita);
        return itenscolheitaMapper.toDTO(itenscolheita);
    }

    public void deleteById(Integer id) {
        itenscolheitaRepository.deleteById(id);
    }
}
