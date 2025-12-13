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

    public ServicoDTO findById(Integer id) {
        return servicoRepository.findById(id)
                .map(servicoMapper::toDto)
                .orElse(null);
    }

    public ServicoDTO save(ServicoDTO servicoDTO) {
        var entity = servicoMapper.toEntity(servicoDTO);
        var saved = servicoRepository.save(entity);
        return servicoMapper.toDto(saved);
    }

    public ServicoDTO update(Integer id, ServicoDTO servicoDTO) {
        return servicoRepository.findById(id)
                .map(existing -> {
                    var entity = servicoMapper.toEntity(servicoDTO);

                    return servicoMapper.toDto(servicoRepository.save(entity));
                })
                .orElse(null);
    }

    public void delete(Integer id) {
        servicoRepository.deleteById(id);
    }
}
