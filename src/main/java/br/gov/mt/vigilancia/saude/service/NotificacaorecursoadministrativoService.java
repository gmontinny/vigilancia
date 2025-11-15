package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Notificacaorecursoadministrativo;
import br.gov.mt.vigilancia.saude.dto.NotificacaorecursoadministrativoDTO;
import br.gov.mt.vigilancia.saude.mapper.NotificacaorecursoadministrativoMapper;
import br.gov.mt.vigilancia.saude.repository.NotificacaorecursoadministrativoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NotificacaorecursoadministrativoService {

    @Autowired
    private NotificacaorecursoadministrativoRepository notificacaorecursoadministrativoRepository;

    @Autowired
    private NotificacaorecursoadministrativoMapper notificacaorecursoadministrativoMapper;

    public List<NotificacaorecursoadministrativoDTO> findAll() {
        return notificacaorecursoadministrativoRepository.findAll().stream()
                .map(notificacaorecursoadministrativoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<NotificacaorecursoadministrativoDTO> findById(Integer id) {
        return notificacaorecursoadministrativoRepository.findById(id)
                .map(notificacaorecursoadministrativoMapper::toDTO);
    }

    public NotificacaorecursoadministrativoDTO save(NotificacaorecursoadministrativoDTO notificacaorecursoadministrativoDTO) {
        Notificacaorecursoadministrativo notificacaorecursoadministrativo = notificacaorecursoadministrativoMapper.toEntity(notificacaorecursoadministrativoDTO);
        notificacaorecursoadministrativo = notificacaorecursoadministrativoRepository.save(notificacaorecursoadministrativo);
        return notificacaorecursoadministrativoMapper.toDTO(notificacaorecursoadministrativo);
    }

    public void deleteById(Integer id) {
        notificacaorecursoadministrativoRepository.deleteById(id);
    }
}
