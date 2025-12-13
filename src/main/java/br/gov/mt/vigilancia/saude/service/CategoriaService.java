package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.CategoriaDTO;
import br.gov.mt.vigilancia.saude.mapper.CategoriaMapper;
import br.gov.mt.vigilancia.saude.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    public List<CategoriaDTO> findAll() {
        return categoriaRepository.findAll()
                .stream()
                .map(categoriaMapper::toDto)
                .collect(Collectors.toList());
    }

    public CategoriaDTO findById(Integer id) {
        return categoriaRepository.findById(id)
                .map(categoriaMapper::toDto)
                .orElse(null);
    }

    public CategoriaDTO save(CategoriaDTO categoriaDTO) {
        var entity = categoriaMapper.toEntity(categoriaDTO);
        var saved = categoriaRepository.save(entity);
        return categoriaMapper.toDto(saved);
    }

    public CategoriaDTO update(Integer id, CategoriaDTO categoriaDTO) {
        return categoriaRepository.findById(id)
                .map(existing -> {
                    var entity = categoriaMapper.toEntity(categoriaDTO);
                    return categoriaMapper.toDto(categoriaRepository.save(entity));
                })
                .orElse(null);
    }

    public void delete(Integer id) {
        categoriaRepository.deleteById(id);
    }
}
