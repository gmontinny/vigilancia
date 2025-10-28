package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Tramitacao;
import br.gov.mt.vigilancia.saude.dto.TramitacaoDTO;
import br.gov.mt.vigilancia.saude.mapper.TramitacaoMapper;
import br.gov.mt.vigilancia.saude.repository.TramitacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TramitacaoService {

    @Autowired
    private TramitacaoRepository tramitacaoRepository;

    @Autowired
    private TramitacaoMapper tramitacaoMapper;

    public List<TramitacaoDTO> findAll() {
        return tramitacaoRepository.findAll().stream()
                .map(tramitacaoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<TramitacaoDTO> findById(Integer id) {
        return tramitacaoRepository.findById(id)
                .map(tramitacaoMapper::toDTO);
    }

    public TramitacaoDTO save(TramitacaoDTO tramitacaoDTO) {
        Tramitacao tramitacao = tramitacaoMapper.toEntity(tramitacaoDTO);
        tramitacao = tramitacaoRepository.save(tramitacao);
        return tramitacaoMapper.toDTO(tramitacao);
    }

    public void deleteById(Integer id) {
        tramitacaoRepository.deleteById(id);
    }
}
