package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.GeraautoDTO;
import br.gov.mt.vigilancia.saude.mapper.GeraautoMapper;
import br.gov.mt.vigilancia.saude.repository.GeraautoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GeraautoService {

    private final GeraautoRepository geraautoRepository;
    private final GeraautoMapper geraautoMapper;

    public List<GeraautoDTO> findAll() {
        return geraautoRepository.findAll()
                .stream()
                .map(geraautoMapper::toDto)
                .collect(Collectors.toList());
    }

    public GeraautoDTO findById(Integer id) {
        return geraautoRepository.findById(id)
                .map(geraautoMapper::toDto)
                .orElse(null);
    }

    public GeraautoDTO save(GeraautoDTO geraautoDTO) {
        var entity = geraautoMapper.toEntity(geraautoDTO);
        var saved = geraautoRepository.save(entity);
        return geraautoMapper.toDto(saved);
    }

    public GeraautoDTO update(Integer id, GeraautoDTO geraautoDTO) {
        return geraautoRepository.findById(id)
                .map(existing -> {
                    var entity = geraautoMapper.toEntity(geraautoDTO);

                    return geraautoMapper.toDto(geraautoRepository.save(entity));
                })
                .orElse(null);
    }

    public void delete(Integer id) {
        geraautoRepository.deleteById(id);
    }
}
