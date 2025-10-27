package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Assuntosolicitacao;
import br.gov.mt.vigilancia.saude.dto.AssuntosolicitacaoDTO;
import br.gov.mt.vigilancia.saude.mapper.AssuntosolicitacaoMapper;
import br.gov.mt.vigilancia.saude.repository.AssuntosolicitacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AssuntosolicitacaoService {

    @Autowired
    private AssuntosolicitacaoRepository assuntosolicitacaoRepository;

    @Autowired
    private AssuntosolicitacaoMapper assuntosolicitacaoMapper;

    public List<AssuntosolicitacaoDTO> findAll() {
        return assuntosolicitacaoRepository.findAll().stream()
                .map(assuntosolicitacaoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<AssuntosolicitacaoDTO> findById(Integer id) {
        return assuntosolicitacaoRepository.findById(id)
                .map(assuntosolicitacaoMapper::toDTO);
    }

    public AssuntosolicitacaoDTO save(AssuntosolicitacaoDTO assuntosolicitacaoDTO) {
        Assuntosolicitacao assuntosolicitacao = assuntosolicitacaoMapper.toEntity(assuntosolicitacaoDTO);
        assuntosolicitacao = assuntosolicitacaoRepository.save(assuntosolicitacao);
        return assuntosolicitacaoMapper.toDTO(assuntosolicitacao);
    }

    public void deleteById(Integer id) {
        assuntosolicitacaoRepository.deleteById(id);
    }
}
