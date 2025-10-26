package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Areainspecao;
import br.gov.mt.vigilancia.saude.dto.AreainspecaoDTO;
import br.gov.mt.vigilancia.saude.mapper.AreainspecaoMapper;
import br.gov.mt.vigilancia.saude.repository.AreainspecaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AreainspecaoService {

    @Autowired
    private AreainspecaoRepository areainspecaoRepository;

    @Autowired
    private AreainspecaoMapper areainspecaoMapper;

    public List<AreainspecaoDTO> findAll() {
        return areainspecaoRepository.findAll().stream()
                .map(areainspecaoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<AreainspecaoDTO> findById(Integer id) {
        return areainspecaoRepository.findById(id)
                .map(areainspecaoMapper::toDTO);
    }

    public AreainspecaoDTO save(AreainspecaoDTO areainspecaoDTO) {
        Areainspecao areainspecao = areainspecaoMapper.toEntity(areainspecaoDTO);
        areainspecao = areainspecaoRepository.save(areainspecao);
        return areainspecaoMapper.toDTO(areainspecao);
    }

    public void deleteById(Integer id) {
        areainspecaoRepository.deleteById(id);
    }
}
