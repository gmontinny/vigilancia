package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.RoteiroDTO;
import br.gov.mt.vigilancia.saude.mapper.RoteiroMapper;
import br.gov.mt.vigilancia.saude.repository.RoteiroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoteiroService {

    private final RoteiroRepository roteiroRepository;
    private final RoteiroMapper roteiroMapper;

    public List<RoteiroDTO> findAll() {
        return roteiroRepository.findAll()
                .stream()
                .map(roteiroMapper::toDto)
                .collect(Collectors.toList());
    }

    public RoteiroDTO findById(Integer id) {
        return roteiroRepository.findById(id)
                .map(roteiroMapper::toDto)
                .orElse(null);
    }

    public RoteiroDTO save(RoteiroDTO roteiroDTO) {
        var entity = roteiroMapper.toEntity(roteiroDTO);
        var saved = roteiroRepository.save(entity);
        return roteiroMapper.toDto(saved);
    }

    public RoteiroDTO update(Integer id, RoteiroDTO roteiroDTO) {
        return roteiroRepository.findById(id)
                .map(existing -> {
                    var entity = roteiroMapper.toEntity(roteiroDTO);

                    return roteiroMapper.toDto(roteiroRepository.save(entity));
                })
                .orElse(null);
    }

    public void delete(Integer id) {
        roteiroRepository.deleteById(id);
    }
}
