package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Categoriaproduto;
import br.gov.mt.vigilancia.saude.dto.CategoriaprodutoDTO;
import br.gov.mt.vigilancia.saude.mapper.CategoriaprodutoMapper;
import br.gov.mt.vigilancia.saude.repository.CategoriaprodutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaprodutoService {

    @Autowired
    private CategoriaprodutoRepository categoriaprodutoRepository;

    @Autowired
    private CategoriaprodutoMapper categoriaprodutoMapper;

    public List<CategoriaprodutoDTO> findAll() {
        return categoriaprodutoRepository.findAll().stream()
                .map(categoriaprodutoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<CategoriaprodutoDTO> findById(Integer id) {
        return categoriaprodutoRepository.findById(id)
                .map(categoriaprodutoMapper::toDTO);
    }

    public CategoriaprodutoDTO save(CategoriaprodutoDTO categoriaprodutoDTO) {
        Categoriaproduto categoriaproduto = categoriaprodutoMapper.toEntity(categoriaprodutoDTO);
        categoriaproduto = categoriaprodutoRepository.save(categoriaproduto);
        return categoriaprodutoMapper.toDTO(categoriaproduto);
    }

    public void deleteById(Integer id) {
        categoriaprodutoRepository.deleteById(id);
    }
}
