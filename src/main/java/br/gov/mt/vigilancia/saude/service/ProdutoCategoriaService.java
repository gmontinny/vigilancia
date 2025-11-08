package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.ProdutoCategoria;
import br.gov.mt.vigilancia.saude.dto.ProdutoCategoriaDTO;
import br.gov.mt.vigilancia.saude.mapper.ProdutoCategoriaMapper;
import br.gov.mt.vigilancia.saude.repository.ProdutoCategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoCategoriaService {

    @Autowired
    private ProdutoCategoriaRepository produtocategoriaRepository;

    @Autowired
    private ProdutoCategoriaMapper produtocategoriaMapper;

    public List<ProdutoCategoriaDTO> findAll() {
        return produtocategoriaRepository.findAll().stream()
                .map(produtocategoriaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<ProdutoCategoriaDTO> findById(Integer id) {
        return produtocategoriaRepository.findById(id)
                .map(produtocategoriaMapper::toDTO);
    }

    public ProdutoCategoriaDTO save(ProdutoCategoriaDTO produtocategoriaDTO) {
        ProdutoCategoria produtocategoria = produtocategoriaMapper.toEntity(produtocategoriaDTO);
        produtocategoria = produtocategoriaRepository.save(produtocategoria);
        return produtocategoriaMapper.toDTO(produtocategoria);
    }

    public void deleteById(Integer id) {
        produtocategoriaRepository.deleteById(id);
    }
}
