package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Geraprocesso;
import br.gov.mt.vigilancia.saude.dto.GeraprocessoDTO;
import br.gov.mt.vigilancia.saude.mapper.GeraprocessoMapper;
import br.gov.mt.vigilancia.saude.repository.GeraprocessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GeraprocessoService {

    @Autowired
    private GeraprocessoRepository geraprocessoRepository;

    @Autowired
    private GeraprocessoMapper geraprocessoMapper;

    public List<GeraprocessoDTO> findAll() {
        return geraprocessoRepository.findAll().stream()
                .map(geraprocessoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<GeraprocessoDTO> findById(Integer id) {
        return geraprocessoRepository.findById(id)
                .map(geraprocessoMapper::toDTO);
    }

    public GeraprocessoDTO save(GeraprocessoDTO geraprocessoDTO) {
        Geraprocesso geraprocesso = geraprocessoMapper.toEntity(geraprocessoDTO);
        geraprocesso = geraprocessoRepository.save(geraprocesso);
        return geraprocessoMapper.toDTO(geraprocesso);
    }

    public void deleteById(Integer id) {
        geraprocessoRepository.deleteById(id);
    }
}
