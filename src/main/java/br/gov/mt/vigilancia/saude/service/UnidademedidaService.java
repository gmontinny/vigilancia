package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.UnidademedidaDTO;
import br.gov.mt.vigilancia.saude.mapper.UnidademedidaMapper;
import br.gov.mt.vigilancia.saude.repository.UnidademedidaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UnidademedidaService {

    private final UnidademedidaRepository unidademedidaRepository;
    private final UnidademedidaMapper unidademedidaMapper;

    public List<UnidademedidaDTO> findAll() {
        return unidademedidaRepository.findAll()
                .stream()
                .map(unidademedidaMapper::toDto)
                .collect(Collectors.toList());
    }

    public UnidademedidaDTO findById(Integer id) {
        return unidademedidaRepository.findById(id)
                .map(unidademedidaMapper::toDto)
                .orElse(null);
    }

    public UnidademedidaDTO save(UnidademedidaDTO unidademedidaDTO) {
        var entity = unidademedidaMapper.toEntity(unidademedidaDTO);
        var saved = unidademedidaRepository.save(entity);
        return unidademedidaMapper.toDto(saved);
    }

    public UnidademedidaDTO update(Integer id, UnidademedidaDTO unidademedidaDTO) {
        return unidademedidaRepository.findById(id)
                .map(existing -> {
                    var entity = unidademedidaMapper.toEntity(unidademedidaDTO);

                    return unidademedidaMapper.toDto(unidademedidaRepository.save(entity));
                })
                .orElse(null);
    }

    public void delete(Integer id) {
        unidademedidaRepository.deleteById(id);
    }
}
