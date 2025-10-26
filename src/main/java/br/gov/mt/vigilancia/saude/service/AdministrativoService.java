package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Administrativo;
import br.gov.mt.vigilancia.saude.dto.AdministrativoDTO;
import br.gov.mt.vigilancia.saude.mapper.AdministrativoMapper;
import br.gov.mt.vigilancia.saude.repository.AdministrativoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdministrativoService {

    @Autowired
    private AdministrativoRepository administrativoRepository;

    @Autowired
    private AdministrativoMapper administrativoMapper;

    public List<AdministrativoDTO> findAll() {
        return administrativoRepository.findAll().stream()
                .map(administrativoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<AdministrativoDTO> findById(Integer id) {
        return administrativoRepository.findById(id)
                .map(administrativoMapper::toDTO);
    }

    public AdministrativoDTO save(AdministrativoDTO administrativoDTO) {
        Administrativo administrativo = administrativoMapper.toEntity(administrativoDTO);
        administrativo = administrativoRepository.save(administrativo);
        return administrativoMapper.toDTO(administrativo);
    }

    public void deleteById(Integer id) {
        administrativoRepository.deleteById(id);
    }
}
