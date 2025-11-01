package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Entregador;
import br.gov.mt.vigilancia.saude.dto.EntregadorDTO;
import br.gov.mt.vigilancia.saude.mapper.EntregadorMapper;
import br.gov.mt.vigilancia.saude.repository.EntregadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EntregadorService {

    @Autowired
    private EntregadorRepository entregadorRepository;

    @Autowired
    private EntregadorMapper entregadorMapper;

    public List<EntregadorDTO> findAll() {
        return entregadorRepository.findAll().stream()
                .map(entregadorMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<EntregadorDTO> findById(Integer id) {
        return entregadorRepository.findById(id)
                .map(entregadorMapper::toDTO);
    }

    public EntregadorDTO save(EntregadorDTO entregadorDTO) {
        Entregador entregador = entregadorMapper.toEntity(entregadorDTO);
        entregador = entregadorRepository.save(entregador);
        return entregadorMapper.toDTO(entregador);
    }

    public void deleteById(Integer id) {
        entregadorRepository.deleteById(id);
    }
}
