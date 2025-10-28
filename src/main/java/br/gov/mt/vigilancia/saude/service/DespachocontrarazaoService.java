package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Despachocontrarazao;
import br.gov.mt.vigilancia.saude.dto.DespachocontrarazaoDTO;
import br.gov.mt.vigilancia.saude.mapper.DespachocontrarazaoMapper;
import br.gov.mt.vigilancia.saude.repository.DespachocontrarazaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DespachocontrarazaoService {

    @Autowired
    private DespachocontrarazaoRepository despachocontrarazaoRepository;

    @Autowired
    private DespachocontrarazaoMapper despachocontrarazaoMapper;

    public List<DespachocontrarazaoDTO> findAll() {
        return despachocontrarazaoRepository.findAll().stream()
                .map(despachocontrarazaoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<DespachocontrarazaoDTO> findById(Integer id) {
        return despachocontrarazaoRepository.findById(id)
                .map(despachocontrarazaoMapper::toDTO);
    }

    public DespachocontrarazaoDTO save(DespachocontrarazaoDTO despachocontrarazaoDTO) {
        Despachocontrarazao despachocontrarazao = despachocontrarazaoMapper.toEntity(despachocontrarazaoDTO);
        despachocontrarazao = despachocontrarazaoRepository.save(despachocontrarazao);
        return despachocontrarazaoMapper.toDTO(despachocontrarazao);
    }

    public void deleteById(Integer id) {
        despachocontrarazaoRepository.deleteById(id);
    }
}
