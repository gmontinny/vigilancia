package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Relatorio;
import br.gov.mt.vigilancia.saude.dto.RelatorioDTO;
import br.gov.mt.vigilancia.saude.mapper.RelatorioMapper;
import br.gov.mt.vigilancia.saude.repository.RelatorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RelatorioService {

    @Autowired
    private RelatorioRepository relatorioRepository;

    @Autowired
    private RelatorioMapper relatorioMapper;

    public List<RelatorioDTO> findAll() {
        return relatorioRepository.findAll().stream()
                .map(relatorioMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<RelatorioDTO> findById(Integer id) {
        return relatorioRepository.findById(id)
                .map(relatorioMapper::toDTO);
    }

    public RelatorioDTO save(RelatorioDTO relatorioDTO) {
        Relatorio relatorio = relatorioMapper.toEntity(relatorioDTO);
        relatorio = relatorioRepository.save(relatorio);
        return relatorioMapper.toDTO(relatorio);
    }

    public void deleteById(Integer id) {
        relatorioRepository.deleteById(id);
    }
}
