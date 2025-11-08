package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Termocolheita;
import br.gov.mt.vigilancia.saude.dto.TermocolheitaDTO;
import br.gov.mt.vigilancia.saude.mapper.TermocolheitaMapper;
import br.gov.mt.vigilancia.saude.repository.TermocolheitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TermocolheitaService {

    @Autowired
    private TermocolheitaRepository termocolheitaRepository;

    @Autowired
    private TermocolheitaMapper termocolheitaMapper;

    public List<TermocolheitaDTO> findAll() {
        return termocolheitaRepository.findAll().stream()
                .map(termocolheitaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<TermocolheitaDTO> findById(Integer id) {
        return termocolheitaRepository.findById(id)
                .map(termocolheitaMapper::toDTO);
    }

    public TermocolheitaDTO save(TermocolheitaDTO termocolheitaDTO) {
        Termocolheita termocolheita = termocolheitaMapper.toEntity(termocolheitaDTO);
        termocolheita = termocolheitaRepository.save(termocolheita);
        return termocolheitaMapper.toDTO(termocolheita);
    }

    public void deleteById(Integer id) {
        termocolheitaRepository.deleteById(id);
    }
}
