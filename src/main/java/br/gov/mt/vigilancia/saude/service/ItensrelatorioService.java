package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Itensrelatorio;
import br.gov.mt.vigilancia.saude.dto.ItensrelatorioDTO;
import br.gov.mt.vigilancia.saude.mapper.ItensrelatorioMapper;
import br.gov.mt.vigilancia.saude.repository.ItensrelatorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItensrelatorioService {

    @Autowired
    private ItensrelatorioRepository itensrelatorioRepository;

    @Autowired
    private ItensrelatorioMapper itensrelatorioMapper;

    public List<ItensrelatorioDTO> findAll() {
        return itensrelatorioRepository.findAll().stream()
                .map(itensrelatorioMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<ItensrelatorioDTO> findById(Integer id) {
        return itensrelatorioRepository.findById(id)
                .map(itensrelatorioMapper::toDTO);
    }

    public ItensrelatorioDTO save(ItensrelatorioDTO itensrelatorioDTO) {
        Itensrelatorio itensrelatorio = itensrelatorioMapper.toEntity(itensrelatorioDTO);
        itensrelatorio = itensrelatorioRepository.save(itensrelatorio);
        return itensrelatorioMapper.toDTO(itensrelatorio);
    }

    public void deleteById(Integer id) {
        itensrelatorioRepository.deleteById(id);
    }
}
