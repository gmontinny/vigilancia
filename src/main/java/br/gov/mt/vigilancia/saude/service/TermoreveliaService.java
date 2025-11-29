package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Termorevelia;
import br.gov.mt.vigilancia.saude.dto.TermoreveliaDTO;
import br.gov.mt.vigilancia.saude.mapper.TermoreveliaMapper;
import br.gov.mt.vigilancia.saude.repository.TermoreveliaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TermoreveliaService {

    @Autowired
    private TermoreveliaRepository termoreveliaRepository;

    @Autowired
    private TermoreveliaMapper termoreveliaMapper;

    public List<TermoreveliaDTO> findAll() {
        return termoreveliaRepository.findAll().stream()
                .map(termoreveliaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<TermoreveliaDTO> findById(Integer id) {
        return termoreveliaRepository.findById(id)
                .map(termoreveliaMapper::toDTO);
    }

    public TermoreveliaDTO save(TermoreveliaDTO termoreveliaDTO) {
        Termorevelia termorevelia = termoreveliaMapper.toEntity(termoreveliaDTO);
        termorevelia = termoreveliaRepository.save(termorevelia);
        return termoreveliaMapper.toDTO(termorevelia);
    }

    public void deleteById(Integer id) {
        termoreveliaRepository.deleteById(id);
    }
}
