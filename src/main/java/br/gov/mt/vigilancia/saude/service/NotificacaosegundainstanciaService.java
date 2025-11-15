package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Notificacaosegundainstancia;
import br.gov.mt.vigilancia.saude.dto.NotificacaosegundainstanciaDTO;
import br.gov.mt.vigilancia.saude.mapper.NotificacaosegundainstanciaMapper;
import br.gov.mt.vigilancia.saude.repository.NotificacaosegundainstanciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NotificacaosegundainstanciaService {

    @Autowired
    private NotificacaosegundainstanciaRepository notificacaosegundainstanciaRepository;

    @Autowired
    private NotificacaosegundainstanciaMapper notificacaosegundainstanciaMapper;

    public List<NotificacaosegundainstanciaDTO> findAll() {
        return notificacaosegundainstanciaRepository.findAll().stream()
                .map(notificacaosegundainstanciaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<NotificacaosegundainstanciaDTO> findById(Integer id) {
        return notificacaosegundainstanciaRepository.findById(id)
                .map(notificacaosegundainstanciaMapper::toDTO);
    }

    public NotificacaosegundainstanciaDTO save(NotificacaosegundainstanciaDTO notificacaosegundainstanciaDTO) {
        Notificacaosegundainstancia notificacaosegundainstancia = notificacaosegundainstanciaMapper.toEntity(notificacaosegundainstanciaDTO);
        notificacaosegundainstancia = notificacaosegundainstanciaRepository.save(notificacaosegundainstancia);
        return notificacaosegundainstanciaMapper.toDTO(notificacaosegundainstancia);
    }

    public void deleteById(Integer id) {
        notificacaosegundainstanciaRepository.deleteById(id);
    }
}
