package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Notificacaorecurso;
import br.gov.mt.vigilancia.saude.dto.NotificacaorecursoDTO;
import br.gov.mt.vigilancia.saude.mapper.NotificacaorecursoMapper;
import br.gov.mt.vigilancia.saude.repository.NotificacaorecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NotificacaorecursoService {

    @Autowired
    private NotificacaorecursoRepository notificacaorecursoRepository;

    @Autowired
    private NotificacaorecursoMapper notificacaorecursoMapper;

    public List<NotificacaorecursoDTO> findAll() {
        return notificacaorecursoRepository.findAll().stream()
                .map(notificacaorecursoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<NotificacaorecursoDTO> findById(Integer id) {
        return notificacaorecursoRepository.findById(id)
                .map(notificacaorecursoMapper::toDTO);
    }

    public NotificacaorecursoDTO save(NotificacaorecursoDTO notificacaorecursoDTO) {
        Notificacaorecurso notificacaorecurso = notificacaorecursoMapper.toEntity(notificacaorecursoDTO);
        notificacaorecurso = notificacaorecursoRepository.save(notificacaorecurso);
        return notificacaorecursoMapper.toDTO(notificacaorecurso);
    }

    public void deleteById(Integer id) {
        notificacaorecursoRepository.deleteById(id);
    }
}
