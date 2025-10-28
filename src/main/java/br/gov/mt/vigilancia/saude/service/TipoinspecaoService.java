package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Tipoinspecao;
import br.gov.mt.vigilancia.saude.dto.TipoinspecaoDTO;
import br.gov.mt.vigilancia.saude.mapper.TipoinspecaoMapper;
import br.gov.mt.vigilancia.saude.repository.TipoinspecaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TipoinspecaoService {

    @Autowired
    private TipoinspecaoRepository tipoinspecaoRepository;

    @Autowired
    private TipoinspecaoMapper tipoinspecaoMapper;

    public List<TipoinspecaoDTO> findAll() {
        return tipoinspecaoRepository.findAll().stream()
                .map(tipoinspecaoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<TipoinspecaoDTO> findById(Integer id) {
        return tipoinspecaoRepository.findById(id)
                .map(tipoinspecaoMapper::toDTO);
    }

    public TipoinspecaoDTO save(TipoinspecaoDTO tipoinspecaoDTO) {
        Tipoinspecao tipoinspecao = tipoinspecaoMapper.toEntity(tipoinspecaoDTO);
        tipoinspecao = tipoinspecaoRepository.save(tipoinspecao);
        return tipoinspecaoMapper.toDTO(tipoinspecao);
    }

    public void deleteById(Integer id) {
        tipoinspecaoRepository.deleteById(id);
    }
}
