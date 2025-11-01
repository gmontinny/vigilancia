package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Geracodigocertificacao;
import br.gov.mt.vigilancia.saude.dto.GeracodigocertificacaoDTO;
import br.gov.mt.vigilancia.saude.mapper.GeracodigocertificacaoMapper;
import br.gov.mt.vigilancia.saude.repository.GeracodigocertificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GeracodigocertificacaoService {

    @Autowired
    private GeracodigocertificacaoRepository geracodigocertificacaoRepository;

    @Autowired
    private GeracodigocertificacaoMapper geracodigocertificacaoMapper;

    public List<GeracodigocertificacaoDTO> findAll() {
        return geracodigocertificacaoRepository.findAll().stream()
                .map(geracodigocertificacaoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<GeracodigocertificacaoDTO> findById(Integer id) {
        return geracodigocertificacaoRepository.findById(id)
                .map(geracodigocertificacaoMapper::toDTO);
    }

    public GeracodigocertificacaoDTO save(GeracodigocertificacaoDTO geracodigocertificacaoDTO) {
        Geracodigocertificacao geracodigocertificacao = geracodigocertificacaoMapper.toEntity(geracodigocertificacaoDTO);
        geracodigocertificacao = geracodigocertificacaoRepository.save(geracodigocertificacao);
        return geracodigocertificacaoMapper.toDTO(geracodigocertificacao);
    }

    public void deleteById(Integer id) {
        geracodigocertificacaoRepository.deleteById(id);
    }
}
