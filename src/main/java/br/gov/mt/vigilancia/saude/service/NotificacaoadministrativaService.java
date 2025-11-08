package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Notificacaoadministrativa;
import br.gov.mt.vigilancia.saude.dto.NotificacaoadministrativaDTO;
import br.gov.mt.vigilancia.saude.mapper.NotificacaoadministrativaMapper;
import br.gov.mt.vigilancia.saude.repository.NotificacaoadministrativaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NotificacaoadministrativaService {

    @Autowired
    private NotificacaoadministrativaRepository notificacaoadministrativaRepository;

    @Autowired
    private NotificacaoadministrativaMapper notificacaoadministrativaMapper;

    public List<NotificacaoadministrativaDTO> findAll() {
        return notificacaoadministrativaRepository.findAll().stream()
                .map(notificacaoadministrativaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<NotificacaoadministrativaDTO> findById(Integer id) {
        return notificacaoadministrativaRepository.findById(id)
                .map(notificacaoadministrativaMapper::toDTO);
    }

    public NotificacaoadministrativaDTO save(NotificacaoadministrativaDTO notificacaoadministrativaDTO) {
        Notificacaoadministrativa notificacaoadministrativa = notificacaoadministrativaMapper.toEntity(notificacaoadministrativaDTO);
        notificacaoadministrativa = notificacaoadministrativaRepository.save(notificacaoadministrativa);
        return notificacaoadministrativaMapper.toDTO(notificacaoadministrativa);
    }

    public void deleteById(Integer id) {
        notificacaoadministrativaRepository.deleteById(id);
    }
}
