package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.DocumentoDTO;
import br.gov.mt.vigilancia.saude.mapper.DocumentoMapper;
import br.gov.mt.vigilancia.saude.repository.DocumentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DocumentoService {

    private final DocumentoRepository documentoRepository;
    private final DocumentoMapper documentoMapper;

    public List<DocumentoDTO> findAll() {
        return documentoRepository.findAll()
                .stream()
                .map(documentoMapper::toDto)
                .collect(Collectors.toList());
    }
}
