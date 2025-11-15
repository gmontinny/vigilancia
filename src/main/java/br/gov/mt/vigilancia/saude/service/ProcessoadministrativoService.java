package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Processoadministrativo;
import br.gov.mt.vigilancia.saude.dto.ProcessoadministrativoDTO;
import br.gov.mt.vigilancia.saude.mapper.ProcessoadministrativoMapper;
import br.gov.mt.vigilancia.saude.repository.ProcessoadministrativoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProcessoadministrativoService {

    @Autowired
    private ProcessoadministrativoRepository processoadministrativoRepository;

    @Autowired
    private ProcessoadministrativoMapper processoadministrativoMapper;

    public List<ProcessoadministrativoDTO> findAll() {
        return processoadministrativoRepository.findAll().stream()
                .map(processoadministrativoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<ProcessoadministrativoDTO> findById(Integer id) {
        return processoadministrativoRepository.findById(id)
                .map(processoadministrativoMapper::toDTO);
    }

    public ProcessoadministrativoDTO save(ProcessoadministrativoDTO processoadministrativoDTO) {
        Processoadministrativo processoadministrativo = processoadministrativoMapper.toEntity(processoadministrativoDTO);
        processoadministrativo = processoadministrativoRepository.save(processoadministrativo);
        return processoadministrativoMapper.toDTO(processoadministrativo);
    }

    public void deleteById(Integer id) {
        processoadministrativoRepository.deleteById(id);
    }
}
