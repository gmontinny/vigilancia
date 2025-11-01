package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Despachorevelia;
import br.gov.mt.vigilancia.saude.dto.DespachoreveliaDTO;
import br.gov.mt.vigilancia.saude.mapper.DespachoreveliaMapper;
import br.gov.mt.vigilancia.saude.repository.DespachoreveliaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DespachoreveliaService {

    @Autowired
    private DespachoreveliaRepository despachoreveliaRepository;

    @Autowired
    private DespachoreveliaMapper despachoreveliaMapper;

    public List<DespachoreveliaDTO> findAll() {
        return despachoreveliaRepository.findAll().stream()
                .map(despachoreveliaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<DespachoreveliaDTO> findById(Integer id) {
        return despachoreveliaRepository.findById(id)
                .map(despachoreveliaMapper::toDTO);
    }

    public DespachoreveliaDTO save(DespachoreveliaDTO despachoreveliaDTO) {
        Despachorevelia despachorevelia = despachoreveliaMapper.toEntity(despachoreveliaDTO);
        despachorevelia = despachoreveliaRepository.save(despachorevelia);
        return despachoreveliaMapper.toDTO(despachorevelia);
    }

    public void deleteById(Integer id) {
        despachoreveliaRepository.deleteById(id);
    }
}
