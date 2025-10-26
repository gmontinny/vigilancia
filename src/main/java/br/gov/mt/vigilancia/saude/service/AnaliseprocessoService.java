package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Analiseprocesso;
import br.gov.mt.vigilancia.saude.dto.AnaliseprocessoDTO;
import br.gov.mt.vigilancia.saude.mapper.AnaliseprocessoMapper;
import br.gov.mt.vigilancia.saude.repository.AnaliseprocessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnaliseprocessoService {

    @Autowired
    private AnaliseprocessoRepository analiseprocessoRepository;

    @Autowired
    private AnaliseprocessoMapper analiseprocessoMapper;

    public List<AnaliseprocessoDTO> findAll() {
        return analiseprocessoRepository.findAll().stream()
                .map(analiseprocessoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<AnaliseprocessoDTO> findById(Integer id) {
        return analiseprocessoRepository.findById(id)
                .map(analiseprocessoMapper::toDTO);
    }

    public AnaliseprocessoDTO save(AnaliseprocessoDTO analiseprocessoDTO) {
        Analiseprocesso analiseprocesso = analiseprocessoMapper.toEntity(analiseprocessoDTO);
        analiseprocesso = analiseprocessoRepository.save(analiseprocesso);
        return analiseprocessoMapper.toDTO(analiseprocesso);
    }

    public void deleteById(Integer id) {
        analiseprocessoRepository.deleteById(id);
    }
}
