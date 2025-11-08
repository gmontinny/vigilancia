package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Itenscategoriaservico;
import br.gov.mt.vigilancia.saude.dto.ItenscategoriaservicoDTO;
import br.gov.mt.vigilancia.saude.mapper.ItenscategoriaservicoMapper;
import br.gov.mt.vigilancia.saude.repository.ItenscategoriaservicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItenscategoriaservicoService {

    @Autowired
    private ItenscategoriaservicoRepository itenscategoriaservicoRepository;

    @Autowired
    private ItenscategoriaservicoMapper itenscategoriaservicoMapper;

    public List<ItenscategoriaservicoDTO> findAll() {
        return itenscategoriaservicoRepository.findAll().stream()
                .map(itenscategoriaservicoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<ItenscategoriaservicoDTO> findById(Integer id) {
        return itenscategoriaservicoRepository.findById(id)
                .map(itenscategoriaservicoMapper::toDTO);
    }

    public ItenscategoriaservicoDTO save(ItenscategoriaservicoDTO itenscategoriaservicoDTO) {
        Itenscategoriaservico itenscategoriaservico = itenscategoriaservicoMapper.toEntity(itenscategoriaservicoDTO);
        itenscategoriaservico = itenscategoriaservicoRepository.save(itenscategoriaservico);
        return itenscategoriaservicoMapper.toDTO(itenscategoriaservico);
    }

    public void deleteById(Integer id) {
        itenscategoriaservicoRepository.deleteById(id);
    }
}
