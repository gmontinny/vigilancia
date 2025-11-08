package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Gestaodocumento;
import br.gov.mt.vigilancia.saude.dto.GestaodocumentoDTO;
import br.gov.mt.vigilancia.saude.mapper.GestaodocumentoMapper;
import br.gov.mt.vigilancia.saude.repository.GestaodocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GestaodocumentoService {

    @Autowired
    private GestaodocumentoRepository gestaodocumentoRepository;

    @Autowired
    private GestaodocumentoMapper gestaodocumentoMapper;

    public List<GestaodocumentoDTO> findAll() {
        return gestaodocumentoRepository.findAll().stream()
                .map(gestaodocumentoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<GestaodocumentoDTO> findById(Integer id) {
        return gestaodocumentoRepository.findById(id)
                .map(gestaodocumentoMapper::toDTO);
    }

    public GestaodocumentoDTO save(GestaodocumentoDTO gestaodocumentoDTO) {
        Gestaodocumento gestaodocumento = gestaodocumentoMapper.toEntity(gestaodocumentoDTO);
        gestaodocumento = gestaodocumentoRepository.save(gestaodocumento);
        return gestaodocumentoMapper.toDTO(gestaodocumento);
    }

    public void deleteById(Integer id) {
        gestaodocumentoRepository.deleteById(id);
    }
}
