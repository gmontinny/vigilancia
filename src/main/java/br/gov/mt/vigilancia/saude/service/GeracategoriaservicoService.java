package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Geracategoriaservico;
import br.gov.mt.vigilancia.saude.dto.GeracategoriaservicoDTO;
import br.gov.mt.vigilancia.saude.mapper.GeracategoriaservicoMapper;
import br.gov.mt.vigilancia.saude.repository.GeracategoriaservicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GeracategoriaservicoService {

    @Autowired
    private GeracategoriaservicoRepository geracategoriaservicoRepository;

    @Autowired
    private GeracategoriaservicoMapper geracategoriaservicoMapper;

    public List<GeracategoriaservicoDTO> findAll() {
        return geracategoriaservicoRepository.findAll().stream()
                .map(geracategoriaservicoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<GeracategoriaservicoDTO> findById(Integer id) {
        return geracategoriaservicoRepository.findById(id)
                .map(geracategoriaservicoMapper::toDTO);
    }

    public GeracategoriaservicoDTO save(GeracategoriaservicoDTO geracategoriaservicoDTO) {
        Geracategoriaservico geracategoriaservico = geracategoriaservicoMapper.toEntity(geracategoriaservicoDTO);
        geracategoriaservico = geracategoriaservicoRepository.save(geracategoriaservico);
        return geracategoriaservicoMapper.toDTO(geracategoriaservico);
    }

    public void deleteById(Integer id) {
        geracategoriaservicoRepository.deleteById(id);
    }
}
