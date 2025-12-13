package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.BpaDTO;
import br.gov.mt.vigilancia.saude.mapper.BpaMapper;
import br.gov.mt.vigilancia.saude.repository.BpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BpaService {

    private final BpaRepository bpaRepository;
    private final BpaMapper bpaMapper;

    public List<BpaDTO> findAll() {
        return bpaRepository.findAll()
                .stream()
                .map(bpaMapper::toDto)
                .collect(Collectors.toList());
    }

    public BpaDTO findById(Integer id) {
        return bpaRepository.findById(id)
                .map(bpaMapper::toDto)
                .orElse(null);
    }

    public BpaDTO save(BpaDTO bpaDTO) {
        var entity = bpaMapper.toEntity(bpaDTO);
        var saved = bpaRepository.save(entity);
        return bpaMapper.toDto(saved);
    }

    public BpaDTO update(Integer id, BpaDTO bpaDTO) {
        return bpaRepository.findById(id)
                .map(existing -> {
                    var entity = bpaMapper.toEntity(bpaDTO);
                    entity.setId(id);
                    return bpaMapper.toDto(bpaRepository.save(entity));
                })
                .orElse(null);
    }

    public void delete(Integer id) {
        bpaRepository.deleteById(id);
    }
}
