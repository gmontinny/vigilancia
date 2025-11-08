package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Geraroteiro;
import br.gov.mt.vigilancia.saude.dto.GeraroteiroDTO;
import br.gov.mt.vigilancia.saude.mapper.GeraroteiroMapper;
import br.gov.mt.vigilancia.saude.repository.GeraroteiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GeraroteiroService {

    @Autowired
    private GeraroteiroRepository geraroteiroRepository;

    @Autowired
    private GeraroteiroMapper geraroteiroMapper;

    public List<GeraroteiroDTO> findAll() {
        return geraroteiroRepository.findAll().stream()
                .map(geraroteiroMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<GeraroteiroDTO> findById(Integer id) {
        return geraroteiroRepository.findById(id)
                .map(geraroteiroMapper::toDTO);
    }

    public GeraroteiroDTO save(GeraroteiroDTO geraroteiroDTO) {
        Geraroteiro geraroteiro = geraroteiroMapper.toEntity(geraroteiroDTO);
        geraroteiro = geraroteiroRepository.save(geraroteiro);
        return geraroteiroMapper.toDTO(geraroteiro);
    }

    public void deleteById(Integer id) {
        geraroteiroRepository.deleteById(id);
    }
}
