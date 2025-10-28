package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Bloqueioitenssolicitacao;
import br.gov.mt.vigilancia.saude.dto.BloqueioitenssolicitacaoDTO;
import br.gov.mt.vigilancia.saude.mapper.BloqueioitenssolicitacaoMapper;
import br.gov.mt.vigilancia.saude.repository.BloqueioitenssolicitacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BloqueioitenssolicitacaoService {

    @Autowired
    private BloqueioitenssolicitacaoRepository bloqueioitenssolicitacaoRepository;

    @Autowired
    private BloqueioitenssolicitacaoMapper bloqueioitenssolicitacaoMapper;

    public List<BloqueioitenssolicitacaoDTO> findAll() {
        return bloqueioitenssolicitacaoRepository.findAll().stream()
                .map(bloqueioitenssolicitacaoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<BloqueioitenssolicitacaoDTO> findById(Integer id) {
        return bloqueioitenssolicitacaoRepository.findById(id)
                .map(bloqueioitenssolicitacaoMapper::toDTO);
    }

    public BloqueioitenssolicitacaoDTO save(BloqueioitenssolicitacaoDTO bloqueioitenssolicitacaoDTO) {
        Bloqueioitenssolicitacao bloqueioitenssolicitacao = bloqueioitenssolicitacaoMapper.toEntity(bloqueioitenssolicitacaoDTO);
        bloqueioitenssolicitacao = bloqueioitenssolicitacaoRepository.save(bloqueioitenssolicitacao);
        return bloqueioitenssolicitacaoMapper.toDTO(bloqueioitenssolicitacao);
    }

    public void deleteById(Integer id) {
        bloqueioitenssolicitacaoRepository.deleteById(id);
    }
}
