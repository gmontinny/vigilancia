package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Temoaditivo;
import br.gov.mt.vigilancia.saude.dto.TemoaditivoDTO;
import br.gov.mt.vigilancia.saude.mapper.TemoaditivoMapper;
import br.gov.mt.vigilancia.saude.repository.TemoaditivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TemoaditivoService {

    @Autowired
    private TemoaditivoRepository temoaditivoRepository;

    @Autowired
    private TemoaditivoMapper temoaditivoMapper;

    public List<TemoaditivoDTO> findAll() {
        return temoaditivoRepository.findAll().stream()
                .map(temoaditivoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<TemoaditivoDTO> findById(Integer id) {
        return temoaditivoRepository.findById(id)
                .map(temoaditivoMapper::toDTO);
    }

    public TemoaditivoDTO save(TemoaditivoDTO temoaditivoDTO) {
        Temoaditivo temoaditivo = temoaditivoMapper.toEntity(temoaditivoDTO);
        temoaditivo = temoaditivoRepository.save(temoaditivo);
        return temoaditivoMapper.toDTO(temoaditivo);
    }

    public void deleteById(Integer id) {
        temoaditivoRepository.deleteById(id);
    }
}
