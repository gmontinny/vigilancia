package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.TipoEmpresaDTO;
import br.gov.mt.vigilancia.saude.mapper.TipoEmpresaMapper;
import br.gov.mt.vigilancia.saude.repository.TipoEmpresaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TipoEmpresaService {

    private final TipoEmpresaRepository tipoEmpresaRepository;
    private final TipoEmpresaMapper tipoEmpresaMapper;

    public List<TipoEmpresaDTO> findAll() {
        return tipoEmpresaRepository.findAll()
                .stream()
                .map(tipoEmpresaMapper::toDto)
                .collect(Collectors.toList());
    }

    public TipoEmpresaDTO findById(Integer id) {
        return tipoEmpresaRepository.findById(id)
                .map(tipoEmpresaMapper::toDto)
                .orElse(null);
    }

    public TipoEmpresaDTO save(TipoEmpresaDTO tipoEmpresaDTO) {
        var entity = tipoEmpresaMapper.toEntity(tipoEmpresaDTO);
        var saved = tipoEmpresaRepository.save(entity);
        return tipoEmpresaMapper.toDto(saved);
    }

    public TipoEmpresaDTO update(Integer id, TipoEmpresaDTO tipoEmpresaDTO) {
        return tipoEmpresaRepository.findById(id)
                .map(existing -> {
                    var entity = tipoEmpresaMapper.toEntity(tipoEmpresaDTO);

                    return tipoEmpresaMapper.toDto(tipoEmpresaRepository.save(entity));
                })
                .orElse(null);
    }

    public void delete(Integer id) {
        tipoEmpresaRepository.deleteById(id);
    }
}
