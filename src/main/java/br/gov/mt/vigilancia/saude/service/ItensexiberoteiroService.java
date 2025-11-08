package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Itensexiberoteiro;
import br.gov.mt.vigilancia.saude.dto.ItensexiberoteiroDTO;
import br.gov.mt.vigilancia.saude.mapper.ItensexiberoteiroMapper;
import br.gov.mt.vigilancia.saude.repository.ItensexiberoteiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItensexiberoteiroService {

    @Autowired
    private ItensexiberoteiroRepository itensexiberoteiroRepository;

    @Autowired
    private ItensexiberoteiroMapper itensexiberoteiroMapper;

    public List<ItensexiberoteiroDTO> findAll() {
        return itensexiberoteiroRepository.findAll().stream()
                .map(itensexiberoteiroMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<ItensexiberoteiroDTO> findById(Integer id) {
        return itensexiberoteiroRepository.findById(id)
                .map(itensexiberoteiroMapper::toDTO);
    }

    public ItensexiberoteiroDTO save(ItensexiberoteiroDTO itensexiberoteiroDTO) {
        Itensexiberoteiro itensexiberoteiro = itensexiberoteiroMapper.toEntity(itensexiberoteiroDTO);
        itensexiberoteiro = itensexiberoteiroRepository.save(itensexiberoteiro);
        return itensexiberoteiroMapper.toDTO(itensexiberoteiro);
    }

    public void deleteById(Integer id) {
        itensexiberoteiroRepository.deleteById(id);
    }
}
