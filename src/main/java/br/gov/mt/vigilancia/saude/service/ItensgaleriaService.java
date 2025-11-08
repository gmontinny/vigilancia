package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Itensgaleria;
import br.gov.mt.vigilancia.saude.dto.ItensgaleriaDTO;
import br.gov.mt.vigilancia.saude.mapper.ItensgaleriaMapper;
import br.gov.mt.vigilancia.saude.repository.ItensgaleriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItensgaleriaService {

    @Autowired
    private ItensgaleriaRepository itensgaleriaRepository;

    @Autowired
    private ItensgaleriaMapper itensgaleriaMapper;

    public List<ItensgaleriaDTO> findAll() {
        return itensgaleriaRepository.findAll().stream()
                .map(itensgaleriaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<ItensgaleriaDTO> findById(Integer id) {
        return itensgaleriaRepository.findById(id)
                .map(itensgaleriaMapper::toDTO);
    }

    public ItensgaleriaDTO save(ItensgaleriaDTO itensgaleriaDTO) {
        Itensgaleria itensgaleria = itensgaleriaMapper.toEntity(itensgaleriaDTO);
        itensgaleria = itensgaleriaRepository.save(itensgaleria);
        return itensgaleriaMapper.toDTO(itensgaleria);
    }

    public void deleteById(Integer id) {
        itensgaleriaRepository.deleteById(id);
    }
}
