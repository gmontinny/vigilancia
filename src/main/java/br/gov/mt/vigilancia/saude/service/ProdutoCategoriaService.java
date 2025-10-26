package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.ProdutoCategoriaDTO;
import br.gov.mt.vigilancia.saude.mapper.ProdutoCategoriaMapper;
import br.gov.mt.vigilancia.saude.repository.ProdutoCategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProdutoCategoriaService {

    private final ProdutoCategoriaRepository produtoCategoriaRepository;
    private final ProdutoCategoriaMapper produtoCategoriaMapper;

    public List<ProdutoCategoriaDTO> findAll() {
        return produtoCategoriaRepository.findAll()
                .stream()
                .map(produtoCategoriaMapper::toDto)
                .collect(Collectors.toList());
    }
}
