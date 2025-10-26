package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.ForumDTO;
import br.gov.mt.vigilancia.saude.mapper.ForumMapper;
import br.gov.mt.vigilancia.saude.repository.ForumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ForumService {

    private final ForumRepository forumRepository;
    private final ForumMapper forumMapper;

    public List<ForumDTO> findAll() {
        return forumRepository.findAll()
                .stream()
                .map(forumMapper::toDto)
                .collect(Collectors.toList());
    }
}
