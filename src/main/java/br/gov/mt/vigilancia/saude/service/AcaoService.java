package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.AcaoDTO;
import br.gov.mt.vigilancia.saude.mapper.AcaoMapper;
import br.gov.mt.vigilancia.saude.repository.AcaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AcaoService {

    private final AcaoRepository acaoRepository;
    private final AcaoMapper acaoMapper;

    public List<AcaoDTO> findAll() {
        return acaoRepository.findAll()
                .stream()
                .map(acaoMapper::toDto)
                .collect(Collectors.toList());
    }

    public AcaoDTO findById(Integer id) {
        return acaoRepository.findById(id)
                .map(acaoMapper::toDto)
                .orElse(null);
    }

    public AcaoDTO save(AcaoDTO acaoDTO) {
        var entity = acaoMapper.toEntity(acaoDTO);
        var saved = acaoRepository.save(entity);
        return acaoMapper.toDto(saved);
    }

    public AcaoDTO update(Integer id, AcaoDTO acaoDTO) {
        return acaoRepository.findById(id)
                .map(existing -> {
                    var entity = acaoMapper.toEntity(acaoDTO);
                    entity.setId(id);
                    return acaoMapper.toDto(acaoRepository.save(entity));
                })
                .orElse(null);
    }

    public void delete(Integer id) {
        acaoRepository.deleteById(id);
    }
}
