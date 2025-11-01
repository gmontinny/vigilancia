package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Montarroteiro;
import br.gov.mt.vigilancia.saude.dto.MontarroteiroDTO;
import br.gov.mt.vigilancia.saude.mapper.MontarroteiroMapper;
import br.gov.mt.vigilancia.saude.repository.MontarroteiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MontarroteiroService {

    @Autowired
    private MontarroteiroRepository montarroteiroRepository;

    @Autowired
    private MontarroteiroMapper montarroteiroMapper;

    public List<MontarroteiroDTO> findAll() {
        return montarroteiroRepository.findAll().stream()
                .map(montarroteiroMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<MontarroteiroDTO> findById(Integer id) {
        return montarroteiroRepository.findById(id)
                .map(montarroteiroMapper::toDTO);
    }

    public MontarroteiroDTO save(MontarroteiroDTO montarroteiroDTO) {
        Montarroteiro montarroteiro = montarroteiroMapper.toEntity(montarroteiroDTO);
        montarroteiro = montarroteiroRepository.save(montarroteiro);
        return montarroteiroMapper.toDTO(montarroteiro);
    }

    public void deleteById(Integer id) {
        montarroteiroRepository.deleteById(id);
    }
}
