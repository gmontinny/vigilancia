package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Exiberoteiro;
import br.gov.mt.vigilancia.saude.dto.ExiberoteiroDTO;
import br.gov.mt.vigilancia.saude.mapper.ExiberoteiroMapper;
import br.gov.mt.vigilancia.saude.repository.ExiberoteiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExiberoteiroService {

    @Autowired
    private ExiberoteiroRepository exiberoteiroRepository;

    @Autowired
    private ExiberoteiroMapper exiberoteiroMapper;

    public List<ExiberoteiroDTO> findAll() {
        return exiberoteiroRepository.findAll().stream()
                .map(exiberoteiroMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<ExiberoteiroDTO> findById(Integer id) {
        return exiberoteiroRepository.findById(id)
                .map(exiberoteiroMapper::toDTO);
    }

    public ExiberoteiroDTO save(ExiberoteiroDTO exiberoteiroDTO) {
        Exiberoteiro exiberoteiro = exiberoteiroMapper.toEntity(exiberoteiroDTO);
        exiberoteiro = exiberoteiroRepository.save(exiberoteiro);
        return exiberoteiroMapper.toDTO(exiberoteiro);
    }

    public void deleteById(Integer id) {
        exiberoteiroRepository.deleteById(id);
    }
}
