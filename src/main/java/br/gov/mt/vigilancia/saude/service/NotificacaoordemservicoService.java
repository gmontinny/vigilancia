package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Notificacaoordemservico;
import br.gov.mt.vigilancia.saude.dto.NotificacaoordemservicoDTO;
import br.gov.mt.vigilancia.saude.mapper.NotificacaoordemservicoMapper;
import br.gov.mt.vigilancia.saude.repository.NotificacaoordemservicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NotificacaoordemservicoService {

    @Autowired
    private NotificacaoordemservicoRepository notificacaoordemservicoRepository;

    @Autowired
    private NotificacaoordemservicoMapper notificacaoordemservicoMapper;

    public List<NotificacaoordemservicoDTO> findAll() {
        return notificacaoordemservicoRepository.findAll().stream()
                .map(notificacaoordemservicoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<NotificacaoordemservicoDTO> findById(Integer id) {
        return notificacaoordemservicoRepository.findById(id)
                .map(notificacaoordemservicoMapper::toDTO);
    }

    public NotificacaoordemservicoDTO save(NotificacaoordemservicoDTO notificacaoordemservicoDTO) {
        Notificacaoordemservico notificacaoordemservico = notificacaoordemservicoMapper.toEntity(notificacaoordemservicoDTO);
        notificacaoordemservico = notificacaoordemservicoRepository.save(notificacaoordemservico);
        return notificacaoordemservicoMapper.toDTO(notificacaoordemservico);
    }

    public void deleteById(Integer id) {
        notificacaoordemservicoRepository.deleteById(id);
    }
}
