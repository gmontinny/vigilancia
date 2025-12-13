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

    public java.util.Optional<ApreensaoDTO> findById(Integer id) {
        return apreensaoRepository.findById(id)
                .map(apreensaoMapper::toDto);
    }

    public ApreensaoDTO save(ApreensaoDTO apreensaoDTO) {
        var entity = apreensaoMapper.toEntity(apreensaoDTO);
        var saved = apreensaoRepository.save(entity);
        return apreensaoMapper.toDto(saved);
    }

    public void deleteById(Integer id) {
        apreensaoRepository.deleteById(id);
    }
}
