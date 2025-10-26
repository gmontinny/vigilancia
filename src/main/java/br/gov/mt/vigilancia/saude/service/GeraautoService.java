package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.GeraautoDTO;
import br.gov.mt.vigilancia.saude.mapper.GeraautoMapper;
import br.gov.mt.vigilancia.saude.repository.GeraautoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GeraautoService {

    private final GeraautoRepository geraautoRepository;
    private final GeraautoMapper geraautoMapper;

    public List<GeraautoDTO> findAll() {
        return geraautoRepository.findAll()
                .stream()
                .map(geraautoMapper::toDto)
                .collect(Collectors.toList());
    }
}
