package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.UsuarioDTO;
import br.gov.mt.vigilancia.saude.mapper.UsuarioMapper;
import br.gov.mt.vigilancia.saude.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public List<UsuarioDTO> findAll() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuarioMapper::toDto)
                .collect(Collectors.toList());
    }

    public java.util.Optional<UsuarioDTO> findById(Integer id) {
        return usuarioRepository.findById(id)
                .map(usuarioMapper::toDto);
    }

    public UsuarioDTO save(UsuarioDTO usuarioDTO) {
        var entity = usuarioMapper.toEntity(usuarioDTO);
        var saved = usuarioRepository.save(entity);
        return usuarioMapper.toDto(saved);
    }

    public void deleteById(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
