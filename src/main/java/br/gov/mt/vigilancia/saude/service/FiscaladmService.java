package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Fiscaladm;
import br.gov.mt.vigilancia.saude.dto.FiscaladmDTO;
import br.gov.mt.vigilancia.saude.mapper.FiscaladmMapper;
import br.gov.mt.vigilancia.saude.repository.FiscaladmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FiscaladmService {

    @Autowired
    private FiscaladmRepository fiscaladmRepository;

    @Autowired
    private FiscaladmMapper fiscaladmMapper;

    public List<FiscaladmDTO> findAll() {
        return fiscaladmRepository.findAll().stream()
                .map(fiscaladmMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<FiscaladmDTO> findById(Integer id) {
        return fiscaladmRepository.findById(id)
                .map(fiscaladmMapper::toDTO);
    }

    public FiscaladmDTO save(FiscaladmDTO fiscaladmDTO) {
        Fiscaladm fiscaladm = fiscaladmMapper.toEntity(fiscaladmDTO);
        fiscaladm = fiscaladmRepository.save(fiscaladm);
        return fiscaladmMapper.toDTO(fiscaladm);
    }

    public void deleteById(Integer id) {
        fiscaladmRepository.deleteById(id);
    }
}
