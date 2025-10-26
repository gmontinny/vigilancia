package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Geraprodi;
import br.gov.mt.vigilancia.saude.dto.GeraprodiDTO;
import br.gov.mt.vigilancia.saude.mapper.GeraprodiMapper;
import br.gov.mt.vigilancia.saude.repository.GeraprodiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GeraprodiService {

    @Autowired
    private GeraprodiRepository geraprodiRepository;

    @Autowired
    private GeraprodiMapper geraprodiMapper;

    public List<GeraprodiDTO> findAll() {
        return geraprodiRepository.findAll().stream()
                .map(geraprodiMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<GeraprodiDTO> findById(Integer id) {
        return geraprodiRepository.findById(id)
                .map(geraprodiMapper::toDTO);
    }

    public GeraprodiDTO save(GeraprodiDTO geraprodiDTO) {
        Geraprodi geraprodi = geraprodiMapper.toEntity(geraprodiDTO);
        geraprodi = geraprodiRepository.save(geraprodi);
        return geraprodiMapper.toDTO(geraprodi);
    }

    public void deleteById(Integer id) {
        geraprodiRepository.deleteById(id);
    }
}
