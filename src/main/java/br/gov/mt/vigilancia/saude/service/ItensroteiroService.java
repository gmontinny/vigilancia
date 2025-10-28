package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Itensroteiro;
import br.gov.mt.vigilancia.saude.dto.ItensroteiroDTO;
import br.gov.mt.vigilancia.saude.mapper.ItensroteiroMapper;
import br.gov.mt.vigilancia.saude.repository.ItensroteiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItensroteiroService {

    @Autowired
    private ItensroteiroRepository itensroteiroRepository;

    @Autowired
    private ItensroteiroMapper itensroteiroMapper;

    public List<ItensroteiroDTO> findAll() {
        return itensroteiroRepository.findAll().stream()
                .map(itensroteiroMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<ItensroteiroDTO> findById(Integer id) {
        return itensroteiroRepository.findById(id)
                .map(itensroteiroMapper::toDTO);
    }

    public ItensroteiroDTO save(ItensroteiroDTO itensroteiroDTO) {
        Itensroteiro itensroteiro = itensroteiroMapper.toEntity(itensroteiroDTO);
        itensroteiro = itensroteiroRepository.save(itensroteiro);
        return itensroteiroMapper.toDTO(itensroteiro);
    }

    public void deleteById(Integer id) {
        itensroteiroRepository.deleteById(id);
    }
}
