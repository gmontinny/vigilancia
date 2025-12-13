package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.ReclamacaoDTO;
import br.gov.mt.vigilancia.saude.mapper.ReclamacaoMapper;
import br.gov.mt.vigilancia.saude.repository.ReclamacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReclamacaoService {

    private final ReclamacaoRepository reclamacaoRepository;
    private final ReclamacaoMapper reclamacaoMapper;

    public List<ReclamacaoDTO> findAll() {
        return reclamacaoRepository.findAll()
                .stream()
                .map(reclamacaoMapper::toDto)
                .collect(Collectors.toList());
    }

    public ReclamacaoDTO findById(Integer id) {
        return reclamacaoRepository.findById(id)
                .map(reclamacaoMapper::toDto)
                .orElse(null);
    }

    public ReclamacaoDTO save(ReclamacaoDTO reclamacaoDTO) {
        var entity = reclamacaoMapper.toEntity(reclamacaoDTO);
        var saved = reclamacaoRepository.save(entity);
        return reclamacaoMapper.toDto(saved);
    }

    public ReclamacaoDTO update(Integer id, ReclamacaoDTO reclamacaoDTO) {
        return reclamacaoRepository.findById(id)
                .map(existing -> {
                    var entity = reclamacaoMapper.toEntity(reclamacaoDTO);

                    return reclamacaoMapper.toDto(reclamacaoRepository.save(entity));
                })
                .orElse(null);
    }

    public void delete(Integer id) {
        reclamacaoRepository.deleteById(id);
    }
}
