package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Tecnicoprojeto;
import br.gov.mt.vigilancia.saude.dto.TecnicoprojetoDTO;
import br.gov.mt.vigilancia.saude.mapper.TecnicoprojetoMapper;
import br.gov.mt.vigilancia.saude.repository.TecnicoprojetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TecnicoprojetoService {

    @Autowired
    private TecnicoprojetoRepository tecnicoprojetoRepository;

    @Autowired
    private TecnicoprojetoMapper tecnicoprojetoMapper;

    public List<TecnicoprojetoDTO> findAll() {
        return tecnicoprojetoRepository.findAll().stream()
                .map(tecnicoprojetoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<TecnicoprojetoDTO> findById(Integer id) {
        return tecnicoprojetoRepository.findById(id)
                .map(tecnicoprojetoMapper::toDTO);
    }

    public TecnicoprojetoDTO save(TecnicoprojetoDTO tecnicoprojetoDTO) {
        Tecnicoprojeto tecnicoprojeto = tecnicoprojetoMapper.toEntity(tecnicoprojetoDTO);
        tecnicoprojeto = tecnicoprojetoRepository.save(tecnicoprojeto);
        return tecnicoprojetoMapper.toDTO(tecnicoprojeto);
    }

    public void deleteById(Integer id) {
        tecnicoprojetoRepository.deleteById(id);
    }
}
