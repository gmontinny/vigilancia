package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Itensatividade;
import br.gov.mt.vigilancia.saude.dto.ItensatividadeDTO;
import br.gov.mt.vigilancia.saude.mapper.ItensatividadeMapper;
import br.gov.mt.vigilancia.saude.repository.ItensatividadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItensatividadeService {

    @Autowired
    private ItensatividadeRepository itensatividadeRepository;

    @Autowired
    private ItensatividadeMapper itensatividadeMapper;

    public List<ItensatividadeDTO> findAll() {
        return itensatividadeRepository.findAll().stream()
                .map(itensatividadeMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<ItensatividadeDTO> findById(Integer id) {
        return itensatividadeRepository.findById(id)
                .map(itensatividadeMapper::toDTO);
    }

    public ItensatividadeDTO save(ItensatividadeDTO itensatividadeDTO) {
        Itensatividade itensatividade = itensatividadeMapper.toEntity(itensatividadeDTO);
        itensatividade = itensatividadeRepository.save(itensatividade);
        return itensatividadeMapper.toDTO(itensatividade);
    }

    public void deleteById(Integer id) {
        itensatividadeRepository.deleteById(id);
    }
}
