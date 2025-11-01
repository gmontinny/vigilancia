package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Despachoinstancia;
import br.gov.mt.vigilancia.saude.dto.DespachoinstanciaDTO;
import br.gov.mt.vigilancia.saude.mapper.DespachoinstanciaMapper;
import br.gov.mt.vigilancia.saude.repository.DespachoinstanciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DespachoinstanciaService {

    @Autowired
    private DespachoinstanciaRepository despachoinstanciaRepository;

    @Autowired
    private DespachoinstanciaMapper despachoinstanciaMapper;

    public List<DespachoinstanciaDTO> findAll() {
        return despachoinstanciaRepository.findAll().stream()
                .map(despachoinstanciaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<DespachoinstanciaDTO> findById(Integer id) {
        return despachoinstanciaRepository.findById(id)
                .map(despachoinstanciaMapper::toDTO);
    }

    public DespachoinstanciaDTO save(DespachoinstanciaDTO despachoinstanciaDTO) {
        Despachoinstancia despachoinstancia = despachoinstanciaMapper.toEntity(despachoinstanciaDTO);
        despachoinstancia = despachoinstanciaRepository.save(despachoinstancia);
        return despachoinstanciaMapper.toDTO(despachoinstancia);
    }

    public void deleteById(Integer id) {
        despachoinstanciaRepository.deleteById(id);
    }
}
