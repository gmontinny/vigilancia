package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.RespostaDTO;
import br.gov.mt.vigilancia.saude.mapper.RespostaMapper;
import br.gov.mt.vigilancia.saude.repository.RespostaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RespostaService {

    private final RespostaRepository respostaRepository;
    private final RespostaMapper respostaMapper;

    public List<RespostaDTO> findAll() {
        return respostaRepository.findAll()
                .stream()
                .map(respostaMapper::toDto)
                .collect(Collectors.toList());
    }
}
