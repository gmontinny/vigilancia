package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Geragaleria;
import br.gov.mt.vigilancia.saude.dto.GeragaleriaDTO;
import br.gov.mt.vigilancia.saude.mapper.GeragaleriaMapper;
import br.gov.mt.vigilancia.saude.repository.GeragaleriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GeragaleriaService {

    @Autowired
    private GeragaleriaRepository geragaleriaRepository;

    @Autowired
    private GeragaleriaMapper geragaleriaMapper;

    public List<GeragaleriaDTO> findAll() {
        return geragaleriaRepository.findAll().stream()
                .map(geragaleriaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<GeragaleriaDTO> findById(Integer id) {
        return geragaleriaRepository.findById(id)
                .map(geragaleriaMapper::toDTO);
    }

    public GeragaleriaDTO save(GeragaleriaDTO geragaleriaDTO) {
        Geragaleria geragaleria = geragaleriaMapper.toEntity(geragaleriaDTO);
        geragaleria = geragaleriaRepository.save(geragaleria);
        return geragaleriaMapper.toDTO(geragaleria);
    }

    public void deleteById(Integer id) {
        geragaleriaRepository.deleteById(id);
    }
}
