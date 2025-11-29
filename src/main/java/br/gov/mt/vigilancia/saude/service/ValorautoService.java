package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Valorauto;
import br.gov.mt.vigilancia.saude.dto.ValorautoDTO;
import br.gov.mt.vigilancia.saude.mapper.ValorautoMapper;
import br.gov.mt.vigilancia.saude.repository.ValorautoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ValorautoService {

    @Autowired
    private ValorautoRepository valorautoRepository;

    @Autowired
    private ValorautoMapper valorautoMapper;

    public List<ValorautoDTO> findAll() {
        return valorautoRepository.findAll().stream()
                .map(valorautoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<ValorautoDTO> findById(Integer id) {
        return valorautoRepository.findById(id)
                .map(valorautoMapper::toDTO);
    }

    public ValorautoDTO save(ValorautoDTO valorautoDTO) {
        Valorauto valorauto = valorautoMapper.toEntity(valorautoDTO);
        valorauto = valorautoRepository.save(valorauto);
        return valorautoMapper.toDTO(valorauto);
    }

    public void deleteById(Integer id) {
        valorautoRepository.deleteById(id);
    }
}
