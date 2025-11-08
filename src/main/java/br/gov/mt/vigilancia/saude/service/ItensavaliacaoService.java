package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Itensavaliacao;
import br.gov.mt.vigilancia.saude.dto.ItensavaliacaoDTO;
import br.gov.mt.vigilancia.saude.mapper.ItensavaliacaoMapper;
import br.gov.mt.vigilancia.saude.repository.ItensavaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItensavaliacaoService {

    @Autowired
    private ItensavaliacaoRepository itensavaliacaoRepository;

    @Autowired
    private ItensavaliacaoMapper itensavaliacaoMapper;

    public List<ItensavaliacaoDTO> findAll() {
        return itensavaliacaoRepository.findAll().stream()
                .map(itensavaliacaoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<ItensavaliacaoDTO> findById(Integer id) {
        return itensavaliacaoRepository.findById(id)
                .map(itensavaliacaoMapper::toDTO);
    }

    public ItensavaliacaoDTO save(ItensavaliacaoDTO itensavaliacaoDTO) {
        Itensavaliacao itensavaliacao = itensavaliacaoMapper.toEntity(itensavaliacaoDTO);
        itensavaliacao = itensavaliacaoRepository.save(itensavaliacao);
        return itensavaliacaoMapper.toDTO(itensavaliacao);
    }

    public void deleteById(Integer id) {
        itensavaliacaoRepository.deleteById(id);
    }
}
