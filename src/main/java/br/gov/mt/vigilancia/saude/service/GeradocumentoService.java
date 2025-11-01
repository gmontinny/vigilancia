package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Geradocumento;
import br.gov.mt.vigilancia.saude.dto.GeradocumentoDTO;
import br.gov.mt.vigilancia.saude.mapper.GeradocumentoMapper;
import br.gov.mt.vigilancia.saude.repository.GeradocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GeradocumentoService {

    @Autowired
    private GeradocumentoRepository geradocumentoRepository;

    @Autowired
    private GeradocumentoMapper geradocumentoMapper;

    public List<GeradocumentoDTO> findAll() {
        return geradocumentoRepository.findAll().stream()
                .map(geradocumentoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<GeradocumentoDTO> findById(Integer id) {
        return geradocumentoRepository.findById(id)
                .map(geradocumentoMapper::toDTO);
    }

    public GeradocumentoDTO save(GeradocumentoDTO geradocumentoDTO) {
        Geradocumento geradocumento = geradocumentoMapper.toEntity(geradocumentoDTO);
        geradocumento = geradocumentoRepository.save(geradocumento);
        return geradocumentoMapper.toDTO(geradocumento);
    }

    public void deleteById(Integer id) {
        geradocumentoRepository.deleteById(id);
    }
}
