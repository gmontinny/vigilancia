package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Geraitensprodi;
import br.gov.mt.vigilancia.saude.dto.GeraitensprodiDTO;
import br.gov.mt.vigilancia.saude.mapper.GeraitensprodiMapper;
import br.gov.mt.vigilancia.saude.repository.GeraitensprodiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GeraitensprodiService {

    @Autowired
    private GeraitensprodiRepository geraitensprodiRepository;

    @Autowired
    private GeraitensprodiMapper geraitensprodiMapper;

    public List<GeraitensprodiDTO> findAll() {
        return geraitensprodiRepository.findAll().stream()
                .map(geraitensprodiMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<GeraitensprodiDTO> findById(Integer id) {
        return geraitensprodiRepository.findById(id)
                .map(geraitensprodiMapper::toDTO);
    }

    public GeraitensprodiDTO save(GeraitensprodiDTO geraitensprodiDTO) {
        Geraitensprodi geraitensprodi = geraitensprodiMapper.toEntity(geraitensprodiDTO);
        geraitensprodi = geraitensprodiRepository.save(geraitensprodi);
        return geraitensprodiMapper.toDTO(geraitensprodi);
    }

    public void deleteById(Integer id) {
        geraitensprodiRepository.deleteById(id);
    }
}
