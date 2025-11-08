package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.OrdemServico;
import br.gov.mt.vigilancia.saude.dto.OrdemServicoDTO;
import br.gov.mt.vigilancia.saude.mapper.OrdemServicoMapper;
import br.gov.mt.vigilancia.saude.repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrdemServicoService {

    @Autowired
    private OrdemServicoRepository ordemservicoRepository;

    @Autowired
    private OrdemServicoMapper ordemservicoMapper;

    public List<OrdemServicoDTO> findAll() {
        return ordemservicoRepository.findAll().stream()
                .map(ordemservicoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<OrdemServicoDTO> findById(Integer id) {
        return ordemservicoRepository.findById(id)
                .map(ordemservicoMapper::toDTO);
    }

    public OrdemServicoDTO save(OrdemServicoDTO ordemservicoDTO) {
        OrdemServico ordemservico = ordemservicoMapper.toEntity(ordemservicoDTO);
        ordemservico = ordemservicoRepository.save(ordemservico);
        return ordemservicoMapper.toDTO(ordemservico);
    }

    public void deleteById(Integer id) {
        ordemservicoRepository.deleteById(id);
    }
}
