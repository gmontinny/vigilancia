package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.ProcessoDTO;
import br.gov.mt.vigilancia.saude.mapper.ProcessoMapper;
import br.gov.mt.vigilancia.saude.repository.ProcessoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProcessoService {

    private final ProcessoRepository processoRepository;
    private final ProcessoMapper processoMapper;

    public List<ProcessoDTO> findAll() {
        return processoRepository.findAll()
                .stream()
                .map(processoMapper::toDto)
                .collect(Collectors.toList());
    }

    public ProcessoDTO findById(String id) {
        return processoRepository.findById(id)
                .map(processoMapper::toDto)
                .orElse(null);
    }

    public ProcessoDTO save(ProcessoDTO processoDTO) {
        var entity = processoMapper.toEntity(processoDTO);
        var saved = processoRepository.save(entity);
        return processoMapper.toDto(saved);
    }

    public ProcessoDTO update(String id, ProcessoDTO processoDTO) {
        return processoRepository.findById(id)
                .map(existing -> {
                    var entity = processoMapper.toEntity(processoDTO);

                    return processoMapper.toDto(processoRepository.save(entity));
                })
                .orElse(null);
    }

    public void delete(String id) {
        processoRepository.deleteById(id);
    }
}
