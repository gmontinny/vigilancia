package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.UsuarioDTO;
import br.gov.mt.vigilancia.saude.mapper.UsuarioMapper;
import br.gov.mt.vigilancia.saude.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;
    private final MinioStorageService minioStorageService;

    @Transactional(readOnly = true)
    public List<UsuarioDTO> findAll() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuarioMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public java.util.Optional<UsuarioDTO> findById(Integer id) {
        return usuarioRepository.findById(id)
                .map(usuarioMapper::toDto);
    }

    @Transactional(rollbackFor = Exception.class)
    public UsuarioDTO save(UsuarioDTO usuarioDTO) {
        var entity = usuarioMapper.toEntity(usuarioDTO);

        // Regras para senha: codificar quando informada; manter atual quando não informada em updates
        boolean hasNewPassword = usuarioDTO.getSenha() != null && !usuarioDTO.getSenha().isBlank();
        if (hasNewPassword) {
            entity.setSenha(passwordEncoder.encode(usuarioDTO.getSenha()));
        } else if (usuarioDTO.getId() != null) {
            usuarioRepository.findById(usuarioDTO.getId())
                    .ifPresent(existing -> entity.setSenha(existing.getSenha()));
        }

        var saved = usuarioRepository.save(entity);
        return usuarioMapper.toDto(saved);
    }

    public UsuarioDTO saveWithImage(UsuarioDTO usuarioDTO, MultipartFile imagem) {
        if (imagem != null && !imagem.isEmpty()) {
            // Prefixo opcional para organizar por recurso
            String objectKey = minioStorageService.upload(imagem, "usuarios");
            usuarioDTO.setImagem(objectKey); // Persistimos apenas a objectKey
        }
        return save(usuarioDTO);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
