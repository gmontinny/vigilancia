package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.MotivoDTO;
import br.gov.mt.vigilancia.saude.mapper.MotivoMapper;
import br.gov.mt.vigilancia.saude.repository.MotivoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MotivoService {

    private final MotivoRepository motivoRepository;
    private final MotivoMapper motivoMapper;

    public List<MotivoDTO> findAll() {
        return motivoRepository.findAll()
                .stream()
                .map(motivoMapper::toDto)
                .collect(Collectors.toList());
    }
}
