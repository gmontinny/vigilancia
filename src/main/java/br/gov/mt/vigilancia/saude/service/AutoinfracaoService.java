package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Autoinfracao;
import br.gov.mt.vigilancia.saude.dto.AutoinfracaoDTO;
import br.gov.mt.vigilancia.saude.mapper.AutoinfracaoMapper;
import br.gov.mt.vigilancia.saude.repository.AutoinfracaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AutoinfracaoService {

    @Autowired
    private AutoinfracaoRepository autoinfracaoRepository;

    @Autowired
    private AutoinfracaoMapper autoinfracaoMapper;

    public List<AutoinfracaoDTO> findAll() {
        return autoinfracaoRepository.findAll().stream()
                .map(autoinfracaoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<AutoinfracaoDTO> findById(Integer id) {
        return autoinfracaoRepository.findById(id)
                .map(autoinfracaoMapper::toDTO);
    }

    public AutoinfracaoDTO save(AutoinfracaoDTO autoinfracaoDTO) {
        Autoinfracao autoinfracao = autoinfracaoMapper.toEntity(autoinfracaoDTO);
        autoinfracao = autoinfracaoRepository.save(autoinfracao);
        return autoinfracaoMapper.toDTO(autoinfracao);
    }

    public void deleteById(Integer id) {
        autoinfracaoRepository.deleteById(id);
    }
}
