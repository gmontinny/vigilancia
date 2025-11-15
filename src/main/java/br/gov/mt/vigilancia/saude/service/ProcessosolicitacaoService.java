package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Processosolicitacao;
import br.gov.mt.vigilancia.saude.dto.ProcessosolicitacaoDTO;
import br.gov.mt.vigilancia.saude.mapper.ProcessosolicitacaoMapper;
import br.gov.mt.vigilancia.saude.repository.ProcessosolicitacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProcessosolicitacaoService {

    @Autowired
    private ProcessosolicitacaoRepository processosolicitacaoRepository;

    @Autowired
    private ProcessosolicitacaoMapper processosolicitacaoMapper;

    public List<ProcessosolicitacaoDTO> findAll() {
        return processosolicitacaoRepository.findAll().stream()
                .map(processosolicitacaoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<ProcessosolicitacaoDTO> findById(Integer id) {
        return processosolicitacaoRepository.findById(id)
                .map(processosolicitacaoMapper::toDTO);
    }

    public ProcessosolicitacaoDTO save(ProcessosolicitacaoDTO processosolicitacaoDTO) {
        Processosolicitacao processosolicitacao = processosolicitacaoMapper.toEntity(processosolicitacaoDTO);
        processosolicitacao = processosolicitacaoRepository.save(processosolicitacao);
        return processosolicitacaoMapper.toDTO(processosolicitacao);
    }

    public void deleteById(Integer id) {
        processosolicitacaoRepository.deleteById(id);
    }
}
