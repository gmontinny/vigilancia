package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Autonotificacao;
import br.gov.mt.vigilancia.saude.dto.AutonotificacaoDTO;
import br.gov.mt.vigilancia.saude.mapper.AutonotificacaoMapper;
import br.gov.mt.vigilancia.saude.repository.AutonotificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AutonotificacaoService {

    @Autowired
    private AutonotificacaoRepository autonotificacaoRepository;

    @Autowired
    private AutonotificacaoMapper autonotificacaoMapper;

    public List<AutonotificacaoDTO> findAll() {
        return autonotificacaoRepository.findAll().stream()
                .map(autonotificacaoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<AutonotificacaoDTO> findById(Integer id) {
        return autonotificacaoRepository.findById(id)
                .map(autonotificacaoMapper::toDTO);
    }

    public AutonotificacaoDTO save(AutonotificacaoDTO autonotificacaoDTO) {
        Autonotificacao autonotificacao = autonotificacaoMapper.toEntity(autonotificacaoDTO);
        autonotificacao = autonotificacaoRepository.save(autonotificacao);
        return autonotificacaoMapper.toDTO(autonotificacao);
    }

    public void deleteById(Integer id) {
        autonotificacaoRepository.deleteById(id);
    }
}
