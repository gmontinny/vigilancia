package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Arquivodocumento;
import br.gov.mt.vigilancia.saude.dto.ArquivodocumentoDTO;
import br.gov.mt.vigilancia.saude.mapper.ArquivodocumentoMapper;
import br.gov.mt.vigilancia.saude.repository.ArquivodocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArquivodocumentoService {

    @Autowired
    private ArquivodocumentoRepository arquivodocumentoRepository;

    @Autowired
    private ArquivodocumentoMapper arquivodocumentoMapper;

    public List<ArquivodocumentoDTO> findAll() {
        return arquivodocumentoRepository.findAll().stream()
                .map(arquivodocumentoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<ArquivodocumentoDTO> findById(Integer id) {
        return arquivodocumentoRepository.findById(id)
                .map(arquivodocumentoMapper::toDTO);
    }

    public ArquivodocumentoDTO save(ArquivodocumentoDTO arquivodocumentoDTO) {
        Arquivodocumento arquivodocumento = arquivodocumentoMapper.toEntity(arquivodocumentoDTO);
        arquivodocumento = arquivodocumentoRepository.save(arquivodocumento);
        return arquivodocumentoMapper.toDTO(arquivodocumento);
    }

    public void deleteById(Integer id) {
        arquivodocumentoRepository.deleteById(id);
    }
}
