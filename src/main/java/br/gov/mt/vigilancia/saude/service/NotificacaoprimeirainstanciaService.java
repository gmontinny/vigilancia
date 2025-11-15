package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Notificacaoprimeirainstancia;
import br.gov.mt.vigilancia.saude.dto.NotificacaoprimeirainstanciaDTO;
import br.gov.mt.vigilancia.saude.mapper.NotificacaoprimeirainstanciaMapper;
import br.gov.mt.vigilancia.saude.repository.NotificacaoprimeirainstanciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NotificacaoprimeirainstanciaService {

    @Autowired
    private NotificacaoprimeirainstanciaRepository notificacaoprimeirainstanciaRepository;

    @Autowired
    private NotificacaoprimeirainstanciaMapper notificacaoprimeirainstanciaMapper;

    public List<NotificacaoprimeirainstanciaDTO> findAll() {
        return notificacaoprimeirainstanciaRepository.findAll().stream()
                .map(notificacaoprimeirainstanciaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<NotificacaoprimeirainstanciaDTO> findById(Integer id) {
        return notificacaoprimeirainstanciaRepository.findById(id)
                .map(notificacaoprimeirainstanciaMapper::toDTO);
    }

    public NotificacaoprimeirainstanciaDTO save(NotificacaoprimeirainstanciaDTO notificacaoprimeirainstanciaDTO) {
        Notificacaoprimeirainstancia notificacaoprimeirainstancia = notificacaoprimeirainstanciaMapper.toEntity(notificacaoprimeirainstanciaDTO);
        notificacaoprimeirainstancia = notificacaoprimeirainstanciaRepository.save(notificacaoprimeirainstancia);
        return notificacaoprimeirainstanciaMapper.toDTO(notificacaoprimeirainstancia);
    }

    public void deleteById(Integer id) {
        notificacaoprimeirainstanciaRepository.deleteById(id);
    }
}
