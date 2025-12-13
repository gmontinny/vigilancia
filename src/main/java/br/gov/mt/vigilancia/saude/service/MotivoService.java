package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.MotivoDTO;
import br.gov.mt.vigilancia.saude.mapper.MotivoMapper;
import br.gov.mt.vigilancia.saude.repository.MotivoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MotivoService {

    private final MotivoRepository motivoRepository;
    private final MotivoMapper motivoMapper;

    public List<MotivoDTO> findAll() {
        return motivoRepository.findAll()
                .stream()
                .map(motivoMapper::toDto)
                .collect(Collectors.toList());
    }

    public MotivoDTO findById(Integer id) {
        return motivoRepository.findById(id)
                .map(motivoMapper::toDto)
                .orElse(null);
    }

    public MotivoDTO save(MotivoDTO motivoDTO) {
        var entity = motivoMapper.toEntity(motivoDTO);
        var saved = motivoRepository.save(entity);
        return motivoMapper.toDto(saved);
    }

    public MotivoDTO update(Integer id, MotivoDTO motivoDTO) {
        return motivoRepository.findById(id)
                .map(existing -> {
                    var entity = motivoMapper.toEntity(motivoDTO);

                    return motivoMapper.toDto(motivoRepository.save(entity));
                })
                .orElse(null);
    }

    public void delete(Integer id) {
        motivoRepository.deleteById(id);
    }
}
