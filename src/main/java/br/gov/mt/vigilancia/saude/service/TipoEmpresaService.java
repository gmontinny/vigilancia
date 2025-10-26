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
}
