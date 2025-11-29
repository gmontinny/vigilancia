package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Tramiteadm;
import br.gov.mt.vigilancia.saude.dto.TramiteadmDTO;
import br.gov.mt.vigilancia.saude.mapper.TramiteadmMapper;
import br.gov.mt.vigilancia.saude.repository.TramiteadmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TramiteadmService {

    @Autowired
    private TramiteadmRepository tramiteadmRepository;

    @Autowired
    private TramiteadmMapper tramiteadmMapper;

    public List<TramiteadmDTO> findAll() {
        return tramiteadmRepository.findAll().stream()
                .map(tramiteadmMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<TramiteadmDTO> findById(Integer id) {
        return tramiteadmRepository.findById(id)
                .map(tramiteadmMapper::toDTO);
    }

    public TramiteadmDTO save(TramiteadmDTO tramiteadmDTO) {
        Tramiteadm tramiteadm = tramiteadmMapper.toEntity(tramiteadmDTO);
        tramiteadm = tramiteadmRepository.save(tramiteadm);
        return tramiteadmMapper.toDTO(tramiteadm);
    }

    public void deleteById(Integer id) {
        tramiteadmRepository.deleteById(id);
    }
}
