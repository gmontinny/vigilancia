package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Processolicenciamento;
import br.gov.mt.vigilancia.saude.dto.ProcessolicenciamentoDTO;
import br.gov.mt.vigilancia.saude.mapper.ProcessolicenciamentoMapper;
import br.gov.mt.vigilancia.saude.repository.ProcessolicenciamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProcessolicenciamentoService {

    @Autowired
    private ProcessolicenciamentoRepository processolicenciamentoRepository;

    @Autowired
    private ProcessolicenciamentoMapper processolicenciamentoMapper;

    public List<ProcessolicenciamentoDTO> findAll() {
        return processolicenciamentoRepository.findAll().stream()
                .map(processolicenciamentoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<ProcessolicenciamentoDTO> findById(Integer id) {
        return processolicenciamentoRepository.findById(id)
                .map(processolicenciamentoMapper::toDTO);
    }

    public ProcessolicenciamentoDTO save(ProcessolicenciamentoDTO processolicenciamentoDTO) {
        Processolicenciamento processolicenciamento = processolicenciamentoMapper.toEntity(processolicenciamentoDTO);
        processolicenciamento = processolicenciamentoRepository.save(processolicenciamento);
        return processolicenciamentoMapper.toDTO(processolicenciamento);
    }

    public void deleteById(Integer id) {
        processolicenciamentoRepository.deleteById(id);
    }
}
