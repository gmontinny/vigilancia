package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.ApreensaoDTO;
import br.gov.mt.vigilancia.saude.mapper.ApreensaoMapper;
import br.gov.mt.vigilancia.saude.repository.ApreensaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApreensaoService {

    private final ApreensaoRepository apreensaoRepository;
    private final ApreensaoMapper apreensaoMapper;

    public List<ApreensaoDTO> findAll() {
        return apreensaoRepository.findAll()
                .stream()
                .map(apreensaoMapper::toDto)
                .collect(Collectors.toList());
    }
}
