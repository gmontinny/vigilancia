package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Farmaceutico;
import br.gov.mt.vigilancia.saude.dto.FarmaceuticoDTO;
import br.gov.mt.vigilancia.saude.mapper.FarmaceuticoMapper;
import br.gov.mt.vigilancia.saude.repository.FarmaceuticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FarmaceuticoService {

    @Autowired
    private FarmaceuticoRepository farmaceuticoRepository;

    @Autowired
    private FarmaceuticoMapper farmaceuticoMapper;

    public List<FarmaceuticoDTO> findAll() {
        return farmaceuticoRepository.findAll().stream()
                .map(farmaceuticoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<FarmaceuticoDTO> findById(Integer id) {
        return farmaceuticoRepository.findById(id)
                .map(farmaceuticoMapper::toDTO);
    }

    public FarmaceuticoDTO save(FarmaceuticoDTO farmaceuticoDTO) {
        Farmaceutico farmaceutico = farmaceuticoMapper.toEntity(farmaceuticoDTO);
        farmaceutico = farmaceuticoRepository.save(farmaceutico);
        return farmaceuticoMapper.toDTO(farmaceutico);
    }

    public void deleteById(Integer id) {
        farmaceuticoRepository.deleteById(id);
    }
}
