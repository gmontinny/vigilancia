package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Notificacaousuario;
import br.gov.mt.vigilancia.saude.dto.NotificacaousuarioDTO;
import br.gov.mt.vigilancia.saude.mapper.NotificacaousuarioMapper;
import br.gov.mt.vigilancia.saude.repository.NotificacaousuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NotificacaousuarioService {

    @Autowired
    private NotificacaousuarioRepository notificacaousuarioRepository;

    @Autowired
    private NotificacaousuarioMapper notificacaousuarioMapper;

    public List<NotificacaousuarioDTO> findAll() {
        return notificacaousuarioRepository.findAll().stream()
                .map(notificacaousuarioMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<NotificacaousuarioDTO> findById(Integer id) {
        return notificacaousuarioRepository.findById(id)
                .map(notificacaousuarioMapper::toDTO);
    }

    public NotificacaousuarioDTO save(NotificacaousuarioDTO notificacaousuarioDTO) {
        Notificacaousuario notificacaousuario = notificacaousuarioMapper.toEntity(notificacaousuarioDTO);
        notificacaousuario = notificacaousuarioRepository.save(notificacaousuario);
        return notificacaousuarioMapper.toDTO(notificacaousuario);
    }

    public void deleteById(Integer id) {
        notificacaousuarioRepository.deleteById(id);
    }
}
