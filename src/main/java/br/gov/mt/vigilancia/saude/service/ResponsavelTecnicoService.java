package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.ResponsavelTecnicoDTO;
import br.gov.mt.vigilancia.saude.mapper.ResponsavelTecnicoMapper;
import br.gov.mt.vigilancia.saude.repository.ResponsavelTecnicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ResponsavelTecnicoService {

    private final ResponsavelTecnicoRepository responsavelTecnicoRepository;
    private final ResponsavelTecnicoMapper responsavelTecnicoMapper;

    public List<ResponsavelTecnicoDTO> findAll() {
        return responsavelTecnicoRepository.findAll()
                .stream()
                .map(responsavelTecnicoMapper::toDto)
                .collect(Collectors.toList());
    }

    public ResponsavelTecnicoDTO findById(Integer id) {
        return responsavelTecnicoRepository.findById(id)
                .map(responsavelTecnicoMapper::toDto)
                .orElse(null);
    }

    public ResponsavelTecnicoDTO save(ResponsavelTecnicoDTO responsavelTecnicoDTO) {
        var entity = responsavelTecnicoMapper.toEntity(responsavelTecnicoDTO);
        var saved = responsavelTecnicoRepository.save(entity);
        return responsavelTecnicoMapper.toDto(saved);
    }

    public ResponsavelTecnicoDTO update(Integer id, ResponsavelTecnicoDTO responsavelTecnicoDTO) {
        return responsavelTecnicoRepository.findById(id)
                .map(existing -> {
                    var entity = responsavelTecnicoMapper.toEntity(responsavelTecnicoDTO);

                    return responsavelTecnicoMapper.toDto(responsavelTecnicoRepository.save(entity));
                })
                .orElse(null);
    }

    public void delete(Integer id) {
        responsavelTecnicoRepository.deleteById(id);
    }
}
