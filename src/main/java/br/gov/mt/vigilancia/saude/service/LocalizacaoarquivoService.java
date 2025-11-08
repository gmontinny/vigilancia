package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Localizacaoarquivo;
import br.gov.mt.vigilancia.saude.dto.LocalizacaoarquivoDTO;
import br.gov.mt.vigilancia.saude.mapper.LocalizacaoarquivoMapper;
import br.gov.mt.vigilancia.saude.repository.LocalizacaoarquivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LocalizacaoarquivoService {

    @Autowired
    private LocalizacaoarquivoRepository localizacaoarquivoRepository;

    @Autowired
    private LocalizacaoarquivoMapper localizacaoarquivoMapper;

    public List<LocalizacaoarquivoDTO> findAll() {
        return localizacaoarquivoRepository.findAll().stream()
                .map(localizacaoarquivoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<LocalizacaoarquivoDTO> findById(Integer id) {
        return localizacaoarquivoRepository.findById(id)
                .map(localizacaoarquivoMapper::toDTO);
    }

    public LocalizacaoarquivoDTO save(LocalizacaoarquivoDTO localizacaoarquivoDTO) {
        Localizacaoarquivo localizacaoarquivo = localizacaoarquivoMapper.toEntity(localizacaoarquivoDTO);
        localizacaoarquivo = localizacaoarquivoRepository.save(localizacaoarquivo);
        return localizacaoarquivoMapper.toDTO(localizacaoarquivo);
    }

    public void deleteById(Integer id) {
        localizacaoarquivoRepository.deleteById(id);
    }
}
