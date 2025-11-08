package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Notificacao;
import br.gov.mt.vigilancia.saude.dto.NotificacaoDTO;
import br.gov.mt.vigilancia.saude.mapper.NotificacaoMapper;
import br.gov.mt.vigilancia.saude.repository.NotificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NotificacaoService {

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    @Autowired
    private NotificacaoMapper notificacaoMapper;

    public List<NotificacaoDTO> findAll() {
        return notificacaoRepository.findAll().stream()
                .map(notificacaoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<NotificacaoDTO> findById(Integer id) {
        return notificacaoRepository.findById(id)
                .map(notificacaoMapper::toDTO);
    }

    public NotificacaoDTO save(NotificacaoDTO notificacaoDTO) {
        Notificacao notificacao = notificacaoMapper.toEntity(notificacaoDTO);
        notificacao = notificacaoRepository.save(notificacao);
        return notificacaoMapper.toDTO(notificacao);
    }

    public void deleteById(Integer id) {
        notificacaoRepository.deleteById(id);
    }
}
