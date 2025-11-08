package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Geratramite;
import br.gov.mt.vigilancia.saude.dto.GeratramiteDTO;
import br.gov.mt.vigilancia.saude.mapper.GeratramiteMapper;
import br.gov.mt.vigilancia.saude.repository.GeratramiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GeratramiteService {

    @Autowired
    private GeratramiteRepository geratramiteRepository;

    @Autowired
    private GeratramiteMapper geratramiteMapper;

    public List<GeratramiteDTO> findAll() {
        return geratramiteRepository.findAll().stream()
                .map(geratramiteMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<GeratramiteDTO> findById(Integer id) {
        return geratramiteRepository.findById(id)
                .map(geratramiteMapper::toDTO);
    }

    public GeratramiteDTO save(GeratramiteDTO geratramiteDTO) {
        Geratramite geratramite = geratramiteMapper.toEntity(geratramiteDTO);
        geratramite = geratramiteRepository.save(geratramite);
        return geratramiteMapper.toDTO(geratramite);
    }

    public void deleteById(Integer id) {
        geratramiteRepository.deleteById(id);
    }
}
