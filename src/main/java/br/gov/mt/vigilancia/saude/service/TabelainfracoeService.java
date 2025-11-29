package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Tabelainfracoe;
import br.gov.mt.vigilancia.saude.dto.TabelainfracoeDTO;
import br.gov.mt.vigilancia.saude.mapper.TabelainfracoeMapper;
import br.gov.mt.vigilancia.saude.repository.TabelainfracoeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TabelainfracoeService {

    @Autowired
    private TabelainfracoeRepository tabelainfracoeRepository;

    @Autowired
    private TabelainfracoeMapper tabelainfracoeMapper;

    public List<TabelainfracoeDTO> findAll() {
        return tabelainfracoeRepository.findAll().stream()
                .map(tabelainfracoeMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<TabelainfracoeDTO> findById(Integer id) {
        return tabelainfracoeRepository.findById(id)
                .map(tabelainfracoeMapper::toDTO);
    }

    public TabelainfracoeDTO save(TabelainfracoeDTO tabelainfracoeDTO) {
        Tabelainfracoe tabelainfracoe = tabelainfracoeMapper.toEntity(tabelainfracoeDTO);
        tabelainfracoe = tabelainfracoeRepository.save(tabelainfracoe);
        return tabelainfracoeMapper.toDTO(tabelainfracoe);
    }

    public void deleteById(Integer id) {
        tabelainfracoeRepository.deleteById(id);
    }
}
