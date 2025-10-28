package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Categoriaroteiro;
import br.gov.mt.vigilancia.saude.dto.CategoriaroteiroDTO;
import br.gov.mt.vigilancia.saude.mapper.CategoriaroteiroMapper;
import br.gov.mt.vigilancia.saude.repository.CategoriaroteiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaroteiroService {

    @Autowired
    private CategoriaroteiroRepository categoriaroteiroRepository;

    @Autowired
    private CategoriaroteiroMapper categoriaroteiroMapper;

    public List<CategoriaroteiroDTO> findAll() {
        return categoriaroteiroRepository.findAll().stream()
                .map(categoriaroteiroMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<CategoriaroteiroDTO> findById(Integer id) {
        return categoriaroteiroRepository.findById(id)
                .map(categoriaroteiroMapper::toDTO);
    }

    public CategoriaroteiroDTO save(CategoriaroteiroDTO categoriaroteiroDTO) {
        Categoriaroteiro categoriaroteiro = categoriaroteiroMapper.toEntity(categoriaroteiroDTO);
        categoriaroteiro = categoriaroteiroRepository.save(categoriaroteiro);
        return categoriaroteiroMapper.toDTO(categoriaroteiro);
    }

    public void deleteById(Integer id) {
        categoriaroteiroRepository.deleteById(id);
    }
}
