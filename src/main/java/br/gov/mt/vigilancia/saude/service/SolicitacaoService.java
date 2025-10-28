package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Solicitacao;
import br.gov.mt.vigilancia.saude.dto.SolicitacaoDTO;
import br.gov.mt.vigilancia.saude.mapper.SolicitacaoMapper;
import br.gov.mt.vigilancia.saude.repository.SolicitacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SolicitacaoService {

    @Autowired
    private SolicitacaoRepository solicitacaoRepository;

    @Autowired
    private SolicitacaoMapper solicitacaoMapper;

    public List<SolicitacaoDTO> findAll() {
        return solicitacaoRepository.findAll().stream()
                .map(solicitacaoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<SolicitacaoDTO> findById(Integer id) {
        return solicitacaoRepository.findById(id)
                .map(solicitacaoMapper::toDTO);
    }

    public SolicitacaoDTO save(SolicitacaoDTO solicitacaoDTO) {
        Solicitacao solicitacao = solicitacaoMapper.toEntity(solicitacaoDTO);
        solicitacao = solicitacaoRepository.save(solicitacao);
        return solicitacaoMapper.toDTO(solicitacao);
    }

    public void deleteById(Integer id) {
        solicitacaoRepository.deleteById(id);
    }
}
