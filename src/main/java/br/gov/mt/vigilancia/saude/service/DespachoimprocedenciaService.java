package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Despachoimprocedencia;
import br.gov.mt.vigilancia.saude.dto.DespachoimprocedenciaDTO;
import br.gov.mt.vigilancia.saude.mapper.DespachoimprocedenciaMapper;
import br.gov.mt.vigilancia.saude.repository.DespachoimprocedenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DespachoimprocedenciaService {

    @Autowired
    private DespachoimprocedenciaRepository despachocontrarazaoRepository;

    @Autowired
    private DespachoimprocedenciaMapper despachocontrarazaoMapper;

    public List<DespachoimprocedenciaDTO> findAll() {
        return despachocontrarazaoRepository.findAll().stream()
                .map(despachocontrarazaoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<DespachoimprocedenciaDTO> findById(Integer id) {
        return despachocontrarazaoRepository.findById(id)
                .map(despachocontrarazaoMapper::toDTO);
    }

    public DespachoimprocedenciaDTO save(DespachoimprocedenciaDTO despachocontrarazaoDTO) {
        Despachoimprocedencia despachocontrarazao = despachocontrarazaoMapper.toEntity(despachocontrarazaoDTO);
        despachocontrarazao = despachocontrarazaoRepository.save(despachocontrarazao);
        return despachocontrarazaoMapper.toDTO(despachocontrarazao);
    }

    public void deleteById(Integer id) {
        despachocontrarazaoRepository.deleteById(id);
    }
}
