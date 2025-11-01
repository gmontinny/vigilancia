package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Empresainfracoe;
import br.gov.mt.vigilancia.saude.dto.EmpresainfracoeDTO;
import br.gov.mt.vigilancia.saude.mapper.EmpresainfracoeMapper;
import br.gov.mt.vigilancia.saude.repository.EmpresainfracoeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmpresainfracoeService {

    @Autowired
    private EmpresainfracoeRepository empresainfracoeRepository;

    @Autowired
    private EmpresainfracoeMapper empresainfracoeMapper;

    public List<EmpresainfracoeDTO> findAll() {
        return empresainfracoeRepository.findAll().stream()
                .map(empresainfracoeMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<EmpresainfracoeDTO> findById(Integer id) {
        return empresainfracoeRepository.findById(id)
                .map(empresainfracoeMapper::toDTO);
    }

    public EmpresainfracoeDTO save(EmpresainfracoeDTO empresainfracoeDTO) {
        Empresainfracoe empresainfracoe = empresainfracoeMapper.toEntity(empresainfracoeDTO);
        empresainfracoe = empresainfracoeRepository.save(empresainfracoe);
        return empresainfracoeMapper.toDTO(empresainfracoe);
    }

    public void deleteById(Integer id) {
        empresainfracoeRepository.deleteById(id);
    }
}
