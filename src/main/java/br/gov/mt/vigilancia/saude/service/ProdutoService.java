package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.ProdutoDTO;
import br.gov.mt.vigilancia.saude.mapper.ProdutoMapper;
import br.gov.mt.vigilancia.saude.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;

    public List<ProdutoDTO> findAll() {
        return produtoRepository.findAll()
                .stream()
                .map(produtoMapper::toDto)
                .collect(Collectors.toList());
    }

    public ProdutoDTO findById(Integer id) {
        return produtoRepository.findById(id)
                .map(produtoMapper::toDto)
                .orElse(null);
    }

    public ProdutoDTO save(ProdutoDTO produtoDTO) {
        var entity = produtoMapper.toEntity(produtoDTO);
        var saved = produtoRepository.save(entity);
        return produtoMapper.toDto(saved);
    }

    public ProdutoDTO update(Integer id, ProdutoDTO produtoDTO) {
        return produtoRepository.findById(id)
                .map(existing -> {
                    var entity = produtoMapper.toEntity(produtoDTO);

                    return produtoMapper.toDto(produtoRepository.save(entity));
                })
                .orElse(null);
    }

    public void delete(Integer id) {
        produtoRepository.deleteById(id);
    }
}
