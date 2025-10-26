package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Licenciamento;
import br.gov.mt.vigilancia.saude.dto.LicenciamentoDTO;
import br.gov.mt.vigilancia.saude.mapper.LicenciamentoMapper;
import br.gov.mt.vigilancia.saude.repository.LicenciamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LicenciamentoService {

    @Autowired
    private LicenciamentoRepository licenciamentoRepository;

    @Autowired
    private LicenciamentoMapper licenciamentoMapper;

    public List<LicenciamentoDTO> findAll() {
        return licenciamentoRepository.findAll().stream()
                .map(licenciamentoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<LicenciamentoDTO> findById(Integer id) {
        return licenciamentoRepository.findById(id)
                .map(licenciamentoMapper::toDTO);
    }

    public LicenciamentoDTO save(LicenciamentoDTO licenciamentoDTO) {
        Licenciamento licenciamento = licenciamentoMapper.toEntity(licenciamentoDTO);
        licenciamento = licenciamentoRepository.save(licenciamento);
        return licenciamentoMapper.toDTO(licenciamento);
    }

    public void deleteById(Integer id) {
        licenciamentoRepository.deleteById(id);
    }
}
