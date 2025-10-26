package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Arquitetonico;
import br.gov.mt.vigilancia.saude.dto.ArquitetonicoDTO;
import br.gov.mt.vigilancia.saude.mapper.ArquitetonicoMapper;
import br.gov.mt.vigilancia.saude.repository.ArquitetonicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArquitetonicoService {

    @Autowired
    private ArquitetonicoRepository arquitetonicoRepository;

    @Autowired
    private ArquitetonicoMapper arquitetonicoMapper;

    public List<ArquitetonicoDTO> findAll() {
        return arquitetonicoRepository.findAll().stream()
                .map(arquitetonicoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<ArquitetonicoDTO> findById(Integer id) {
        return arquitetonicoRepository.findById(id)
                .map(arquitetonicoMapper::toDTO);
    }

    public ArquitetonicoDTO save(ArquitetonicoDTO arquitetonicoDTO) {
        Arquitetonico arquitetonico = arquitetonicoMapper.toEntity(arquitetonicoDTO);
        arquitetonico = arquitetonicoRepository.save(arquitetonico);
        return arquitetonicoMapper.toDTO(arquitetonico);
    }

    public void deleteById(Integer id) {
        arquitetonicoRepository.deleteById(id);
    }
}
