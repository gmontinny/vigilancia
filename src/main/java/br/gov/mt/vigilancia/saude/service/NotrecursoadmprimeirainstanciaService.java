package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Notrecursoadmprimeirainstancia;
import br.gov.mt.vigilancia.saude.dto.NotrecursoadmprimeirainstanciaDTO;
import br.gov.mt.vigilancia.saude.mapper.NotrecursoadmprimeirainstanciaMapper;
import br.gov.mt.vigilancia.saude.repository.NotrecursoadmprimeirainstanciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NotrecursoadmprimeirainstanciaService {

    @Autowired
    private NotrecursoadmprimeirainstanciaRepository notrecursoadmprimeirainstanciaRepository;

    @Autowired
    private NotrecursoadmprimeirainstanciaMapper notrecursoadmprimeirainstanciaMapper;

    public List<NotrecursoadmprimeirainstanciaDTO> findAll() {
        return notrecursoadmprimeirainstanciaRepository.findAll().stream()
                .map(notrecursoadmprimeirainstanciaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<NotrecursoadmprimeirainstanciaDTO> findById(Integer id) {
        return notrecursoadmprimeirainstanciaRepository.findById(id)
                .map(notrecursoadmprimeirainstanciaMapper::toDTO);
    }

    public NotrecursoadmprimeirainstanciaDTO save(NotrecursoadmprimeirainstanciaDTO notrecursoadmprimeirainstanciaDTO) {
        Notrecursoadmprimeirainstancia notrecursoadmprimeirainstancia = notrecursoadmprimeirainstanciaMapper.toEntity(notrecursoadmprimeirainstanciaDTO);
        notrecursoadmprimeirainstancia = notrecursoadmprimeirainstanciaRepository.save(notrecursoadmprimeirainstancia);
        return notrecursoadmprimeirainstanciaMapper.toDTO(notrecursoadmprimeirainstancia);
    }

    public void deleteById(Integer id) {
        notrecursoadmprimeirainstanciaRepository.deleteById(id);
    }
}
