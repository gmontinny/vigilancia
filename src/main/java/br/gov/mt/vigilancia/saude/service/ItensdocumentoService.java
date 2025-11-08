package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Itensdocumento;
import br.gov.mt.vigilancia.saude.dto.ItensdocumentoDTO;
import br.gov.mt.vigilancia.saude.mapper.ItensdocumentoMapper;
import br.gov.mt.vigilancia.saude.repository.ItensdocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItensdocumentoService {

    @Autowired
    private ItensdocumentoRepository itensdocumentoRepository;

    @Autowired
    private ItensdocumentoMapper itensdocumentoMapper;

    public List<ItensdocumentoDTO> findAll() {
        return itensdocumentoRepository.findAll().stream()
                .map(itensdocumentoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<ItensdocumentoDTO> findById(Integer id) {
        return itensdocumentoRepository.findById(id)
                .map(itensdocumentoMapper::toDTO);
    }

    public ItensdocumentoDTO save(ItensdocumentoDTO itensdocumentoDTO) {
        Itensdocumento itensdocumento = itensdocumentoMapper.toEntity(itensdocumentoDTO);
        itensdocumento = itensdocumentoRepository.save(itensdocumento);
        return itensdocumentoMapper.toDTO(itensdocumento);
    }

    public void deleteById(Integer id) {
        itensdocumentoRepository.deleteById(id);
    }
}
