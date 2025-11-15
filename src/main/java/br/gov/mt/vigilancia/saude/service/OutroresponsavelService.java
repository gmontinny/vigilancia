package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Outroresponsavel;
import br.gov.mt.vigilancia.saude.dto.OutroresponsavelDTO;
import br.gov.mt.vigilancia.saude.mapper.OutroresponsavelMapper;
import br.gov.mt.vigilancia.saude.repository.OutroresponsavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OutroresponsavelService {

    @Autowired
    private OutroresponsavelRepository outroresponsavelRepository;

    @Autowired
    private OutroresponsavelMapper outroresponsavelMapper;

    public List<OutroresponsavelDTO> findAll() {
        return outroresponsavelRepository.findAll().stream()
                .map(outroresponsavelMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<OutroresponsavelDTO> findById(Integer id) {
        return outroresponsavelRepository.findById(id)
                .map(outroresponsavelMapper::toDTO);
    }

    public OutroresponsavelDTO save(OutroresponsavelDTO outroresponsavelDTO) {
        Outroresponsavel outroresponsavel = outroresponsavelMapper.toEntity(outroresponsavelDTO);
        outroresponsavel = outroresponsavelRepository.save(outroresponsavel);
        return outroresponsavelMapper.toDTO(outroresponsavel);
    }

    public void deleteById(Integer id) {
        outroresponsavelRepository.deleteById(id);
    }
}
