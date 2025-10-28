package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Categoriaservico;
import br.gov.mt.vigilancia.saude.dto.CategoriaservicoDTO;
import br.gov.mt.vigilancia.saude.mapper.CategoriaservicoMapper;
import br.gov.mt.vigilancia.saude.repository.CategoriaservicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaservicoService {

    @Autowired
    private CategoriaservicoRepository categoriaservicoRepository;

    @Autowired
    private CategoriaservicoMapper categoriaservicoMapper;

    public List<CategoriaservicoDTO> findAll() {
        return categoriaservicoRepository.findAll().stream()
                .map(categoriaservicoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<CategoriaservicoDTO> findById(Integer id) {
        return categoriaservicoRepository.findById(id)
                .map(categoriaservicoMapper::toDTO);
    }

    public CategoriaservicoDTO save(CategoriaservicoDTO categoriaservicoDTO) {
        Categoriaservico categoriaservico = categoriaservicoMapper.toEntity(categoriaservicoDTO);
        categoriaservico = categoriaservicoRepository.save(categoriaservico);
        return categoriaservicoMapper.toDTO(categoriaservico);
    }

    public void deleteById(Integer id) {
        categoriaservicoRepository.deleteById(id);
    }
}
