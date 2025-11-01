package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Docnecessario;
import br.gov.mt.vigilancia.saude.dto.DocnecessarioDTO;
import br.gov.mt.vigilancia.saude.mapper.DocnecessarioMapper;
import br.gov.mt.vigilancia.saude.repository.DocnecessarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DocnecessarioService {

    @Autowired
    private DocnecessarioRepository docnecessarioRepository;

    @Autowired
    private DocnecessarioMapper docnecessarioMapper;

    public List<DocnecessarioDTO> findAll() {
        return docnecessarioRepository.findAll().stream()
                .map(docnecessarioMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<DocnecessarioDTO> findById(Integer id) {
        return docnecessarioRepository.findById(id)
                .map(docnecessarioMapper::toDTO);
    }

    public DocnecessarioDTO save(DocnecessarioDTO docnecessarioDTO) {
        Docnecessario docnecessario = docnecessarioMapper.toEntity(docnecessarioDTO);
        docnecessario = docnecessarioRepository.save(docnecessario);
        return docnecessarioMapper.toDTO(docnecessario);
    }

    public void deleteById(Integer id) {
        docnecessarioRepository.deleteById(id);
    }
}
