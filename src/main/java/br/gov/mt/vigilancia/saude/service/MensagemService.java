package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.MensagemDTO;
import br.gov.mt.vigilancia.saude.mapper.MensagemMapper;
import br.gov.mt.vigilancia.saude.repository.MensagemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MensagemService {

    private final MensagemRepository mensagemRepository;
    private final MensagemMapper mensagemMapper;

    public List<MensagemDTO> findAll() {
        return mensagemRepository.findAll()
                .stream()
                .map(mensagemMapper::toDto)
                .collect(Collectors.toList());
    }

    public java.util.Optional<MensagemDTO> findById(Integer id) {
        return mensagemRepository.findById(id)
                .map(mensagemMapper::toDto);
    }

    public MensagemDTO save(MensagemDTO mensagemDTO) {
        var entity = mensagemMapper.toEntity(mensagemDTO);
        var saved = mensagemRepository.save(entity);
        return mensagemMapper.toDto(saved);
    }

    public void deleteById(Integer id) {
        mensagemRepository.deleteById(id);
    }
}
