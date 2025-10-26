package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.PermissaoDTO;
import br.gov.mt.vigilancia.saude.mapper.PermissaoMapper;
import br.gov.mt.vigilancia.saude.repository.PermissaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PermissaoService {

    private final PermissaoRepository permissaoRepository;
    private final PermissaoMapper permissaoMapper;

    public List<PermissaoDTO> findAll() {
        return permissaoRepository.findAll()
                .stream()
                .map(permissaoMapper::toDto)
                .collect(Collectors.toList());
    }
}
