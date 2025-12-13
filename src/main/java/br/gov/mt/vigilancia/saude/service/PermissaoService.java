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

    public java.util.Optional<PermissaoDTO> findById(Integer id) {
        return permissaoRepository.findById(id)
                .map(permissaoMapper::toDto);
    }

    public PermissaoDTO save(PermissaoDTO permissaoDTO) {
        var entity = permissaoMapper.toEntity(permissaoDTO);
        var saved = permissaoRepository.save(entity);
        return permissaoMapper.toDto(saved);
    }

    public void deleteById(Integer id) {
        permissaoRepository.deleteById(id);
    }
}
