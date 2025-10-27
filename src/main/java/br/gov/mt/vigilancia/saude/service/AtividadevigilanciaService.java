package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Atividadevigilancia;
import br.gov.mt.vigilancia.saude.dto.AtividadevigilanciaDTO;
import br.gov.mt.vigilancia.saude.mapper.AtividadevigilanciaMapper;
import br.gov.mt.vigilancia.saude.repository.AtividadevigilanciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AtividadevigilanciaService {

    @Autowired
    private AtividadevigilanciaRepository atividadevigilanciaRepository;

    @Autowired
    private AtividadevigilanciaMapper atividadevigilanciaMapper;

    public List<AtividadevigilanciaDTO> findAll() {
        return atividadevigilanciaRepository.findAll().stream()
                .map(atividadevigilanciaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<AtividadevigilanciaDTO> findById(Integer id) {
        return atividadevigilanciaRepository.findById(id)
                .map(atividadevigilanciaMapper::toDTO);
    }

    public AtividadevigilanciaDTO save(AtividadevigilanciaDTO atividadevigilanciaDTO) {
        Atividadevigilancia atividadevigilancia = atividadevigilanciaMapper.toEntity(atividadevigilanciaDTO);
        atividadevigilancia = atividadevigilanciaRepository.save(atividadevigilancia);
        return atividadevigilanciaMapper.toDTO(atividadevigilancia);
    }

    public void deleteById(Integer id) {
        atividadevigilanciaRepository.deleteById(id);
    }
}
