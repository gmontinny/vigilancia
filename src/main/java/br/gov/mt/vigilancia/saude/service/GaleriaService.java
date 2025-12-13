package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.GaleriaDTO;
import br.gov.mt.vigilancia.saude.mapper.GaleriaMapper;
import br.gov.mt.vigilancia.saude.repository.GaleriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GaleriaService {

    private final GaleriaRepository galeriaRepository;
    private final GaleriaMapper galeriaMapper;

    public List<GaleriaDTO> findAll() {
        return galeriaRepository.findAll()
                .stream()
                .map(galeriaMapper::toDto)
                .collect(Collectors.toList());
    }

    public GaleriaDTO findById(Integer id) {
        return galeriaRepository.findById(id)
                .map(galeriaMapper::toDto)
                .orElse(null);
    }

    public GaleriaDTO save(GaleriaDTO galeriaDTO) {
        var entity = galeriaMapper.toEntity(galeriaDTO);
        var saved = galeriaRepository.save(entity);
        return galeriaMapper.toDto(saved);
    }

    public GaleriaDTO update(Integer id, GaleriaDTO galeriaDTO) {
        return galeriaRepository.findById(id)
                .map(existing -> {
                    var entity = galeriaMapper.toEntity(galeriaDTO);

                    return galeriaMapper.toDto(galeriaRepository.save(entity));
                })
                .orElse(null);
    }

    public void delete(Integer id) {
        galeriaRepository.deleteById(id);
    }
}
