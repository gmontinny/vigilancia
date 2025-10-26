package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.EnderecoDTO;
import br.gov.mt.vigilancia.saude.mapper.EnderecoMapper;
import br.gov.mt.vigilancia.saude.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final EnderecoMapper enderecoMapper;

    public List<EnderecoDTO> findAll() {
        return enderecoRepository.findAll()
                .stream()
                .map(enderecoMapper::toDto)
                .collect(Collectors.toList());
    }
}
