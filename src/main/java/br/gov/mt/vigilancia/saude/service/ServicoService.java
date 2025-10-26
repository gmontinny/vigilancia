package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.ServicoDTO;
import br.gov.mt.vigilancia.saude.mapper.ServicoMapper;
import br.gov.mt.vigilancia.saude.repository.ServicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServicoService {

    private final ServicoRepository servicoRepository;
    private final ServicoMapper servicoMapper;

    public List<ServicoDTO> findAll() {
        return servicoRepository.findAll()
                .stream()
                .map(servicoMapper::toDto)
                .collect(Collectors.toList());
    }
}
