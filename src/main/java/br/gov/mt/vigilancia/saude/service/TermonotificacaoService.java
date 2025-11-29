package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Termonotificacao;
import br.gov.mt.vigilancia.saude.dto.TermonotificacaoDTO;
import br.gov.mt.vigilancia.saude.mapper.TermonotificacaoMapper;
import br.gov.mt.vigilancia.saude.repository.TermonotificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TermonotificacaoService {

    @Autowired
    private TermonotificacaoRepository termonotificacaoRepository;

    @Autowired
    private TermonotificacaoMapper termonotificacaoMapper;

    public List<TermonotificacaoDTO> findAll() {
        return termonotificacaoRepository.findAll().stream()
                .map(termonotificacaoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<TermonotificacaoDTO> findById(Integer id) {
        return termonotificacaoRepository.findById(id)
                .map(termonotificacaoMapper::toDTO);
    }

    public TermonotificacaoDTO save(TermonotificacaoDTO termonotificacaoDTO) {
        Termonotificacao termonotificacao = termonotificacaoMapper.toEntity(termonotificacaoDTO);
        termonotificacao = termonotificacaoRepository.save(termonotificacao);
        return termonotificacaoMapper.toDTO(termonotificacao);
    }

    public void deleteById(Integer id) {
        termonotificacaoRepository.deleteById(id);
    }
}
