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

    public java.util.Optional<EnderecoDTO> findById(Integer id) {
        return enderecoRepository.findById(id)
                .map(enderecoMapper::toDto);
    }

    public EnderecoDTO save(EnderecoDTO enderecoDTO) {
        var entity = enderecoMapper.toEntity(enderecoDTO);
        var saved = enderecoRepository.save(entity);
        return enderecoMapper.toDto(saved);
    }

    public void deleteById(Integer id) {
        enderecoRepository.deleteById(id);
    }
}
