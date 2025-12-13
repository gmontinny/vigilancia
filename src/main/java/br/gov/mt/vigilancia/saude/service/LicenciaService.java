package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.LicenciaDTO;
import br.gov.mt.vigilancia.saude.mapper.LicenciaMapper;
import br.gov.mt.vigilancia.saude.repository.LicenciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LicenciaService {

    private final LicenciaRepository licenciaRepository;
    private final LicenciaMapper licenciaMapper;

    public List<LicenciaDTO> findAll() {
        return licenciaRepository.findAll()
                .stream()
                .map(licenciaMapper::toDto)
                .collect(Collectors.toList());
    }

    public LicenciaDTO findById(Integer id) {
        return licenciaRepository.findById(id)
                .map(licenciaMapper::toDto)
                .orElse(null);
    }

    public LicenciaDTO save(LicenciaDTO licenciaDTO) {
        var entity = licenciaMapper.toEntity(licenciaDTO);
        var saved = licenciaRepository.save(entity);
        return licenciaMapper.toDto(saved);
    }

    public LicenciaDTO update(Integer id, LicenciaDTO licenciaDTO) {
        return licenciaRepository.findById(id)
                .map(existing -> {
                    var entity = licenciaMapper.toEntity(licenciaDTO);

                    return licenciaMapper.toDto(licenciaRepository.save(entity));
                })
                .orElse(null);
    }

    public void delete(Integer id) {
        licenciaRepository.deleteById(id);
    }
}
