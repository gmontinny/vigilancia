package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Itenssolicitacao;
import br.gov.mt.vigilancia.saude.dto.ItenssolicitacaoDTO;
import br.gov.mt.vigilancia.saude.mapper.ItenssolicitacaoMapper;
import br.gov.mt.vigilancia.saude.repository.ItenssolicitacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItenssolicitacaoService {

    @Autowired
    private ItenssolicitacaoRepository itenssolicitacaoRepository;

    @Autowired
    private ItenssolicitacaoMapper itenssolicitacaoMapper;

    public List<ItenssolicitacaoDTO> findAll() {
        return itenssolicitacaoRepository.findAll().stream()
                .map(itenssolicitacaoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<ItenssolicitacaoDTO> findById(Integer id) {
        return itenssolicitacaoRepository.findById(id)
                .map(itenssolicitacaoMapper::toDTO);
    }

    public ItenssolicitacaoDTO save(ItenssolicitacaoDTO itenssolicitacaoDTO) {
        Itenssolicitacao itenssolicitacao = itenssolicitacaoMapper.toEntity(itenssolicitacaoDTO);
        itenssolicitacao = itenssolicitacaoRepository.save(itenssolicitacao);
        return itenssolicitacaoMapper.toDTO(itenssolicitacao);
    }

    public void deleteById(Integer id) {
        itenssolicitacaoRepository.deleteById(id);
    }
}
