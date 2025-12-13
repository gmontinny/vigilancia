package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.FabrilDTO;
import br.gov.mt.vigilancia.saude.mapper.FabrilMapper;
import br.gov.mt.vigilancia.saude.repository.FabrilRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FabrilService {

    private final FabrilRepository fabrilRepository;
    private final FabrilMapper fabrilMapper;

    public List<FabrilDTO> findAll() {
        return fabrilRepository.findAll()
                .stream()
                .map(fabrilMapper::toDto)
                .collect(Collectors.toList());
    }

    public java.util.Optional<FabrilDTO> findById(Integer id) {
        return fabrilRepository.findById(id)
                .map(fabrilMapper::toDto);
    }

    public FabrilDTO save(FabrilDTO fabrilDTO) {
        var entity = fabrilMapper.toEntity(fabrilDTO);
        var saved = fabrilRepository.save(entity);
        return fabrilMapper.toDto(saved);
    }

    public void deleteById(Integer id) {
        fabrilRepository.deleteById(id);
    }
}
