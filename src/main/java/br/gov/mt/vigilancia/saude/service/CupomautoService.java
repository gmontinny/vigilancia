package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.CupomautoDTO;
import br.gov.mt.vigilancia.saude.mapper.CupomautoMapper;
import br.gov.mt.vigilancia.saude.repository.CupomautoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CupomautoService {

    private final CupomautoRepository cupomautoRepository;
    private final CupomautoMapper cupomautoMapper;

    public List<CupomautoDTO> findAll() {
        return cupomautoRepository.findAll()
                .stream()
                .map(cupomautoMapper::toDto)
                .collect(Collectors.toList());
    }

    public java.util.Optional<CupomautoDTO> findById(Integer id) {
        return cupomautoRepository.findById(id)
                .map(cupomautoMapper::toDto);
    }

    public CupomautoDTO save(CupomautoDTO cupomautoDTO) {
        var entity = cupomautoMapper.toEntity(cupomautoDTO);
        var saved = cupomautoRepository.save(entity);
        return cupomautoMapper.toDto(saved);
    }

    public void deleteById(Integer id) {
        cupomautoRepository.deleteById(id);
    }
}
