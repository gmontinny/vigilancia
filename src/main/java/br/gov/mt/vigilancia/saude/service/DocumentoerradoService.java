package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Documentoerrado;
import br.gov.mt.vigilancia.saude.dto.DocumentoerradoDTO;
import br.gov.mt.vigilancia.saude.mapper.DocumentoerradoMapper;
import br.gov.mt.vigilancia.saude.repository.DocumentoerradoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DocumentoerradoService {

    @Autowired
    private DocumentoerradoRepository documentoerradoRepository;

    @Autowired
    private DocumentoerradoMapper documentoerradoMapper;

    public List<DocumentoerradoDTO> findAll() {
        return documentoerradoRepository.findAll().stream()
                .map(documentoerradoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<DocumentoerradoDTO> findById(Integer id) {
        return documentoerradoRepository.findById(id)
                .map(documentoerradoMapper::toDTO);
    }

    public DocumentoerradoDTO save(DocumentoerradoDTO documentoerradoDTO) {
        Documentoerrado documentoerrado = documentoerradoMapper.toEntity(documentoerradoDTO);
        documentoerrado = documentoerradoRepository.save(documentoerrado);
        return documentoerradoMapper.toDTO(documentoerrado);
    }

    public void deleteById(Integer id) {
        documentoerradoRepository.deleteById(id);
    }
}
