package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Itensautoinfracao;
import br.gov.mt.vigilancia.saude.dto.ItensautoinfracaoDTO;
import br.gov.mt.vigilancia.saude.mapper.ItensautoinfracaoMapper;
import br.gov.mt.vigilancia.saude.repository.ItensautoinfracaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItensautoinfracaoService {

    @Autowired
    private ItensautoinfracaoRepository itensautoinfracaoRepository;

    @Autowired
    private ItensautoinfracaoMapper itensautoinfracaoMapper;

    public List<ItensautoinfracaoDTO> findAll() {
        return itensautoinfracaoRepository.findAll().stream()
                .map(itensautoinfracaoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<ItensautoinfracaoDTO> findById(Integer id) {
        return itensautoinfracaoRepository.findById(id)
                .map(itensautoinfracaoMapper::toDTO);
    }

    public ItensautoinfracaoDTO save(ItensautoinfracaoDTO itensautoinfracaoDTO) {
        Itensautoinfracao itensautoinfracao = itensautoinfracaoMapper.toEntity(itensautoinfracaoDTO);
        itensautoinfracao = itensautoinfracaoRepository.save(itensautoinfracao);
        return itensautoinfracaoMapper.toDTO(itensautoinfracao);
    }

    public void deleteById(Integer id) {
        itensautoinfracaoRepository.deleteById(id);
    }
}
