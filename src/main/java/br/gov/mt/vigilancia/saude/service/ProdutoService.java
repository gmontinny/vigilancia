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
}
