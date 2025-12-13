package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.BaixaDTO;
import br.gov.mt.vigilancia.saude.mapper.BaixaMapper;
import br.gov.mt.vigilancia.saude.repository.BaixaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BaixaService {

    private final BaixaRepository baixaRepository;
    private final BaixaMapper baixaMapper;

    public List<BaixaDTO> findAll() {
        return baixaRepository.findAll()
                .stream()
                .map(baixaMapper::toDto)
                .collect(Collectors.toList());
    }

    public java.util.Optional<BaixaDTO> findById(Integer id) {
        return baixaRepository.findById(id)
                .map(baixaMapper::toDto);
    }

    public BaixaDTO save(BaixaDTO baixaDTO) {
        var entity = baixaMapper.toEntity(baixaDTO);
        var saved = baixaRepository.save(entity);
        return baixaMapper.toDto(saved);
    }

    public void deleteById(Integer id) {
        baixaRepository.deleteById(id);
    }
}
