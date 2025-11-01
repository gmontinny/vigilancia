package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Geraatividade;
import br.gov.mt.vigilancia.saude.dto.GeraatividadeDTO;
import br.gov.mt.vigilancia.saude.mapper.GeraatividadeMapper;
import br.gov.mt.vigilancia.saude.repository.GeraatividadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GeraatividadeService {

    @Autowired
    private GeraatividadeRepository geraatividadeRepository;

    @Autowired
    private GeraatividadeMapper geraatividadeMapper;

    public List<GeraatividadeDTO> findAll() {
        return geraatividadeRepository.findAll().stream()
                .map(geraatividadeMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<GeraatividadeDTO> findById(Integer id) {
        return geraatividadeRepository.findById(id)
                .map(geraatividadeMapper::toDTO);
    }

    public GeraatividadeDTO save(GeraatividadeDTO geraatividadeDTO) {
        Geraatividade geraatividade = geraatividadeMapper.toEntity(geraatividadeDTO);
        geraatividade = geraatividadeRepository.save(geraatividade);
        return geraatividadeMapper.toDTO(geraatividade);
    }

    public void deleteById(Integer id) {
        geraatividadeRepository.deleteById(id);
    }
}
