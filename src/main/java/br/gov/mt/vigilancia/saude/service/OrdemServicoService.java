package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.OrdemServicoDTO;
import br.gov.mt.vigilancia.saude.mapper.OrdemServicoMapper;
import br.gov.mt.vigilancia.saude.repository.OrdemServicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrdemServicoService {

    private final OrdemServicoRepository ordemServicoRepository;
    private final OrdemServicoMapper ordemServicoMapper;

    public List<OrdemServicoDTO> findAll() {
        return ordemServicoRepository.findAll()
                .stream()
                .map(ordemServicoMapper::toDto)
                .collect(Collectors.toList());
    }
}
