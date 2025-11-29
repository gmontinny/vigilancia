package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Restricao;
import br.gov.mt.vigilancia.saude.dto.RestricaoDTO;
import br.gov.mt.vigilancia.saude.mapper.RestricaoMapper;
import br.gov.mt.vigilancia.saude.repository.RestricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestricaoService {

    @Autowired
    private RestricaoRepository restricaoRepository;

    @Autowired
    private RestricaoMapper restricaoMapper;

    public List<RestricaoDTO> findAll() {
        return restricaoRepository.findAll().stream()
                .map(restricaoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<RestricaoDTO> findById(Integer id) {
        return restricaoRepository.findById(id)
                .map(restricaoMapper::toDTO);
    }

    public RestricaoDTO save(RestricaoDTO restricaoDTO) {
        Restricao restricao = restricaoMapper.toEntity(restricaoDTO);
        restricao = restricaoRepository.save(restricao);
        return restricaoMapper.toDTO(restricao);
    }

    public void deleteById(Integer id) {
        restricaoRepository.deleteById(id);
    }
}
