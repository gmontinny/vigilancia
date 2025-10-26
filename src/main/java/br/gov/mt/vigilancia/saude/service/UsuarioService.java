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
}
