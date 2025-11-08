package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Geratermorevelia;
import br.gov.mt.vigilancia.saude.dto.GeratermoreveliaDTO;
import br.gov.mt.vigilancia.saude.mapper.GeratermoreveliaMapper;
import br.gov.mt.vigilancia.saude.repository.GeratermoreveliaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GeratermoreveliaService {

    @Autowired
    private GeratermoreveliaRepository geratermoreveliaRepository;

    @Autowired
    private GeratermoreveliaMapper geratermoreveliaMapper;

    public List<GeratermoreveliaDTO> findAll() {
        return geratermoreveliaRepository.findAll().stream()
                .map(geratermoreveliaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<GeratermoreveliaDTO> findById(Integer id) {
        return geratermoreveliaRepository.findById(id)
                .map(geratermoreveliaMapper::toDTO);
    }

    public GeratermoreveliaDTO save(GeratermoreveliaDTO geratermoreveliaDTO) {
        Geratermorevelia geratermorevelia = geratermoreveliaMapper.toEntity(geratermoreveliaDTO);
        geratermorevelia = geratermoreveliaRepository.save(geratermorevelia);
        return geratermoreveliaMapper.toDTO(geratermorevelia);
    }

    public void deleteById(Integer id) {
        geratermoreveliaRepository.deleteById(id);
    }
}
