package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Legislacao;
import br.gov.mt.vigilancia.saude.dto.LegislacaoDTO;
import br.gov.mt.vigilancia.saude.mapper.LegislacaoMapper;
import br.gov.mt.vigilancia.saude.repository.LegislacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LegislacaoService {

    @Autowired
    private LegislacaoRepository legislacaoRepository;

    @Autowired
    private LegislacaoMapper legislacaoMapper;

    public List<LegislacaoDTO> findAll() {
        return legislacaoRepository.findAll().stream()
                .map(legislacaoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<LegislacaoDTO> findById(Integer id) {
        return legislacaoRepository.findById(id)
                .map(legislacaoMapper::toDTO);
    }

    public LegislacaoDTO save(LegislacaoDTO legislacaoDTO) {
        Legislacao legislacao = legislacaoMapper.toEntity(legislacaoDTO);
        legislacao = legislacaoRepository.save(legislacao);
        return legislacaoMapper.toDTO(legislacao);
    }

    public void deleteById(Integer id) {
        legislacaoRepository.deleteById(id);
    }
}
