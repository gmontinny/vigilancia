package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.GrupoDTO;
import br.gov.mt.vigilancia.saude.mapper.GrupoMapper;
import br.gov.mt.vigilancia.saude.repository.GrupoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GrupoService {

    private final GrupoRepository grupoRepository;
    private final GrupoMapper grupoMapper;

    public List<GrupoDTO> findAll() {
        return grupoRepository.findAll()
                .stream()
                .map(grupoMapper::toDto)
                .collect(Collectors.toList());
    }

    public java.util.Optional<GrupoDTO> findById(Integer id) {
        return grupoRepository.findById(id)
                .map(grupoMapper::toDto);
    }

    public GrupoDTO save(GrupoDTO grupoDTO) {
        var entity = grupoMapper.toEntity(grupoDTO);
        var saved = grupoRepository.save(entity);
        return grupoMapper.toDto(saved);
    }

    public void deleteById(Integer id) {
        grupoRepository.deleteById(id);
    }
}
