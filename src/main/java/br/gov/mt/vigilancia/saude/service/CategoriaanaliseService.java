package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Categoriaanalise;
import br.gov.mt.vigilancia.saude.dto.CategoriaanaliseDTO;
import br.gov.mt.vigilancia.saude.mapper.CategoriaanaliseMapper;
import br.gov.mt.vigilancia.saude.repository.CategoriaanaliseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaanaliseService {

    @Autowired
    private CategoriaanaliseRepository categoriaanaliseRepository;

    @Autowired
    private CategoriaanaliseMapper categoriaanaliseMapper;

    public List<CategoriaanaliseDTO> findAll() {
        return categoriaanaliseRepository.findAll().stream()
                .map(categoriaanaliseMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<CategoriaanaliseDTO> findById(Integer id) {
        return categoriaanaliseRepository.findById(id)
                .map(categoriaanaliseMapper::toDTO);
    }

    public CategoriaanaliseDTO save(CategoriaanaliseDTO categoriaanaliseDTO) {
        Categoriaanalise categoriaanalise = categoriaanaliseMapper.toEntity(categoriaanaliseDTO);
        categoriaanalise = categoriaanaliseRepository.save(categoriaanalise);
        return categoriaanaliseMapper.toDTO(categoriaanalise);
    }

    public void deleteById(Integer id) {
        categoriaanaliseRepository.deleteById(id);
    }
}
