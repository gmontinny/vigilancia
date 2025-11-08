package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Itensembalagem;
import br.gov.mt.vigilancia.saude.dto.ItensembalagemDTO;
import br.gov.mt.vigilancia.saude.mapper.ItensembalagemMapper;
import br.gov.mt.vigilancia.saude.repository.ItensembalagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItensembalagemService {

    @Autowired
    private ItensembalagemRepository itensembalagemRepository;

    @Autowired
    private ItensembalagemMapper itensembalagemMapper;

    public List<ItensembalagemDTO> findAll() {
        return itensembalagemRepository.findAll().stream()
                .map(itensembalagemMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<ItensembalagemDTO> findById(Integer id) {
        return itensembalagemRepository.findById(id)
                .map(itensembalagemMapper::toDTO);
    }

    public ItensembalagemDTO save(ItensembalagemDTO itensembalagemDTO) {
        Itensembalagem itensembalagem = itensembalagemMapper.toEntity(itensembalagemDTO);
        itensembalagem = itensembalagemRepository.save(itensembalagem);
        return itensembalagemMapper.toDTO(itensembalagem);
    }

    public void deleteById(Integer id) {
        itensembalagemRepository.deleteById(id);
    }
}
